package fr.fms.entities;

import java.io.Serializable;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article implements Serializable{
	private static final long serialVersionUID=1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double unitaryPrice;
	private String brand;
	@ManyToOne
	private Category category;
	//@OneToMany(mappedBy = "orderedItem")
	//private Collection<OrderedItem> orderedItems;

}
	

	