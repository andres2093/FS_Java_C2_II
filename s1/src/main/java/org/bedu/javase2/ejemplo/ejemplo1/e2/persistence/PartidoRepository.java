package org.bedu.javase2.ejemplo.ejemplo1.e2.persistence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Partido;
import org.springframework.data.repository.CrudRepository;

public interface PartidoRepository extends CrudRepository<Partido, Long> {
    Iterable<Partido> findAllByEquipo1NombreAndEquipo2Nombre(String nombreEquipo1, String nombreEquipo2);
}
