package com.microservicio.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.producto.dao.ProductDao;
import com.microservicio.producto.dto.Producto;
import com.microservicio.producto.interfaces.ProductInterface;

@Service
public class ProductService implements ProductInterface{
	
	@Autowired
	ProductDao productoDao;

	@Override
	public List<Producto> getProducts() {
		List<Producto> productos = productoDao.getProducts();
		return productos;
	}
}
