package com.akihabara.market.model;

//IMPORTAMOS LOS sql. NECESARIOS PARA CREAR LA CONEXIÓN CON LA BBDD.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseConnection {
	// CREAMOS LAS CONSTANTES ESTATICAS QUE USAREMOS PARA ESTABLECER LA CONEXIÓN A LA BASE DE DATOS.
	final static String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db";
	final static String USER = "userAkihabara";
	final static String PASSWORD = "curso";
	
	//CREAMOS UNA VARIABLE ESTÁTICA 'CONEXION' DEL TIPO CONNECTION.
	private static Connection conexion;
	
	//MÉTODO QUE SIRVE PARA CONECTARSE A LA BBDD.
	public DatabaseConnection() {
		  try {
			  //OBTENEMOS EL DRIVER DE MYSQL.
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  System.out.println("Se ha cargado en memoria el driver de MySQL.");
			  
			  //CON LAS CONSTANTES ESTABLECIDAS NOS CONECTAMOS A LA BBDD.
			  //EL DRIVERMANAGER USARÁ UN CORRECTO DRIVER PARA ESTABLECER LA CONEXIÓN.
	          conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	          System.out.println("Se ha establecido con éxito la conexión a la base de datos.");
	      //MENSAJES DE ERRORES SI NO SE CARGA EL DRIVER O SI NO SE PRODUCE LA CONEXIÓN 
	      }catch (ClassNotFoundException e) {
	    	  System.out.println("Error al cargar el driver " + e.getMessage());
	      } catch (SQLException e) {
	          System.out.println("Error en la conexión a la Base de Datos: " + e.getMessage());
	      } 
	}
	
	//MÉTODO PARA DEVOLVER LA CONEXIÓN.
	public static Connection getConexion() {
		return conexion;
  }
	
	//MÉTODO PARA CERRAR LA CONEXÓN.
	public static void cerrarConexion() {
		try {
			//CERRAMOS LA CONEXIÓN.
			conexion.close();
			System.out.println("Se ha cerrado la conexión con la base de datos.");
			//SI NO SE CIERRA APARECE UN MENSAJE DEL ERROR.
		} catch (Exception e) {
			System.out.println("Error cerrando la conexión: " + e.getMessage());
		}
	}

	public PreparedStatement prepareStatement(String instruccionSql) {
		// TODO Auto-generated method stub
		return null;
	}
	

}