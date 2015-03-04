package TrabalhoEDB;

import combinacao.Combinacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //Comeca a contar o tempo de execucao do programa
        long tempoInicial = System.currentTimeMillis();  
        Scanner in = new Scanner(System.in);

        String linha = " ";
        //Lê do arquivo
        System.out.println("Informe o caminho do arquivo de entrada: ");
        String arquivoEntrada = in.nextLine();
        FileReader reader;
        BufferedReader leitor;

        File arquivo = new File(arquivoEntrada);
        reader = new FileReader(arquivo);
        leitor = new BufferedReader(reader);

        String elemento = "";
        //salva os valores para casa e quantidade de filhos
        int casas, maxfilhos;

        linha += leitor.readLine() + " ";

        ArrayList<String> elementos = new ArrayList<>();

        for (int i = 0; i < linha.length() - 1; i++) {
            if (linha.charAt(i) == ' ') {
                for (int j = i + 1; j < linha.length() - 1; j++) {
                    if (linha.charAt(j) == ' ') {
                        break;
                    } else {
                        elemento += linha.charAt(j);
                    }
                }
                elementos.add(elemento);
                elemento = "";
            }
        }

        casas = Integer.parseInt(elementos.get(0));
        maxfilhos = Integer.parseInt(elementos.get(1));
        //Coloca as casas em conjuntos disjuntos
        ArrayList<Casa> vetorCasas = new ArrayList<>();

        ArrayList<UnionFind<Casa>> unions = new ArrayList<>();

        for (int i = 1; i <= casas; i++) {
            Casa c = new Casa("C" + i);
            vetorCasas.add(c);
            unions.add(UnionFind.singleton(c));
        }

        elemento = "";

        int numCasa = 0;
        int contador = 1;
        //Le os valores da matriz e adiciona conexoes nas respectivas casas
        while (leitor.ready()) {

            linha = " " + leitor.readLine() + " ";

            contador = numCasa + 1;

            for (int i = 0; i < linha.length() - 1; i++) {

                if (linha.charAt(i) == ' ') {
                    for (int j = i + 1; j < linha.length() - 1; j++) {
                        if (linha.charAt(j) == ' ') {
                            break;
                        } else {
                            elemento += linha.charAt(j);
                        }
                    }

                    vetorCasas.get(numCasa).addConexao(vetorCasas.get(contador), Integer.parseInt(elemento));
                    contador++;
                    elemento = "";
                }
            }

            numCasa++;
        }
        //Cria uma cidade 
        Cidade Parnatalandia = new Cidade();

        for (Casa c : vetorCasas) {
            Parnatalandia.addCasa(c);
        }

        ArrayList<String> conecPossiveis = new ArrayList<>();
        ArrayList<Conexao> conexoes = new ArrayList<>();
        
        for (Casa v : Parnatalandia.getCasas()) {
            for (Conexao a : v.getConexoes()) {
                String conec = v.getNome() + "-" + a.getCasa().getNome();
                conecPossiveis.add(conec);
            }
        }

        String[] str = new String[conecPossiveis.size()];

        int h = 0;

        for (String a : conecPossiveis) {
            str[h] = a;
            h++;
        }

        ArrayList<String> saida;

        ArrayList<ArrayList<String>> combinacoes = new ArrayList<>();
        //Fazendo as combinaÃ§oes possiveis  com permutação
        
        System.out.println("---------- Cidades Viáveis  ----------");
        Combinacao comb = new Combinacao(str, casas - 1);
        int i = 0;
        while (comb.hasNext()) {
            saida = comb.next();
            if (saida.size() == casas - 1) {//Restringe as combinacoes de n-1

                boolean ciclo = true;
                boolean filhos = true;
                boolean temTodasCasas = true;//verifica se todas as casas estão na combinação

                int[] existe = new int[casas];

                for (int g = 0; g < casas; g++) {   
                    existe[g] = 0;
                }
                
                for (int j = 0; j < saida.size(); j++) {
                    saida.set(j, "-" + saida.get(j) + "-");
                }

                for (int cont = 0; cont < casas; cont++) {
                    for (String e1 : saida) {
                        if (pegaPrimeira(e1).equals("C" + (cont + 1)) || pegaSegunda(e1).equals("C" + (cont + 1))) {
                            existe[cont]++;
                        }
                    }
                }

                for (int g = 0; g < casas; g++) {
                    if (existe[g] == 0) {
                        temTodasCasas = false;
                    }
                }

                if (temTodasCasas) {
                    for (String e : saida) {
                        ArrayList<UnionFind<Casa>> unionsTemp = new ArrayList<>();

                        for (Casa casa : vetorCasas) {
                            unionsTemp.add(UnionFind.singleton(casa));
                        }

                        String origem = pegaPrimeira(e);
                        String destino = pegaSegunda(e);

                        int numVezesFilhos = 0;
                        // verifica a quantidade de filhos
                        for (String x : saida) {
                            if (pegaPrimeira(x).equals(origem)) {
                                if(pegaSegunda(x).equals(destino)){
                                    numVezesFilhos++;
                                }
                                
                            }
                        }
                        //verifica se gera ciclo
                        for (UnionFind<Casa> u : unionsTemp) {
                            for (UnionFind<Casa> u1 : unionsTemp) {
                                if (u.value().getNome().equals(origem) && u1.value().getNome().equals(destino)) {
                                    if (!UnionFind.areMerged(u, u1)) {
                                        u.merge(u1);
                                    } else {
                                        ciclo = false;
                                    }
                                }
                            }
                        }

                        if (numVezesFilhos > maxfilhos) {
                            filhos = false;
                        }
                    }

                }

                if (filhos && ciclo && temTodasCasas) {// adiciona apenas combinacoes vÃ¡lidas
                    combinacoes.add(saida);
                }
            }
        }

        int d = 0;

        for (ArrayList<String> e : combinacoes) {
            System.out.println(d + "- " + e);
            d++;
        }

        System.out.println("---------------------------------------");

        ArrayList<Conexao> conexoesPossiveis = new ArrayList<>();

        for (Casa residencia : Parnatalandia.getCasas()) {
            for (Conexao conexaoDaResidencia : residencia.getConexoes()) {
                conexoesPossiveis.add(conexaoDaResidencia);
            }
        }
        
        ArrayList<ArrayList<Conexao>> cidades = new ArrayList<>();
        ArrayList<Integer> cidadeCustos = new ArrayList<>();

        for (ArrayList<String> conecte: combinacoes) {

            ArrayList<Conexao> cidade = new ArrayList<>();

            int custo = 0;
            //Verificar e comparar os custos das combinacoes
            for (String s : conecte) {
                String C1 = pegaPrimeira(s);
                String C2 = pegaSegunda(s);

                for (Conexao c : conexoesPossiveis) {
                    if (c.getCasa2().getNome().equals(C1) && c.getCasa().getNome().equals(C2)) {
                        cidade.add(c);
                        custo += c.getValor();
                    }
                }
            }

            cidades.add(cidade);
            cidadeCustos.add(custo);
        }
        
        int menor = cidadeCustos.get(0);
        int posCidadeOtima = 0;
        ArrayList<Conexao> cidadeOtima = cidades.get(0);
        //menor custo e possicao
        for (Integer e : cidadeCustos) {
            if (e < menor) {
                menor = e;
                cidadeOtima = cidades.get(posCidadeOtima);
            }
            posCidadeOtima++;
        }

        System.out.println();
        System.out.println("------------- Cidade Ótima ------------");
        
        String configuracao = "";

        for (Conexao c : cidadeOtima) {
            System.out.println(c.getCasa2().getNome() + "-" + c.getCasa().getNome() + " valor " + c.getValor());
            configuracao += c.getCasa2().getNome() + "-" + c.getCasa().getNome() + ", ";
        }
        System.out.println("Custo da conexão = " + menor);

        System.out.println("---------------------------------------");
        
        long tempoFinal = System.currentTimeMillis();  
  
        System.out.println("Tempo de execução do programa:" +(tempoFinal - tempoInicial)+ "ms");
        
        String s;
        
        s = "Numero de soluções possíveis: " + d + ". \r\n";
        s += "Custo da melhor solução: " + menor + ". \r\n";
        s += "Configuração da melhor solução: " + configuracao + ". \r\n";
        s += "Tempo de execução: " + (tempoFinal - tempoInicial)+ "ms" + ".";
        
        
        File arquivoSaida = new File( "saida.txt");
        try (FileWriter escreve = new FileWriter(arquivoSaida)) {
            escreve.write(s);
            escreve.flush();
            escreve.close();
            System.out.println("Escreveu em " + arquivoSaida.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        }
    }
    
    public static String pegaPrimeira(String string) {
        String elemento = "";
        
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == '-') {
                for (int j = i + 1; j < string.length() - 1; j++) {
                    if (string.charAt(j) == '-') {
                        break;
                    } else {
                        elemento += string.charAt(j);
                    }
                }
                return elemento;
            }
        }
        return null;
    }
    
    public static String pegaSegunda(String string) {
        String elemento = "";
        ArrayList<String> el = new ArrayList<>();
        
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == '-') {
                for (int j = i + 1; j < string.length() - 1; j++) {
                    if (string.charAt(j) == '-') {
                        break;
                    } else {
                        elemento += string.charAt(j);
                    }
                }
                
                el.add(elemento);
                elemento = "";
            }
        }
        
        return el.get(1);
    }
    
}
