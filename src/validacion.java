


public class validacion{
		
		String  matriz[][];
		
		
		public validacion(){	
			
			matriz = new String [4][5]; 	
			for (int k = 0; k<matriz.length;k++){
			matriz[k][1]="Variable";
			matriz[k][3]="Variable";
			matriz[k][4]=".";
			}
			
			//Suma
			matriz[0][0] = "ADD";
			matriz[0][2] = "TO";
			
			//Resta
			matriz[1][0] = "SUBTRACT";
			matriz[1][2] = "FROM";
			
			//Multiplicacion
			matriz[2][0] = "MULTIPLY";
			matriz[2][2] = "BY";
			
			//Division
			matriz[3][0] = "DIVIDE";
			matriz[3][2] = "INTO";
		}
		
		public boolean validateSuma(String valor, Integer indice){
			boolean validoSuma = false;
			if (valor == "Número") {
				valor = "Variable";
			}
			validoSuma = matriz[0][indice] == valor;
			return validoSuma;
		}
		
		public boolean validateResta(String valor, Integer indice){
			boolean validoResta = false;
			if (valor == "Número") {
				valor = "Variable";
			}
			validoResta = matriz[1][indice] == valor;
			return validoResta;
		}
		
		public boolean validateMultiplicacion(String valor, Integer indice){
			boolean validoMultiplicacion = false;
			if (valor == "Número") {
				valor = "Variable";
			}
			validoMultiplicacion = matriz[2][indice] == valor;
			return validoMultiplicacion;
		}
		public boolean validateDivision(String valor, Integer indice){
			boolean validoDivision = false;
			if (valor == "Número") {
				valor = "Variable";
			}
			validoDivision = matriz[3][indice] == valor;
			return validoDivision;
		}
		
		
	}