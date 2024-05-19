package org.ptecnica.pruebatecspringboot.service;

import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.EpisodeDto;

public interface EpisodeService {
    EpisodeDto findByEpisode(int id);
}
