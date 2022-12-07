package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Agendamento;
import application.model.Cliente;

public class AgendamentoDao implements IAgendamentoDao {
	
	private Connection c;
	
	public AgendamentoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void insereAgendamento(Agendamento a) throws SQLException {
		String sql = "INSERT INTO Agendamento VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getIdAgendamento());
		ps.setString(2, a.getDataAgendada());
		ps.setString(3, a.getHorario());
		ps.setString(4, a.getServico());
		ps.setString(5, a.getCliente().getCpf());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void atualizaAgendamento(Agendamento a) throws SQLException {
		String sql = "UPDATE  Agendamento SET DataAgendada = ?, Horario = ? WHERE IdAgendamento = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getDataAgendada());
		ps.setString(2, a.getHorario());
		ps.setString(3, a.getIdAgendamento());
		
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiAgendamento(Agendamento a) throws SQLException {
		String sql = "DELETE Agendamento WHERE IdAgendamento = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getIdAgendamento());
		ps.execute();
		ps.close();
		
		
	}

	@Override
	public Agendamento buscaAgendamento(Agendamento a) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.IdAgendamento AS Agendamento, a.DataAgendada AS Agendamento ");
		sql.append("ci.Cpf AS cliente, ci.nomeCliente As cliente, ci.NumeroEnd AS cliente ");
		sql.append("From Agendamento a INEER JOIN cliente ci ");
		sql.append("ON a.cliente = ci.Cpf ");
		sql.append("WHERE a.IdAgendamento = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, a.getIdAgendamento());
		ResultSet rs = ps.executeQuery();
		 int cont = 0;
		 if(rs.next()) {
			 Cliente c = new Cliente();
			 c.setCpf(rs.getString("Cpf"));
			 c.setNomeCliente(rs.getString("nomeCliente"));
			 c.setNumeroEnd(rs.getString("NumeroEnd"));
			 
			 a.setIdAgendamento(rs.getString("IdAgendamento"));
			 a.setCliente(c);
			 cont++;
		 }
		 if(cont == 0) {
			 a = new Agendamento();
			 Cliente c = new Cliente();
			 a.setCliente(c);
		 }
		 rs.close();
		 ps.close();
		
		 return a;
	}
	


	@Override
	public List<Agendamento> buscaAgendamentos() throws SQLException {
		List<Agendamento> listaAgendamentos = new ArrayList<Agendamento>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.IdAgendamento AS Agendamento, a.DataAgendada AS Agendamento ");
		sql.append("ci.Cpf AS cliente, ci.nomeCliente As cliente, ci.NumeroEnd AS cliente ");
		sql.append("From Agendamento a INEER JOIN cliente ci ");
		sql.append("ON a.cliente = ci.Cpf ");
		sql.append("WHERE a.IdAgendamento = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Cliente c = new Cliente();
			 c.setCpf(rs.getString("Cpf"));
			 c.setNomeCliente(rs.getString("nomeCliente"));
			 c.setNumeroEnd(rs.getString("NumeroEnd"));
			 
			 Agendamento a = new Agendamento();
			 a.setIdAgendamento(rs.getString("IdAgendamento"));
			 a.setDataAgendada(rs.getString("DataAgendada"));
			 a.setDataAgendada(rs.getString("DataAgendada"));
			 a.setCliente(c);
			 
			 listaAgendamentos.add(a);
			 
			 rs.close();
			 ps.close();
			
				
			
			
		}
		return listaAgendamentos;
		
	}


	
	}


