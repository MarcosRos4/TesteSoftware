// Autor: Marcos Vinícius Cavalcante Rosa

package negocio;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	private GerenciadoraClientes gerenciarClientes;
	private double idCliente01 = 1;
	private double idCliente02 = 2;
	
	@Before
	public void setUp() {
		Cliente cliente01 = new Cliente(idCliente01, "João", 31, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 34, "maria@gmail.com", 1, true);
		
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciarClientes = new GerenciadoraClientes(clientesDoBanco);
	}
	
	@After
	public void tearDown() {
		gerenciarClientes.limpa();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPesquisaCliente() {
		Cliente cliente = gerenciarClientes.pesquisaCliente(idCliente01);
		assertThat(cliente.getId(), CoreMatchers.is(idCliente01));
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRemoveCliente() {
		boolean clienteRemovido = gerenciarClientes.removeCliente(idCliente02);
		
		assertThat(clienteRemovido, CoreMatchers.is(true));
		assertThat(gerenciarClientes.getClientesDoBanco().size(), CoreMatchers.is(1));
		assertNull(gerenciarClientes.pesquisaCliente(idCliente02));	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testVerificarIdadeValida() {
		try {
			assertThat(gerenciarClientes.validaIdade(
					gerenciarClientes.pesquisaCliente(
							idCliente01).getIdade()), CoreMatchers.is(true));
		}
		catch(IdadeNaoPermitidaException e) {
			e.printStackTrace();
		}

		try {
			assertThat(gerenciarClientes.validaIdade(17), CoreMatchers.is(true));
		}
		catch(IdadeNaoPermitidaException e) {
			e.printStackTrace();
		}
		
		try {
			assertThat(gerenciarClientes.validaIdade(86), CoreMatchers.is(true));
		}
		catch(IdadeNaoPermitidaException e) {
			e.printStackTrace();
		}
	}
}
