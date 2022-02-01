package br.com.aluno.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
   private static Connection connection;
      
   /**
	 * Método para conectar ao banco de dados
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @return uma conexão com banco de dados
	 */
   
   public static Connection getConnection() throws Exception {
		
		connection = null;
		
		try {
				
			  Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno?useTimezone=true&serverTimezone=UTC"
						+ "&autoReconnect=true&useSSL=false", "root", "root"); 
							
		}catch(ClassNotFoundException cfe) {
			System.out.println("Driver n�o encontrado: "+cfe.getMessage());
						
		}catch(SQLException sql) {
			System.out.println("SQLException: " + sql.getMessage());
		    System.out.println("SQLState: " + sql.getSQLState());
		    System.out.println("Erro: " + sql.getErrorCode());
		    System.out.println("StackTrace: " + sql.getStackTrace());		   
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
		
   // -----------------------------------------------------------------------------------------------------
   
   /**
	 * Método para encerrar uma conexão com banco de dados
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param conn objeto de conexão
	 * @param ps objeto do tipo preparedStatement
	 * @param rs objeto do tipo resultSet
	 */
   
	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
		
		try {
			
			close(conn, ps, rs);
	
		}catch(Exception e) {
		
			System.out.println("Erro ao encerrar conexão: "+e.getMessage());
		}		
	}
	
	// -----------------------------------------------------------------------------------------------------
   
  /**
	 * Método para encerrar uma conexão com banco de dados (sem resultSet)
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param conn objeto de conexão
	 * @param ps objeto do tipo preparedStatement	
	 */
	public static void closeConnection(Connection conn, PreparedStatement ps) {
		
		try {
		
			close(conn, ps, null);
	
		}catch(Exception e) {
		System.out.println("Erro ao encerrar conexão: "+e.getMessage());
	}		
  }
	
  // -----------------------------------------------------------------------------------------------------
	   
  /**
	 * Método para modelo para encerrar uma conexão com banco de dados
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param conn objeto de conexão
	 * @param ps objeto do tipo preparedStatement
	 * @param rs objeto do tipo resultSet
	 */
	private static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws Exception {
		
		try {
			
			if (rs != null)
					rs.close();
			
			if (ps != null)
					ps.close();
			
			if (conn != null)
					conn.close();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao encerrar conexão: "+e.getMessage());
			
		}
	}
	
 // -----------------------------------------------------------------------------------------------------
	   
		
}

