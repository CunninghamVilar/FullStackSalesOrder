package com.vilar.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

public class Client extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy = "client")
	private List<OS> list = new ArrayList<>();

	public Client() {
		super();

	}

	public Client(Integer id, String name, String pps, String telephone) {
		super(id, name, pps, telephone);

	}

	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}

}
