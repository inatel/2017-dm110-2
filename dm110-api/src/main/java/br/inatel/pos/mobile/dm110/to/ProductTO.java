package br.inatel.pos.mobile.dm110.to;

import java.io.Serializable;

public class ProductTO implements Serializable {

	private static final long serialVersionUID = 2693625650697491893L;

	private Integer id;
	private String name;
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
