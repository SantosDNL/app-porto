package com.AppPorto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Containers {
	
	@Id
	private String id;
	private String cliente;
	private String numeroContainer;
	private String tipo;
	private String status;
	private String categoria;

	
	public Containers(String id, String cliente, String numeroContainer, String tipo, String status, String categoria) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.numeroContainer = numeroContainer;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}
	
	public Containers() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public String getCliente() {
		return cliente;
	}
	public String getNumeroContainer() {
		return numeroContainer;
	}
	public String getTipo() {
		return tipo;
	}
	public String getStatus() {
		return status;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void setNumeroContainer(String numeroContainer) {
		this.numeroContainer = numeroContainer;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
