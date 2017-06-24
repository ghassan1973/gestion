package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Product;
import com.mypackage.gestion2.service.ProductService;
import com.mypackage.gestion2.repo.ProductRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService
{
	@Resource
	private ProductRepository productRepository;

	@Override
	protected BaseRepository<Product> getRepository() {
		return productRepository;
	}
	
	
}
