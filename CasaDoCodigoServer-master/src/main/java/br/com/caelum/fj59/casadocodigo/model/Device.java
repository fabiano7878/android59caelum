package br.com.caelum.fj59.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {

	@Id
	private String id;
	private String email;

	public Device() {

	}

	public Device(String email, String id) {
		this.email = email;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
