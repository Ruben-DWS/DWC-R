package servicio;
import dto.Club;
import dto.Usuario;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ConsultaFuncionalidade implements InterfazConsulta{

	/**
	 * @author Ruben
	 * Metodo que inserta nuevo usuario en la base de datos
	 * */
	
	public void insertarnewUsuario(Connection crearconexion, Usuario usuario){
		
		PreparedStatement statenmen = null;
		
		try {
			// Saco la query de postgre para insertarsela al statement
			String sql = "INSERT INTO dlk.usuario (id, nombre, apellidos, dni, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
			statenmen = crearconexion.prepareStatement(sql);
			// Relleno los campos
			statenmen.setLong(1, usuario.getId());
			statenmen.setString(2, usuario.getNombre());
			statenmen.setString(3, usuario.getApellidos());
			statenmen.setString(4, usuario.getDni());
			statenmen.setInt(5, usuario.getTelefono());
			statenmen.setString(6, usuario.getEmail());
			statenmen.executeQuery();
	        // cierro recursos
			statenmen.close();
			crearconexion.close();			
		} catch (SQLException e) {
		
			System.err.println("[ERROR-InterfazConsulta-insertarnewUsuario] Error generando o ejecutando la declaracionSQL: " + e);
			
		}
		
	}
	
	
	/**
	 * @author Ruben
	 * Metodo que comprueba y inserta DNI
	 * */
	
	public long cargaIDUsuario(Connection crearConnection) {
	    String sql = "SELECT * FROM dlk.usuario ORDER BY id DESC LIMIT 1";
	    
	    Statement statemen = null;
	    ResultSet result = null;
	    
	    long newID = 0;
	    
	    try {
	        statemen = crearConnection.createStatement();
	        result = statemen.executeQuery(sql);
	        
	        if (result.next()) {
	            newID = result.getLong("id") + 1;
	        } else {
	            newID = 1;
	        }
	        
	        result.close();
	        statemen.close();
	        crearConnection.close();
	        
	    } catch (Exception e) {
	        System.err.println("[ERROR]- ConsultaFuncionalidades-cargarIDUsuario" + e);
	    }
	    
	    return newID;
	}
	
	
	public long cargaIDClub(Connection crearConnection) {
	    String sql = "SELECT * FROM dlk.club ORDER BY id DESC LIMIT 1";
	    Statement statemen = null;
	    ResultSet result = null;
	    
	    long newID = 0;
	    
	    try {
	        statemen = crearConnection.createStatement();
	        result = statemen.executeQuery(sql);
	        
	        if (result.next()) {
	            newID = result.getLong("id") + 1;
	        } else {
	            newID = 1;
	        }
	        
	        result.close();
	        statemen.close();
	        crearConnection.close();
	        
	    } catch (Exception e) {
	        System.err.println("[ERROR]- ConsultaFuncionalidades-cargarIDUsuario" + e);
	    }
	    
	    return newID;
	}
	
	
	
	
	public void insertarnewClub(Connection crearconexion, Club club){
		
		PreparedStatement statenmen = null;
		
		try {
			
			String sql = "INSERT INTO dlk.club (id, nombre, colores, alias) VALUES (?, ?, ?, ? )";
			statenmen = crearconexion.prepareStatement(sql);
			
			statenmen.setLong(1, club.getId());
			statenmen.setString(2, club.getNombre());
			statenmen.setString(3, club.getColores());
			statenmen.setString(4, club.getAlias());
			statenmen.executeQuery();
	        
			statenmen.close();
			crearconexion.close();			
		} catch (SQLException e) {
		
			System.err.println("[ERROR-InterfazConsulta-insertarnewUsuario] Error generando o ejecutando la declaracionSQL: " + e);
			
		}
		
	}
	
	/**
	 * @author Ruben
	 * 
	 * Metodo que recoge un DNI y hace una carga de tabla usuario para comprobar 
	 * que existe dicho usuario lo carga y lo devuelve para editarlo de manera local
	 * */
	
	public Usuario cargarUsuarioPorDNI(Connection crearConexion, String DNI) {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        String sql = "SELECT id, nombre, apellidos, dni, telefono, email FROM dlk.usuario WHERE dni = ?";
	        statement = crearConexion.prepareStatement(sql);
	        statement.setString(1, DNI);
	        resultSet = statement.executeQuery();

	        // Si se encuentra un resultado, crea el objeto Usuario
	        if (resultSet.next()) {
	            long id = resultSet.getLong("id");
	            String nombre = resultSet.getString("nombre");
	            String apellidos = resultSet.getString("apellidos");
	            String dni = resultSet.getString("dni");
	            int telefono = resultSet.getInt("telefono");
	            String email = resultSet.getString("email");
	            Usuario user = new Usuario(id, nombre, apellidos, dni, telefono, email);
	            return user;
	           
	        } else {
	            return null; // Devuelve null si no se encuentra el usuario
	        }
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	        return null; // Devuelve null si ocurre una excepción
	    } finally {
	        // Cerrar recursos
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	            crearConexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	/**
	 * @author Ruben
	 * Metodo que al pasarle un usuario y una conexion ya comprobado que existe lo actualiza
	 * */
	
	public void actualizarUser (Connection crearConexion, Usuario user) {
	    PreparedStatement statement = null;
	    try {
	        String sql = "UPDATE dlk.usuario SET nombre = ?, apellidos = ?, dni = ?, telefono = ?, email = ? WHERE id = ?"; // Ejecuto una consulta de actualizacion que a su vez recoge el id del usuario a editar
	        statement = crearConexion.prepareStatement(sql);

	        // introduzco los valores que ya trae el usuario que le paso
	        statement.setString(1, user.getNombre());
	        statement.setString(2, user.getApellidos());
	        statement.setString(3, user.getDni());
	        statement.setInt(4, user.getTelefono());
	        statement.setString(5, user.getEmail());
	        statement.setLong(6, user.getId());

	        // Ejecutar la actualización
	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("[INFO] - Usuario actualizado correctamente."); // para comprobar que se actualizado la columna calculo si ha sido afectada
	        } else {
	            System.out.println("[WARN] - No se encontró el usuario con el ID proporcionado.");
	        }
	        
	        statement.close();
	        crearConexion.close();
	        
	    } catch (SQLException e) {
	    		
	    		System.err.println("[ERROR-ConsultaFuncionalidades-actualizarUser]" + e);

	    } 
	}
	
	
	
	public void eliminarUsuarioPorDNI(Connection crearConexion, String DNI) {
	    PreparedStatement statement = null;
	    try {
	        String sql = "DELETE FROM dlk.usuario WHERE dni = ?";
	        statement = crearConexion.prepareStatement(sql);
	        
	        // Establecer el parámetro de la consulta
	        statement.setString(1, DNI);
	        
	        // Ejecutar la eliminación
	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("[INFO] - Usuario eliminado correctamente.");
	        } else {
	            System.out.println("[WARN] - No se encontró ningún usuario con el DNI proporcionado.");
	        }
	    } catch (SQLException e) {
	        // Manejar la excepción
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos
	        try {
	            if (statement != null) 
	            	statement.close();
	            	crearConexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
}
