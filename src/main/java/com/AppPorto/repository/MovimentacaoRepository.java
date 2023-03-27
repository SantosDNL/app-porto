package com.AppPorto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AppPorto.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, String>{

}
