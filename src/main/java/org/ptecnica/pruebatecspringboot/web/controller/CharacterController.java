package org.ptecnica.pruebatecspringboot.web.controller;


import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.CharacterDto;
import org.ptecnica.pruebatecspringboot.persistence.integration.rym.dto.EpisodeDto;
import org.ptecnica.pruebatecspringboot.service.CharacterService;
import org.ptecnica.pruebatecspringboot.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")


public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private EpisodeService episodeService;
    @PreAuthorize("hasAuthority('character:read-all')")
    @GetMapping
    public ResponseEntity<List<CharacterDto>> findAll (){

        return ResponseEntity.ok(characterService.findAll());
    }

    @PreAuthorize("hasAuthority('character:read-all')")
    @GetMapping("/name")
    public ResponseEntity<List<CharacterDto>> findByName (@RequestParam String name){

        return ResponseEntity.ok(characterService.findByName(name));
    }

    @PreAuthorize("hasAuthority('character:read-all')")
    @GetMapping("/episode/{id}")
    public ResponseEntity<EpisodeDto> findByEpisode (@PathVariable int id){

        return ResponseEntity.ok(episodeService.findByEpisode(id));
    }
    @PreAuthorize("hasAuthority('character:read-all')")
    @GetMapping("/image/{id}")
    public ResponseEntity<String> getUrlImage (@PathVariable int id){

        return ResponseEntity.ok(characterService.getImage(id));
    }





}
