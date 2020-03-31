package control;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.lang.Iterable;

import beans.Login;

import beans.UsuarioCita;
import beans.Cita;
import modelo.CitaDAO;
import beans.Usuario;
import beans.ListaUsuarios;
import modelo.UsuarioDAO;
import beans.ListaCitas;

import beans.Estudiante;
import beans.ListaEstudiantes;
import modelo.EstudianteDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class EstudianteControl {

	private Usuario usr;
	

	
	@RequestMapping( value = "/get", method = RequestMethod.GET )
	public ModelAndView get() {


		Usuario usuario = new Usuario();

		return new ModelAndView( "add_contacto" , "usuario", usuario );
	}

	@RequestMapping( value = "/agregar_usuario", method = RequestMethod.POST )
	public ModelAndView agregar_usuario(@ModelAttribute("usuario") Usuario usuario) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );

		dao.agregaUsuario(usuario);

		return new ModelAndView( "add_contacto" , "usuario", usuario );
	}

	@RequestMapping( value = "/ingresar", method = RequestMethod.POST )
	public ModelAndView ingresar(@ModelAttribute("login") Login login) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );

		ArrayList<Usuario> lista = dao.consultaTodosArray();

		ListaUsuarios listaUsuarios = new ListaUsuarios();
		listaUsuarios.setListaUsuarios( lista );

		for (Usuario usuario : lista){ 
			if(usuario.getEmail().contentEquals(login.getEmail()) &&
					usuario.getPassword().contentEquals(login.getPassword())) {
				usr = usuario;
				if(usuario.getEsProfesor())
					return new ModelAndView( "administrar_datos_prof" , "usuario", usuario );
				else
					return new ModelAndView( "administrar_datos_alumno" , "usuario", usuario );

			}
		}

		return new ModelAndView( "add_contacto" , "login", login );		
	}
	//////////////////////////////PROFESOR////////////////////////////////
	@RequestMapping( value = "/administrar_datos_prof", method = RequestMethod.POST )
	public ModelAndView administrar_datos_prof(@ModelAttribute("usuario") Usuario usuario) {
		usuario = usr;

		return new ModelAndView( "administrar_datos_prof" , "usuario", usuario );
	}

	@RequestMapping( value = "/actualizar_datos_prof", method = RequestMethod.POST )
	public ModelAndView actualizar_datos_prof(@ModelAttribute("usuario") Usuario usuario) {

		usr.setNombre(usuario.getNombre());
		usr.setApellido1(usuario.getApellido1());
		usr.setApellido2(usuario.getApellido2());
		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );
		dao.modificaUsuario(usr);

		return new ModelAndView( "administrar_datos_prof" , "usuario", usr );
	}

	@RequestMapping( value = "/publicar_cita", method = RequestMethod.POST )
	public ModelAndView publicar_cita(@ModelAttribute("usuario") Usuario usuario) {
		usuario = usr;

		return new ModelAndView( "publicar_cita" , "usuario", usuario );
	}

	@RequestMapping( value = "/publica", method = RequestMethod.POST )
	public ModelAndView publica(@ModelAttribute("cita") Cita cita ) {

		if(cita.getLugar() != null) {

			ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
			CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

			cita.setId_profesor((int)usr.getId_usuario());
			cita.setFecha(cita.getFecha());
			dao.agregaCita(cita);
		}
		return new ModelAndView( "ver_citas" , "usuario", usr );


	}



	@RequestMapping( value = "/ver_citas", method = RequestMethod.POST )
	public ModelAndView ver_citas(@ModelAttribute("listaCitas") ListaCitas listaCitas, @ModelAttribute("listaCitas2") ListaCitas listaCitas2) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosProfesorAsignadasArray( usr.getId_usuario());

		listaCitas.setListaCitas( lista );
		
		ArrayList<Cita> lista2 = dao.consultaTodosProfesorDisponiblesArray( usr.getId_usuario());

		listaCitas2.setListaCitas( lista2 );

		return new ModelAndView( "ver_citas" , "usuario", usr );
	}
	
	@RequestMapping( value = "/ver_citas_solicitadas", method = RequestMethod.POST )
	public ModelAndView ver_citas_solicitadas(@ModelAttribute("listaCitas") ListaCitas listaCitas) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosProfesorSolicitadasArray( usr.getId_usuario());
		listaCitas.setListaCitas( lista );
		
		return new ModelAndView( "ver_citas_solicitadas" , "usuario", usr );
	}
	
	@RequestMapping( "/borra_cita/{id_cita}" )
	public String borra_cita(@PathVariable("id_cita") Integer id_cita) {


		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );
				
		dao.borrarCita(id_cita);
		
		return "redirect:/regresa.html";
	}
	
	@RequestMapping( "/aceptar_cita/{id_cita}" )
	public String aceptar_cita(@PathVariable("id_cita") Integer id_cita) {


		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );
				
		dao.aceptarCita(id_cita);
		
		return "redirect:/regresa.html";
	}
	@RequestMapping( "/rechazar_cita/{id_cita}" )
	public String rechazar_cita(@PathVariable("id_cita") Integer id_cita) {


		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );
				
		dao.rechazarCita(id_cita);
		
		return "redirect:/regresa.html";
	}
	/*@RequestMapping( "/cerrar_sesion/" )
	public String rechazar_cita() {
		
		return "redirect:/get.html";
	}*/

	@RequestMapping( value = "/regresa", method = RequestMethod.GET )
	public ModelAndView regresa() {

		return new ModelAndView( "ver_citas" , "usuario", usr );
	}
	//////////////////////////////ALUMNO////////////////////////////////
	@RequestMapping( value = "/administrar_datos_alumno", method = RequestMethod.POST )
	public ModelAndView administrar_datos_alumno(@ModelAttribute("usuario") Usuario usuario) {
		usuario = usr;

		return new ModelAndView( "administrar_datos_alumno" , "usuario", usuario );
	}
	
	@RequestMapping( value = "/actualizar_datos_alumno", method = RequestMethod.POST )
	public ModelAndView actualizar_datos_alumno(@ModelAttribute("usuario") Usuario usuario) {

		usr.setNombre(usuario.getNombre());
		usr.setApellido1(usuario.getApellido1());
		usr.setApellido2(usuario.getApellido2());
		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );
		dao.modificaUsuario(usr);

		return new ModelAndView( "administrar_datos_alumno" , "usuario", usr );
	}

	@RequestMapping( value = "/ver_citas_agendadas", method = RequestMethod.POST )
	public ModelAndView ver_citas_agendadas(@ModelAttribute("listaCitas") ListaCitas listaCitas) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosAlumnoAgendadas( usr.getId_usuario());

		listaCitas.setListaCitas( lista );
		
	
		
		return new ModelAndView( "ver_citas_agendadas" , "usuario", usr );
	}
	
	@RequestMapping( value = "/solicitar_cita", method = RequestMethod.POST )
	public ModelAndView solicitar_cita(@ModelAttribute("listaCitas") ListaCitas listaCitas,
			@ModelAttribute("listaCitas2") ListaCitas listaCitas2,
			@ModelAttribute("listaCitas3") ListaCitas listaCitas3) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosDisponiblesMateArray();
		listaCitas.setListaCitas( lista );
		
		lista = dao.consultaTodosDisponiblesFisiArray();
		listaCitas2.setListaCitas( lista );
		
		lista = dao.consultaTodosDisponiblesCompuArray();
		listaCitas3.setListaCitas( lista );
		
		
		return new ModelAndView( "solicitar_cita" , "usuario", usr );
	}
	
	@RequestMapping( "/solicitar/{id_cita}" )
	public String solicitar(@PathVariable("id_cita") Integer id_cita) {


		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );
				
		dao.solicitarCita(usr.getId_usuario(), id_cita);
		
		return "redirect:/regresa2.html";
	}
	
	@RequestMapping( value = "/regresa2", method = RequestMethod.GET )
	public ModelAndView regresa2() {

		return new ModelAndView( "ver_citas_agendadas" , "usuario", usr );
	}
	
	//////////////////////////////////////////////////////////////

	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public ModelAndView save( @ModelAttribute("listaestudiantes") ListaEstudiantes listaestudiantes ) {

		System.out.println( listaestudiantes );
		System.out.println( listaestudiantes.getEstudiantes() );
		List<Estudiante> lista = listaestudiantes.getEstudiantes();
		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		EstudianteDAO dao = (EstudianteDAO)context.getBean( "estudianteDAO" );

		if( null != lista && lista.size() > 0 ) {
			for( Estudiante estu : lista ) {
				dao.modificaEstudiante( estu );
			}
		}		
		return new ModelAndView( "show_contacto", "listaestudiantes", listaestudiantes );
	}		
}
