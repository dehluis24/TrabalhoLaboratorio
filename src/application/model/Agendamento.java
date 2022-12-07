package application.model;

 


public class Agendamento {

	private String idAgendamento;
	private String dataAgendada;
	private String horario;
	private String servico;
	private Cliente cliente;
	public String getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public String getDataAgendada() {
		return dataAgendada;
	}
	public void setDataAgendada(String dataAgendada) {
		this.dataAgendada = dataAgendada;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "[idAgendamento=" + idAgendamento + ", dataAgendada=" + dataAgendada + ", horario=" + horario
				+ ", servico=" + servico + ", cliente=" + cliente + "]";
	}
	
	
}
