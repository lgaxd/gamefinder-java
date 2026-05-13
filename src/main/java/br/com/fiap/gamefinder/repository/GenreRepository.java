package br.com.fiap.gamefinder.repository;

import br.com.fiap.gamefinder.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>{
}
