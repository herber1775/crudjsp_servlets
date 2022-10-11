<%@page import="entidad.Equipo" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>REPORTE</title>
</head>
<body>
	<%
      List<Equipo> eq = (List<Equipo>) request.getAttribute("datos");
   %>
   <h2 align="center">LISTADO DE CELULARES</h2>
   <p align="center">
      <a href="registrarCelulares.jsp"> + Nuevo Registro</a>

   <table border="2" align="center" width="75%">
      <tr>
         <th>CÓDIGO</th>
         <th>NOMBRE</th>
         <th>DESCRIPCION</th>
         <th>FECHA</th>
         <th>MARCA</th>
         <th>MODELO</th>
         <th colspan="2">ACCIONES</th>
      </tr>
      <%
         if (eq != null) {
         for (Equipo e : eq) {
      %>
      <tr>
         <td><%=e.getCodigo_equipo()%></td>
         <td><%=e.getNombre()%></td>
         <td><%=e.getDescripcion()%></td>
         <td><%=e.getFechaFabricacion()%></td>
         <td><%=e.getNombreMarca()%></td>
         <td><%=e.getNombreModelo()%></td>
         <td colspan="2" align="center"><a
            href="ServletCelular_Villegas?tipo=eliminar&cod=<%=e.getCodigo_equipo()%>"> <img
               title="Eliminar" src="img/ic_close.png"></a></td>
      </tr>
      <%
      }
   }
%>
   </table>
</body>
</html>