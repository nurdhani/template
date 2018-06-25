package com.pji.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pji.model.Customer;
import com.pji.model.Product;
import com.pji.repository.CustomerJpaRepository;
import com.pji.repository.ProductJpaRepository;

@Component
public class ProductService {

	@Autowired
	private ProductJpaRepository productJpaRepository;
	private Logger log = LoggerFactory.getLogger(getClass());

	public List<Product> getProductName(String productName) throws JsonProcessingException {
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "getProductName", "String", productName);
		List<Product> product = productJpaRepository.findByProductName(productName);
		log.info("\"{}\" | ".concat("output").concat(" ({}) : {}"), "getproductName", "List<product>",
				new ObjectMapper().writeValueAsString(product));
		return product;
	}
	
	public List<Product> getProductCategory(String product_category) throws JsonProcessingException {
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "getProductCategory", "String", product_category);
		List<Product> product = productJpaRepository.findByProductCategory(product_category);
		log.info("\"{}\" | ".concat("output").concat(" ({}) : {}"), "getproductCategory", "List<product>",
				new ObjectMapper().writeValueAsString(product));
		return product;
	}
	
	public List<Product> getproductType(String productType) throws JsonProcessingException {
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "getproducttype", "String", productType);
		List<Product> product = productJpaRepository.findByProductType(productType);
		log.info("\"{}\" | ".concat("output").concat(" ({}) : {}"), "getproductType", "List<product>",
				new ObjectMapper().writeValueAsString(product));
		return product;
	}
	
	public List<Product> getStock(Long stock) throws JsonProcessingException {
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "getStock", "String", stock);
		List<Product> product = productJpaRepository.findByStock(stock);
		log.info("\"{}\" | ".concat("output").concat(" ({}) : {}"), "getStock", "List<product>",
				new ObjectMapper().writeValueAsString(product));
		return product;
	}

	public List<Product> getByParam(String productName) throws JsonProcessingException {
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "getByParam", "String", productName);
		List<Product> product = productJpaRepository.findByParam(productName);
		log.info("\"{}\" | ".concat("output").concat(" ({}) : {}"), "getByParam", "List<product>",
				new ObjectMapper().writeValueAsString(product));
		return product;
	}


	public void saveDataProduct(Product p_ObjectData) {

		productJpaRepository.save(p_ObjectData);
		log.info("\"{}\" | ".concat("input").concat(" ({}) : {}"), "saveDataProduct", "String", p_ObjectData);
	}

	public boolean isIDExist(Long long1) {
		List<Product> exist = productJpaRepository.findByProductId((long) long1);
		return exist.size() != 0 ? false : true;
	}
	
	public String createDataByHash(HashMap<String, Object> param) throws ParseException {
		Product data = new Product();
		data.setProductName(param.get("productName").toString());
		data.setProductCategory(param.get("productCategory").toString());
		data.setProductType(param.get("productType").toString());
		data.setStock(Long.valueOf(param.get("stock").toString()));
		//data.setLastname(param.get("lastName").toString());
		productJpaRepository.save(data);

		return "Success Created";
	}

}
