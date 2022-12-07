package application.controller;

import java.sql.SQLException;
import java.util.List;


import application.model.Cliente;

import application.persistence.ClienteDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienteController implements IClienteController{
	private TextField tfCpf;
	private TextField tfNomeCliente;
	private TextField tfTelefone;
	private TextField tfLogradouro;
	private TextField tfNumeroEnd;
	private TextField tfCep;
	private TextField tfDataNasc;
	private TextArea taListaCliente;
	
	public ClienteController(TextField tfCpf, TextField tfNomeCliente, TextField tfTelefone, TextField tfLogradouro,
			TextField tfNumeroEnd, TextField tfCep, TextField tfDataNasc, TextArea taListaCliente) {
		this.tfCpf = tfCpf;
		this.tfNomeCliente = tfNomeCliente;
		this.tfTelefone = tfTelefone;
		this.tfLogradouro = tfLogradouro;
		this.tfNumeroEnd = tfNumeroEnd;
		this.tfCep = tfCep;
		this.tfDataNasc = tfDataNasc;
		this.taListaCliente = taListaCliente;
	}

	@Override
	public void inserirCliente(Cliente ci) throws ClassNotFoundException, SQLException {
		ClienteDao aDao = new ClienteDao();
		aDao.insereCliente(ci);
		limpaCamposCliente();
		buscarClientes();
		
	}

	@Override
	public void atualizaCliente(Cliente ci) throws ClassNotFoundException, SQLException {
		ClienteDao aDao = new ClienteDao();
		aDao.atualizaCliente(ci);
		limpaCamposCliente();
		buscarClientes();
		
	}

	@Override
	public void excluiCliente(Cliente ci) throws ClassNotFoundException, SQLException {
		ClienteDao aDao = new ClienteDao();
		aDao.excluiCliente(ci);
		limpaCamposCliente();
		buscarClientes();
		
		
	}

	@Override
	public void buscarCliente(Cliente ci) throws ClassNotFoundException, SQLException {
		limpaCamposCliente();
		ClienteDao aDao = new ClienteDao();
		aDao.buscaCliente(ci);
		tfCpf.setText(ci.getCpf());
		tfNomeCliente.setText(ci.getNomeCliente());
		tfCep.setText(ci.getCep());
		tfTelefone.setText(ci.getTelefone());
		tfNumeroEnd.setText(ci.getNumeroEnd());
		tfLogradouro.setText(ci.getLogradouro());
		tfDataNasc.setText(ci.getDataNasc());
		
	}

	@Override
	public void buscarClientes() throws ClassNotFoundException, SQLException {
		limpaCamposCliente();
		taListaCliente.setText("");
		ClienteDao aDao = new ClienteDao();
		List<Cliente> listaClientes = aDao.buscaClientes();
		
		StringBuffer buffer  = new StringBuffer("Cpfo\t\t\t\tNomeCliente\t\t\t\tTelefone\\t\\t\\t\\tCep\\t\\t\\t\\tLogradouro\\t\\t\\t\\tNumeroEnd\\t\\t\\t\\tDataNasc");
		 for(Cliente ci : listaClientes) {
			 buffer.append(ci.getCpf()+"\t\t\t\t\t"+ci.getNomeCliente()+"\t\t\t\t\t"+ci.getTelefone()+"\t\t\t\t\t"+ci.getCep()
			 +"\t\t\t\t\t"+ci.getLogradouro()+"\t\t\t\t\t"+ci.getNumeroEnd()+"\t\t\t\t\t"+ci.getDataNasc()+"\n");
			 
		 }
		 taListaCliente.setText(buffer.toString());
		
	}
	private  void limpaCamposCliente() {
		tfCpf.setText("");
		tfNomeCliente.setText("");
		tfCep.setText("");
		tfTelefone.setText("");
		tfNumeroEnd.setText("");
		tfLogradouro.setText("");
		tfDataNasc.setText("");
	}

}
