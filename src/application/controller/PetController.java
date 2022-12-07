package application.controller;

import java.sql.SQLException;
import java.util.List;


import application.model.Pet;
import application.persistence.PetDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PetController implements IPetController {
	private TextField tfidPet;
	private TextField tfnomePet;
	private TextField tfpeso;
	private TextField tfalergia;
	private TextField tfsangue;
	private TextArea taListaPet;
	


	public PetController(TextField tfidPet, TextField tfnomePet, TextField tfpeso, TextField tfalergia,
			TextField tfsangue, TextArea taListaPet) {
		super();
		this.tfidPet = tfidPet;
		this.tfnomePet = tfnomePet;
		this.tfpeso = tfpeso;
		this.tfalergia = tfalergia;
		this.tfsangue = tfsangue;
		this.taListaPet = taListaPet;
	}

	@Override
	public void inserirPet(Pet p) throws ClassNotFoundException, SQLException {
		PetDao aDao = new PetDao();
		aDao.inserePet(p);
		limpaCamposPet();
		buscarPets();

	}

	@Override
	public void atualizaPet(Pet p) throws ClassNotFoundException, SQLException {
		PetDao aDao = new PetDao();
		aDao.atualizaPet(p);
		limpaCamposPet();
		buscarPets();
	}

	@Override
	public void excluiPet(Pet p) throws ClassNotFoundException, SQLException {
		PetDao aDao = new PetDao();
		aDao.excluiPet(p);
		limpaCamposPet();
		buscarPets();
		
	}

	@Override
	public void buscarPet(Pet p) throws ClassNotFoundException, SQLException {
		limpaCamposPet();
		PetDao aDao = new PetDao();
		aDao.buscaPet(p);
		tfidPet.setText(p.getIdPet());
		tfnomePet.setText(p.getNomePet());
		tfpeso.setText(p.getPeso());
		tfalergia.setText(p.getAlergia());
		tfsangue.setText(p.getSangue());
		
	}

	@Override
	public void buscarPets() throws ClassNotFoundException, SQLException {
		limpaCamposPet();
		taListaPet.setText("");
		PetDao pDao = new PetDao();
		List<Pet> listaPets = pDao.buscaPets();
		
		StringBuffer buffer  = new StringBuffer("IdAgendamento\t\t\ttDataAgendamento\t\t\t\tHorario");
		 for(Pet p : listaPets) {
			 buffer.append(p.getIdPet()+"\t\t\t\t\t"+p.getNomePet()+"\t\t\t\t\t"+p.getPeso()+"\t\t\t\t\t"+p.getAlergia()+
					 "\t\t\t\t\t"+p.getSangue()+"\n");
			 }
		 			taListaPet.setText(buffer.toString());
		
	}

	private  void limpaCamposPet() {
		tfidPet.setText("");
		tfnomePet.setText("");
		tfpeso.setText("");
		tfalergia.setText("");
		tfsangue.setText("");
	
	}

}
