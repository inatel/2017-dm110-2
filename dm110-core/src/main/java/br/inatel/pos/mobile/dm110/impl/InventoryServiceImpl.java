package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.InventoryService;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;
import br.inatel.pos.mobile.dm110.to.ProductTO;

@RequestScoped
public class InventoryServiceImpl implements InventoryService {

	@EJB(lookup = "java:app/dm110-ejb-1.0.0-SNAPSHOT/InventoryBean!br.inatel.pos.mobile.dm110.interfaces.InventoryRemote")
	private InventoryRemote inventoryBean;

	@Override
	public void addNewProduct(ProductTO product) {
		inventoryBean.addNewProduct(product);
	}

	@Override
	public String[] listProductNames() {
		return inventoryBean.listProductNames();
	}

	@Override
	public ProductTO[] listProducts() {
		return inventoryBean.listProducts();
	}

}
