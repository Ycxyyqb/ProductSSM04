package com.yqb.dao;

import java.util.List;
import java.util.Map;

import com.yqb.domain.Category;
import com.yqb.domain.Product;



public interface ProductMapper {
	
	public Product queryProduct(String id);

	public List<Product> queryProducts();
	
	public int deleteProduct(String id);
	
	public int insertProduct(Product product);
	
	public int updateProduct(Product product);
	
	
	public List<Category> queryAllCategories();
	
	public List<Category> queryCategories(String pid);
	
	public int insertProductCategory(Map<String, Object> map);
	
	public int deleteProductCategory(String pid);
}
