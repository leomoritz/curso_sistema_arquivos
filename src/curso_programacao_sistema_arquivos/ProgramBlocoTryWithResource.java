package curso_programacao_sistema_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramBlocoTryWithResource {

	public static void main(String[] args) {

		/*
		 * � um bloco try que declara um ou mais recursos e garante que esses recursos
		 * ser�o fechados ao final do bloco.
		 * 
		 * Dispon�vel no Java 7 em diante.
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
		
		/* N�o precisou declarar o Finally para fechar 
		 * o Buffered e o File, pois o bloco try 
		 * resource instaciou os recursos e encerrou no 
		 * final do bloco.
		*/

	}

}
