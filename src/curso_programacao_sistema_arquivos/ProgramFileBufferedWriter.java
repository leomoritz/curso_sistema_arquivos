package curso_programacao_sistema_arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramFileBufferedWriter {

	public static void main(String[] args) {

		/*
		 * Criando arquivos e escrevendo através das classes abaixo: FileWriter - stream
		 * de escrita de caracteres em de arquivos. Cria/recria o arquivo: new
		 * FileWriter(path); Acrescenta ao arquivo existente: new FileWriter(path,
		 * true); BufferedWriter - torna o FileWriter mais rápido.
		 * 
		 */

		String[] lines = new String[] { "Good Morning", "Good Affternoon", "Good Night" };

		String path = "C:\\temp\\out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
