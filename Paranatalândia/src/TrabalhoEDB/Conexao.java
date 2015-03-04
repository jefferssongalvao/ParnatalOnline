
package TrabalhoEDB;
//Faz a conexao entre duas casas e guarda o valor da conexao
public class Conexao {
    private Casa casa = null;
    private Casa casa2 = null;
    private int valor = 0;
    
    public Conexao(Casa casa, Casa casa2, int valor) {
        this.casa = casa;
        this.casa2 = casa2;
        this.valor = valor;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Casa getCasa2() {
        return this.casa2;
    }

    public void setCasa2(Casa casa2) {
        this.casa2 = casa2;
    }
}
