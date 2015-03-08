import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Essa classe é responsável por ler um arquivo e inicializar a matriz de custos.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public class MatrixReader implements ReadMatrix {

	/**
	 * Método que realiza a leitura de um arquivo e preenche a matriz com os dados obtidos.
	 * @param path Caminho/Nome+extensão do arquivo
	 * @throws java.util.NoSuchElementException Caso o arquivo esteja incompleto 
	 */
	@SuppressWarnings("unused")
	public void read(Matrix matrix, String path) {
		try {
			int cX;
			Scanner scan = new Scanner(new FileReader(path));
			for(int i = 0; i < 2; i++) {
				// Ignorar 'n' e 'd' que já foram lidos do arquivo
				// e não interessam a matriz
				if(scan.hasNextInt()) {
					int tmp = scan.nextInt();
				} else {
					System.err.println("Problema na leitura do arquivo \'" 
							+ path + "\'");
					scan.close();
					throw new NoSuchElementException("Estão faltando informações" +
							" sobre as restrinções da rede");
				}
			}
			for(int i = 0; i < matrix.size(); i++) {
				for(int j = i; j < matrix.size(); j++) {
					if(i == j) {
						matrix.setElement(i, j, 0);;
					} else {
						if(scan.hasNextInt()) {
							cX = scan.nextInt();
							matrix.setElement(i, j, cX);
							matrix.setElement(j, i, cX); // Vai espelhando a matriz
						} else {
							System.err.println("Problema na leitura do arquivo \'" 
									+ path + "\'");
							scan.close();
							throw new NoSuchElementException("Estão faltando células" +
									" na matriz! Verifique o arquivo.");
						}
					}
				}
			}
			scan.close();
		} catch(FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
	}
	
}
