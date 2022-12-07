package application.controller;

import java.sql.SQLException;


import application.model.Cliente;

public interface IClienteController {
	public void inserirCliente(Cliente ci) throws ClassNotFoundException, SQLException;
	public void atualizaCliente(Cliente ci) throws ClassNotFoundException, SQLException;
	public void excluiCliente(Cliente ci) throws ClassNotFoundException, SQLException;
	public void buscarCliente(Cliente ci) throws ClassNotFoundException, SQLException;
	public void buscarClientes() throws ClassNotFoundException, SQLException;

}
