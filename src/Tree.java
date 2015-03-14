import java.util.Vector;

/**
 * Classe abstrata que serve de modelo para uma árvore.
 * 
 * Vamos ter especificamente um grafo acíclico e conexo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

public abstract class Tree {

	// Vetor contendo as arestas da árvore; Tem tamanho n-1 (qntd de arestas)
	protected Vector<Edge> tree;
	
	// Vetor que armazena o grau de cada vértice
	protected int[] degree;
	
	// Estrutura union-find para verificar ciclos na solução
	protected UnionFind uf;
	
	// Custo da solução
	protected int totalCost;
	
	/**
	 * Construtor da classe abstrata; Inicializa campos.
	 */
	public Tree() {
		tree = null;
		degree = null;
		uf = null;
		totalCost = 0;
	}
	
	/**
	 * Construtor da classe abstrata; Inicializa campos.
	 * @param vertexMax
	 */
	public Tree(int vertexMax) {
		tree = new Vector<Edge>();
		degree = new int[vertexMax];
		for(int i = 0; i < degree.length; i++) {
			degree[i] = 0;
		}
		uf = new UnionFind(vertexMax);
		totalCost = 0;
	}

	/**
	 * 
	 * @return Vetor contendo as arestas do grafo;
	 */
	public Vector<Edge> getTree() {
		return tree;
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
	 * Altera o vetor que contém as arestas do grafo;
	 * @param tree
	 */
	public void setTree(Vector<Edge> tree) {
		this.tree = tree;
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
