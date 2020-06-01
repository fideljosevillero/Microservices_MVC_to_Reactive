package com.fideljose.eureka_discovery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import lombok.Data;

@Entity
@Table(name="Client")
@Data
public class ClientEntity extends SerializableSerializer {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=50, unique=false)
	private String idClientDB;

	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=50)
	private String address;
	
	@Column(nullable=false, length=400, unique=false)
	private String passwordEncrypted;
	
	@Column(nullable=false, length=400, unique=true)
	private String email;
}
