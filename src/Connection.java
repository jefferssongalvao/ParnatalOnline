/**
 * Essa classe é responsável por representar a conexão entre duas residências.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

public class Connection extends Edge {
	
    /**
     * Construtor da classe; Inicializa campos.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Idenficador da conexão
     * @param custo Custo da conexão
     */
    public Connection(Residence inicial, Residence terminal, int id, int custo) {
        super(inicial, terminal, id, custo);
    }

    /**
     * 
     * @return Ponto inicial
     */
    public Residence getInicial() {
        return (Residence) inicial;
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
        return (Residence) terminal;
    }

    /**
     * Altera o ponto final.
     * @param terminal Ponto final
     */
    public void setTerminal(Residence terminal) {
        this.terminal = terminal;
    }
    
}