package servicio;

import java.sql.Connection;

import dto.Club;
import dto.Usuario;

public interface InterfazConsulta {

	public void insertarnewUsuario(Connection crearconexion, Usuario usuario);
	public long cargaIDUsuario(Connection crearConnection);
	public long cargaIDClub(Connection crearConnection);
	public void insertarnewClub(Connection crearconexion, Club club);
	public Usuario cargarUsuarioPorDNI(Connection crearConexion, String DNI);
	public void actualizarUser (Connection crearConexion, Usuario user);
	public void eliminarUsuarioPorDNI(Connection crearConexion, String DNI);
}
