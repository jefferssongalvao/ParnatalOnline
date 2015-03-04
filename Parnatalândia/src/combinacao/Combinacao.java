package combinacao;
 
import java.util.ArrayList;

public class Combinacao {
    private int r ;
    private String[] entrada ;
    private int MAX ;
    private int N ;
    // r == '0' faz todas as combinações
    public Combinacao(String[] entrada, int r) {
        this.r = r ;
        this.entrada = entrada ;
        this.MAX = ~(1 << entrada.length) ;
        this.N = 1;
    }
 
    /** Retorna true quando ha pelo menos
     * uma combinacao disponivel.
     */
    public boolean hasNext() {
        if ( r != 0 ) {
            while ( ((this.N & this.MAX) != 0) && (countbits() != r) ) N+=1 ;
        }
 
        return (this.N & this.MAX) != 0;
    }
 
    /** Retorna a quantidade de bits ativos (= 1)
     * de N.
     */
    private int countbits() {
        int i;
        int c;
 
        i = 1;
        c = 0;
        while ( (this.MAX & i) != 0 ) {
            if ( (this.N & i) != 0) {
                c++;
            }
            i = i << 1 ;
        }
 
        return c ;
    }
 
    //Util para obter o tamanho da saida
    public int getSaidaLength() {
        if (r != 0) {
            return r;
        }
 
        return this.countbits();
    }
 
    /** Retorna uma combinacao.
     *
     * ATENCAO: Sempre use next() quando se
     * tem certeza que ha uma combinacao
     * disponivel. Ou seja, sempre use next()
     * quando hasNext() retornar true.
     */
    public ArrayList<String> next() {
        int saida_index, entrada_index, i;
        
        ArrayList<String> s = new ArrayList<>();
 
        entrada_index = 0;
        saida_index = 0;
        i = 1;
 
        while ((this.MAX & i) != 0) {
            if ((this.N & i) != 0) {
                s.add(entrada[entrada_index]);
                saida_index += 1;
            }
            entrada_index += 1;
            i = i << 1;
        }
 
        N += 1;
 
        return s;
    }
}