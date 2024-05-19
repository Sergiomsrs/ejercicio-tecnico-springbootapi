package org.ptecnica.pruebatecspringboot.persistence.integration.rym.mapper;

import org.ptecnica.pruebatecspringboot.dto.GetUserInteractionLogDto;
import org.ptecnica.pruebatecspringboot.persistence.entity.UserInteractionLog;

public class UserInteractionLogMapper {

    public static GetUserInteractionLogDto toDto(UserInteractionLog entity){

        if(entity == null) return null;

        return new GetUserInteractionLogDto(
                entity.getId(),
                entity.getUrl(),
                entity.getHttpMethod(),
                entity.getUsername(),
                entity.getTimestamp(),
                entity.getRemoteAddress()
        );

    }


}
