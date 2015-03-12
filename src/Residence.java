/**
 * Essa classe é responsável por representar uma casa no cenário.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 04.03.2015
 */

public class Residence {
    
    // Identificador da casa
    private int id;

    /**
     * Construtor da classe.
     * @param id Identificador da casa
     */
    public Residence(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return Identificador da casa
     */
    public int getID() {
        return id;
    }

    /**
     * Altera o identificador da casa
     * @param id Identificador da casa
     */
    public void setID(int id) {
        this.id = id;
    }

}
