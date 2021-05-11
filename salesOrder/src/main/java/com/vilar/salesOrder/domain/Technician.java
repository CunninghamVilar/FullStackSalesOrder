package com.vilar.salesOrder.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Technician extends People implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "Technician")
	private List<Os> list = new ArrayList<>();

	public Technician() {
		super();

	}

	public Technician(Integer id, String name, String cpf, String telephone) {
		super(id, name, cpf, telephone);
		
	}

	public List<Os> getList() {
		return list;
	}

	public void setList(List<Os> list) {
		this.list = list;
	}

}
