package busca;

import indice.CriaIndice;
import java.io.IOException;
import java.util.Scanner;

import java.io.RandomAccessFile;

public class BuscaNis{

	//metodo que busca o nis desejado
	public static void buscaNis(String nis, RandomAccessFile indice) throws IOException{
		
		indice.seek(CriaIndice.h(nis));
		String linha = indice.readLine();
		String[] colunasIndice = linha.split("\t");
		String nome = colunasIndice[8];
		String valor = colunasIndice[10];
		System.out.println("NIS: " + nis + "\nNome: " + nome + "\nValor: " + valor);
	}     
	
	//metodo executavel
	public static void main(String[] args) throws IOException{

		RandomAccessFile indice = new RandomAccessFile("indice.dat", "r");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o NIS: ");
		//exemplo de nis valido: 00016354424781
		String nis = teclado.nextLine();
		System.out.println("Dados: ");
		buscaNis(nis, indice);
		indice.close();
	}
	
	
}