import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NumerRegistros {
	 public static void main(String[] args) {
	      try {
		//Cargar el driver
		Class.forName("com.mysql.jdbc.Driver");
		
	      //Establecemos la conexion con la BD
		Connection conexion = DriverManager.getConnection 
	             ("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");

		// Preparamos la consulta
		Statement sentencia = conexion.createStatement();
	      String sql = "SELECT * FROM departamentos";
		ResultSet resul = sentencia.executeQuery(sql);

		resul.last(); //Nos situamos en el último registro
		System.out.println ("NÚMERO DE FILAS: " + resul.getRow());

		resul.beforeFirst(); //Nos situamos antes del primer registro	  
				  
		//Recorremos el resultado para visualizar cada fila
		while (resul.next()) 
		    System.out.printf("Fila %d: %d, %s, %s %n",  
		    		 resul.getRow(),
		             resul.getInt(1), resul.getString(2), resul.getString(3) );


		resul.close();     // Cerrar ResultSet
		sentencia.close(); // Cerrar Statement
		conexion.close();  // Cerrar conexión

	      } catch (ClassNotFoundException cn) {
		   cn.printStackTrace();
	      } catch (SQLException e) {
		   e.printStackTrace();
	      }

	   }// fin de main
}
