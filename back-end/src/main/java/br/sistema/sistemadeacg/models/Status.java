package br.sistema.sistemadeacg.models;

public enum Status {
    PENDENTE("Pendente"), DEFERIDO("Deferido"), INDEFERIDO("Indeferido");

    private final String value;

    Status(String value) {
        this.value = value;

    }

    public String toString() {
        return this.value;
    }

}