package br.inatel.pos.mobile.dm110.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
public class Product {

	@Id
	@GeneratedValue(generator = "seq_product", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
