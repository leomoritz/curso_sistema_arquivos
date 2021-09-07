package curso_programacao_sistema_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramBlocoTryWithResource {

	public static void main(String[] args) {

		/*
		 * É um bloco try que declara um ou mais recursos e garante que esses recursos
		 * serão fechados ao final do bloco.
		 * 
		 * Disponível no Java 7 em diante.
		 */

		String path = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		/* Não precisou declarar o Finally para fechar 
		 * o Buffered e o File, pois o bloco try 
		 * resource instaciou os recursos e encerrou no 
		 * final do bloco.
		*/

	}

}
