package uinterface;

import java.io.IOException;
import java.util.Scanner;

import Business.Cliente;
import Persistence.GerenciadorDeCliente;

public class Main {
	 public static void main(String args[]) throws IOException{
		 Scanner in = new Scanner(System.in);
		 GerenciadorDeCliente Bar1 = new GerenciadorDeCliente();
		 boolean sair = false, checkOut = false, checkIn = false, isSocio = false;
		 int opcao, CPF, idade, numeroSocio;
		 String nome, genero;
		 do{
			 System.out.println("1. Cliente chegando");
			 System.out.println("2. Cliente Saindo");
			 System.out.println("3. Imprimir relatório do dia");
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
				 if(!checkIn){
					 System.out.println("Ocorreu um erro, por favor, tente novamente");
				 }
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
					 System.out.println("Problema! Verifique se esse CPF digitado está correto!");
				 }
			 }
			 break;
			 case 03: {
				 Bar1.imprimeNoArquivoTexto();
				 System.out.println("Relatório impresso, dia encerrado!");
				 sair = true;
			 }
			 break;
			 }
		 }while(sair == false);
	 }

}
