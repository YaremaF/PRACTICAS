package com.akihabara.market.model;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		InterfazConsola interfaz = new InterfazConsola ();
		ProductoDAO dao = new ProductoDAO();
		
		//CREAMOS VARIABLE LOCAL
		int opcion;
		do {
			interfaz.mostrarMenu();
			
			opcion = interfaz.opcionElegida();
			
			switch(opcion) {
			case 1:
				ProductoOtaku insertarProducto;
				insertarProducto = interfaz.datosProducto();
				dao.agregarProducto(insertarProducto);
				
				break;
				
			case 2:
				int consultarId;
				consultarId = interfaz.idProducto();
				System.out.println(dao.obtenerProductoPorId(consultarId));
				System.out.println("");
				
				break;
				
			case 3:
				dao.obtenerTodosLosProductos();
				
				List <ProductoOtaku> productos = dao.obtenerTodosLosProductos();
				for (ProductoOtaku producto : productos) {
					System.out.println(producto);
				}
				
				break;
				
			case 4:
				
				String nombre;
				nombre = interfaz.nombreProducto();
				
				
				List<ProductoOtaku> productosNombre = dao.buscarProductosPorNombre(nombre);
				for(ProductoOtaku producto : productosNombre) {
					System.out.println(producto);
				}
				
				break;
				
			case 5:
				String categoria;
				categoria = interfaz.categoriaProducto();
				
				List<ProductoOtaku> productosCategoria = dao.buscarProductoPorCategoria(categoria);			
				
				for(ProductoOtaku producto : productosCategoria) {
					System.out.println(producto);
				}
				break;
				
			case 6:
				
				ProductoOtaku actualizar;
				actualizar = interfaz.datosProductoConId();
				dao.actualizarProducto(actualizar);
				
				break;
				
			case 7:
				int id;
				id = interfaz.idProducto();
				dao.eliminarProducto(id);
				
				break;
				
			case 8:
				
				break;
				
			default:
				System.out.println("El número introducido no es válido");
			}
			
				
			
		}while(opcion != 8);
			System.out.println("Saliendo del sistema!!");
		}

}