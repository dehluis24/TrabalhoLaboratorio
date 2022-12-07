package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import application.model.Cliente;
import application.model.Pet;

public class PetDao implements IPetDao{
private Connection c;
	
	public PetDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void inserePet(Pet p) throws SQLException {
		String sql = "INSERT INTO Pet VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getIdPet());
		ps.setString(2, p.getNomePet());
		ps.setString(3, p.getPeso());
		ps.setString(4, p.getAlergia());
		ps.setString(5, p.getSangue());
		ps.setString(6, p.getDono().getCpf());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void atualizaPet(Pet p) throws SQLException {
		String sql = "UPDATE  Pet SET   NomePet = ? WHERE IdPet = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getNomePet());
		ps.setString(2, p.getIdPet());
		
		
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiPet(Pet p) throws SQLException {
		String sql = "DELETE Pet WHERE IdPet = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getIdPet());
		
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Pet buscaPet(Pet p) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.IdPet AS Pet, p.nomePet AS Pet");
		sql.append("ci.Cpf AS cliente, ci.nomeCliente As cliente, ci.NumeroEnd AS cliente ");
		sql.append("From Pet p INEER JOIN cliente ci ");
		sql.append("ON p.cliente = ci.Cpf ");
		sql.append("WHERE p.IdPet = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, p.getIdPet());
		ResultSet rs = ps.executeQuery();
		 int cont = 0;
		 if(rs.next()) {
			 Cliente c = new Cliente();
			 c.setCpf(rs.getString("Cpf"));
			 c.setNomeCliente(rs.getString("nomeCliente"));
			 c.setNumeroEnd(rs.getString("NumeroEnd"));
			 
			 p.setIdPet(rs.getString("IdPet"));
			 p.setDono(c);
			 cont++;
		 }
		 if(cont == 0) {
			 p = new Pet();
			 Cliente c = new Cliente();
			 p.setDono(c);
		 }
		 rs.close();
		 ps.close();
	
		 return p;
}

	@Override
	public List<Pet> buscaPets() throws SQLException {
		List<Pet> listaPets = new ArrayList<Pet>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.IdPet AS Pet, p.nomePet AS Pet");
		sql.append("ci.Cpf AS cliente, ci.nomeCliente As cliente, ci.NumeroEnd AS cliente ");
		sql.append("From Pet p INEER JOIN cliente ci ");
		sql.append("ON p.cliente = ci.Cpf ");
		sql.append("WHERE p.IdPet = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Cliente c = new Cliente();
			 c.setCpf(rs.getString("Cpf"));
			 c.setNomeCliente(rs.getString("nomeCliente"));
			 c.setNumeroEnd(rs.getString("NumeroEnd"));
			 
		Pet p = new Pet();
			 p.setIdPet(rs.getString("IdPet"));
			 p.setNomePet(rs.getString("NomePet"));
			 p.setPeso(rs.getString("Peso"));
			 p.setAlergia(rs.getString("Alergia"));
			 p.setSangue(rs.getString("Sangue"));
			 p.setDono(c);
			 
			 listaPets.add(p);
			 
			 rs.close();
			 ps.close();
			
				
			
			
		}
		return listaPets;
		
	}


	
	}

