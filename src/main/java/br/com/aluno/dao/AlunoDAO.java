package br.com.aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.aluno.model.Aluno;

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
	 */
	
	public boolean salvar(Aluno aluno) {
		
		boolean saved = false;
		
		
		
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
	
	public boolean atualizar(Aluno aluno) {
		
		boolean updated = false;
		
		
		
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
	 */
	
	public boolean deletar(int matricula) {
		
		boolean deleted = false;
		
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
	
	public Aluno getAluno(int matricula) {
		
		Aluno aluno = new Aluno();
		
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
	 */
	
	public List<Aluno> listarAlunos() {
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		return lista;
		
	}
	
	// -----------------------------------------------
	
}
