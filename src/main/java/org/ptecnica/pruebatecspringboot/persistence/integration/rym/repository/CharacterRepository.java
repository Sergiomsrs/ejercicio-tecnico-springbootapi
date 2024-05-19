package org.ptecnica.pruebatecspringboot.persistence.integration.rym.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.CharacterDto;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.mapper.CharacterMapper;
import org.ptecnica.pruebatecspringboot.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {

    @Autowired
    private HttpClientService httpClientService;

    @Value("${integration.rym.base-path}")
    private String basePath;


    private String getCharacterPath(int page) {
        return basePath + "/character?page=" + page;
    }

    public List<CharacterDto> findAll() {

        List<CharacterDto> characters = new ArrayList<>();
        int currentPage = 1;
        int totalPages = 1;

        while (currentPage <= totalPages) {
            JsonNode response = httpClientService.doGet(getCharacterPath(currentPage), JsonNode.class);
            List<CharacterDto> charactersOfPage = CharacterMapper.toDtoList(response);

            characters.addAll(charactersOfPage);

            currentPage++;
            totalPages = response.get("info").get("pages").asInt();
        }

        return characters;
    }

    public List<CharacterDto> findByName(String name) {

        JsonNode response = httpClientService.doGet(basePath + "/character/?name=" + name, JsonNode.class);
        List<CharacterDto> charactersOfPage = CharacterMapper.toDtoList(response);
        return new ArrayList<>(charactersOfPage);

    }

    public String getImage(int id){

        JsonNode response = httpClientService.doGet( basePath + "/character/" + id, JsonNode.class);



        return response.get("image").asText();
    }





}
