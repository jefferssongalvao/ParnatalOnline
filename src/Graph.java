/**
 * Classe abstrata que serve de modelo para um grafo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 12.03.2015
 */

public abstract class Graph {

	// Vetor que armazena o grau de cada vértice
	protected int[] degree;
	
	// Estrutura union-find para verificar ciclos na solução
	protected UnionFind uf;
	
	// Custo da solução
	protected int totalCost;
	
	/**
	 * Construtor da classe abstrata; Inicializa campos.
	 */
	public Graph() {
		degree = null;
		uf = null;
		totalCost = 0;
	}
	
	/**
	 * 
	 * @return Vetor que armazena o grau de cada vértice
	 */
	public int[] getDegree() {
		return degree;
	}
	
	/**
	 * 
	 * @return Estrutura union-find da rede
	 */
	public UnionFind getUnionFind() {
		return uf;
	}

	/**
	 * 
	 * @return Custo da solução
	 */
	public int totalCost() {
		return totalCost;
	}

	/**
	 * Altera o vetor que armazena o grau de cada vértice.
	 * @param degree Vetor que armazena o grau de cada vértice
	 */
	public void setDegree(int[] degree) {
		this.degree = degree;
	}

	/**
	 * Altera estrutura union-find.
	 * @param uf Estrutura union-find
	 */
	public void setUnionFind(UnionFind uf) {
		this.uf = uf;
	}

	/**
	 * Altera custo da solução.
	 * @param totalCost Custo da solução
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
