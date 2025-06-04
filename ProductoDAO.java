package com.akihabara.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
	private DatabaseConnection conexion;
	
	ProductoOtaku producto = new ProductoOtaku();
	
	public void agregarProducto (ProductoOtaku producto) {
		Connection conexion1 = conexion.getConexion();
		String instruccionSql = "INSERT INTO producto (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
	
		try {
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(instruccionSql);
			miPreparedStatement.setString(1, producto.getNombre());
			miPreparedStatement.setString(2, producto.getCategoria());
			miPreparedStatement.setDouble(3, producto.getPrecio());
			miPreparedStatement.setInt(4, producto.getStock());
			
		    //EJECUTAMOS EL QUERY
			miPreparedStatement.executeUpdate();
			
			System.out.println("SE INSERTÓ CORRECTAMENTE\n");
			
			//CERRAMOS EL PREPAREDSTATEMENT
			miPreparedStatement.close();
			
			conexion1.close();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public ProductoOtaku obtenerProductoPorId(int id) {
		Connection conexion1 = conexion.getConexion();
		String busquedaId = "SELECT * FROM producto WHERE id = ?";
		
		try{
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(busquedaId);
			miPreparedStatement.setInt(1, id);
			ResultSet miResultSet = miPreparedStatement.executeQuery();
			
			 if (miResultSet.next()) {
		            producto = new ProductoOtaku();
		            producto.setNombre(miResultSet.getString("nombre"));
		            producto.setPrecio(miResultSet.getDouble("precio"));
		            producto.setCategoria(miResultSet.getString("categoria"));
		            producto.setStock(miResultSet.getInt("stock"));
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		return producto;

	}
	
	public List<ProductoOtaku> obtenerTodosLosProductos(){
		Connection conexion1 = conexion.getConexion();
		
		List<ProductoOtaku> productos = new ArrayList<>();
		
		String enlistar = "SELECT * FROM producto";
		
		try {
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(enlistar);
			ResultSet miResultSet = miPreparedStatement.executeQuery();
			
			while (miResultSet.next()) {
				ProductoOtaku producto = new ProductoOtaku();
				producto.setNombre(miResultSet.getString("nombre"));
				producto.setCategoria(miResultSet.getString("categoria"));
				producto.setPrecio(miResultSet.getDouble("precio"));
				producto.setStock(miResultSet.getInt("stock"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public boolean actualizarProducto(ProductoOtaku producto) {
		Connection conexion1 = conexion.getConexion();
		
		String actualizar = "UPDATE producto SET nombre = ?, categoria = ?, precio = ?, stock = ? ";
		try {
			
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(actualizar);
			
			miPreparedStatement.setString(1, producto.getNombre());
			miPreparedStatement.setString(2, producto.getCategoria());
			miPreparedStatement.setDouble(3, producto.getPrecio());
			miPreparedStatement.setInt(4, producto.getStock());
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarProducto(int id) {
		Connection conexion1 = conexion.getConexion();
		
		String eliminar = ("DELETE FROM producto WHERE id = ?");
		try {
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(eliminar);
			miPreparedStatement.setInt(1,id);
			miPreparedStatement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
