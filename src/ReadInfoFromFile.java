import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Classe responsável por ler as informações relacionadas a rede de distribuição a partir
 * de um arquivo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public class ReadInfoFromFile {

	/**
	 * Lê a quantidade máxima de vértices (casas) e grau máximo a partir do arquivo.
	 * @param path Caminho do arquivo
	 * @throws java.util.NoSuchElementException Caso o arquivo esteja incompleto
	 */
	public static void readInfo(String path) {
		try {
			Scanner scan = new Scanner(new FileReader(path));
			if(scan.hasNextInt()) {
				Network.setVertexMax(scan.nextInt());
				if(scan.hasNextInt()) {
					Network.setDegreeMax(scan.nextInt());
					scan.close();
					return;
				}
			}
			System.err.println("Problema na leitura do arquivo \'" 
					+ path + "\'");
			scan.close();
			throw new NoSuchElementException("Estão faltando informações" +
					"sobre as restrinções da rede");
		} catch(FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
	}
	
}
