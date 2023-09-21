package com.ac1.tarefa_3_devops.model;

import com.ac1.tarefa_3_devops.enums.StatusPagamento;
import com.ac1.tarefa_3_devops.enums.Plano;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pagamento {

	private Aluno aluno;
	private float valor;
    private StatusPagamento statusPagamento;
	private Plano produto;

	public Pagamento(Aluno aluno, float valor, StatusPagamento statusPagamento, Plano produto) {
		this.aluno = aluno;
		this.valor = valor;
		this.statusPagamento = statusPagamento;
		this.produto = produto;
	}
	
	public Pagamento(float valor, Aluno aluno) {
		this.valor = valor;
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;	
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;	
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Plano getProduto() {
		return produto;
	}

	public void setProduto(Plano produto) {
		this.produto = produto;
	}

	public boolean confirmarPagamento() {
		if(this.produto != null && this.statusPagamento == StatusPagamento.PAGO) {
			this.aluno.setPlano(Plano.BASICO);
			return true;
		}
		return false;
	}
}
