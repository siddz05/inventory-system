/**
 * 
 */
package com.cleartrip.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleartrip.inventory.pojo.InventoryPojo;

/**
 * @author sid
 *
 */
@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

	private static final Logger logger = Logger.getLogger(InventoryController.class.getName());
	InventoryPojo inventory = new InventoryPojo();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	Map<Object, Object> create(@RequestParam(required = true, value = "name") String name,
			@RequestParam(required = true, value = "cost") Double cost,
			@RequestParam(required = true, value = "quantity") Long quantity) {
		Map<Object, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("Item Added " + name, inventory.addAndgetItemIInventory(name, cost, quantity).size());
			logger.info("Record Saved! " + resultMap);
		} catch (Exception e) {
			logger.info("Some Error Occured." + e);
			resultMap.put("Error", "Some Error Occured, While Saving The Data!" + e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	Map<Object, Object> update(@RequestParam(required = true, value = "name") String name,
			@RequestParam(required = true, value = "cost") Double cost,
			@RequestParam(required = true, value = "quantity") Long quantity) {
		Map<Object, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("ItemsList", inventory.updateItemInInventory(name, cost, quantity));
			logger.info("Record Updated! " + resultMap);
		} catch (Exception e) {
			logger.info("Some Error Occured." + e);
			resultMap.put("Error", "Some Error Occured, While Saving The Data!" + e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/checkOut", method = RequestMethod.GET)
	@ResponseBody
	Map<Object, Object> checkOut(@RequestParam(required = true, value = "name") String name,
			@RequestParam(required = true, value = "quantity") Long quantity) {
		Map<Object, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("ItemCheckout " + name, inventory.checkOutInventory(name, quantity));
			logger.info("ItemCheckout! " + resultMap);
		} catch (Exception e) {
			logger.info("Some Error Occured." + e);
			resultMap.put("Error", "Some Error Occured, While Saving The Data!" + e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	Map<Object, Object> get() {
		Map<Object, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("ItemsList", inventory.getAllInventoryItems());
			logger.info("Records Are! " + resultMap);
		} catch (Exception e) {
			logger.info("Some Error Occured." + e);
			resultMap.put("Error", "Some Error Occured, While Displaying The Data!" + e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	Map<String, List<InventoryPojo>> test(@RequestParam(required = true, value = "name") String name) {
		Map<String, List<InventoryPojo>> resultMap = new HashMap<>();

		logger.info("Record Saved! " + resultMap);
		return resultMap;
	}
}
