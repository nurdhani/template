package com.pji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pji.model.Customer;
import com.pji.model.Product;;


public interface ProductJpaRepository extends PagingAndSortingRepository<Product, Integer>{

	@Query(value = "select * from product where product_name like %?1%", nativeQuery = true)
	List<Product> findByParam(String productName);

	List<Product> findByProductName(String productName);

	List<Product> findByProductCategory(String productCategory);
	
	List<Product> findByProductType(String productType);
	
	List<Product> findByProductId(Long productId);
	
	List<Product> findByStock(Long stock);
	
}
