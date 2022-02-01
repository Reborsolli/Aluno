package br.com.aluno.controller;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.aluno.dao.AlunoDAO;
import br.com.aluno.model.Aluno;

@ManagedBean(name="alunoController")
@RequestScoped
public class AlunoControllerBean implements Serializable {
	AlunoDAO dao;
	
	private static final long serialVersionUID = 1L;
	
	FacesContext facesContext;
	ExternalContext externalContext;
	
	private List<Aluno> alunosList;
	private String param;
	
	private Aluno aluno;
	
	public List<Aluno> getAlunosList() {
		return alunosList;
	}
		
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
		
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@PostConstruct 
	public void init() {	
		
		facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		
		externalContext.getSessionMap().put("title", false);
					
		try {
			
			getLista();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	} 
	
	// ------------------------------
	
	/**
	 * Método para salvar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @throws Exception 
	 * @since 1.0	
	 */
	
	public void salvar() throws Exception  {
					
		//Get values for fields selection						
		Map<String, String> parameter = (Map<String, String>) externalContext.getRequestParameterMap();
			
		Aluno aluno = new Aluno();
		dao = new AlunoDAO();
		
		aluno.setMatricula(Integer.parseInt(parameter.get("matricula")));
		aluno.setNome(parameter.get("nome"));
		aluno.setIdade(Integer.parseInt(parameter.get("idade")));

		dao.salvar(aluno);

	}
	
	// ------------------------------
	
	/**
	 * Método para atualizar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @throws Exception 
	 * @since 1.0	
	 */
	public void atualizar() throws Exception {
		
		boolean updated = false;
		
		//Get values for fields selection						
				Map<String, String> parameter = (Map<String, String>) externalContext.getRequestParameterMap();
					
				Aluno aluno = new Aluno();
				dao = new AlunoDAO();
				
				aluno.setMatricula(Integer.parseInt(parameter.get("matricula")));
				aluno.setNome(parameter.get("nome"));
				aluno.setIdade(Integer.parseInt(parameter.get("idade")));

				updated = dao.atualizar(aluno);
				
				if(updated) {									
					
					externalContext.getSessionMap().put("matricula", aluno.getMatricula());
					externalContext.getSessionMap().put("nome", aluno.getNome());
					externalContext.getSessionMap().put("idade", aluno.getIdade());
					
				}					
				
	       }
	
	// ------------------------------
	
	/**
	 * Método para deletar um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @param int matricula 
	 * @since 1.0	
	 */
	public void deletar() {

		//Get values for fields selection	
		
		boolean del = false;
															
				dao = new AlunoDAO();
											
				int matricula = (int) externalContext.getSessionMap().get("mat");
											
				try {
					
					del = dao.deletar(matricula);
					
					if(del) {
						externalContext.getSessionMap().remove("mat");
						getLista();
					}
				
				} catch (Exception e) {
				
					e.printStackTrace();
				}

			}
					
	
	
	
	// ------------------------------
	
	/**
	 * Método para obter um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @throws Exception 
	 * @since 1.0	
	 */
	public Aluno obterAluno() throws Exception {
										
		String mat = getParam();
					
		int matricula = Integer.parseInt(mat);
					
		dao = new AlunoDAO();
		
		Aluno aluno = dao.getAluno(matricula);
								
		return aluno;
				
	}
	
	// ------------------------------
	
	/**
	 * Método para obter um aluno
	 * 
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @throws Exception 
	 * @since 1.0	
	 */
	public void getDeleteInfo() throws Exception {
			
		aluno = obterAluno();
			
		externalContext.getSessionMap().put("mat", aluno.getMatricula());
				
		RequestContext.getCurrentInstance().update("dialog-form:modal-text");
										
	}
				
	// ------------------------------
	
	/**
	 * Método para listar todos alunos
	 *  
	 * @author Renata 30/01/2021
	 * @version 1.0
	 * @throws Throwable 
	 * @since 1.0	
	 */

		public void getLista() throws Exception {
	   
			AlunoDAO dao = new AlunoDAO ();
			
			alunosList = dao.listarAlunos();
	   	}
	
	// ------------------------------
	
	public String goToCadastro() {
		
		clear();
													
		return "/resources/pages/form.xhtml?faces-redirect=true";
		
	}
	
	// ------------------------------
	
	public String goToAtualizar() {
		
		externalContext.getSessionMap().put("title", true);
					
		try {
			
			aluno = obterAluno();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		externalContext.getSessionMap().put("matricula", aluno.getMatricula());
		externalContext.getSessionMap().put("nome", aluno.getNome());
		externalContext.getSessionMap().put("idade", aluno.getIdade());
		
		RequestContext.getCurrentInstance().execute("$('#matricula').prop('disabled', true);");
						
		return "/resources/pages/form.xhtml?faces-redirect=true";
	
	}
	
	// ------------------------------
		
	public void clear() {
		
		externalContext.getSessionMap().remove("matricula");
		externalContext.getSessionMap().remove("nome");
		externalContext.getSessionMap().remove("idade");
												
				
	}
	
	// ------------------------------
	
}
