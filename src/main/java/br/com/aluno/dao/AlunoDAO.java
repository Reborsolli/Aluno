package br.com.aluno.dao;
import br.com.aluno.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluno.util.ConnectionFactory;

public class AlunoDAO {
	
	private Connection conn;			
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Método para salvar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param aluno objeto do tipo aluno
	 * @return verdadeiro caso salvou um aluno
	 * @throws Exception 
	 */
	
	public boolean salvar(Aluno data) throws Exception {
		
		boolean saved = false;
		
		String query="INSERT INTO aluno(id, matricula, nome, idade) VALUES (null, ?, ?, ?)";

		try {

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(query);
		
			ps.setInt(1, data.getMatricula());
			ps.setString(2, data.getNome());
			ps.setInt(3, data.getIdade());
	 	 
			int res = ps.executeUpdate();
			
			if(res > 0)
				saved = true;
					
		}catch (SQLException cadastrar){
			
			System.out.println("Erro ao inserir dados: " + cadastrar.getMessage());
		
		}finally {
			
			ConnectionFactory.closeConnection(conn, ps);

		}
		
		return saved;
	
		}		

	// -----------------------------------------------
	
	/**
	 * Método para atualizar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param aluno objeto do tipo aluno
	 * @return verdadeiro caso atualizou um aluno
	 */
	
		public boolean atualizar(Aluno aluno) throws Exception {
		
		boolean updated = false;
		
		String query = "UPDATE aluno SET nome= ?, idade = ? WHERE matricula = ?";
		
			try {
				
				conn = ConnectionFactory.getConnection();
				ps = conn.prepareStatement(query);
				
				ps.setString(1, aluno.getNome());
				ps.setInt(2, aluno.getIdade());
				ps.setInt(3, aluno.getMatricula());
			
			 int rs = ps.executeUpdate();

				if(rs > 0)
					updated = true;
				
			}catch (SQLException atualizar){
				
			System.out.println("Erro ao alterar dados "+atualizar.getMessage());
			
			}finally {
				ConnectionFactory.closeConnection(conn, ps);
			}	
				
		return updated;	
  }
	
	// -----------------------------------------------

	/**	
	 * Método para deleção de um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param matricula número da matricula do aluno
	 * @return verdadeiro caso deletou um aluno
	 * @throws Exception 
	 */
	
		public boolean deletar(int matricula) throws Exception {
		
		boolean deleted = false;
		
		String query = "Delete FROM aluno WHERE matricula = ?";
		
		try {
			
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, matricula);
			int res = ps.executeUpdate();
			
			if(res > 0)
				deleted = true;
			
		}catch (SQLException delete){
			
			System.out.println("Erro deletar "+delete.getMessage());
			
		}finally {
				
			ConnectionFactory.closeConnection(conn, ps);
		}	
		
		return deleted;
		
	}
	
	// -----------------------------------------------
	
	/**
	 * Método para salvar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param matricula número da matricula do aluno
	 * @return um objeto do tipo aluno
	 */
	
    public Aluno getAluno(int matricula)  throws Exception {
		
		Aluno aluno = new Aluno();
	
		String query = "SELECT matricula, nome, idade FROM aluno WHERE matricula = ? ";
 		
		try {
		
	    conn = ConnectionFactory.getConnection();
		ps = conn.prepareStatement(query);		
		ps.setInt(1, matricula);
		
		rs = ps.executeQuery();
					
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
				
				aluno.setMatricula(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setIdade(rs.getInt(3));				
				
		   }		
		}
		
		
		}catch (SQLException obter){
			
		System.out.println("Erro buscar dados "+obter.getMessage());
		
		}finally {
			
			ConnectionFactory.closeConnection(conn, ps, rs);
		}	
		
		return aluno;		
		
	} 

	// -----------------------------------------------
	
	/**
	 * Método para listar alunos
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0
	 * @param aluno objeto do tipo aluno
	 * @return uma lista com objetos do tipo aluno
	 * @throws Exception 
	 */
	
	public List<Aluno> listarAlunos() throws Exception { 
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		String query = "SELECT matricula, nome, idade FROM aluno ";
		
		try {
			
		conn = ConnectionFactory.getConnection();
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		
		if(rs.isBeforeFirst()) {			
			while(rs.next()) {
				
				Aluno aluno  = new Aluno();				
				
				aluno.setMatricula(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setIdade(rs.getInt(3));
				
				
				lista.add(aluno);
				
			}
		}
		
		}catch(SQLException listar) {
			
			System.out.println("Erro listar dados "+listar.getMessage());
			
		}finally {
			
			ConnectionFactory.closeConnection(conn, ps, rs);
			
		}
		
		return lista;
		
	}

	
	}
	
	// -----------------------------------------------
	


