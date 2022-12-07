package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import application.model.Cliente;

public class ClienteDao implements IClienteDao {
	
	private Connection c;
	
	public ClienteDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void insereCliente(Cliente ci) throws SQLException {
		String sql = "INSERT INTO cliente VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ci.getCpf());
		ps.setString(2, ci.getNomeCliente());
		ps.setString(3, ci.getTelefone());
		ps.setString(4, ci.getLogradouro());
		ps.setString(5, ci.getNumeroEnd());
		ps.setString(6, ci.getCep());
		ps.setString(7, ci.getDataNasc());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void atualizaCliente(Cliente ci) throws SQLException {
		String sql = "UPDATE cliente SET NomeCliente = ?, Telefone = ? WHERE Cpf = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ci.getNomeCliente());
		ps.setString(2, ci.getTelefone());
		ps.setString(3, ci.getCpf());
		
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiCliente(Cliente ci) throws SQLException {
		String sql = "DELETE cliente WHERE Cpf = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ci.getCpf());
		
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Cliente buscaCliente(Cliente ci) throws SQLException {
String sql = "SELECT Cpf, NomeCliente, Telefone FROM cliente WHERE Cpf = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ci.getCpf());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			ci.setCpf(rs.getString("Cpf"));
			ci.setNomeCliente(rs.getString("NomeCliente"));
			ci.setTelefone(rs.getString("Telefone"));
			
			cont++;
			
		}
		if(cont == 0) {
			ci = new Cliente();
		}
		rs.close();
		ps.close();
		return ci;
	}

	@Override
	public List<Cliente> buscaClientes() throws SQLException {
String sql = "SELECT IdAgendamento, DataAgendada, Horario FROM Agendamento WHERE IdAgendamento = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		

		ResultSet rs = ps.executeQuery();
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		while(rs.next()) {
			Cliente a1 = new Cliente();
			a1.setCpf(rs.getString("cpf"));
			a1.setNomeCliente(rs.getString("nomeCliente"));
			a1.setTelefone(rs.getString("telefone"));
			a1.setLogradouro(rs.getString("logradouro"));
			a1.setNumeroEnd(rs.getString("numeroEnd"));
			a1.setCep(rs.getString("cep"));
			a1.setDataNasc(rs.getString("dataNasc"));
			
			listaClientes.add(a1);
			
		}
		rs.close();
		ps.close();
		return listaClientes;
	}

}
