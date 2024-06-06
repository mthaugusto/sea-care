package br.com.fiap.seacare.repository;

import br.com.fiap.seacare.entity.Relato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatoRepository extends JpaRepository<Relato, Long> {
}
