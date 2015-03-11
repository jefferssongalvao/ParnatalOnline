/**
 * Interface que define o método que deve ser implementado para salvar os resultados
 * da simulação.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public interface WriteResultsToFile {

	/**
	 * Salva informações sobre a melhor rede de distribuição no arquivo "BestSolution.out";
	 * 
	 * Informações a serem salvas: vetor de arestas, quantidade de soluções válidas
	 * geradas e tempo gasto na obtenção da solução.
	 * 
	 */
	public void writeToFile(BestNetwork best);
	
}
