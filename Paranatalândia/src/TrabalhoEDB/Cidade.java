
package TrabalhoEDB;

import java.util.ArrayList;
// Array list de casas
public class Cidade {
    private ArrayList<Casa> casas;

    public Cidade() {
        this.casas = new ArrayList<>();
    }
    
    public Cidade(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public ArrayList<Casa> getCasas() {
        return this.casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
    
    public void addCasa(Casa casa) {
        this.casas.add(casa);
    }
}
