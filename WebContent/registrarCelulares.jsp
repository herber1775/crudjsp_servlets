<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Date dNow = new Date();
	SimpleDateFormat ft = 
	new SimpleDateFormat ("dd/MM/yyyy");
	String currentDate = ft.format(dNow);
%>
<body>
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
            <td>Fecha de Fabricación:</td>
            <td><input type="date" name="txt_fecha" value="02/08/2022"></td>       
         </tr>
         <tr>
            <td>Marca:</td>
            <td><select name="cbo_marca" style="width: 150px">
            	<option>BLUE</option>
            	<option>SAMSUNG</option>                  
            </select></td>
         </tr>
         <tr>
            <td>Modelo:</td>
            <td><select name="cbo_modelo" style="width: 150px">
            	<option>x01</option>
            	<option>S20+</option>
            	<option>Energi10</option>
            	<option>S07</option>
            	<option>A19</option>
            	<option>x148</option>                    
            </select></td>
         </tr>
         
         <tr>
            <td colspan="2" align="right"><input type="submit" value="Registrar"></td>
         </tr>
      </table>
   </form>
</body>
</html>