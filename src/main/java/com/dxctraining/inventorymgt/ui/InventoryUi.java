package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {

	@Autowired
	private ISupplierService supplierService;

	@PostConstruct
	public void runUi() {
		try {
			Supplier supplier1 = new Supplier("dharma");
			supplierService.addSupplier(supplier1);
			Supplier supplier2 = new Supplier("teja");
			supplierService.addSupplier(supplier2);
			Supplier supplier3 = new Supplier("dharma teja");
			supplierService.addSupplier(supplier3);

			System.out.println("*****Fetching supplier by id*****");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is " + fetched.getId() + " fetched supplier = " + fetched.getName());

		} catch (InvalidSupplierArgumentException e) {
			e.printStackTrace();
		} catch (SupplierNullException e) {
			e.printStackTrace();
		}

	}

}
