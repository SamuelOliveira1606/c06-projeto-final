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

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public EstadoEquipamento getEstado() {
        return estado;
    }

    public long getCiclosExecutados() {
        return ciclosExecutados;
    }

    public synchronized void ligar() {
        if (estado != EstadoEquipamento.PARADO) {
            throw new IllegalStateException("Não é possível ligar o equipamento " + id + " está em " + estado);
        }
        System.out.println("Ligando o equipamento " + nome + " " + id);
        estado = EstadoEquipamento.OPERANDO;
    }

    public synchronized void desligar() {
        if (estado != EstadoEquipamento.OPERANDO) {
            throw new IllegalStateException("Não é possível desligar o equipamento " + id + " está em " + estado);
        }
        System.out.println("Desligando o equipamento " + nome + " " + id);
        estado = EstadoEquipamento.PARADO;
    }

    public final synchronized void ciclo() {
        if (estado == EstadoEquipamento.OPERANDO) {
            executarCiclo();
            ciclosExecutados++;
        }
    }
    protected abstract void executarCiclo();
    public abstract String getTipo();
}
