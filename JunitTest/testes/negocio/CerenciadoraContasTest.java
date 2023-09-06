import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import negocio.ContaCorrente;
import negocio.GerenciadoraContas;

/**
 * CerenciadorContasTest
 */
public class CerenciadoraContasTest {

    private GerenciadoraContas gerContas;

    @Test
    public void testTransfereValor(){
        int idConta01 = 1;
        int idConta02 = 2;
        ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);

        gerContas = new GerenciadoraContas(contasDoBanco);

        boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
        assertTrue(sucesso);
        assertTrue(conta01.getSaldo(), is(100.0));
        assertTrue(conta02.getSaldo(), is(100.0));
    }
}