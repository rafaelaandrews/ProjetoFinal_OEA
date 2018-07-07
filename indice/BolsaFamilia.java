package indice;

import java.io.IOException;

public class BolsaFamilia{

	private String uf;
	private String siafi;
	private String municipio;
	private String municipioCod;
	private String funcaoCod;
	private String subfuncaoCod;
	private String programaCod;
	private String nis;
	private String nome;
	private String fonte;
	private String parcelaMes;
	private String competencia;	

	public void leBolsa(String linha) throws IOException{

		String colunas[];
		colunas = linha.split("\t");

		uf = colunas[0];
		siafi = colunas[1];
		municipio = colunas[2];
		municipioCod = colunas[3];
		funcaoCod = colunas[4];
		subfuncaoCod = colunas[5];
		programaCod = colunas[6];
		nis = colunas[7];
		nome = colunas[8];
		fonte = colunas[9];
		parcelaMes = colunas[10];
		competencia = colunas[11];		
	}

	public String getNis(){
		return nis;
	}

	public void setNis(String nis){
		this.nis = nis;
	}
	
	public String getLinha(){
		return nis + "\t" + uf + "\t" +  siafi + "\t" + municipio + "\t" + municipioCod + "\t" + funcaoCod + 
		"\t" + subfuncaoCod + "\t" + programaCod + "\t" + nome + "\t" + fonte +
		"\t" + parcelaMes + "\t" + competencia;
	}

}