package refatoracao;

import java.util.ArrayList;

public class Cliente {
	private int CPF;
	private int idade;
	private String genero;
	private String nome;
	private boolean isSocio;
	private int nroSocio;
	
	public Cliente(String nome, int CPF, int idade, String genero){
		this.isSocio = false;
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
		this.genero = genero;
	}
	public Cliente(String nome, int CPF, int idade, String genero, int nroSocio){
		this(nome, CPF, idade, genero);
		this.isSocio = true;
		this.nroSocio = nroSocio;
	}
	public int getCpf(){
		return this.CPF;
	}
	public String getGenero(){
		return this.genero;
	}
	public boolean isSocio(){
		return isSocio;
	}
	
	
}
