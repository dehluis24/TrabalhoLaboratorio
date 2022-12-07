package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Pet;


public interface IPetDao {

	public void inserePet(Pet p) throws SQLException;
	public void atualizaPet(Pet p) throws SQLException;
	public void excluiPet(Pet p) throws SQLException;
	public Pet buscaPet(Pet p) throws SQLException;
	public List<Pet> buscaPets() throws SQLException;
	
	
	
}
