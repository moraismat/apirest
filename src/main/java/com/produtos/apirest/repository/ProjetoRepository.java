package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Projeto;

// JpaRepository possui os metodos prontos para comunicação com o bando de dados como o CRUD
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
	Projeto findById(long id); // Utilizado para achar um produto pelo seu id

}