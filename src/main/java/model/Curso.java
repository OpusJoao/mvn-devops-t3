package model;

import enums.Plano;

public class Curso {

	private String nome;
    private Plano plano;

	public Curso(String nome, Plano plano) {
		this.nome = nome;
		this.plano = plano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
}