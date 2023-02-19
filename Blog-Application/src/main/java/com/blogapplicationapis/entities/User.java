package com.blogapplicationapis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//if we want to change the name of  entity then we can write like @Entity(name="entity_name")
@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="user_name",nullable=false,length=100)
	private String name;
	private String email;
	private String password;
	private String about;
	
	

}
