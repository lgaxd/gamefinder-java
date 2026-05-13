package br.com.fiap.gamefinder.repository;

import br.com.fiap.gamefinder.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    Page<Game> findByGenreId(Long genreId, Pageable pageable);

    Page<Game> findByPlatformId(Long platformId, Pageable pageable);
}