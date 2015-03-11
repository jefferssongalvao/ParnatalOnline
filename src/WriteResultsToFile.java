/**
 * Interface que define o método que deve ser implementado para salvar os resultados
 * da simulação.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 10.03.2015
 */

public interface WriteResultsToFile {

	/**
	 * Salva informações sobre a melhor rede de distribuição.
	 */
	public void writeToFile(BestNetwork best);
	
}
