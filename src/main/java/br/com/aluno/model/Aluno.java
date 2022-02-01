package br.com.aluno.model;



import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class Aluno {
	
	private int id;
	private int matricula;
	private String nome;
	private int idade;

	public Aluno(int matricula, String nome, int idade) {	
		this.matricula = matricula;
		this.nome = nome;
		this.idade = idade;
	}

	public Aluno() {}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}	
	
	private boolean save, edit, new_, delete;
	

	public boolean isSave() {
		return save;
	
	}
	public boolean isEdit() {
		return edit;

	}
	public boolean isNew_() {
		return new_;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
		

	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
}
	


