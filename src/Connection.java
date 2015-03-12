/**
 * Essa classe é responsável por representar a conexão entre duas casas.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 12.03.2015
 */

public class Connection extends Edge {

	// Ponto inicial
    private Residence inicial;
    
    // Ponto final
    private Residence terminal;
       
    /**
     * Construtor da classe.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Idenficador da conexão
     * @param custo Custo da conexão
     */
    public Connection(Residence inicial, Residence terminal, int id, int custo) {
        this.inicial = inicial;
        this.terminal = terminal;
        this.id = id;
        this.custo = custo;
    }

    /**
     * 
     * @return Ponto inicial
     */
    public Residence getInicial() {
        return inicial;
    }

    /**
     * Altera o ponto inicial. 
     * @param inicial Ponto inicial.
     */
    public void setInicial(Residence inicial) {
        this.inicial = inicial;
    }

    /**
     * 
     * @return Ponto final.
     */
    public Residence getTerminal() {
        return terminal;
    }

    /**
     * Altera o ponto final.
     * @param terminal Ponto final
     */
    public void setTerminal(Residence terminal) {
        this.terminal = terminal;
    }
    
}
