/**
 * Essa classe é responsável por imprimir a matriz de custos.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 08.03.2015
 */

public class MatrixPrinter implements PrintMatrix {

	/**
	 * Método que imprime a matriz de custos.
	 */
	public void print(Matrix matrix) {
		for(int i = 0; i < matrix.size(); i++) {
			for(int j = 0; j < matrix.size(); j++) {
				System.out.print(matrix.getElement(i, j) + " ");
			}
			System.out.print('\n');
		}
	}
	
}
