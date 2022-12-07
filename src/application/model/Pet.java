package application.model;

public class Pet {
	
	private String idPet;
	private String nomePet;
	private String peso;
	private String alergia;
	private String sangue;
	private Cliente dono;
	
	@Override
	public String toString() {
		return "[idPet=" + idPet + ", nomePet=" + nomePet + ", peso=" + peso + ", alergia=" + alergia + ", sangue="
				+ sangue + ", dono=" + dono + "]";
	}
	public String getIdPet() {
		return idPet;
	}
	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	public String getSangue() {
		return sangue;
	}
	public void setSangue(String sangue) {
		this.sangue = sangue;
	}
	public Cliente getDono() {
		return dono;
	}
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	

}
