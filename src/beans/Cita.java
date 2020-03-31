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

public class Cita {

		private int id_cita;
		private String materia;
		private String fecha;
		private String hora;
		private String lugar;
		private int id_alumno;
		private int id_profesor;
		private boolean asignada;
		private boolean solicitada;
		private String nombre_profesor;
		private String nombre_alumno;
		private String correoProf;
		
		
		public Cita() {
			
		}
		
		public Cita(int id_cita,String mat, String fecha, String hora, String lugar,
		int al, int pr, boolean solicitada, boolean asignada) {
			this.id_cita= id_cita;
			this.materia = mat;
			this.fecha= fecha;
			this.hora= hora;
			this.lugar= lugar;
			this.id_alumno=al;
			this.id_profesor= pr;
			this.asignada=asignada;
			this.solicitada=solicitada;
		}

		public int getId_cita() {
			return id_cita;
		}

		public void setId_cita(int id_cita) {
			this.id_cita = id_cita;
		}
		
		public String getMateria() {
			return materia;
		}

		public void setMateria(String materia) {
			this.materia = materia;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getHora() {
			return hora;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}

		public String getLugar() {
			return lugar;
		}

		public void setLugar(String lugar) {
			this.lugar = lugar;
		}

		public int getId_alumno() {
			return id_alumno;
		}

		public void setId_alumno(int id_alumno) {
			this.id_alumno = id_alumno;
		}

		public int getId_profesor() {
			return id_profesor;
		}

		public void setId_profesor(int id_profesor) {
			this.id_profesor = id_profesor;
		}

		public boolean isAsignada() {
			return asignada;
		}

		public void setAsignada(boolean asignada) {
			this.asignada = asignada;
		}
		
		public boolean isSolicitada() {
			return solicitada;
		}

		public void setSolicitada(boolean solicitada) {
			this.solicitada = solicitada;
		}

		public String getNombre_profesor() {
			return nombre_profesor;
		}

		public void setNombre_profesor(String nombre_profesor) {
			this.nombre_profesor = nombre_profesor;
		}

		public String getNombre_alumno() {
			return nombre_alumno;
		}

		public void setNombre_alumno(String nombre_alumno) {
			this.nombre_alumno = nombre_alumno;
		}

		public String getCorreoProf() {
			return correoProf;
		}

		public void setCorreoProf(String correoProf) {
			this.correoProf = correoProf;
		}
		
		
		
}
