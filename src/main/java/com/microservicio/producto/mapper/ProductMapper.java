package com.microservicio.producto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.microservicio.producto.dto.Producto;

public class ProductMapper implements RowMapper<Producto>{

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto = new Producto();
		producto.setDescription(rs.getString("DESCRIPTION"));
		producto.setExist(rs.getInt("EXIST"));
		producto.setId(rs.getInt("ID"));
		producto.setName(rs.getString("NAME"));
		producto.setPrice(rs.getString("PRICE"));
		return producto;
	}

}
