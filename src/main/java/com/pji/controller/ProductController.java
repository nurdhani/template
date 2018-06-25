package com.pji.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pji.model.Customer;
import com.pji.model.Product;
import com.pji.service.CustomerService;
import com.pji.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getProductName", method = RequestMethod.POST)
	private List<Product> getByProductName(@RequestBody HashMap<String, String> param) throws JsonProcessingException {
		return productService.getProductName(param.get("productName").toString());
	}
	
	@RequestMapping(value = "/getProductCategory", method = RequestMethod.POST)
	private List<Product> getByProductCategory(@RequestBody HashMap<String, String> param) throws JsonProcessingException {
		return productService.getProductCategory(param.get("productCategory").toString());
	}
	
	@RequestMapping(value = "/getProductType", method = RequestMethod.POST)
	private List<Product> getByProductType(@RequestBody HashMap<String, String> param) throws JsonProcessingException {
		return productService.getproductType(param.get("productType").toString());
	}
	
	@RequestMapping(value = "/getStock", method = RequestMethod.POST)
	private List<Product> getByStock(@RequestBody HashMap<String, String> param) throws JsonProcessingException {
		return productService.getStock(Long.valueOf(param.get("stock").toString()));
	}
	
	@RequestMapping(value = "/getByParam", method = RequestMethod.POST)
	private List<Product> getByParam(@RequestBody HashMap<String, String> param) throws JsonProcessingException {
		return productService.getByParam(param.get("ProductName").toString());
	}
	
	@RequestMapping(value = "/productCreate", method = RequestMethod.POST)
	public String productCreateByHash(@RequestBody HashMap<String, Object> param) throws ParseException
	{	
		/*String respon = "Failed";
		Boolean exist = personService.isIDExist((Integer)param.get("id"));
		if (exist){
			personService.createDataByHash(param);
			respon = "Success";
		}*/
		return productService.createDataByHash(param);
	}
	
}
