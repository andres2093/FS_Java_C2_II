package org.bedu.jse2.demo.reactive.ejemplo1;

import io.reactivex.Single;
import org.bedu.jse2.demo.reactive.generator.RxJavaObservableGenerator;

public class Ejemplo1 {

    static Single<Integer> sumarSingle() {
        return RxJavaObservableGenerator
                .observableStream()
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer::sum);
    }

    static Integer sumar() {
        return RxJavaObservableGenerator
                .observableStream()
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer::sum)
                .blockingGet();
    }

    static Single<Integer> reto() {
        return RxJavaObservableGenerator
                .observableStream()
                .map(valor -> valor * valor * valor)
                .filter(valor -> valor > 50)
                .reduce(0, Integer::sum);
    }
}
