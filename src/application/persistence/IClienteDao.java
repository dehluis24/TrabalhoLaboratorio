package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Cliente;

public interface IClienteDao {
	
	public void insereCliente(Cliente c) throws SQLException;
	public void atualizaCliente(Cliente c) throws SQLException;
	public void excluiCliente(Cliente c) throws SQLException;
	public Cliente buscaCliente(Cliente c) throws SQLException;
	public List<Cliente> buscaClientes() throws SQLException;
	
	
}
