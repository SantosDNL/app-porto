package com.AppPorto.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movimentacao {

	@Id
	private String id;
	private String tipoMovimentacao;
	private String numeroContainer;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;

	public Movimentacao(String id, String tipoMovimentacao, String numeroContainer, LocalDateTime dataEntrada,
			LocalDateTime dataSaida) {
		super();
		this.id = id;
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.numeroContainer = numeroContainer;
	}
	
	public Movimentacao() {
		
	}

	public String getId() {
		return id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getNumeroContainer() {
		return numeroContainer;
	}

	public void setNumeroContainer(String numeroContainer) {
		this.numeroContainer = numeroContainer;
	}

}
