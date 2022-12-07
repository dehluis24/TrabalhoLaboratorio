package application.controller;

import java.sql.SQLException;

import java.util.List;

import application.model.Agendamento;
import application.persistence.AgendamentoDao;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgendamentoController implements IAgendamentoController {
	private TextField tfIdAgendamento;
	private TextField tfDataAgendada;
	private TextField tfHorario;
	private TextField tfServico;
	private TextField tfCliente;
	private TextArea taListaAgendamento;

	public AgendamentoController(TextField tfIdAgendamento, TextField tfDataAgendada, TextField tfHorario,
			TextField tfServico, TextField tfCliente, TextArea tataListaAgendamento) {
		this.tfIdAgendamento = tfIdAgendamento;
		this.tfDataAgendada = tfDataAgendada;
		this.tfHorario = tfHorario;
		this.tfServico = tfServico;
		this.tfCliente = tfCliente;
		this.taListaAgendamento = tataListaAgendamento;
	}

	@Override
	public void inserirAgendamento(Agendamento a) throws ClassNotFoundException, SQLException {
		AgendamentoDao aDao = new AgendamentoDao();
		aDao.insereAgendamento(a);
		limpaCamposAgendamento();
		buscarAgendamentos();
	}

	@Override
	public void atualizaAgendamento(Agendamento a) throws ClassNotFoundException, SQLException {
		AgendamentoDao aDao = new AgendamentoDao();
		aDao.atualizaAgendamento(a);
		limpaCamposAgendamento();
		buscarAgendamentos();
		
	}

	@Override
	public void excluiAgendamento(Agendamento a) throws ClassNotFoundException, SQLException {
		AgendamentoDao aDao = new AgendamentoDao();
		aDao.excluiAgendamento(a);
		limpaCamposAgendamento();
		buscarAgendamentos();
		
	}

	@Override
	public void buscarAgendamento(Agendamento a) throws ClassNotFoundException, SQLException {
		limpaCamposAgendamento();
		AgendamentoDao aDao = new AgendamentoDao();
		aDao.buscaAgendamento(a);
		tfIdAgendamento.setText(String.valueOf(a.getIdAgendamento()));
		tfDataAgendada.setText(a.getDataAgendada());
		tfHorario.setText(a.getHorario());
		tfServico.setText(a.getServico());
		
	}

	@Override
	public void buscarAgendamentos() throws ClassNotFoundException, SQLException {
		limpaCamposAgendamento();
		taListaAgendamento.setText("");
		AgendamentoDao aDao = new AgendamentoDao();
		List<Agendamento> listaAgendamentos = aDao.buscaAgendamentos();
		
		StringBuffer buffer  = new StringBuffer("IdAgendamento\t\t\ttDataAgendamento\t\t\t\tHorario");
		 for(Agendamento a : listaAgendamentos) {
			 buffer.append(a.getIdAgendamento()+"\t\t\t\t\t"+a.getDataAgendada()+"\t\t\t\t\t"+a.getHorario()+"\n");
			 
		 }
		 
		 taListaAgendamento.setText(buffer.toString());
		
		
		
		
	}
	
	private  void limpaCamposAgendamento() {
		tfIdAgendamento.setText("");
		tfDataAgendada.setText("");
		tfHorario.setText("");
		tfServico.setText("");
		tfCliente.setText("");
	}

}
