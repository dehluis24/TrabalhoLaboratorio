package application.controller;

import java.sql.SQLException;


import application.model.Pet;

public interface IPetController {
	public void inserirPet(Pet p) throws ClassNotFoundException, SQLException;
	public void atualizaPet(Pet p) throws ClassNotFoundException, SQLException;
	public void excluiPet(Pet p) throws ClassNotFoundException, SQLException;
	public void buscarPet(Pet p) throws ClassNotFoundException, SQLException;
	public void buscarPets() throws ClassNotFoundException, SQLException;

}
