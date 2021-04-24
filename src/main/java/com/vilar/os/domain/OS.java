package com.vilar.os.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vilar.os.domain.enuns.Priority;
import com.vilar.os.domain.enuns.Status;

@Entity
public class OS {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private LocalDateTime dataFechamento;
	private Integer priority;
	private String observacoes;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "Technician_id")
	private Technician technician;
	
	@ManyToOne
	@JoinColumn(name = "Client_id")
	private Client client;

	public OS() {
		super();

		// to receive the data now
		this.setDataAbertura(LocalDateTime.now());

		// shows what priority is about the OS
		this.setPriority(Priority.BAIXA);

		// Shows the status if Open or Closed
		this.setStatus(Status.ABERTO);

		// When status is closed, the data & time is informed

	}

	public OS(Integer id, Priority priority, String observacoes, Status status, Technician technician, Client client) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDateTime.now());
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.observacoes = observacoes;
		this.status = (status == null) ? 0 : status.getCod();
		this.technician = technician;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
