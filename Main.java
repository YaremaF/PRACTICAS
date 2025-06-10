package com.akihabara.market.model;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		InterfazConsola interfaz = new InterfazConsola ();
		ProductoDAO dao = new ProductoDAO();
		
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
				Productootaku consultarId;
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				break;
				
			case 7:
				
				break;
				
			case 8:
				
				break;
			}
			
		}while(opcion != 8);
			
		}

}