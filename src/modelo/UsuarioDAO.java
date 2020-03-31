/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import beans.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UsuarioDAO extends SimpleJdbcDaoSupport{

	private static final String CONSULTATODOS = "SELECT * FROM usuario";
	private static final String MODIFICAUSUARIO =
			"UPDATE usuario SET id_usuario = ?, nombre = ?, apellido1 = ?, " +
					"apellido2 = ?, facultad = ?, esProfesor = ?, email = ?, password = ?, rfc = ? "+
					", departamento =  ?, nCuenta = ?, carrera = ? "+
					"WHERE id_usuario = ? ";
	private static final String AGREGAUSUARIO = "INSERT INTO `usuario` (`nombre`,`apellido1`,`apellido2`,`facultad`,"+
			"`esProfesor`,`email`,`password`,`rfc`,`departamento`,`nCuenta`,`carrera`) "+
			"VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	class ProyectosRowMapper implements ParameterizedRowMapper<Usuario>  {

		public Usuario mapRow( ResultSet rs, int numeroRenglon ) throws SQLException {

			Usuario usuario = new Usuario();

			usuario.setId_usuario( rs.getInt( "id_usuario" ) );
			usuario.setNombre( rs.getString( "nombre" ) );
			usuario.setApellido1( rs.getString( "apellido1" ) );
			usuario.setApellido2( rs.getString( "apellido2" ) );
			usuario.setFacultad( rs.getString( "facultad" ) );
			usuario.setEsProfesor( rs.getBoolean( "esProfesor" ) );
			usuario.setEmail( rs.getString( "email" ) );
			usuario.setPassword( rs.getString( "password" ) );
			usuario.setRfc( rs.getString( "rfc" ) );
			usuario.setDepartamento( rs.getString( "departamento" ) );
			usuario.setnCuenta( rs.getString( "nCuenta" ) );
			usuario.setCarrera( rs.getString( "carrera" ) );

			return usuario;
		}
	}

	public ArrayList<Usuario> consultaTodosArray() {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
		ArrayList<Usuario> usuarios =
				(ArrayList<Usuario>) sjdbc.query( CONSULTATODOS, new ProyectosRowMapper() );	
		return  usuarios ;   	
	}

	public void modificaUsuario( Usuario usr ) {

		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		sjdbct.update( MODIFICAUSUARIO, usr.getId_usuario(), usr.getNombre(),usr.getApellido1(),usr.getApellido2(),
				usr.getFacultad(),usr.getEsProfesor(),usr.getEmail(),usr.getPassword(),usr.getRfc(),usr.getDepartamento(),
				usr.getnCuenta(),usr.getCarrera(), usr.getId_usuario());

	}

	public void agregaUsuario( Usuario usr ) {

		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		sjdbct.update( AGREGAUSUARIO, usr.getNombre(),usr.getApellido1(),usr.getApellido2(),
				usr.getFacultad(),usr.getEsProfesor(),usr.getEmail(),usr.getPassword(),usr.getRfc(),usr.getDepartamento(),
				usr.getnCuenta(),usr.getCarrera());

	}

	public String getNombre(int id) {
		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		ArrayList<Usuario> usuarios =
				(ArrayList<Usuario>) sjdbct.query( CONSULTATODOS, new ProyectosRowMapper()  );
		
		for (Usuario usuario : usuarios){ 
			if(usuario.getId_usuario() == id) {
				return usuario.getNombre().toString() +" "+ usuario.getApellido1().toString();
			}
		}
		return null;
	}
	public String getCorreoProf(int id) {
		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		ArrayList<Usuario> usuarios =
				(ArrayList<Usuario>) sjdbct.query( CONSULTATODOS, new ProyectosRowMapper()  );
		
		for (Usuario usuario : usuarios){ 
			if(usuario.getId_usuario() == id) {
				return usuario.getEmail().toString() ;
			}
		}
		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	