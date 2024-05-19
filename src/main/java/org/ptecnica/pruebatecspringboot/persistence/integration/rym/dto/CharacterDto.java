package org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto;

public record CharacterDto( Long id, String name, String status) {



    public static record CharacterImageDto(String image){}
    public static record CharacterNameDto(String name){}

}
