package com.senac.srsharp;

import com.senac.srsharp.model.Servico;
import com.senac.srsharp.service.ServicoService;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SrsharpApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SrsharpApplication.class, args);
        System.out.println("\n\n");
        System.out.println("Crud de serviços para teste");

        Scanner scanner = new Scanner(System.in);

        // Pega o service direto do contexto Spring
        ServicoService servicoService = context.getBean(ServicoService.class);

        int opcao;

        do {
            System.out.println("\n=== MENU SRSHARP ===");
            System.out.println("1 - Cadastrar novo serviço");
            System.out.println("2 - Listar serviços cadastrados");
            System.out.println("3 - Atulizar serviços ");
            System.out.println("4 - Excluir serviços ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n--- Cadastro de Serviço ---");

                    Servico novoServico = new Servico();

                    System.out.print("Nome: ");
                    novoServico.setNome(scanner.nextLine());

                    System.out.print("Observacao: ");
                    novoServico.setObservacao(scanner.nextLine());

                    System.out.print("Preço: ");
                    novoServico.setPreco(scanner.nextBigDecimal());

                    scanner.nextLine(); // limpa o buffer

                    servicoService.salvar(novoServico);

                    System.out.println("\n Serviço cadastrado com sucesso!\n");
                }

                case 2 -> {
                    System.out.println("\n--- Lista de Serviços Cadastrados ---");
                    List<Servico> lista = servicoService.listarTodos();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado ainda.");
                    } else {
                        for (Servico s : lista) {
                            System.out.println("Id: " + s.getId());
                            System.out.println("Descrição: " + s.getNome());
                            System.out.println("Descrição: " + s.getObservacao());
                            System.out.println("Preço: R$" + s.getPreco());
                            System.out.println("---------------------------");
                        }
                    }
                }

                case 3 -> {
                    System.out.println("\n--- Atualizar Serviço ---");
                    System.out.println("\nSelecione um serviço (id) ");
                    System.out.print("Serviço - ");
                    Long idServ = scanner.nextLong();
                    scanner.nextLine();

                    Servico novoServico = new Servico();

                    System.out.print("Nome - ");
                    novoServico.setNome(scanner.nextLine());

                    System.out.print("Descrição - ");
                    novoServico.setObservacao(scanner.nextLine());

                    System.out.print("Preço - ");
                    novoServico.setPreco(scanner.nextBigDecimal());

                    servicoService.atualizar(idServ, novoServico);
                    
                    System.out.println("\n Serviço atualizado com sucesso!\n");

                }

                case 4 -> {
                    System.out.println("\n --- Excluir Serviço ---");
                    System.out.println("\n Selecione um serviço para excluir (id) ");
                    System.out.print(" Serviço - ");
                    Long idServico = scanner.nextLong();
                    scanner.nextLine();

                    servicoService.deletar(idServico);

                    System.out.println("\n Serviço Excluido com Sucesso ");
                    System.out.println();
                }

                case 0 -> {
                    System.out.println("\nEncerrando o sistema. Até logo!\n");
                    scanner.close();
                }

                default ->
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
