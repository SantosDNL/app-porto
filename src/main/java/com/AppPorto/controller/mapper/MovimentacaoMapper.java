package com.AppPorto.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.AppPorto.controller.dto.MovimentacaoDTO;
import com.AppPorto.models.Movimentacao;

@Component
public class MovimentacaoMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public MovimentacaoDTO toMovimentacaoDTO(Movimentacao movimentacao) {
		return MODEL_MAPPER.map(movimentacao, MovimentacaoDTO.class);
	}

	public List<MovimentacaoDTO> toMovimentacaoDTOList(List<Movimentacao> movimentacaoList) {
		return movimentacaoList.stream().map(this::toMovimentacaoDTO).collect(Collectors.toList());
	}

	public Movimentacao toMovimentacao(MovimentacaoDTO dto) {
		return MODEL_MAPPER.map(dto, Movimentacao.class);
	}

	public Movimentacao toMovimentacaoCreate(MovimentacaoDTO dto) {
		return MODEL_MAPPER.map(dto, Movimentacao.class);
	}

}
