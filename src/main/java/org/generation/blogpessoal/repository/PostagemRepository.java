package org.generation.blogpessoal.repository;

import java.util.List;

import org.generation.blogpessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // É um objeto que isola os objetos ou entidades do domínio do código que acessa o banco de dados.
	public  interface  PostagemRepository  extends  JpaRepository < Postagem , Long > {
		
		 public List < Postagem > findAllByTituloContainingIgnoreCase ( String  titulo );
		
	}