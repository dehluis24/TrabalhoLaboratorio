package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;



import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class PrincipalController {
	@FXML
	private TextField tfIdAgendamento;
	@FXML
	private TextField tfCpfAgendamento;
	@FXML
	private TextField tfIdPetAgendamento;
	@FXML
	private TextField tfHorarioAgendamento;
	@FXML
	private TextField tfDataAgendamento;
	@FXML
	private TextArea taListaAgendamento;
	@FXML
	private Button btnBuscarAgendamento;
	@FXML
	private Button btnExcluirAgendamento;
	@FXML
	private Button btnAlterarAgendamento;
	@FXML
	private Button btnListarAgendamento;
	@FXML
	private Button btnAgendar;
	@FXML
	private TextField tfServico;
	@FXML
	private TextField tfCpfCliente;
	@FXML
	private TextField tfNomeCliente;
	@FXML
	private TextField tfTelefoneCliente;
	@FXML
	private TextField tfLogradouroCliente;
	@FXML
	private TextField tfNumeroCliente;
	@FXML
	private TextField tfCepCliente;
	@FXML
	private TextField tfDataNascCliente;
	@FXML
	private TextArea taListaCliente;
	@FXML
	private Button btnBuscarCliente;
	@FXML
	private Button btnExcluirCliente;
	@FXML
	private Button btnAlterarCliente;
	@FXML
	private Button btnListarCliente;
	@FXML
	private Button btnCadastrarCliente;
	@FXML
	private TextField tfIdPet;
	@FXML
	private TextField tfCpfPet;
	@FXML
	private TextField tfNomePet;
	@FXML
	private TextField tfPesoPet;
	@FXML
	private TextField tfAlergiaPet;
	@FXML
	private TextField tfSanguePet;
	@FXML
	private TextArea taListaPet;
	@FXML
	private Button btnBuscarPet;
	@FXML
	private Button btnExcluirPet;
	@FXML
	private Button btnAlterarPet;
	@FXML
	private Button btnListarPet;
	@FXML
	private Button btnCadastrarPet;

	// Event Listener on Button[#btnBuscarAgendamento].onAction
	@FXML
	public void acaoAgendamento(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		AgendamentoController agendamentoController =
				new AgendamentoController(tfIdAgendamento, tfDataAgendamento, tfHorarioAgendamento, 
						tfServico, tfCpfCliente, taListaAgendamento);
		
		
	
		
	}
	// Event Listener on Button[#btnBuscarCliente].onAction
	@FXML
	public void acaoCliente(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		ClienteController clienteController =
				new ClienteController(tfCpfAgendamento, tfNomeCliente, tfTelefoneCliente, tfLogradouroCliente, tfNumeroCliente, tfCepCliente, tfDataNascCliente, taListaCliente);
		
	}
	// Event Listener on Button[#btnBuscarPet].onAction
	@FXML
	public void acaoPet(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		PetController petController =
				new PetController(tfIdPet, tfNomePet, tfPesoPet, tfAlergiaPet, tfSanguePet, taListaPet);
	}
}
