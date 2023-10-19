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
}
