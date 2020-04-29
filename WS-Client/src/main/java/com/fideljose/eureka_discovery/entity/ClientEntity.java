package com.fideljose.eureka_discovery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.sun.istack.NotNull;

@Entity
@Table(name="Client")
public class ClientEntity extends SerializableSerializer {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;
	
	@Column(nullable=false, length=50, unique=true)
	private String idClientDB;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=50)
	private String address;
	
	@Column(nullable=false, length=50, unique=true)
	private String passwordEncrypted;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}
	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}
	
	
	
}