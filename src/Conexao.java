/**
 * Essa classe é responsável por representar a conexão entre duas casas.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 04.03.2015
 */

public class Conexao {

	// Ponto inicial
    private Casa inicial;
    
    // Ponto final
    private Casa terminal;
    
    // Identificador da conexão
    private int id;
    
    /**
     * Construtor da classe.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Idenficador da conexão
     */
    public Conexao(Casa inicial, Casa terminal, int id) {
        this.inicial = inicial;
        this.terminal = terminal;
        this.id = id;
    }

    /**
     * 
     * @return Ponto inicial
     */
    public Casa getInicial() {
        return inicial;
    }

    /**
     * Altera o ponto inicial. 
     * @param inicial Ponto inicial.
     */
    public void setInicial(Casa inicial) {
        this.inicial = inicial;
    }

    /**
     * 
     * @return Ponto final.
     */
    public Casa getTerminal() {
        return terminal;
    }

    /**
     * Altera o ponto final.
     * @param terminal Ponto final
     */
    public void setTerminal(Casa terminal) {
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

}
