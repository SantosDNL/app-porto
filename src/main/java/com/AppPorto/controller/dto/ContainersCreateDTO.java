package com.AppPorto.controller.dto;

public class ContainersCreateDTO {

	private String cliente;
	private String numeroContainer;
	private String tipo;
	private String status;
	private String categoria;

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
