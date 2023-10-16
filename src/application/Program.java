package application;

import java.util.Scanner;

import domain.Pessoa;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class Program {
	
	public static void main (String args[]) {
		
		Pessoa pessoa = cadastrarPessoa();
		imprimirPessoa(pessoa);
	}
	
	private static Pessoa cadastrarPessoa() {
		
		Scanner input = new Scanner(System.in);	
		
		System.out.print("Nome: ");
		String nome = input.nextLine();
		
		while (true) {
			System.out.print("CPF/CNPJ: ");
			
			/* Inicialmente, essa variável era convertida para Long, mas números iniciados com "0" eram 
			cortados, até aparecer um número inteiro maior que 0 */
			String id = input.nextLine();
			
			if (id.length() == 11 && id.matches("\\d+")) {
				input.close();
				return new PessoaFisica(nome, id);
			}
			
			else if(id.length() == 14 && id.matches("\\d+")) {
				input.close();
				return new PessoaJuridica(nome, id);
			}
			
			else {
				System.out.println("Número de caracteres inválido. Tente novamente");
			}
		}
	}
	
	private static void imprimirPessoa(Pessoa pessoa) {
		
		if (pessoa instanceof PessoaFisica) {
			
			PessoaFisica pessoaF = (PessoaFisica) pessoa;
			
			System.out.println("Nome: " + pessoaF.getNome());
			System.out.println("CPF: " + pessoaF.getCpf());
		} 
		
		else {
			
			PessoaJuridica pessoaJ = (PessoaJuridica) pessoa;
			
			System.out.println("Razão social: " + pessoaJ.getNome());
			System.out.println("CNPJ: " + pessoaJ.getCnpj());
		}
		
	}
}
