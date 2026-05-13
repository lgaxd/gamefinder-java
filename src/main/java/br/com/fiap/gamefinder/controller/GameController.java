package br.com.fiap.gamefinder.controller;

import br.com.fiap.gamefinder.assembler.GameAssembler;
import br.com.fiap.gamefinder.model.Game;
import br.com.fiap.gamefinder.service.GameService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import org.springframework.data.web.PagedResourcesAssembler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService service;
    private final GameAssembler gameAssembler;
    private final PagedResourcesAssembler<Game> pagedAssembler;

    public GameController(
            GameService service,
            GameAssembler gameAssembler,
            PagedResourcesAssembler<Game> pagedAssembler
    ) {
        this.service = service;
        this.gameAssembler = gameAssembler;
        this.pagedAssembler = pagedAssembler;
    }

    @GetMapping
    public PagedModel<EntityModel<Game>> findAll(Pageable pageable) {

        Page<Game> games = service.getAll(pageable);

        return pagedAssembler.toModel(games, gameAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {

        return gameAssembler.toModel(service.getById(id));
    }

    @GetMapping("/genres/{genreId}")
    public PagedModel<EntityModel<Game>> findByGenre(
            @PathVariable Long genreId,
            Pageable pageable
    ) {

        Page<Game> games = service.findByGenre(genreId, pageable);

        return pagedAssembler.toModel(games, gameAssembler);
    }

    @GetMapping("/platforms/{platformId}")
    public PagedModel<EntityModel<Game>> findByPlatform(
            @PathVariable Long platformId,
            Pageable pageable
    ) {

        Page<Game> games = service.findByPlatform(platformId, pageable);

        return pagedAssembler.toModel(games, gameAssembler);
    }
}