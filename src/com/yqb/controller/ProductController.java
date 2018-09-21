package com.yqb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.binding.StringFormatter;
import com.yqb.domain.Category;

import com.yqb.domain.Product;
import com.yqb.service.ProductService;

@Controller
public class ProductController {
    @Autowired
	private ProductService service;
    @RequestMapping("/queryProducts.do")
    public ModelAndView queryProducts() {
    	List<Product> products = service.queryProducts();
    	//System.out.println(products);
          
		ModelAndView mv = new ModelAndView();
    	mv.addObject("products",products);
    	
    	mv.setViewName("product-list");
    	return mv;
    }
    @RequestMapping("/insertProduct.do")
	public ModelAndView insertProduct(Product product) {
		//1.获取参数
		System.out.println(product);
		
		//2.处理业务
		int result = service.insertProduct(product);
		
		//3.返回处理结果
		ModelAndView mv=new ModelAndView();
		if(result>0) {
			mv.setViewName("redirect:queryProducts.do");
		}else{
			mv.setViewName("/fail");
		}
		
		
		return mv;
	}
    @RequestMapping("/deleteProduct.do")
	public ModelAndView deleteProduct(String id) {
		//System.out.println(id);
		
		int result = service.deleteProduct(id);
		ModelAndView mv = new ModelAndView();
		if(result>0) {
			mv.setViewName("redirect:queryProducts.do");
		}else {
			mv.setViewName("error");
		}
		return mv;
	}
    @RequestMapping("/getUpdateForm.do")
    public ModelAndView getUpdateForm(String id) {
    	Product product = service.queryProduct(id);
    	List<Category> categories=service.queryAllCategories();
    	
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("product",product);
    	mv.addObject("categories", categories);
    	mv.setViewName("update");
    	return mv;
    }
    @RequestMapping("/updateProduct.do")
    public ModelAndView updateProduct(Product product) {
    	int i = service.updateProduct(product);
    	ModelAndView mv=new ModelAndView();
    	if (i>0) {
			mv.setViewName("redirect:queryProducts.do");
		}else{
			mv.setViewName("error");
		}
    	return mv;
    }
    @RequestMapping("/getInsertForm.do")
	public ModelAndView getInsertForm() {
		//1.获取参数
		//2.处理业务
		List<Category> categories=service.queryAllCategories();
		
		//3.返回处理结果
		ModelAndView mv=new ModelAndView();
		mv.addObject("categories",categories);
		mv.setViewName("insert");
		
		return mv;
	}
}
