package com.AppPorto.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.AppPorto.exception.MovimentacaoNotFoundException;
import com.AppPorto.models.Movimentacao;
import com.AppPorto.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	private final MovimentacaoRepository movimentacaoRepository;

	public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
		this.movimentacaoRepository = movimentacaoRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Movimentacao findById(String id) {
		return movimentacaoRepository.findById(id).orElseThrow(() -> new MovimentacaoNotFoundException(id));
	}

	@Transactional
	public Movimentacao create(Movimentacao movimentacaoCreate) {
		String uuid = getUUID();
		movimentacaoCreate.setId(uuid);
		movimentacaoCreate.setDataEntrada(LocalDateTime.now());
		movimentacaoRepository.save(movimentacaoCreate);
		return movimentacaoCreate;
	}

	@Transactional
	public Movimentacao update(String id, Movimentacao movimentacaoCreate) {
		Movimentacao movimentacao = findById(id);
		movimentacao.setTipoMovimentacao(movimentacaoCreate.getTipoMovimentacao());
		movimentacao.setNumeroContainer(movimentacaoCreate.getNumeroContainer());
		movimentacaoRepository.save(movimentacao);
		return movimentacaoCreate;
	}

	@Transactional
	public Movimentacao fimMovimentacao(String id) {
		Movimentacao movimentacao = findById(id);
		movimentacao.setDataSaida(LocalDateTime.now());
		movimentacaoRepository.save(movimentacao);
		return movimentacao;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		movimentacaoRepository.deleteById(id);
	}

}
