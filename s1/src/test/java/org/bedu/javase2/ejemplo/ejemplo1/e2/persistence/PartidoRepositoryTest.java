package org.bedu.javase2.ejemplo.ejemplo1.e2.persistence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Equipo;
import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Partido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.ejemplo.ejemplo1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PartidoRepositoryTest {
    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    Equipo equipo1;
    Equipo equipo2;

    @BeforeAll
    void setupDatabase() {
        partidoRepository.deleteAll();
        equipoRepository.deleteAll();

        equipo1 = new Equipo();
        equipo1.setNombre("Equipo Bedu");
        equipoRepository.save(equipo1);

        equipo2 = new Equipo();
        equipo2.setNombre("Equipo Beto");
        equipoRepository.save(equipo2);
    }

    @Test
    @DisplayName("Busca por nombres")
    void searchMatchByNames() {

        Partido partido = new Partido();
        partido.setEquipo1(equipo1);
        partido.setEquipo2(equipo2);
        partido.setMarcadorEquipo1(0);
        partido.setMarcadorEquipo2(0);

        partidoRepository.save(partido);

        Iterable<Partido> conjuntoPartidos = partidoRepository.findAllByEquipo1NombreAndEquipo2Nombre("Equipo X", "Equipo Y");

    }
}