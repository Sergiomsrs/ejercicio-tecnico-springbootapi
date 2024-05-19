package org.ptecnica.pruebatecspringboot.persistence.integration.rym.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.CharacterDto;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    public static List<CharacterDto> toDtoList(JsonNode rootNode){

        JsonNode inforesult =  rootNode.get("info");
        ArrayNode result = (ArrayNode) rootNode.get("results");
        List<CharacterDto> characters = new ArrayList<>();
        String pages = inforesult.get("next").asText();


        result.elements().forEachRemaining(each -> {
            characters.add(CharacterMapper.toDto(each));
        });


        return characters;
    }

    public static CharacterDto toDto(JsonNode characterNode) {


        return new CharacterDto(
                Long.parseLong(characterNode.get("id").asText()),
                        characterNode.get("name").asText(),
                        characterNode.get("status").asText()
        );

    }
}
