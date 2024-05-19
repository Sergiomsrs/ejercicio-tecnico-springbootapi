package org.ptecnica.pruebatecspringboot.service.impl;

import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.EpisodeDto;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.repository.EpisodeRepository;
import org.ptecnica.pruebatecspringboot.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    @Autowired
    EpisodeRepository episodeRepository;

    @Override
    public EpisodeDto findByEpisode(int id) {
        return episodeRepository.findByEpisode(id) ;
    }
}
