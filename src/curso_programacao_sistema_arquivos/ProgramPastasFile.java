package curso_programacao_sistema_arquivos;

import java.io.File;
import java.util.Scanner;

public class ProgramPastasFile {

	public static void main(String[] args) {
		
		/*
		 * Manipulando pastas com File
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//Listando as pastas do diretório informado
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		//Listando os arquivos do diretório informado
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES:");
		for (File file : files) {
			System.out.println(file);
		}
		
		//Criando uma nova pasta no diretório informado com função mkdir();
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		sc.close();

	}

}
