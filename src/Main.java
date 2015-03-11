/**
 * Essa é a classe principal do projeto.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 09.03.2015
 */

public class Main {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			FileReader.readFile(args[0]);
			BestNetwork best = new BestNetwork(args[0]);
			best.findBest();
			WriteResultsToOUT writer = new WriteResultsToOUT();
			writer.writeToFile(best);
			//best.generateXML();
			System.out.println("Menor custo: " + best.getBest().totalCost());
			System.out.println("Soluções válidas: " + best.getSolutions());
			System.out.println("Tempo total gasto na busca pela solução: " +
            		best.getExecutionTime() + "ms");
			System.out.println("**Fim de execução**");	
		} else {
			System.err.println("Essa versão só funciona a partir da leitura de um arquivo!" +
					" Caso não tenha um arquivo, você pode enviar o arquivo de teste padrão" +
					" localizado em tests/in1.in");
		}
		
	}
	
}
