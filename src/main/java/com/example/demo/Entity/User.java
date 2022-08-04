package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class User {
	public User() {};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(targetEntity = Pc.class, cascade = CascadeType.ALL)
	
	private List<Pc> listPc;

	public User(int id, String name, List<Pc> _listPc) {
		super();
		this.id = id;
		this.name = name;
		this.listPc = _listPc;
	}

	public List<Pc> getListPc() {
		return listPc;
	}

	public void setListPc(List<Pc> _listPc) {
		listPc = _listPc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}