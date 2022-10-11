package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Marca;
import entidad.Equipo;
import entidad.ModeloCell;
import utils.MysqlDBConexion;

public class ModelCelulares_Villegas {
	
	public List<Equipo> listar() {
		Equipo eq = null;
		List<Equipo> datos= new ArrayList<Equipo>();
		Connection cn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {		
			cn=MysqlDBConexion.getConexion();
			//String sql = "select equi_cod, equi_nom, equi_descri, equi_fechafabri, marc_cod, mod_cod from tb_equipo";
			//String sql = "select te.equi_cod, te.equi_nom, te.equi_descri, te.equi_fechafabri, tm.mod_nom, tm.mod_descri from tb_equipo te join tb_modelo tm on tm.mod_cod = te.mod_cod";
			String sql = "select t.equi_cod, t.equi_nom, t.equi_descri, t.equi_fechafabri, tmo.mod_nom, tma.marc_nom\r\n" + 
					"from tb_equipo t \r\n" + 
					"join tb_modelo tmo on tmo.mod_cod = t.mod_cod\r\n" + 
					"join tb_marca tma on tma.marc_cod = t.mod_cod";
			pstm=cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
			eq = new Equipo();
			eq.setCodigo_equipo(rs.getInt(1));
			eq.setNombre(rs.getString(2));
			eq.setDescripcion(rs.getString(3));
			eq.setFechaFabricacion(rs.getDate(4));
			eq.setNombreMarca(rs.getString(5));
			eq.setNombreModelo(rs.getString(6));
			datos.add(eq);
				
			}		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		return datos;
	}
	
	public Equipo buscarEquipo(int cod) {
		Equipo equi = null;
		Connection cn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {		
			cn=MysqlDBConexion.getConexion();
			String sql = "select * from tb_equipo where equi_cod=?";
			//String sql = "select te.equi_cod, te.equi_nom, te.equi_descri, te.equi_fechafabri, tm.mod_nom, tm.mod_descri from tb_equipo te join tb_modelo tm on tm.mod_cod = te.mod_cod";			
			pstm=cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				equi = new Equipo();
				equi.setCodigo_equipo(rs.getInt(1));
				equi.setNombre(rs.getString(2));
				equi.setDescripcion(rs.getString(3));
				equi.setFechaFabricacion(rs.getDate(4));
				equi.setNombreMarca(rs.getString(5));
				equi.setNombreModelo(rs.getString(6));			
			}		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		
		return equi;
	}
	public int registrarEquipo(Equipo obj) {
		
		int estado = -1;
		Connection cn= null;		
		PreparedStatement pstm = null;
		try {		
			cn=MysqlDBConexion.getConexion();
			String sql = "insert into tb_equipo values(null,?,?,?,?,?)";
			//String sql = "select te.equi_cod, te.equi_nom, te.equi_descri, te.equi_fechafabri, tm.mod_nom, tm.mod_descri from tb_equipo te join tb_modelo tm on tm.mod_cod = te.mod_cod";			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setDate(3, obj.getFechaFabricacion());
			pstm.setString(4, obj.getNombreMarca());
			pstm.setString(5, obj.getNombreModelo());
					
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
	         try {
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		
		return estado;
	}
}
