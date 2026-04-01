package com.wiseparking.controlador;

import com.wiseparking.dao.RegistroParqueoDAO;
import com.wiseparking.modelo.RegistroParqueo;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // 1. Recibir los datos del formulario HTML
            int usuarioId = 1; // ID temporal
            int tipoVehiculoId = Integer.parseInt(request.getParameter("vehicleType"));
            String placa = request.getParameter("licensePlate");
            
            // 2. Convertir la fecha
            String arrivalTimeStr = request.getParameter("arrivalTime");
            Timestamp arrivalTime = null;
            if (arrivalTimeStr != null && !arrivalTimeStr.isEmpty()) {
                arrivalTimeStr = arrivalTimeStr.replace("T", " ") + ":00"; 
                arrivalTime = Timestamp.valueOf(arrivalTimeStr);
            }

            // 3. Crear el objeto modelo
            RegistroParqueo registro = new RegistroParqueo();
            registro.setUsuarioId(usuarioId);
            registro.setTipoVehiculoId(tipoVehiculoId);
            registro.setLicensePlate(placa);
            registro.setArrivalTime(arrivalTime);

            // 4. Enviar a la base de datos
            RegistroParqueoDAO dao = new RegistroParqueoDAO();
            boolean exito = dao.registrarEntrada(registro);

            // 5. Mostrar resultado
            response.setContentType("text/html;charset=UTF-8");
            if (exito) {
                response.getWriter().println("<h1>¡Vehiculo registrado exitosamente en la base de datos!</h1>");
                response.getWriter().println("<a href='admin.html'>Volver al administrador</a>");
            } else {
                response.getWriter().println("<h1>Error al intentar guardar en la base de datos.</h1>");
            }
            
        } catch (Exception e) {
            response.getWriter().println("Error procesando los datos: " + e.getMessage());
        }
    }
}