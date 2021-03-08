package com.microservicio.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.producto.dto.Producto;
import com.microservicio.producto.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<Object> getProducts(){
		List<Producto> productos = productoService.getProducts();
		return new ResponseEntity<>(productos, new HttpHeaders(), HttpStatus.OK);
	}
}
