package refatoracao;

import java.util.Scanner;

public class Main {
	 public static void main(String args[]){
		 Scanner in = new Scanner(System.in);
		 GerenciadorDeCliente Bar1 = new GerenciadorDeCliente();
		 boolean sair = false, checkOut = false, checkIn = false, isSocio = false;
		 int opcao, CPF, idade, numeroSocio;
		 String nome, genero;
		 do{
			 System.out.println("1. Cliente chegando");
			 System.out.println("2. Cliente Saindo");
			 opcao = in.nextInt();
			 switch(opcao){
			 case 01: {
				 System.out.println("Nome");
				 nome = in.next();
				 System.out.println("CPF");
				 CPF = in.nextInt();
				 System.out.println("Idade");
				 idade = in.nextInt();
				 System.out.println("Gênero");
				 genero = in.next();
				 System.out.println("É Sócio?");
				 isSocio = in.nextBoolean();
				 if(isSocio){
					 System.out.println("Número do sócio");
					 numeroSocio = in.nextInt();
					 checkIn = Bar1.checkIn(new Cliente(nome, CPF, idade, genero,numeroSocio));
				 }
				 else{
					 checkIn = Bar1.checkIn(new Cliente(nome, CPF, idade, genero)); 
				 }
				 System.out.println("Ocorreu um erro, por favor, tente novamente");
			 }
			 break;
			 case 02: {
				 System.out.println("CPF");
				 CPF = in.nextInt();
				 checkOut = Bar1.checkOut(CPF);
				 if(checkOut){
					 System.out.println("Sucesso!");
				 }
				 else{
					 System.out.println("Problema! Tente Novamente!");
				 }
			 }
			 }
		 }while(sair == false);
	 }

}
