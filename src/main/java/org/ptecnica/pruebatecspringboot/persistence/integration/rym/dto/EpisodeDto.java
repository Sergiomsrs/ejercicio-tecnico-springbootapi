package org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto;

import java.util.List;


public record EpisodeDto(String name, List<String> characters) {
}
