package beans;

public class UsuarioCita {
	private Usuario usuario;
	private Cita cita;
	
	public UsuarioCita() {}
	
	public UsuarioCita(Usuario usuario, Cita cita) {
		super();
		this.usuario = usuario;
		this.cita = cita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
	
	
}
