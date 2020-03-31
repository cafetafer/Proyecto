package beans;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class Estudiante {

	private int id_estudiante;
	@NotNull(message = "Ingresa Nombre.")
	private String nombre;
	@NotNull(message = "Ingresa Ap paternp.")
	private String apPat;
	@NotNull(message = "Ingresa Ap materno.")
	private String apMat;   
	@Pattern(regexp = "^(30)\\d{7}")      
	private String cuenta; 
	@NotEmpty @Email
	private String correo;
	@NotNull @Min(18) @Max(100)
	private Integer edad;
	@NotNull
	private String genero;
	@NotNull(message = "Ingresa programa de posgrado.")
	private String posgrado;

	public Estudiante() {  
	}

	public Estudiante( int id_estudiante, String nombre, String aP, String aM, String cuenta,
			String correo, int edad, String gen, String pos) {
		this.id_estudiante = id_estudiante;
		this.nombre = nombre;
		this.apPat = aP;
		this.apMat = aM;
		this.cuenta = cuenta;
		this.correo = correo;
		this.edad = edad;
		this.genero = gen;
		this.posgrado = pos;
		

	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPat() {
		return apPat;
	}

	public void setApPat(String apPat) {
		this.apPat = apPat;
	}

	public String getApMat() {
		return apMat;
	}

	public void setApMat(String apMat) {
		this.apMat = apMat;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPosgrado() {
		return posgrado;
	}

	public void setPosgrado(String posgrado) {
		this.posgrado = posgrado;
	} 




}
