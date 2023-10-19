package org.bedu.jse2.demo.reactive.ejemplo3;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class E3Service {
    private static final E3Repository REPOSITORY = new E3Repository();

    public Flux<String> getListaNombre(){
        return REPOSITORY
                .getPersonas()
                .map(this::formatearNombre);
    }

    private String formatearNombre(PersonaEntity persona){
        return String.format("%s %s, %s", persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getNombre());
    }

    public Mono<AgendaEntity> buscarPorNombre(String nombre) {
        return REPOSITORY.getPersonas()
                .filter(p -> filterFunction(p, nombre))
                .map(this::personToAgenda)
                .next();
    }

    private Boolean filterFunction(PersonaEntity p, String nombre) {
        return p.getNombre().contains(nombre) || p.getPrimerApellido().contains(nombre) || p.getSegundoApellido().contains(nombre);
    }

    private AgendaEntity personToAgenda(PersonaEntity p) {
        return new AgendaEntity(String.format("%s %s %s", p.getNombre(), p.getPrimerApellido(), p.getSegundoApellido()), p.getTelefono());
    }

}
