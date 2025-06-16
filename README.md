# 💈 SrSharp — Sistema de Afiação Web

**SrSharp** é uma aplicação web desenvolvida com **Spring Boot** voltada para gestão de serviços de afiação. Ideal para oficinas, representantes e afiliados (lojas), ela oferece um fluxo moderno e organizado para atender a operação de ponta a ponta, desde o pedido até os relatórios financeiros.

---

## 🌐 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf** (ou outro motor de templates, se aplicável)
- **Banco de Dados MySQL/PostgreSQL**
- **Spring Security** (caso use autenticação)
- **Maven** ou **Gradle**
- **Docker** (opcional)
- **Git & GitHub** para versionamento

---

## 🧩 Funcionalidades Principais

### 🔧 Para o Administrador
- Cadastro de clientes, afiliados (lojas) e produtos de afiação
- Controle e atualização de status dos pedidos
- Relatórios financeiros e operacionais
- Gestão de repasses para afiliados

### 🛍 Para os Afiliados (Lojas)
- Solicitação de novos serviços de afiação
- Acompanhamento dos pedidos em tempo real
- Visualização de valores de repasse por pedido
- Geração de **relatório mensal de ganhos**

---

## 📲 Integração futura com aplicativo mobile

Está prevista a criação de um **aplicativo móvel para Android/iOS**, permitindo:

- Que afiliados acompanhem pedidos, criem novas solicitações e acessem relatórios.
- Que **clientes finais façam seus próprios pedidos diretamente pelo app**, eliminando a necessidade de intermediação por afiliados ou motoboys.
- Pagamentos diretos e digitalizados via o aplicativo.

Essa expansão levará o MrSharp a um novo nível de conveniência, mobilidade e independência para os usuários.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/JonhAdao/MrSharp.git
   ```
2. Importe o projeto em uma IDE como o **IntelliJ** ou **Eclipse**.
3. Configure o arquivo `application.properties` ou `application.yml` com as credenciais do banco de dados.
4. Execute a aplicação com:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Acesse via navegador:  
   [http://localhost:8080](http://localhost:8080)

---

## 📊 Relatórios

O sistema gera automaticamente:
- Relatórios por período (mensal, trimestral, etc.)
- Relatório de repasse individual por afiliado
- Histórico completo de pedidos por cliente

---


## 🤝 Contribuições

Sugestões, pull requests e críticas construtivas são muito bem-vindas! 
---

## 👨‍💻 Autor

Desenvolvido por **Jonathan Adão**  
Empenhado em transformar problemas do mundo real em soluções digitais úteis.

---

## 📄 Licença

Distribuído sob a licença [MIT](LICENSE).  
Sinta-se livre para usar, modificar e colaborar!
