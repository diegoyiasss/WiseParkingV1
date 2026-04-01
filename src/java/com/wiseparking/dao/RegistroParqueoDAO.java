package com.wiseparking.dao;

import com.wiseparking.conexion.ConexionBD;
import com.wiseparking.modelo.RegistroParqueo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroParqueoDAO {

    // Método para INSERTAR un nuevo registro de parqueo
    public boolean registrarEntrada(RegistroParqueo registro) {
        // Esta es la misma query de INSERT que hiciste en MySQL
        String sql = "INSERT INTO RegistrosParqueo (UsuarioID, TipoVehiculoID, LicensePlate, ArrivalTime) VALUES (?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Aquí reemplazamos los "?" de la query con los datos reales usando los "Getters"
            ps.setInt(1, registro.getUsuarioId());
            ps.setInt(2, registro.getTipoVehiculoId());
            ps.setString(3, registro.getLicensePlate());
            ps.setTimestamp(4, registro.getArrivalTime());
            
            // Ejecutamos la inserción
            ps.executeUpdate();
            return true; // Retorna true si guardó bien
            
        } catch (SQLException e) {
            System.out.println("Error al registrar entrada: " + e.getMessage());
            return false; // Retorna false si hubo un error
        }
    }
    // Método para CONSULTAR (Buscar un vehículo estacionado actualmente)
    public RegistroParqueo buscarVehiculoActivo(String placa) {
        RegistroParqueo registro = null;
        String sql = "SELECT * FROM RegistrosParqueo WHERE LicensePlate = ? AND ExitTime IS NULL";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, placa);
            
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    registro = new RegistroParqueo();
                    registro.setRegistroId(rs.getInt("RegistroID"));
                    registro.setUsuarioId(rs.getInt("UsuarioID"));
                    registro.setTipoVehiculoId(rs.getInt("TipoVehiculoID"));
                    registro.setLicensePlate(rs.getString("LicensePlate"));
                    registro.setArrivalTime(rs.getTimestamp("ArrivalTime"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar vehículo: " + e.getMessage());
        }
        return registro;
    }

    // Método para ACTUALIZAR (Registrar la salida y el cobro)
    public boolean registrarSalida(int registroId, java.sql.Timestamp exitTime, double charge) {
        String sql = "UPDATE RegistrosParqueo SET ExitTime = ?, ChargeCalculado = ? WHERE RegistroID = ?";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setTimestamp(1, exitTime);
            ps.setDouble(2, charge);
            ps.setInt(3, registroId);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar salida: " + e.getMessage());
            return false;
        }
    }

    // Método para ELIMINAR un registro
    public boolean eliminarRegistro(int registroId) {
        String sql = "DELETE FROM RegistrosParqueo WHERE RegistroID = ?";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, registroId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro: " + e.getMessage());
            return false;
        }
    }
    // Método para LISTAR todos los vehículos activos (Para el método GET y JSP)
    public java.util.List<RegistroParqueo> listarVehiculosActivos() {
        java.util.List<RegistroParqueo> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM RegistrosParqueo WHERE ExitTime IS NULL";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                RegistroParqueo registro = new RegistroParqueo();
                registro.setRegistroId(rs.getInt("RegistroID"));
                registro.setUsuarioId(rs.getInt("UsuarioID"));
                registro.setTipoVehiculoId(rs.getInt("TipoVehiculoID"));
                registro.setLicensePlate(rs.getString("LicensePlate"));
                registro.setArrivalTime(rs.getTimestamp("ArrivalTime"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar vehículos: " + e.getMessage());
        }
        return lista;
    }
}