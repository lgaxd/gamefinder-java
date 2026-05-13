package br.com.fiap.gamefinder.repository;

import br.com.fiap.gamefinder.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
