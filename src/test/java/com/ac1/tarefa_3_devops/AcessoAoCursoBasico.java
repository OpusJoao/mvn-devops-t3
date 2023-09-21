package com.ac1.tarefa_3_devops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.ac1.tarefa_3_devops.enums.Plano;
import com.ac1.tarefa_3_devops.enums.StatusPagamento;
import com.ac1.tarefa_3_devops.model.Aluno;
import com.ac1.tarefa_3_devops.model.Curso;
import com.ac1.tarefa_3_devops.model.Pagamento;

public class AcessoAoCursoBasico {
	@Test
	public void testLiberarCursoBasicoAoConfirmarPagamento() {
		List<Curso> cursos = null;
		Aluno aluno = new Aluno(
				"Pedro", 
				"pedro@facens.br", 
				"", 
				Plano.NENHUM, 
				cursos);
		Pagamento pagamento = new Pagamento(19, aluno);
		
		pagamento.setProduto(Plano.BASICO);
		pagamento.setStatusPagamento(StatusPagamento.PAGO);
		boolean confirmacaoPagamento = pagamento.confirmarPagamento();
		
		assertTrue(confirmacaoPagamento);
		assertEquals(Plano.BASICO, pagamento.getProduto());
		assertEquals(Plano.BASICO, aluno.getPlano());
	}
	
	@Test
	public void testNaoLiberarCursoBasicoPagamentoNegado() {
		List<Curso> cursos = null;
		Aluno aluno = new Aluno(
				"Pedro", 
				"pedro@facens.br", 
				"", 
				Plano.NENHUM, 
				cursos);
		Pagamento pagamento = new Pagamento(19, aluno);
		
		pagamento.setProduto(Plano.BASICO);
		boolean confirmacaoPagamento = pagamento.confirmarPagamento();
		
		assertFalse(confirmacaoPagamento);
		assertEquals(Plano.BASICO, pagamento.getProduto());
		assertEquals(Plano.NENHUM, aluno.getPlano());
		
	}
	
	@Test
	public void testNaoLiberarCursoBasicoPagamentoPendente() {
		List<Curso> cursos = null;
		Aluno aluno = new Aluno(
				"Pedro", 
				"pedro@facens.br", 
				"", 
				Plano.NENHUM, 
				cursos);
		Pagamento pagamento = new Pagamento(19, aluno);
		
		pagamento.setProduto(Plano.BASICO);
		pagamento.setStatusPagamento(StatusPagamento.PENDENTE);
		assertEquals(StatusPagamento.PENDENTE, pagamento.getStatusPagamento());
		assertEquals(Plano.NENHUM, aluno.getPlano());
	}
	
	@Test
	public void testNaoLiberarCursoBasicoSemPagamento() {
		List<Curso> cursos = null;
		Aluno aluno = new Aluno(
				"Pedro", 
				"pedro@facens.br", 
				"", 
				Plano.NENHUM, 
				cursos);
		assertEquals(Plano.NENHUM, aluno.getPlano());
	}
}
