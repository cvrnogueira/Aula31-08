package refatoracao;

import java.util.ArrayList;

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
}
