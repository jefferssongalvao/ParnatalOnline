/**
<<<<<<< HEAD
 * Essa classe é responsável por representar a conexão entre duas residências.
=======
 * Essa classe representa a conexão entre duas casas.
>>>>>>> e0b72dda5584a4213de3bd266fdca16fc23dab7a
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

<<<<<<< HEAD
public class Connection extends Edge {
	
=======
public class Connection {

	// Ponto inicial
    private House inicial;
    
    // Ponto final
    private House terminal;
    
    // Identificador da conexão
    private int id;
    
    // Custo da conexão
    private int custo;
    
>>>>>>> e0b72dda5584a4213de3bd266fdca16fc23dab7a
    /**
     * Construtor da classe; Inicializa campos.
     * @param inicial Ponto inicial
     * @param terminal Ponto final
     * @param id Idenficador da conexão
     * @param custo Custo da conexão
     */
<<<<<<< HEAD
    public Connection(Residence inicial, Residence terminal, int id, int custo) {
        super(inicial, terminal, id, custo);
=======
    public Connection(House inicial, House terminal, int id, int custo) {
        this.inicial = inicial;
        this.terminal = terminal;
        this.id = id;
        this.custo = custo;
>>>>>>> e0b72dda5584a4213de3bd266fdca16fc23dab7a
    }

    /**
     * 
     * @return Ponto inicial
     */
<<<<<<< HEAD
    public Residence getInicial() {
        return (Residence) inicial;
=======
    public House getInicial() {
        return inicial;
>>>>>>> e0b72dda5584a4213de3bd266fdca16fc23dab7a
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
<<<<<<< HEAD
    public Residence getTerminal() {
        return (Residence) terminal;
=======
    public House getTerminal() {
        return terminal;
>>>>>>> e0b72dda5584a4213de3bd266fdca16fc23dab7a
    }

    /**
     * Altera o ponto final.
     * @param terminal Ponto final
     */
    public void setTerminal(House terminal) {
        this.terminal = terminal;
    }
    
}
