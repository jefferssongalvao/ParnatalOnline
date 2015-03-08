import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class GenerateXML {

	/**
	 * Método responsável por gerar o arquivo XML que servirá de base para o grafo que
	 * será criado pelo framework PREFUSE.
	 */
	public void generateXML(BestNetwork best) {
		StringBuffer arquivo = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"\n" +
				" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				" xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns\n" +
				"  http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n" +
				"<graph id=\"G\" edgedefault=\"undirected\">\n"				
				);
		for(int i = 1; i <= Network.getVertexMax(); i++) {
			arquivo.append(" <node id=\"" + String.valueOf(i) + "\"/>\n");
		}
		Vector<Connection> links = new Vector<Connection>(best.getBest().getTree()); 
        for(Connection edge : links) {
        	arquivo.append(" <edge source=\"" + String.valueOf(edge.getInicial().getID()) + "\" target=\"" + String.valueOf(edge.getTerminal().getID()) + "\"/>\n");
        }
		arquivo.append("</graph>\n");
		arquivo.append("</graphml>");
		final String filename = "BestNetwork.xml";
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(arquivo.toString());
            out.flush();
            out.close();
	    } catch (IOException e) {
	    	System.err.println("Erro ao salvar arquivo \' " + filename + "\'");
	    }
	}
	
}
