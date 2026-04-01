<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WISEPARKING - Admin</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body>
    
    <header class="navbar">
  <div class="logo">
    <img src="images/logo.png" alt="logo" width="96" height="42">
  </div>
      
      <button class="nav-toggle" aria-label="Abrir menú">☰</button>

      <nav class="nav">
        <ul class="menu">
          <li><a href="reports.html">Reports</a></li>
          <li><a href="index.html">Sign out</a></li> </ul>
      </nav>
    </header>
    
    <main>
        
        <section class="admin-panel">
            <div class="admin-links">
                <a href="register-vehicle.html">Register vehicle</a>
                <a href="exit-vehicle.html">Exit vehicle</a>
                <a href="admin.jsp.html" class="active-link">Admin vehicles</a> </div>

            <p class="description">Manage the currently registered vehicles</p>

            <div class="dashboard-container">
                
                <div class="vehicle-grid">
                    
                    <div class="grid-header">License plate</div>
                    <div class="grid-header">Type of vehicle</div>
                    <div class="grid-header">Arrival time</div>
                    <div class="grid-header">Charge</div>

                    <div class="grid-item">ABC-123</div>
                    <div class="grid-item">Car</div>
                    <div class="grid-item">08:00 AM</div>
                    <div class="grid-item empty-box"></div> <div class="grid-item">XYZ-987</div>
                    <div class="grid-item">Motorcycle</div>
                    <div class="grid-item">08:15 AM</div>
                    <div class="grid-item empty-box"></div>

                    <div class="grid-item">ZZZ-111</div>
                    <div class="grid-item">Car</div>
                    <div class="grid-item">09:30 AM</div>
                    <div class="grid-item empty-box"></div>
                    
                     <div class="grid-item">BBB-222</div>
                    <div class="grid-item">Car</div>
                    <div class="grid-item">09:30 AM</div>
                    <div class="grid-item empty-box"></div>

                </div>

                <div class="admin-image">
                    <img src="images/admin.png" alt="Parking Overview">
                </div>

 </div>

<section class="Contact-us" id="contact">
  <h2>Contact us</h2>
  </section>

<div class="contact-container">
    
  <div class="contact-item">
    <h3>Call us</h3>
    <p>+573224121883</p>
  </div>

  <div class="contact-item whatsapp">
    <h3>WhatsApp</h3>
    <p>+573224121883</p>
  </div>

  <div class="contact-item instagram">
    <h3>Instagram</h3>
    <p>@wiseparking</p>
  </div>
  
</div>
</section>

    </main>


    
    <script>
        const navToggle = document.querySelector(".nav-toggle");
        const navMenu = document.querySelector(".menu");
        navToggle.addEventListener("click", () => {
          navMenu.classList.toggle("nav-visible");
        });
    </script>
</body>
<!-- Importar las clases de Java necesarias en JSP -->
<%@page import="java.util.List"%>
<%@page import="com.wiseparking.modelo.RegistroParqueo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <!-- Aquí van tus estilos CSS -->
</head>
<body>
    <h2>Vehículos en el Parqueadero</h2>
    <table border="1">
        <tr>
            <th>ID Registro</th>
            <th>Placa</th>
            <th>Hora de Llegada</th>
        </tr>
        
        <% 
            // ELEMENTOS DE JSP: Recuperar la lista enviada por el Servlet
            List<RegistroParqueo> vehiculos = (List<RegistroParqueo>) request.getAttribute("listaVehiculos");
            
            if (vehiculos != null && !vehiculos.isEmpty()) {
                // Ciclo para imprimir cada fila de la tabla
                for (RegistroParqueo v : vehiculos) {
        %>
                    <tr>
                        <td><%= v.getRegistroId() %></td>
                        <td><%= v.getLicensePlate() %></td>
                        <td><%= v.getArrivalTime() %></td>
                    </tr>
        <% 
                }
            } else {
        %>
                <tr>
                    <td colspan="3">No hay vehículos registrados.</td>
                </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
</html>