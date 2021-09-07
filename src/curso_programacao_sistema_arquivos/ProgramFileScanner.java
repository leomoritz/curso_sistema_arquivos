package curso_programacao_sistema_arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProgramFileScanner {

	public static void main(String[] args) {

		/*
		 * Lendo arquivo com as classes abaixo:
		 * File - Representação abstrata de um arquivo e seu caminho
		 * Scanner - Leitor de texto
		 * IOException - para tratar exeções que podem ser lançadas durante leitura.
		 */
		
		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
