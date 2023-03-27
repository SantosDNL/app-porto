package com.AppPorto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppPorto.controller.dto.MovimentacaoDTO;
import com.AppPorto.controller.mapper.MovimentacaoMapper;
import com.AppPorto.models.Movimentacao;
import com.AppPorto.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	private final MovimentacaoService movimentacaoService;
	private final MovimentacaoMapper movimentacaoMapper;

	public MovimentacaoController(MovimentacaoService movimentacaoService, MovimentacaoMapper movimentacaoMapper) {
		this.movimentacaoService = movimentacaoService;
		this.movimentacaoMapper = movimentacaoMapper;
	}

	@GetMapping
	public ResponseEntity<List<MovimentacaoDTO>> findAll() {
		List<Movimentacao> movimentacaoList = movimentacaoService.findAll();
		List<MovimentacaoDTO> result = movimentacaoMapper.toMovimentacaoDTOList(movimentacaoList);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovimentacaoDTO> findById(@PathVariable String id) {
		Movimentacao movimentacao = movimentacaoService.findById(id);
		MovimentacaoDTO result = movimentacaoMapper.toMovimentacaoDTO(movimentacao);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		movimentacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<MovimentacaoDTO> create(@RequestBody MovimentacaoDTO dto) {
		var movimentacaoCreate = movimentacaoMapper.toMovimentacaoCreate(dto);
		var movimentacao = movimentacaoService.create(movimentacaoCreate);
		var result = movimentacaoMapper.toMovimentacaoDTO(movimentacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovimentacaoDTO> update(@PathVariable String id, @RequestBody MovimentacaoDTO movimentacaoCreateDTO) {
		Movimentacao movimentacaoUpdate = movimentacaoMapper.toMovimentacaoCreate(movimentacaoCreateDTO);
		Movimentacao movimentacao = movimentacaoService.update(id, movimentacaoUpdate);
		return ResponseEntity.ok(movimentacaoMapper.toMovimentacaoDTO(movimentacao));
	}

}
