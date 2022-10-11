<%@page import="java.util.Date" %>
<%@page import="entidad.Equipo" %>
<%@page import="entidad.Marca" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
$(function () {
$("#datepicker").datepicker();
});
</script>
<body>

<%
      List<Equipo> eq = (List<Equipo>) request.getAttribute("datos");
   %>
   <form action="ServletCelular_Villegas?tipo=registrar" id="frmregistro" method="post">
      <table>
         <tr>
            <td>Codigo:</td>
            <td><input type="text" name="txt_cod" class="required"></td>
         </tr>
         <tr>
            <td>Nombre:</td>
            <td><input type="text" name="txt_nom" class="required"></td>
         </tr>
         <tr>
          
            <td>Descripción:</td>
            <td><input type="text" name="txt_desc" class="required"></td>
          
         </tr>     
         <tr>
         <!--  id="datepicker"-->
            <td>Fecha de Fabricación:</td>
           <td><input type="date" name="txt_fecha"></td>      
         </tr>
         <tr>
            <td>Marca:</td>
            <td><select name="cbo_marca" style="width: 150px">
            	        <%
		         if (eq != null) {
		         for (Equipo e : eq) {
			      %>
			      <option value=""><%=e.getNombre()%></option>
			   
			      <%
			      	}
		   		  }
				%>             
            </select></td>
            
       


            
            
            <!--  
             <td><select name="cbo_marca" style="width: 150px">
            	<option value="1">BLUE</option>
            	<option value="2">SAMSUNG</option> 
            	<option value="3">ALCATEL</option>
            	<option value="4">SONI</option>                  
            </select></td>-->
         </tr>
         <tr>
            <td>Modelo:</td>
            <td><select name="cbo_modelo" style="width: 150px">
            	<option value="1">x01</option>
            	<option value="2">S20+</option>   
            	<option value="3">A45</option>
            	<option value="4">REDI6+</option>                    
            </select></td>
         </tr>
         
         <tr>
            <td colspan="2" align="right"><input type="submit" value="Registrar"></td>
         </tr>
      </table>
   </form>
</body>
</html>