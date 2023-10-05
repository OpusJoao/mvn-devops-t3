import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import enums.Plano;
import enums.StatusPagamento;
import model.Aluno;
import model.Curso;
import model.Pagamento;

public class PagamentoTest {
	@Test
	public void testNaoConfirmarPagamentoSeNaoExistirProduto() {
		List<Curso> cursos = null;
		Aluno aluno = new Aluno(
				"Pedro", 
				"pedro@facens.br", 
				"", 
				Plano.NENHUM, 
				cursos);
		Pagamento pagamento = new Pagamento(19, aluno);
		
		pagamento.setStatusPagamento(StatusPagamento.PAGO);
		boolean confirmacaoPagamento = pagamento.confirmarPagamento();
		
		assertFalse(confirmacaoPagamento);
	}
}
