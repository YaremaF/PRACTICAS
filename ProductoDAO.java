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
	
    public ProductoDAO() {
        this.conexion = new DatabaseConnection();
    }
	
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
		            producto.setId(miResultSet.getInt("id"));
		            producto.setNombre(miResultSet.getString("nombre"));
		            producto.setPrecio(miResultSet.getDouble("precio"));
		            producto.setCategoria(miResultSet.getString("categoria"));
		            producto.setStock(miResultSet.getInt("stock"));
			 }
			 miResultSet.close();
			 miPreparedStatement.close();
			 conexion1.close();
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
				producto.setId(miResultSet.getInt("id"));
				producto.setNombre(miResultSet.getString("nombre"));
				producto.setCategoria(miResultSet.getString("categoria"));
				producto.setPrecio(miResultSet.getDouble("precio"));
				producto.setStock(miResultSet.getInt("stock"));
				
				productos.add(producto);
				
			}
			 miResultSet.close();
			 miPreparedStatement.close();
			 conexion1.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public boolean actualizarProducto(ProductoOtaku producto) {
		Connection conexion1 = conexion.getConexion();
		
		String actualizar = "UPDATE producto SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE ID = ?";
		try {
			
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(actualizar);
			
			miPreparedStatement.setString(1, producto.getNombre());
			miPreparedStatement.setString(2, producto.getCategoria());
			miPreparedStatement.setDouble(3, producto.getPrecio());
			miPreparedStatement.setInt(4, producto.getStock());
			miPreparedStatement.setInt(5, producto.getId());
			
			miPreparedStatement.executeUpdate();
			
			System.out.println("El producto se actualizo correctamente");
			
			miPreparedStatement.close();
			conexion1.close();
		
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
			
			miPreparedStatement.close();
			conexion1.close();
			
			System.out.println("Se ha eliminado el producto correctamente");
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public List<ProductoOtaku> buscarProductosPorNombre(String nombre){
		List<ProductoOtaku> productos = new ArrayList<>();
		Connection conexion1 = conexion.getConexion();
		String buscarNombre = "SELECT * FROM producto WHERE nombre LIKE ?";
		
		try {
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(buscarNombre);
			
			miPreparedStatement.setString(1, "%" + nombre + "%");
			ResultSet miResultSet = miPreparedStatement.executeQuery();
			
			while(miResultSet.next()) {
				 ProductoOtaku producto = new ProductoOtaku(
						 miResultSet.getInt("id"),
						 miResultSet.getString("nombre"),
						 miResultSet.getString("categoria"),
						 miResultSet.getDouble("precio"),
						 miResultSet.getInt("stock")
		                );
		                productos.add(producto);
			}
			
			miResultSet.close();
			miPreparedStatement.close();
			conexion1.close();
		}catch(SQLException e) {
            System.out.println("Error al buscar productos por nombre: " + e.getMessage());
        }
        return productos;
	}
	
	public List<ProductoOtaku> buscarProductoPorCategoria(String categoria){
		List<ProductoOtaku> productos = new ArrayList<>();
		Connection conexion1 = conexion.getConexion();
		String buscarCategoria = "SELECT * FROM producto WHERE categoria LIKE ?";
		
		try {
			PreparedStatement miPreparedStatement = conexion1.prepareStatement(buscarCategoria);
			
			miPreparedStatement.setString(1, "%" + categoria + "%");
			ResultSet miResultSet = miPreparedStatement.executeQuery();
			
			while(miResultSet.next()) {
				ProductoOtaku producto = new ProductoOtaku(
				miResultSet.getInt("id"),
				miResultSet.getString("nombre"),
				miResultSet.getString("categoria"),
				miResultSet.getDouble("precio"),
				miResultSet.getInt("stock")
				);
				productos.add(producto);
			}
			
			miResultSet.close();
			miPreparedStatement.close();
			conexion1.close();
			
		}catch(SQLException e) {
			System.out.println("Error al buscar los productos por categoria: " + e.getMessage());
			
		}
		return productos;
	}
}