package curso_programacao_sistema_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramFileBufferedReader {

	public static void main(String[] args) {
		
		/*
		 * Lendo arquivos com as classes abaixo:
		 * Classe FileReader - stream de leitura de caracteres a partir de arquivos
		 * Classe BufferedReader - torna o FileReader mais rápido
		 * IOException - para tratar exceções durante a leitura do arquivo
		 */

		String path = "C:\\temp\\in.txt";
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
