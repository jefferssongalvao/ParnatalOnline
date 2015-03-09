/**
 * Essa classe é responsável por ler as informações contidas em um arquivo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 09.03.2015
 */

public class FileReader {

	/**
	 * Método responsável por ler as informações contidas em um arquivo.
	 * @param path Caminho do arquivo de entrada
	 * @param matrix Matriz de custos a ser preenchida
	 */
	public static void readFile(String path, Matrix matrix) {
		MatrixReader mr = new MatrixReader();
		mr.read(matrix, path);
		ReadInfoFromFile.readInfo(path);
	}
	
}
