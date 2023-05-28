package ed.t1.listacarros;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LeitorCSV {

						
		public static ArrayList<Carro> lerArquivo() {
			ArrayList<Carro> carros = new ArrayList<Carro>();
			
			try {
				FileReader arquivoCSV = new FileReader("carros.csv");
				CSVFormat config = CSVFormat.Builder.create().setHeader("ano","marca","modelo","cor","placa","preco").setSkipHeaderRecord(true).build();
				List<CSVRecord> records = config.parse(arquivoCSV).getRecords();
				for (CSVRecord csvRecord : records) {
					String ano = csvRecord.get("ano");
					String marca = csvRecord.get("marca");
					String modelo = csvRecord.get("modelo");
					String cor = csvRecord.get("cor");
					String placa = csvRecord.get("placa");
					String preco = csvRecord.get("preco");
					
					Carro c = new Carro(ano, marca, modelo, cor, placa, preco);
					carros.add(c);
				}
						
				
			} catch (IOException e) {
				System.out.println("Erro, arquivo não localizado!!");
			}
		
			return carros;
			
		}
		
		

}
