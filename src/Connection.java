/**
 * Essa classe é responsável por representar a conexão entre duas casas.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 04.03.2015
 */

public class Connection {

	// Ponto inicial
    private House inicial;
    
    // Ponto final
    private House terminal;
    
    // Identificador da conexão
    private int id;
    
    // Custo da conexão
    private int custo;
    
    /**
     * Construtor da classe.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Idenficador da conexão
     * @param custo Custo da conexão
     */
    public Connection(House inicial, House terminal, int id, int custo) {
        this.inicial = inicial;
        this.terminal = terminal;
        this.id = id;
        this.custo = custo;
    }

    /**
     * 
     * @return Ponto inicial
     */
    public House getInicial() {
        return inicial;
    }

    /**
     * Altera o ponto inicial. 
     * @param inicial Ponto inicial.
     */
    public void setInicial(House inicial) {
        this.inicial = inicial;
    }

    /**
     * 
     * @return Ponto final.
     */
    public House getTerminal() {
        return terminal;
    }

    /**
     * Altera o ponto final.
     * @param terminal Ponto final
     */
    public void setTerminal(House terminal) {
        this.terminal = terminal;
    }
    
    /**
     * 
     * @return Identificador da conexão
     */
    public int getID() {
        return id;
    }

    /**
     * Altera o valor do identificador da conexão.
     * @param id Identificador da conexão
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * 
     * @return Custo da conexão
     */
    public int getCusto() {
    	return custo;
    }
    
    /**
     * Altera o valor do custo da conexão.
     * @param custo Custo da conexão
     */
    public void setCusto(int custo) {
    	this.custo = custo;
    }
}
