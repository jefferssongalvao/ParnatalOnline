
package TrabalhoEDB;

import java.util.ArrayList;
//Tem um nome e as conexoes que partem dela
public class Casa {
    private String nome;
    private ArrayList<Conexao> conexoes;

    public Casa(String nome) {
        this.nome = nome;
        conexoes = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conexao> getConexoes() {
        return conexoes;
    }

    public void setConexoes(ArrayList<Conexao> conexoes) {
        this.conexoes = conexoes;
    }
    //Adiciona uma conexao da casa para outra com um valor\custo
    public void addConexao(Casa casa, int valor) {
        Conexao novaConexao = new Conexao(casa, this, valor);
        conexoes.add(novaConexao);
    }
}
