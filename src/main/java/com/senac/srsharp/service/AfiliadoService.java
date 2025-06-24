package com.senac.srsharp.service;

import com.senac.srsharp.repository.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class AfiliadoService {

    @Autowired
    AfiliadoRepository afiliadoRepository;

}
