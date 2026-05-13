package br.com.fiap.gamefinder.assembler;

import br.com.fiap.gamefinder.controller.GameController;
import br.com.fiap.gamefinder.model.Game;

import org.springframework.data.domain.PageRequest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameAssembler
        implements RepresentationModelAssembler<Game, EntityModel<Game>> {

    @Override
    public EntityModel<Game> toModel(Game game) {

        return EntityModel.of(
                game,

                linkTo(
                        methodOn(GameController.class)
                                .findById(game.getId())
                ).withSelfRel(),

                linkTo(
                        methodOn(GameController.class)
                                .findAll(PageRequest.of(0, 10))
                ).withRel("games"),

                linkTo(
                        methodOn(GameController.class)
                                .findByGenre(
                                        game.getGenre().getId(),
                                        PageRequest.of(0, 10)
                                )
                ).withRel("genre-games"),

                linkTo(
                        methodOn(GameController.class)
                                .findByPlatform(
                                        game.getPlatform().getId(),
                                        PageRequest.of(0, 10)
                                )
                ).withRel("platform-games")
        );
    }
}