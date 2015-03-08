/**
 * Interface que define o método que deve ser implementado para a leitura da matriz
 * de custos.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public interface ReadMatrix {

	/**
	 * Método que realiza a leitura de um arquivo e preenche a matriz com os dados obtidos.
	 * @param matrix Matriz de custos
	 * @param path Caminho do arquivo
	 */
	public void read(Matrix matrix, String path);
	
}
