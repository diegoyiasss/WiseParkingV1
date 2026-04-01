package com.wiseparking.modelo;

public class Usuario {
    private int usuarioId;
    private String email;
    private String passwordHash;
    private String nombrePropietario;

    public Usuario() {
    }

    public Usuario(int usuarioId, String email, String passwordHash, String nombrePropietario) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.nombrePropietario = nombrePropietario;
    }

    // Para generar los Getters y Setters automáticamente en NetBeans:
    // Presiona Alt + Insert (o clic derecho -> Insert Code) -> Selecciona "Getter and Setter" -> Selecciona todas las variables -> Clic en Generate.

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
}