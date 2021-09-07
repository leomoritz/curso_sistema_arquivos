package curso_programacao_sistema_arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Product;

public class ProgramExercicio {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> produto = new ArrayList<>();

		// Informando o caminho
		System.out.print("Informe o caminho do arquivo desejado: ");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		System.out.print("Informe o nome do arquivo csv desejado: ");
		String fileCsv = sc.nextLine();

		// Pegando o arquivos deste caminho
		String strFile = path.getAbsolutePath() + "\\" + fileCsv + ".csv";

		// Criar novo diretório e novo arquivo csv para armazenar os dados de apenas
		// nome e preço total
		System.out.print("Informe o nome da subpasta que deseja criar: ");
		String newPath = sc.nextLine();

		boolean success = new File(strPath + "\\" + newPath).mkdir();

		if (success) {
			System.out.println("Subpasta \\" + newPath + " criada com sucesso no diretório " + path.getAbsolutePath());

			System.out.print("Informe o nome do arquivo csv que deseja criar na subpasta: ");
			String newFile = sc.nextLine();

			// Lendo o conteúdo do arquivo e armazenando na classe Produto
			try (BufferedReader br = new BufferedReader(new FileReader(strFile))) {

				String lines = br.readLine();
				while (lines != null) {

					String[] datas = lines.split(",");
					produto.add(new Product(datas[0], Double.parseDouble(datas[1]), Integer.parseInt(datas[2])));
					lines = br.readLine();

				}

				String strNewPath = path.getAbsolutePath() + "\\" + newPath + "\\" + newFile;

				// cria arquivo ao instanciar a classe
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(strNewPath.concat(".csv")))) {

					// Monta um vetor de strings com os dados da classe produto
					for (Product product : produto) {
						bw.write(product.getName() + ", " + String.format("%.2f", product.totalValue()));
						bw.newLine();
					}
				}

				System.out.println("\nNovo arquivo criado com sucesso!\n");
				
				try (BufferedReader newBr = new BufferedReader(new FileReader(strNewPath.concat(".csv")))) {
					
					System.out.println("Listando dados do novo arquivo criado: ");
					lines = newBr.readLine();
					
					while (lines != null) {

						String[] datas = lines.split(",");
						int quantity = 0;
						
						for (String line : datas) {
							if (quantity % 2 == 0) { //lógica implementada para ele fazer o salto de linha a cada 2
								System.out.print(line + ", ");
							} else {
								System.out.print(line + "\n");
							}
							quantity++;
						}

						lines = newBr.readLine();
					}
				}

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} else {
			System.out.println("Não foi possível criar o diretório!");
		}

		sc.close();

	}

}
