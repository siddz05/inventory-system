/**
 * 
 */
package com.cleartrip.inventory.pojo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sid
 *
 */
public class InventoryPojo {

	private long id;
	private String name;
	private double Cost;
	private long total;

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	Set<InventoryPojo> listOfInventoryItems = new HashSet<>();
	private final AtomicLong idValue = new AtomicLong();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l the id to set
	 */
	public void setId(long l) {
		this.id = l;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return Cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		Cost = cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InventoryItems [id=" + id + ", name=" + name + ", Cost=" + Cost + ", quantity=" + total + "]";
	}

	public Set<InventoryPojo> addAndgetItemIInventory(String name, Double cost, Long total) {
		InventoryPojo inventory = new InventoryPojo();
		inventory.setId(idValue.incrementAndGet());
		inventory.setName(name);
		inventory.setCost(cost);
		inventory.setTotal(total);
		listOfInventoryItems.add(inventory);
		return listOfInventoryItems;
	}

	public Set<InventoryPojo> updateItemInInventory(String name, Double cost, Long total) throws Exception {
		for (InventoryPojo items : listOfInventoryItems)
			if (items.getName().equalsIgnoreCase(name)) {
				items.setCost(cost);
				items.setTotal(items.getTotal() + total);
				return listOfInventoryItems;
			}
		return listOfInventoryItems;
	}

	public Set<InventoryPojo> getAllInventoryItems() {
		return listOfInventoryItems;
	}

	/**
	 * @param name2
	 * @param quantity
	 * @return
	 * @throws Exception
	 */
	public Set<InventoryPojo> checkOutInventory(String name, Long quantity) throws Exception {
		for (InventoryPojo items : listOfInventoryItems)
			if (items.getName().equalsIgnoreCase(name)) {
				items.setTotal(items.getTotal() - quantity);
				return listOfInventoryItems;
			} else {
				throw new Exception("Item Not Found -- Sold Out!");
			}
		return listOfInventoryItems;
	}

}
