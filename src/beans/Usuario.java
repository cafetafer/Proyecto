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

public class Usuario {

	private int id_usuario;
	@NotNull(message = "Ingresa Nombre.")
	private String nombre;
	@NotNull(message = "Ingresa Ap paternp.")
	private String apellido1;
	@NotNull(message = "Ingresa Ap materno.")
	private String apellido2;
	@NotNull(message = "Ingresa Facultad")
	private String facultad;
	@NotNull(message = "Ingresa tipo de usuario")
	private boolean esProfesor;
	
	@NotEmpty @Email
	private String email;
	@NotNull(message = "ingresa una contraseña")
	private String password;


	private String rfc;
	private String departamento;
	
	@Pattern(regexp = "^(30)\\d{7}")      
	private String nCuenta; 
	private String carrera;
	
	public Usuario() {
		
	}
	
	public Usuario(int id_usuario, String nombre, String apellido1,String apellido2,String facultad,
			String email,String password,String rfc, String departamento,String nCuenta, String carrera, boolean esProfesor) {
		this.id_usuario=id_usuario;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.facultad= facultad;
		this.email= email;
		this.password= password;
		this.rfc= rfc;
		this.departamento= departamento;
		this.nCuenta= nCuenta; 
		this.carrera= carrera;
		this.esProfesor=esProfesor;
	}
	
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getnCuenta() {
		return nCuenta;
	}
	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public boolean getEsProfesor() {
		return esProfesor;
	}

	public void setEsProfesor(boolean esProfesor) {
		this.esProfesor = esProfesor;
	}
	
}
