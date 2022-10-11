package controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import modelo.ModelCelulares_Villegas;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Equipo;

/**
 * Servlet implementation class ServletCelular_Villegas
 */
@WebServlet("/ServletCelular_Villegas")
public class ServletCelular_Villegas extends HttpServlet {
	ModelCelulares_Villegas mv = new ModelCelulares_Villegas();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCelular_Villegas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equals("listar"))
			listar(request,response);
		else if(tipo.equals("registrar"))
			registrar(request,response);
		else if(tipo.equals("eliminar"))
			eliminar(request,response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Equipo> info = new ModelCelulares_Villegas().listar();
		request.setAttribute("datos", info);
		request.getRequestDispatcher("listarCelulares.jsp").forward(request,response);
		
	}
	
	 private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String dato = request.getParameter("cod");
	      int codigo = Integer.parseInt(dato);
	      mv.eliminarEquipo(codigo);
	      request.getRequestDispatcher("ServletCelular_Villegas?tipo=listar").forward(request, response);
	   }
	
	 private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String dato = request.getParameter("cod");
	      int codigo = Integer.parseInt(dato);
	      Equipo x = mv.buscarEquipo(codigo);
	      request.setAttribute("equi", x);
	      request.getRequestDispatcher("actualizarCelular.jsp").forward(request, response);
	   }

	   private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	Equipo obj = new Equipo();
		      String nom = request.getParameter("txt_nom");
		      String desc = request.getParameter("txt_desc");
		      String fecha = request.getParameter("txt_fecha");
		      
		   //   Date fecha = Date.valueOf(request.getParameter("txt_fecha"));
		      //Date.valueOf(txt_fecha.getText());
		      
		      String marca = request.getParameter("cbo_marca");
		      String modelo = request.getParameter("cbo_modelo");
		   
		   //   DateFormat df = new SimpleDateFormat(date);
		   //   String date = "07-27-2020";
		    //  obj.setFechaFabricacion dateToString = setFechaFabricacion.toString(date);
		    //  obj.setFechaFabricacion = new SimpleDateFormat (date);
		     // obj.setFechaFabricacion.String dateToString= fecha.toString();
		      obj.setNombre(nom);
		      obj.setDescripcion(desc);
		      obj.setFechaFabricacion(fecha);
		      obj.setNombreMarca(marca);
		      obj.setNombreModelo(modelo);
		      int estado = mv.registrarEquipo(obj);
		      if (estado != -1)
		         listar(request, response);
		      else
		         response.sendRedirect("error.html");
		   }

}
