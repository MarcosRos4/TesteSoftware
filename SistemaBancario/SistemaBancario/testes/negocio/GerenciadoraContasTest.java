// Autor: Marcos Vinícius Cavalcante Rosa

package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;
import org.junit.*;

public class GerenciadoraContasTest {
	
	private GerenciadoraContas gerenciadoraContas;
	
	@Test
	public void testTransferenciaSuficienteAmbas() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadoraContas = new GerenciadoraContas(contasDoBanco);
		
		boolean sucesso = gerenciadoraContas.transfereValor(idConta01, 100, idConta02);
		
		assertTrue(sucesso);
		assertTrue(conta02.getSaldo()+"", is(100.0) != null);
		assertTrue(conta01.getSaldo()+"", is(100.0) != null);
	}
	
	@Test
	public void testTransferenciaInsuficientePrimeiraContaPositivo() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadoraContas = new GerenciadoraContas(contasDoBanco);
		
		boolean sucesso = gerenciadoraContas.transfereValor(idConta01, 200, idConta02);
		
		assertTrue(sucesso);
		assertTrue(conta02.getSaldo()+"", is(-100.0) != null);
		assertTrue(conta01.getSaldo()+"", is(200.0) != null);
	}
	
	@Test
	public void testTransferenciaInsuficientePrimeiraContaNegativo() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadoraContas = new GerenciadoraContas(contasDoBanco);
		
		boolean sucesso = gerenciadoraContas.transfereValor(idConta01, 200, idConta02);
		
		assertTrue(sucesso);
		assertTrue(conta02.getSaldo()+"", is(-300.0) != null);
		assertTrue(conta01.getSaldo()+"", is(200.0) != null);
	}
	
	@Test
	public void testTransferenciaInsuficienteAmbas() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadoraContas = new GerenciadoraContas(contasDoBanco);
		
		boolean sucesso = gerenciadoraContas.transfereValor(idConta01, 200, idConta02);
		
		assertTrue(sucesso);
		assertTrue(conta02.getSaldo()+"", is(-300.0) != null);
		assertTrue(conta01.getSaldo()+"", is(100.0) != null);
	}
}
