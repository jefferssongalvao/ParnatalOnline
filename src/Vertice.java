/**
 * Classe abstrata que serve de modelo para vértices em um grafo.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 12.03.2015
 */

public abstract class Vertice {

    // Identificador do vertice
    protected int id;
    
    /**
     * Construtor da classe abstrata; inicializa campo ID.
     */
    public Vertice() {
    	id = 0;
    }
    
    /**
     * 
     * @return Identificador do vertice
     */
    public int getID() {
        return id;
    }

    /**
     * Altera o identificador do vertice
     * @param id Identificador do vertice
     */
    public void setID(int id) {
        this.id = id;
    }
	
}
