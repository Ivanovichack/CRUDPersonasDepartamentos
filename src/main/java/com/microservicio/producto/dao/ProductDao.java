package com.microservicio.producto.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.microservicio.producto.dto.Producto;
import com.microservicio.producto.mapper.ProductMapper;

import oracle.jdbc.OracleTypes;

@Component
public class ProductDao {
	
	@Autowired
	DataSource ds;
	
	public List<Producto> getProducts(){
		SimpleJdbcCall data = new SimpleJdbcCall(ds)
				.withProcedureName("SP_GET_PRODUCTS")
				.declareParameters(new SqlOutParameter("productos", OracleTypes.CURSOR, new ProductMapper()));
		Map<String, Object> out = data.execute();
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>)out.get("OUT_PRODUCTS");
		return productos;
	}
}
