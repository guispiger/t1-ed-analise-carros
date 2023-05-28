package ed.t1.listacarros;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Programa {
	
	public static void main(String[] args) {
		
		ArrayList<Carro> carros = LeitorCSV.lerArquivo();
		
		boolean continuar = true;
		
		Processador proc = new Processador();
		
		do {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: 1-Pesquisar Carro | 2-Análise Carros | 3-Sair"));
			
			if (opcao == 1) {
				
				String placaPesquisa = JOptionPane.showInputDialog("Digite a placa do carro");
				
				Carro carroPesquisado = proc.pesquisaPlaca(placaPesquisa, carros);
				
				if (carroPesquisado == null) {
					JOptionPane.showMessageDialog(null, "Carro não localizado!!");
				} else {
					JOptionPane.showMessageDialog(null, carroPesquisado.toString());
				}
				
				
			} else if (opcao == 2) {
				
				Carro carroMaiorValor = proc.pesquisaCarroMaiorValor(carros);
				Carro carroMenorValor = proc.pesquisaCarroMenorValor(carros);
				String corPrevalente = proc.pesquisarCorPrevalente(carros);
				
				JOptionPane.showMessageDialog(null, "Carro de maior valor: " + carroMaiorValor.toString() + 
						"\nCarro de Menor valor: " + carroMenorValor.toString() + 
						"\nCor Prevalente: " + corPrevalente);
				
			} else {
				continuar = false;
			}
		} while (continuar);
		
	}
}	

