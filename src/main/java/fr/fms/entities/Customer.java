package fr.fms.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.apache.catalina.User;
import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer implements Serializable{
	private static final long serialVersionUID=1L;
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	//@Size(min = 5,max = 60)
	private String email;
	private String address;
	private String phone;	
	//@OneToMany(mappedBy="order")
	//private Collection<Order> orders;
	
}