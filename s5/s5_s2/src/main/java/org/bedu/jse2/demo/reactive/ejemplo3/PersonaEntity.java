package org.bedu.jse2.demo.reactive.ejemplo3;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonaEntity {
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;

    private final String telefono;

    public PersonaEntity(String nombre, String primerApellido, String segundoApellido, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }
}

