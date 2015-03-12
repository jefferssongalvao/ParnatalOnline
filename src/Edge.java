/**
 * Classe abstrata que serve de modelo para arestas em um grafo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 12.03.2015
 */

public abstract class Edge {

	// Identificador da aresta
    protected int id;
    
    // Custo da aresta
    protected int custo;
    
    /**
     * Construtor da classe abstrata; Inicializa campos.
     */
    public Edge() {
    	id = 0;
    	custo = 0;
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
