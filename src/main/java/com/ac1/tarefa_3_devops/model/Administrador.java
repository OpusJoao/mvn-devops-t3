package com.ac1.tarefa_3_devops.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Administrador {

	private String nome;
	private String email;
	private String senha;

	public Administrador(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
