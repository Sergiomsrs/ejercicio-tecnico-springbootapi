package org.ptecnica.pruebatecspringboot.persistence.integration.rym.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.EpisodeDto;
import org.ptecnica.pruebatecspringboot.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EpisodeRepository {

    @Autowired
    private HttpClientService httpClientService;

    @Value("${integration.rym.base-path}")
    private String basePath;

    private String characterPath;

    private String getCharacterPath(int episode) {
        return basePath + "/episode/" + episode;
    }

    public EpisodeDto findByEpisode(int id) {

            JsonNode response = httpClientService.doGet(getCharacterPath(id), JsonNode.class);
            String name =  response.get("name").asText();
            ArrayNode characters = (ArrayNode) response.get("characters");
            List<String> list = new ArrayList<>();

        characters.elements().forEachRemaining(each -> {
            JsonNode responses = httpClientService.doGet(each.asText(), JsonNode.class);
            String names = responses.get("name").asText();
            list.add(names);


        });


        return new EpisodeDto(name, list);
    }
}
