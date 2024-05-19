package org.ptecnica.pruebatecspringboot.service.impl;

import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.CharacterDto;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.repository.CharacterRepository;
import org.ptecnica.pruebatecspringboot.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDto> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public List<CharacterDto> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public String getImage(int id) {
        return characterRepository.getImage(id);
    }


}
