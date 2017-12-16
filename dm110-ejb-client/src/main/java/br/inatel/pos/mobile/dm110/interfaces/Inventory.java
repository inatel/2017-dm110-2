package br.inatel.pos.mobile.dm110.interfaces;

import br.inatel.pos.mobile.dm110.to.ProductTO;

public interface Inventory {

	void addNewProduct(String productName);

	String[] listProductNames();

	ProductTO[] listProducts();

}
