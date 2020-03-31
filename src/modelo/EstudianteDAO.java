/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import beans.Estudiante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EstudianteDAO extends SimpleJdbcDaoSupport{

    private static final String CONSULTATODOS = "SELECT * FROM estudiante";
    private static final String MODIFICAPERSONA =
            "UPDATE estudiante SET  nombre = ?, apPat = ?, " +
            "apMat = ?, cuenta = ?, correo = ?, edad =  ?, genero =  ?,posgrado =  ? "+
            "WHERE id_estudiante = ? ";

    class ProyectosRowMapper implements ParameterizedRowMapper<Estudiante>  {

        public Estudiante mapRow( ResultSet rs, int numeroRenglon ) throws SQLException {
            
            Estudiante to = new Estudiante();
            to.setId_estudiante( rs.getInt( "id_estudiante" ) );
            to.setNombre( rs.getString( "nombre" ) );
            to.setApPat( rs.getString( "apPat" ) );
            to.setApMat( rs.getString( "apMat" ) );
            to.setCuenta( rs.getString( "cuenta" ) );
            to.setCorreo( rs.getString( "correo" ) );
            to.setEdad( rs.getInt( "edad" ) );
            to.setGenero( rs.getString( "genero" ) );
            to.setPosgrado( rs.getString( "posgrado" ) );
            return to;
        }
    }

    public ArrayList<Estudiante> consultaTodos() {
    	
        SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
        ArrayList<Estudiante> lista =
                (ArrayList<Estudiante>) sjdbc.query( CONSULTATODOS, new ProyectosRowMapper() );
        return lista;
    }
    
public ArrayList<Estudiante> consultaTodosArray() {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
    	ArrayList<Estudiante> estudiantes =
                (ArrayList<Estudiante>) sjdbc.query( CONSULTATODOS, new ProyectosRowMapper() );	
    	return  estudiantes ;   	
    }
    public void modificaEstudiante( Estudiante est ) {
    	
        SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
        sjdbct.update( MODIFICAPERSONA, est.getNombre(), est.getApPat(),
        		est.getApMat(), est.getCuenta(), est.getCorreo(), est.getEdad(), est.getGenero(),
        		est.getPosgrado(), est.getId_estudiante());
    
    }
}
