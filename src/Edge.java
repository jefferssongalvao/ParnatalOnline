/**
 * Classe abstrata que serve de modelo para arestas em um grafo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

public abstract class Edge {

	// Ponto inicial
    protected Vertice inicial;
    
    // Ponto final
    protected Vertice terminal;
	
	// Identificador da aresta
    protected int id;
    
    // Custo da aresta
    protected int custo;
    
    /**
     * Construtor da classe abstrata; Inicializa campos.
     */
    public Edge() {
    	inicial = null;
    	terminal = null;
    	id = 0;
    	custo = 0;
    }
    
    /**
     * Construtor da classe abstrata; Inicializa campos.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Identificador da aresta
     * @param custo Custo da aresta
     */
    public Edge(Vertice inicial, Vertice terminal, int id, int custo) {
    	this.inicial = inicial;
    	this.terminal = terminal;
    	id = 0;
    	custo = 0;
    }
    
    /**
     * 
     * @return Ponto inicial
     */
    public Vertice getInicial() {
    	return inicial;
    }
    
    /**
     * Altera o ponto inicial
     * @param inicial Ponto inicial
     */
    public void setInicial(Vertice inicial) {
		this.inicial = inicial;
	}

	/**
     * 
     * @return Ponto final
     */
    public Vertice getTerminal() {
    	return terminal;
    }    
    
    /**
     * Altera o ponto final
     * @param terminal Ponto final 
     */
    public void setTerminal(Vertice terminal) {
		this.terminal = terminal;
	}

	/**
     * 
     * @return Identificador da aresta.
     */
    public int getID() {
        return id;
    }

    /**
     * Altera o valor do identificador da aresta.
     * @param id Identificador da aresta
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * 
     * @return Custo da aresta.
     */
    public int getCusto() {
    	return custo;
    }
    
    /**
     * Altera o valor do custo da aresta.
     * @param custo Custo da aresta
     */
    public void setCusto(int custo) {
    	this.custo = custo;
    }
	
}
