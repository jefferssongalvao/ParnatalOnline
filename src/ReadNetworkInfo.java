/**
 * Interface que define o método que deve ser implementado para a leitura de
 * informações relativas a rede de distribuição.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public interface ReadNetworkInfo {

	/**
	 * Lê a quantidade máxima de vértices (casas) e grau máximo a partir do arquivo.
	 * @param path Caminho do arquivo
	 * @throws java.util.NoSuchElementException Caso o arquivo esteja incompleto
	 */
	public void readInfo(String path);
	
}
