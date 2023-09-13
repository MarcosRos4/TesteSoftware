package negocio;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.hamcrest.CoreMatchers.*;

public class GerenciadoraClientesTest {
	private GerenciadoraClientes gerenciarClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
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
	
	@Test
	public void testPesquisaCliente() {
		Cliente cliente = gerenciarClientes.pesquisaCliente(idCliente01);
		assertThat(cliente.getId(), is(idCliente01));
		
	}
	
	@Test
	public void testRemoveCliente() {
		boolean clienteRemovido = gerenciarClientes.removeCliente(idCliente02);
		
		assertThat(clienteRemovido, is(true));
		assertThat(gerenciarClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerenciarClientes.pesquisaCliente(idCliente02));
		
		
	}

}
