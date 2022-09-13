package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ProductDao;
import com.springrest.springrest.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
//	List<Product> list;
	public ProductServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Product(1,"Phone","use","Mobile",1,50000));
//		list.add(new Product(2,"Laptop","use","electronic devices",1,80000));
	}

	@Override
	public List<Product> getProducts() {

		return productDao.findAll();
	}

	
	//
//	public Product getProduct(long productId) {
//		// TODO Auto-generated method stub
//		
//	Product p=null;
//	for(Product product:list)
//		{
//			if(product.getId()==productId)
//			{
//				p=product;
//				break;
//			}
//		}
//		return p;
//	}

//	@Override
//	public Product addProduct(Product product) {
////		list.add(product);
//		productDao.save(product);
//		return product;
//	}

	@Override
	public Product getProduct(long productId) {
		// TODO Auto-generated method stub
		Optional<Product> res = productDao.findById(productId);
		if(res.isEmpty()) {
			throw new RuntimeException("Invalid Product Id");
		}
		
		return res.get();
	}
	@Override
	public Product addProduct(Product product) {
//		list.add(product);
		productDao.save(product);
		return product;
	}

}
