package com.grupo8.scada.model.interfaces;

public interface Ajustavel {
    void ajustarSetpoint(double valor);
    double getSetpoint();
}
