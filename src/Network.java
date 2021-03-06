import java.util.Vector;

/**
 * A classe Network representa uma árvore (rede) de distribuição válida.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

public class Network extends Tree {

	// Quantidade máxima de vértices (casa)
	private static int vertexMax = 0;
	
	// Grau máximo de um vértice
	private static int degreeMax = 0;
	
	/**
	 * Construtor sem parâmetros para a classe; Inicializa o básico.
	 */
	public Network() {
		super(vertexMax);
	}
	
	/**
	 * Adiciona uma conexão/aresta na rede de distribuição.
	 * @param edge Aresta/conexão a ser adicionada
	 * @return true se ela pode/foi adicionada ou false, caso contrário
	 */
	public boolean addConnection(Connection edge) {
		if(((degree[edge.getInicial().getID()-1] < degreeMax) && (degree[edge.getTerminal().getID()-1] < degreeMax))
				&& (!uf.same_component(edge.getInicial().getID(), edge.getTerminal().getID()))) {
			tree.add(edge);
			totalCost += edge.getCusto();
			increaseDegree(edge.getInicial().getID()-1, edge.getTerminal().getID()-1);
			uf.union(edge.getInicial().getID(), edge.getTerminal().getID());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Remove a última conexão/aresta do vetor e atualiza as informações da rede.
	 */
	public void removeConnection() {
		decreaseDegree(tree.get(tree.size()-1).getInicial().getID()-1, 
				tree.get(tree.size()-1).getTerminal().getID()-1);
		totalCost -= tree.get(tree.size()-1).getCusto();
		tree.remove(tree.size()-1);
		uf = new UnionFind(vertexMax);
		for(Edge edge : tree) {
			edge = (Connection) edge;
			uf.union(edge.getInicial().getID(), edge.getTerminal().getID());
		}		
	}
	
	/**
	 * Adiciona uma rede de distribuição; Troca as informações atuais pelas novas.
	 * @param tree Nova rede de distribuição
	 */
	public void changeNetwork(Network tree) {
		if(tree != null) {
			this.tree = new Vector<Edge>(tree.getTree());
			this.degree = new int[tree.getDegree().length];
			this.degree = tree.getDegree().clone();
			this.uf = tree.getUnionFind();
			this.totalCost = tree.totalCost();
		}
	}
	
	/**
	 * Recebe o ID de um vértice e retorna o grau do mesmo.
	 * @param i Casa/vértice
	 * @return Grau do vértice em questão
	 * @throws java.lang.IllegalArgumentException se n não estiver no intervalor [1...n]
	 */
	public int getDegree(int id) {
		if((id < 1) || (id > vertexMax)) {
			throw new IllegalArgumentException("ID inválido!");
		} else {
			return degree[id-1]; 
		}
	}
	
	/**
	 * 
	 * @return Retorna a quantidade máxima de vértices (casa)
	 */
	public static int getVertexMax() {
		return vertexMax;
	}
	
	/**
	 * 
	 * @return Grau máximo de um vértice
	 */
	public static int getDegreeMax() {
		return degreeMax;
	}
	
	/**
	 * Atribui a quantidade máxima de vértices (casa) a partir do arquivo.
	 * @param n Quantidade máxima de vértices (casa)
	 */
	public static void setVertexMax(int n) {
		if(vertexMax == 0) {
			vertexMax = n;
		}
	}
	
	/**
	 * Atribui grau máximo de um vértice.
	 * @param d Grau máximo de um vértice
	 */
	public static void setDegreeMax(int d) {
		if(degreeMax == 0) {
			degreeMax = d;
		}
	}
	
	/**
	 * Incrementa a quantidade de grau de um vértice.
	 * @param i Indice a ser incrementado (conta a partir do zero)
	 * @param j Indice da casa 2 (conta a partir do zero
	 */
	private void increaseDegree(int i, int j) {
		degree[i] += 1;
		degree[j] += 1;
	}
	
	/**
	 * Decrementa a quantidade de grau de um vértice.
	 * @param i Indice da casa 1 (conta a partir do zero)
	 * @param j Indice da casa 2 (conta a partir do zero)
	 */
	private void decreaseDegree(int i, int j) {
		degree[i] -= 1;
		degree[j] -= 1;
	}
}