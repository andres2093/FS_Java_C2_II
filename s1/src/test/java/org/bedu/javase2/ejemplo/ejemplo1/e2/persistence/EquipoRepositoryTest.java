package org.bedu.javase2.ejemplo.ejemplo1.e2.persistence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Equipo;
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
class EquipoRepositoryTest {
    @Autowired
    private EquipoRepository equipoRepository;
    @BeforeAll
    void cleanDatabase(){
        equipoRepository.deleteAll();
    }

    @Test
    @DisplayName("Puede guardar")
    void canSave(){
        Equipo equipo = new Equipo();
        equipo.setNombre("Bedu");
        equipo = equipoRepository.save(equipo);
    }

    @Test
    @DisplayName("Busca por nombre")
    void canFindByName(){
        final String nombre = "Beto";
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo = equipoRepository.save(equipo);

        Iterable<Equipo> listaEquipos = equipoRepository.findAllByNombre(nombre);
        assertTrue(listaEquipos.iterator().hasNext());

        Equipo equipoRecuperado = listaEquipos.iterator().next();
        assertEquals(equipo, equipoRecuperado);

    }

}