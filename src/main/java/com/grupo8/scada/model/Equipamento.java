package com.grupo8.scada.model;

public abstract class Equipamento {
    private final String id;
    private final String nome;
    private EstadoEquipamento estado = EstadoEquipamento.PARADO;
    private long ciclosExecutados = 0;

    protected Equipamento(String id, String nome) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O ID do equipamento não pode ser vazio");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do equipamento não pode ser vazio");
        }
        this.id = id;
        this.nome = nome;
    }
}
