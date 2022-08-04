package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "pc")
@Table(name = "pc")
public class Pc {
	public Pc() {};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marca;

	@ManyToOne
	private User owner;

	public Pc(int id, String marca, User owners) {
		super();
		this.id = id;
		this.marca = marca;
		this.owner = owners;
	}

	public User getOwners() {
		return owner;
	}

	public void setOwners(User owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}