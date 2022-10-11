package entidad;

import java.sql.Date;

public class Equipo {
	
	private int codigo_equipo;
	private String nombre;
	private String descripcion;
	private Date fechaFabricacion;
	private String nombreMarca;
	private String nombreModelo;
	
	public int getCodigo_equipo() {
		return codigo_equipo;
	}
	public void setCodigo_equipo(int codigo_equipo) {
		this.codigo_equipo = codigo_equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	
	
	
		

}
