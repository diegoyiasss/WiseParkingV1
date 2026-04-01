package com.wiseparking.controlador;

import com.wiseparking.dao.RegistroParqueoDAO;
import com.wiseparking.modelo.RegistroParqueo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    // UTILIZANDO MÉTODO GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtener la lista de la base de datos
        RegistroParqueoDAO dao = new RegistroParqueoDAO();
        List<RegistroParqueo> listaVehiculos = dao.listarVehiculosActivos();
        
        // 2. Guardar la lista en el "request" para enviarla al JSP
        request.setAttribute("listaVehiculos", listaVehiculos);
        
        // 3. Redirigir a la página JSP
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}