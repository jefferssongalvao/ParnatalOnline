/**
 * A classe BestNetwork é responsável por procurar a melhor solução (a rede com
 * menor custo).
 * 
 * @author Jeffersson Galvão
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 11.03.2015
 */

public class BestNetwork {

	// Melhor árvore
	private Network bestTree;
	
	// Quantidade de soluções válidas geradas
	private int solutions;
	
	// Tempo gasto para encontrar solução
	private long executionTime;
	
	// Matriz de custos para o problema dado
	private CostMatrix costMatrix;
	
	/**
	 * Costrutor da classe; Inicializa campos.
	 * @param costMatrix Matriz de custos
	 */
	public BestNetwork(CostMatrix costMatrix) {
		bestTree = new Network();
		solutions = 0;
		executionTime = 0;
		this.costMatrix = costMatrix;
	}
	
	/**
	 * Método responsável por procurar a melhor rede de distribuição.
	 *  
	 */
	public void findBest() {
		Connection[] link = new Connection[
		                           edges(Network.getVertexMax())]; // Número de rotas possíveis
																			// equivalente ao somatório de 1...n
		Network tree = new Network();
		int countEdges = 0; // Índice da aresta
		Chronometer.start();
		for(int i = 0; i < Network.getVertexMax(); i++) {
			for(int j = i; j < Network.getVertexMax(); j++) {
				if(i != j) {
					link[countEdges++] = new Connection(new House(i+1), 
							new House(j+1), countEdges, costMatrix.getElement(i, j));
				}
			}
		}
		combinations(link, Network.getVertexMax()-1, 0, tree); // Computa as combinações de arestas possíveis
		Chronometer.stop();
		executionTime = Chronometer.elapsedTime();
	}
	
	/**
	 * Método que computa as combinações de arestas possíveis.
	 * @param link Vetor de conexões/arestas
	 * @param size Número de arestas na árvore
	 * @param startPosition Posição de início no vetor link
	 * @param tree Objeto para armazenar a árvore que está sendo verificada
	 */
	private void combinations(Connection[] link, int size, int startPosition,
			Network tree) {
		if(size == 0) {
			if((solutions == 0) || (tree.totalCost() < bestTree.totalCost())) {
				bestTree.changeNetwork(tree);
			}
			solutions++;
			return;
		}
		for(int i = startPosition; i <= link.length - size; i++) {
			if(tree.addConnection(link[i])) {
				combinations(link, size-1, i+1, tree);
				tree.removeConnection();
			} else {
				combinations(link, size, i+1, tree);
				return;
			}
		}
	}
	
	/**
	 * 
	 * @return Melhor árvore
	 */
	public Network getBest() {
		return bestTree;
	}
	
	/**
	 * 
	 * @return Quantidade de soluções válidas geradas
	 */
	public int getSolutions() {
		return solutions;
	}
	
	/**
	 * 
	 * @return Tempo gasto para encontrar solução
	 */
	public long getExecutionTime() {
		return executionTime;
	}
	
	/**
	 * Calcula o número de arestas.
	 * @param n Número de vértice/casas
	 * @return Número de arestas/ligações/conexões diferentes na rede
	 */
	private int edges(int n) {
        return (n * (n - 1)) / 2;
    }
	
}