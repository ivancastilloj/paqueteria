package com.basico.model;

public class usuario {

	String origen;
	String destino;
	String nombre;
	String password;
	int puja;
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPuja() {
		return puja;
	}
	public void setPuja(int puja) {
		this.puja = puja;
	}
	public usuario(String origen, String destino, String nombre, String password, int puja) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.nombre = nombre;
		this.password = password;
		this.puja = puja;
	}
	
	
}
