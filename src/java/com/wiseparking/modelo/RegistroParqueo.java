package com.wiseparking.modelo;

import java.sql.Timestamp;

public class RegistroParqueo {
    private int registroId;
    private int usuarioId;
    private int tipoVehiculoId;
    private String licensePlate;
    private Timestamp arrivalTime;
    private Timestamp exitTime;
    private double chargeCalculado;

    public RegistroParqueo() {
    }

    public RegistroParqueo(int registroId, int usuarioId, int tipoVehiculoId, String licensePlate, Timestamp arrivalTime, Timestamp exitTime, double chargeCalculado) {
        this.registroId = registroId;
        this.usuarioId = usuarioId;
        this.tipoVehiculoId = tipoVehiculoId;
        this.licensePlate = licensePlate;
        this.arrivalTime = arrivalTime;
        this.exitTime = exitTime;
        this.chargeCalculado = chargeCalculado;
    }

    // Genera los Getters y Setters con Alt + Insert.

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    public double getChargeCalculado() {
        return chargeCalculado;
    }

    public void setChargeCalculado(double chargeCalculado) {
        this.chargeCalculado = chargeCalculado;
    }
}