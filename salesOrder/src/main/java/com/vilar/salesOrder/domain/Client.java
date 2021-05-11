package com.vilar.salesOrder.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Client extends People  implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@OneToMany(mappedBy = "Client")
	private List<Os> List = new ArrayList<>();	
	
	public Client() {
		super();

	}

	public Client(Integer id, String name, String cpf, String telephone) {
		super(id, name, cpf, telephone);

	}

	public List<Os> getList() {
		return List;
	}

	public void setList(List<Os> list) {
		List = list;
	}

}
