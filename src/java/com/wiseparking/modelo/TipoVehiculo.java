package com.wiseparking.modelo;

public class TipoVehiculo {
    private int tipoVehiculoId;
    private String nombreTipo;
    private double tarifaPorMinuto;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int tipoVehiculoId, String nombreTipo, double tarifaPorMinuto) {
        this.tipoVehiculoId = tipoVehiculoId;
        this.nombreTipo = nombreTipo;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    // Recuerda presionar Alt + Insert para generar los Getters y Setters aquí también.

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public double getTarifaPorMinuto() {
        return tarifaPorMinuto;
    }

    public void setTarifaPorMinuto(double tarifaPorMinuto) {
        this.tarifaPorMinuto = tarifaPorMinuto;
    }
}