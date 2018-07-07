package indice;

import java.io.RandomAccessFile;
import java.io.IOException;

public class CriaIndice{
	
	//funçao hash
	public static long h(String chave){
		return (Long.parseLong(chave))%17035859;
	}

	//executavel para criar o indice
	public static void main(String args[]) throws IOException{

		RandomAccessFile arquivo = new RandomAccessFile("bolsa.csv", "r");
		RandomAccessFile indice = new RandomAccessFile("indice.dat", "rw");

		escreveIndice(arquivo, indice);

		arquivo.close();
		indice.close();
	}

	public static void escreveIndice(RandomAccessFile arquivo, RandomAccessFile indice) throws IOException{
		
		BolsaFamilia bolsa = new BolsaFamilia();
		long posicao1, posicao=0, contador = 0;
		String linha;
		linha = arquivo.readLine(); //pula a primeira linha de cabecalho
		
		while(contador < 17035859){			
			linha = arquivo.readLine();
			if(linha.equals("")){
				break;
			}
			bolsa.leBolsa(linha);
			posicao = h(bolsa.getNis());
			indice.seek(posicao*(linha.length()));
			posicao1 = contador;
			indice.writeBytes(linha + "\t" + posicao1 + "\t" + posicao + "\n");
			contador += 1;
		}
	}

	
}

