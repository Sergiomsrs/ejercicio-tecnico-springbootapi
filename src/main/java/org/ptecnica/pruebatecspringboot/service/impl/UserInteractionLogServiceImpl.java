package org.ptecnica.pruebatecspringboot.service.impl;

import org.ptecnica.pruebatecspringboot.dto.GetUserInteractionLogDto;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.mapper.UserInteractionLogMapper;
import org.ptecnica.pruebatecspringboot.persistence.repository.UserInteractionRepository;
import org.ptecnica.pruebatecspringboot.service.UserInteractionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserInteractionLogServiceImpl implements UserInteractionLogService {

    @Autowired
    private UserInteractionRepository userInteractionRepository;


    @Override
    public Page<GetUserInteractionLogDto> findAll(Pageable pageable) {
        return userInteractionRepository.findAll(pageable)
                .map(UserInteractionLogMapper::toDto);
    }

    @Override
    public Page<GetUserInteractionLogDto> findByUsername(Pageable pageable, String username) {
        return userInteractionRepository.findByUsername(pageable, username)
                .map(UserInteractionLogMapper::toDto);
    }
}
