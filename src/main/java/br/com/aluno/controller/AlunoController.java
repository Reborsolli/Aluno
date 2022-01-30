package br.com.aluno.controller;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.aluno.dao.AlunoDAO;

@ManagedBean(name="alunoController")
@RequestScoped
public class AlunoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AlunoDAO dao;
	
	//Construtor usar caso precisar
	
	@PostConstruct 
	public void init() {
		
	} 
	
	// ------------------------------
	
	/**
	 * Método para salvar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0	
	 */
	
	public void salvar() {
		
	}
	
	// ------------------------------
	
	/**
	 * Método para atualizar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0	
	 */
	public void atualizar() {
		
	}
	
	// ------------------------------
	
	/**
	 * Método para deletar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0	
	 */
	public void deletar() {
		
	}
	
	// ------------------------------
	
	/**
	 * Método para obter um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0	
	 */
	public void getAluno() {
		
	}
	
	// ------------------------------
	
	/**
	 * Método para listar todos alunos
	 *  
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @since 1.0	
	 */
	public void listar() {
		
	}
	
}
