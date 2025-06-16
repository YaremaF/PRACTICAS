package com.akihabara.market.model;

import java.util.Scanner;

public class InterfazConsola {

	Scanner scanner = new Scanner(System.in);
	
	public void mostrarMenu() {
		System.out.println("--- MENÚ PRINCIPAL OPCIONES ---");
		System.out.println("1. Añadir producto.");
		System.out.println("2. Consultar producto por ID.");
		System.out.println("3. Listar todos los productos.");
		System.out.println("4. Listar productos por nombre.");
		System.out.println("5. Listar productos por categoría.");
		System.out.println("6. Actualizar producto.");
		System.out.println("7. Eliminar producto.");
		System.out.println("8. Salir del programa.");
	}
	
	public int opcionElegida() {
		System.out.println("Escribe la opción que quieres hacer");
		int opcion = scanner.nextInt();
		scanner.nextLine();
		return opcion;
		

	}
	
	public ProductoOtaku datosProducto() {
		int id = 0;
		
		System.out.println("Escribe el nombre del producto");
		String nombre = scanner.nextLine();
		
		System.out.println("Escribe la categoria del producto");
		String categoria = scanner.nextLine();
		
		System.out.println("Escribe el precio del producto");
		double precio = scanner.nextDouble();
		
		System.out.println("Escribe el stock del producto");
		int stock = scanner.nextInt();
		
		ProductoOtaku producto = new ProductoOtaku(id,nombre,categoria,precio,stock);
		
		return producto;
	}
	
	public int idProducto() {
		System.out.println("Introduce el id del producto");
		int idBuscar = scanner.nextInt();
		
		return idBuscar;
	}
	
	public String nombreProducto() {
		System.out.println("Indtroduce el nombre del producto que quieres buscar");
		String nombre = scanner.nextLine();
		return nombre;
	}
	
	public String categoriaProducto() {
		System.out.println("Introduce la categoria del producto que quieres buscar");
		String categoria = scanner.nextLine();
		return categoria;
	}
	
	public void mostrarInformacion() {
		System.out.println("Mostrando la información:");
		
	}
	
	public ProductoOtaku datosProductoConId() {
		
		System.out.println("Escribe el id del producto");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Escribe el nombre del producto");
		String nombre = scanner.nextLine();
		
		System.out.println("Escribe la categoria del producto");
		String categoria = scanner.nextLine();
		
		System.out.println("Escribe el precio del producto");
		double precio = scanner.nextDouble();
		
		System.out.println("Escribe el stock del producto");
		int stock = scanner.nextInt();
		
		ProductoOtaku producto = new ProductoOtaku(id,nombre,categoria,precio,stock);
		
		return producto;
	}
}
