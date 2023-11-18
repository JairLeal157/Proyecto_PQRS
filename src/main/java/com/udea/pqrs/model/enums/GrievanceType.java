package com.udea.pqrs.model.enums;

public enum GrievanceType {
    SancionesInjustas("Sanciones Injustas"),
    ProblemasDeFacturacion("Problemas de Facturacion"),
    Otros("Otros");

    public final String description;

    GrievanceType(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }

}
