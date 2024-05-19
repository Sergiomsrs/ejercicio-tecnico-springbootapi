package org.ptecnica.pruebatecspringboot.service;

import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.CharacterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterService {
    List<CharacterDto> findAll();
    List<CharacterDto> findByName(String name);

    String getImage(int id);

}
