package application.controller;

import java.sql.SQLException;

import application.model.Agendamento;

public interface IAgendamentoController {
	
	public void inserirAgendamento(Agendamento a) throws ClassNotFoundException, SQLException;
	public void atualizaAgendamento(Agendamento a) throws ClassNotFoundException, SQLException;
	public void excluiAgendamento(Agendamento a) throws ClassNotFoundException, SQLException;
	public void buscarAgendamento(Agendamento a) throws ClassNotFoundException, SQLException;
	public void buscarAgendamentos() throws ClassNotFoundException, SQLException;

}
