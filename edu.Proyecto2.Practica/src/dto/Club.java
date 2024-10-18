package dto;



/**
 * @author RGV
 * 09/10/2024
 * 
 * Creacion de DTOS Club
 * **/


public class Club {

	private long id;
	private String nombre;
	private String colores;
	private String alias;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColores() {
		return colores;
	}
	public void setColores(String colores) {
		this.colores = colores;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String toString() {
		return "Club [id=" + id + ", nombre=" + nombre + ", colores=" + colores + ", alias=" + alias + "]";
	}
	public Club(long id, String nombre, String colores, String alias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.colores = colores;
		this.alias = alias;
	}
	
	

	
	
	
}
