package br.com.fiap.gamefinder.service;

import br.com.fiap.gamefinder.model.Game;
import br.com.fiap.gamefinder.repository.GameRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public Page<Game> getAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public Game getById(Long id) {

        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Game not found"
                )
        );
    }

    public Page<Game> findByGenre(Long genreId, Pageable pageable) {

        return repository.findByGenreId(genreId, pageable);
    }

    public Page<Game> findByPlatform(Long platformId, Pageable pageable) {

        return repository.findByPlatformId(platformId, pageable);
    }
}