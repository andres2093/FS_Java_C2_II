package org.bedu.jse2.demo.reactive.ejemplo2;

import org.bedu.jse2.demo.reactive.generator.ReactorFluxGenerator;
import reactor.core.publisher.Mono;

public class Ejemplo2 {
    static Mono<Integer> sumarMono(){
        return ReactorFluxGenerator
                .fluxStream()
//                .reduce(0, (a,b) -> a+b)
                .reduce(0, Integer::sum);
    }
    static Integer sumar(){
        return ReactorFluxGenerator
                .fluxStream()
//                .reduce(0, (a,b) -> a+b)
                .reduce(0, Integer::sum)
                .block();
    }

//    FLATMAP?
//      - Procesar el stream/flux en paralelo
//      - Cada valor puede generar varios valores más
//           (expansion de la lista)
    static Mono<Integer> reto(){
        return ReactorFluxGenerator
                .fluxStream()
                .flatMap(v -> Mono.just(v*v*v))
                .filter(v -> v < 50)
                .reduce(0, Integer::sum);
    }
//    Consideraciones con FLATMAP procesa en paralelo
//      por lo que el resultado final debe ser independiente
//          del orden de ejecución (deben ser funciones puras)

//    Funciones puras?
//      - Siempre produce el mismo resultado con los mismos argumentos
//      - No produce efectos secundarios
//          - Por ejemplo: modificar una variable global o escribir en
//              la consola
}
