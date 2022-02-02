package org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  // Utilizada para informar que uma classe também é uma entidade.
        // Assim, uma classe será uma entidade e terá uma tabela de mesmo nome no banco de dados.
@Table (name = "tb_postagens") // possui atributos que possibilitam ao desenvolver sobrescrever.
public class Postagem {
	
	@Id // Informa ao JPA qual campo / atributo de uma entidade relacionada à chave primária da tabela no banco de dados.
	@GeneratedValue (strategy = GenerationType.IDENTITY)  // Servir para falar que o campo mapeado será gerado automaticamente pelo banco de dados.
	private long id; 
	
	
	@NotNull   // Não permite um valor nulo, porém permite um valor vazio.
	@Size (min = 10, max = 100, message = "O atribuito deve conter no mínimo 10 caracteres.")  // Defina o tamanho.
    private String titulo;
	
	
	@NotNull   // Não permite um valor nulo, porém permite um valor vazio.
	@Size (min = 10, max = 100, message = "O atribuito deve conter no mínimo 10 caracteres.")  // Defina o tamanho.
    private String texto;
	


	@Temporal (TemporalType.TIMESTAMP) // É uma anotação JPA que se converte entre timestamp e java.
	private Date data = new java.sql.Date(System.currentTimeMillis());  // No caso, a data e horário atual do pc.
	
	@ManyToOne  // Comunicação Muitos para Um
	@JsonIgnoreProperties ("postagem") // Feito para ignorar uma repetição, evitando looping.
	private Tema tema;
	
	@ManyToOne  // Comunicação Muitos para Um
	@JsonIgnoreProperties ("postagem") // Feito para ignorar uma repetição, evitando looping.
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}