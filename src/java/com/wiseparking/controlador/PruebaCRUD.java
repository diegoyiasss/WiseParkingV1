package com.wiseparking.controlador;

import com.wiseparking.dao.RegistroParqueoDAO;
import com.wiseparking.modelo.RegistroParqueo;
import java.sql.Timestamp;

public class PruebaCRUD {

    public static void main(String[] args) {
        
        RegistroParqueoDAO dao = new RegistroParqueoDAO();

        System.out.println("--- 1. PROBANDO INSERCIÓN (CREAR) ---");
        RegistroParqueo nuevoRegistro = new RegistroParqueo();
        nuevoRegistro.setUsuarioId(1); // Suponiendo que el Usuario 1 existe (Diego Castiblanco)
        nuevoRegistro.setTipoVehiculoId(1); // Suponiendo que el Tipo 1 es "Carro"
        nuevoRegistro.setLicensePlate("XYZ-999");
        nuevoRegistro.setArrivalTime(new Timestamp(System.currentTimeMillis())); // Hora actual

        boolean guardado = dao.registrarEntrada(nuevoRegistro);
        if (guardado) {
            System.out.println("¡Vehículo XYZ-999 registrado correctamente!");
        }

        System.out.println("\n--- 2. PROBANDO CONSULTA (LEER) ---");
        RegistroParqueo vehiculoEncontrado = dao.buscarVehiculoActivo("XYZ-999");
        if (vehiculoEncontrado != null) {
            System.out.println("Vehículo encontrado: " + vehiculoEncontrado.getLicensePlate());
            System.out.println("ID del Registro: " + vehiculoEncontrado.getRegistroId());
            System.out.println("Hora de llegada: " + vehiculoEncontrado.getArrivalTime());
            
            System.out.println("\n--- 3. PROBANDO ACTUALIZACIÓN (REGISTRAR SALIDA) ---");
            // Simulamos que pasaron unas horas y cobramos 5000
            Timestamp horaSalida = new Timestamp(System.currentTimeMillis() + 3600000); // 1 hora después
            boolean actualizado = dao.registrarSalida(vehiculoEncontrado.getRegistroId(), horaSalida, 5000.0);
            
            if(actualizado){
                 System.out.println("¡Salida y cobro registrados correctamente!");
            }
        } else {
            System.out.println("Vehículo no encontrado o ya registró salida.");
        }
        
        // Nota: La eliminación (DELETE) la dejamos comentada para que el registro quede en tu BD y lo puedas ver.
        // Si quieres probarla, descomenta las siguientes líneas:
        /*
        System.out.println("\n--- 4. PROBANDO ELIMINACIÓN (BORRAR) ---");
        if (vehiculoEncontrado != null) {
             boolean eliminado = dao.eliminarRegistro(vehiculoEncontrado.getRegistroId());
             if(eliminado){
                 System.out.println("¡Registro eliminado correctamente de la base de datos!");
             }
        }
        */
    }
}