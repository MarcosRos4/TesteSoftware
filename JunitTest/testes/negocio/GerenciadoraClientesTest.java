import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;

public class GerenciadoraClientesTest {
    
    private GerenciadoraClientes gerClientes;

    private int idCliente01 = 1;
    private int idCliente02 = 2;

    @Before
    public void setUp(){
        Cliente cliente01 = new Cliente(idCliente01, "Marcos", 19, "marcos@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(idCliente02, "Ivo", 19, "ivo_metter@nestle.com", 1, true);

        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        gerClientes = new GerenciadoraClientes(clientesDoBanco);
    }
    
    @After
    public void tearDown(){
        gerClientes.limpa();
    }

    @Test
    public void testPesquisaCliente(){
        Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
        assertThat(cliente.getId(), is(idCliente01));
    }

    @Test
    public void testRemoveCliente(){
        boolean clienteRemovido = gerClientes.removeCliente(idCliente02);

        assertThat(clienteRemovido, is(true));
        assertThat(gerClientes.getClientesDoBanco().size(), is(1));
        assertThat(gerClientes.pesquisaCliente(idCliente02));

        
    }
}
