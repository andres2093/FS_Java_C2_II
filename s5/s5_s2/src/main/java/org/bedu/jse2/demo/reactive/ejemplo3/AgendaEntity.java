package org.bedu.jse2.demo.reactive.ejemplo3;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AgendaEntity {
    private final String nombreCompleto;
    private final String telefono;

    public AgendaEntity(String nombreCompleto, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }
}
