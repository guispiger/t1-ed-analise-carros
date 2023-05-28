package ed.t1.listacarros;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Processador {
	public Carro pesquisaPlaca(String placa, ArrayList<Carro> carros) {
		Carro carroPesquisa = null;
		for (Carro carro : carros) {
			if (carro != null) {
				if (carro.getPlaca().equals(placa)) {
					carroPesquisa = carro;
				}
			}
		}
		return carroPesquisa;
	}
	
	public Carro pesquisaCarroMaiorValor(ArrayList<Carro> carros) {
		Carro carroMaiorValor = carros.get(0);
				
		for (Carro carro : carros) {
			if (carro != null) {
				BigDecimal precoMaior = new BigDecimal(carroMaiorValor.getPreco());
				if(precoMaior.compareTo(new BigDecimal(carro.getPreco())) < 0) {
					carroMaiorValor = carro;
				}
			}
		}
		return carroMaiorValor;
	}
	
	public Carro pesquisaCarroMenorValor(ArrayList<Carro> carros) {
		Carro carroMenorValor = carros.get(0);
				
		for (Carro carro : carros) {
			if (carro != null) {
				BigDecimal precoMaior = new BigDecimal(carroMenorValor.getPreco());
				if(precoMaior.compareTo(new BigDecimal(carro.getPreco())) > 0) {
					carroMenorValor = carro;
				}
			}
		}
		return carroMenorValor;
	}
	
	public String pesquisarCorPrevalente(ArrayList<Carro> carros) {
		String corPrevalente = null;
		int corPrevalenteCont = 0;
		int corContagem = 1;
		
		for (int i = 0; i < carros.size(); i++) {		
			for(int j = i+1; j < carros.size(); j++) {
				if(carros.get(i).getCor().equals(carros.get(j).getCor())){
					corContagem++;
				}
			}
			if(corContagem > corPrevalenteCont) {
				corPrevalente = carros.get(i).getCor();
				corPrevalenteCont = corContagem;
			}
			corContagem = 1;
		}
		
		String retorno = corPrevalente + " - " + corPrevalenteCont;
		
		return retorno;
	}
	
}
