package com.AppPorto.controller.dto;

import java.time.LocalDateTime;

public class MovimentacaoDTO {

	private String id;
	private String tipoMovimentacao;
	private String numeroContainer;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;

	public String getId() {
		return id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public String getNumeroContainer() {
		return numeroContainer;
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

	public void setNumeroContainer(String numeroContainer) {
		this.numeroContainer = numeroContainer;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

}
