package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Agendamento;



public interface IAgendamentoDao {
	
	public void insereAgendamento(Agendamento a) throws SQLException;
	public void atualizaAgendamento(Agendamento a) throws SQLException;
	public void excluiAgendamento(Agendamento a) throws SQLException;
	public Agendamento buscaAgendamento(Agendamento a) throws SQLException;
	public List<Agendamento> buscaAgendamentos() throws SQLException;
	


}
