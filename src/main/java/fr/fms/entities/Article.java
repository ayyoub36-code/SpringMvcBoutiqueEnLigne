package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderItems"})
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 50)
	private String description;
	private String brand;
	@DecimalMin("50")
	private double unitaryPrice;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "article")
	private Collection<OrderItem> orderItems;

}
