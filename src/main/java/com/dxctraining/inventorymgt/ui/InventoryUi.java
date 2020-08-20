package com.dxctraining.inventorymgt.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IItemService itemService;

	@PostConstruct
	public void runUi() {
		try {
			List<Item> list = new ArrayList<>();
			Supplier supplier1 = new Supplier("dharma");
			Supplier supplier2 = new Supplier("teja");
			Supplier supplier3 = new Supplier("dharma teja");

			supplierService.addSupplier(supplier1);
			supplierService.addSupplier(supplier2);
			supplierService.addSupplier(supplier3);

			Item item1 = new Item("phone", supplier1);
			Item item2 = new Item("Computer", supplier2);
			Item item3 = new Item("laptop", supplier3);

			list.add(item1);
			itemService.addItem(item1);
			list.add(item2);
			itemService.addItem(item2);
			list.add(item3);
			itemService.addItem(item3);

			Computer item6 = new Computer("lenovo", supplier1, 1024);
			Computer item7 = new Computer("asus", supplier2, 1024);

			list.add(item6);
			itemService.addItem(item6);
			list.add(item7);
			itemService.addItem(item7);

			System.out.println("supplier details");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is " + fetched.getId() + " fetched supplier = " + fetched.getName());

			System.out.println("deleting item");
			int itemid3 = item3.getId();
			itemService.removeItem(itemid3);
			System.out.println("removed item id is " + itemid3);
			
			System.out.println("fetching computer item");
			int itemid1 = item6.getId();
			Computer computer=(Computer)item6;
			Item itemfetched = itemService.findById(itemid1);
			System.out.println("fetched item id is "+itemfetched.getId()+" fetched item name is "+itemfetched.getName());
			System.out.println("computer disk size is "+computer.getDiscSize());

		} catch (InvalidSupplierArgumentException e) {
			e.printStackTrace();
		} catch (SupplierNullException e) {
			e.printStackTrace();
		}

	}

}
