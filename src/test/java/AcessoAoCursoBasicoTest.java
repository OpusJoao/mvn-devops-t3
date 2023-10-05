import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import enums.Plano;
import enums.StatusPagamento;
import model.Aluno;
import model.Curso;
import model.Pagamento;

public class AcessoAoCursoBasicoTest {
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
