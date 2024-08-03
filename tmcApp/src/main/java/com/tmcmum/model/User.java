package com.tmcmum.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

@Data
@Entity
@Table(name="USER")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;

	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="imageUrl", nullable=true)
	private String imageUrl;
	
	@Column(name="EMAIL_VERIFIED", nullable=true)
	private boolean emailVerified = false;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	private AuthProvider provider;
	
	private String providerId;
	

}
