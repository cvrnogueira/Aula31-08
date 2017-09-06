package Persistence;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Business.Cliente;

public class GerenciadorDeCliente {
	ArrayList<Cliente> clientesNoBar;
	
	public GerenciadorDeCliente(){
		clientesNoBar = new ArrayList<Cliente>();
	}
	public boolean checkIn(Cliente cliente){
		 clientesNoBar.add(cliente);
		 return true;
	}
	
	public int quantasPessoasNoBar(){
		return clientesNoBar.size();
	}
	public int nroSocios(){
		int nroSocios = 0;
		for(Cliente c : clientesNoBar){
			if(c.isSocio() == true){
				nroSocios++;
			}
		}
		return nroSocios;
	}
	public int naoSocios(){
		int nroSocios = this.nroSocios();
		return (this.quantasPessoasNoBar() - nroSocios);
	}
	public boolean checkOut(int CPF){
		for(Cliente c: clientesNoBar){
			if(c.getCpf() == CPF){
				clientesNoBar.remove(c);
				return true;
			}
		}
		return false;
	}
	public int porcentagemFeminino(){
		int sexoFeminino = 0;
		for(Cliente c: clientesNoBar){
			if(c.getGenero().equals("F")){
				sexoFeminino++;
			}
		}
		return ((sexoFeminino*100)/this.quantasPessoasNoBar());
	}
	public int porcentagemMasculino(){
		int sexoMasculino = 0;
		for(Cliente c: clientesNoBar){
			if(c.getGenero().equals("M")){
				sexoMasculino++;
			}
		}
		return ((sexoMasculino*100)/this.quantasPessoasNoBar());
	}
	public boolean achaPorCPF(int CPF){
		for(Cliente c: clientesNoBar){
			if(c.getCpf() == CPF){
				clientesNoBar.remove(c);
				return true;
			}
		}
		return false;
	}
	public String getTodayDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		return  dtf.format(localDate);
	}
	public void imprimeNoArquivoTexto() throws IOException{
		try{	
		    PrintWriter writer = new PrintWriter("ClientesDiaDeHoje.txt", "UTF-8");
		    writer.println("Relatório de clientes do dia: " + getTodayDate());
		    
		    for(Cliente c: clientesNoBar){
		    	writer.print("Nome: " + c.getNome() + " CPF: " + c.getCpf() + " Idade: " +c.getIdade() + " Genero: " + c.getGenero());
		    	if(c.isSocio() == true){
		    		writer.print(" Numero Sócio: " + c.getNroSocio());
		    	}
		    	else{
		    		writer.print(" Não sócio ");
		    	}
		    	writer.println(" ");
		    }
		    writer.close();
		} catch (IOException e) {
			throw new IOException("Não foi possível gravar!");
		}
	}
}
