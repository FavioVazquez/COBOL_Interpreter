

import java.util.*;

@SuppressWarnings("rawtypes")

public class TablaSimbolos {
		HashMap t;
		public TablaSimbolos(){
				t = new HashMap();
				
		}
		
		public void startDefault(){
			Integer i = new Integer(0);	
			this.insertar("ADD", "ADD","Palabra reservada");
			this.insertar("SUBTRACT","SUBTRACT","Palabra reservada");
			this.insertar("MULTIPLY","MULTIPLY","Palabra reservada");
			this.insertar("DIVIDE","DIVIDE","Palabra reservada");
			this.insertar("TO","TO","Palabra reservada");
			this.insertar("GIVING","GIVING","Palabra reservada");
			this.insertar("INTO","INTO","Palabra reservada");
			this.insertar("FROM","FROM","Palabra reservada");
			this.insertar("BY","BY","Palabra reservada");
			for (i=0;i<=1000000;i++){
				this.insertar( i.toString(),(i.toString()),"Número");
			}
			this.insertar(".",".","Fin de instrucción");
			this.insertar("*","*","Símbolo no permitido");
			this.insertar("+","+","Símbolo no permitido");
			this.insertar("-","-","Símbolo no permitido");
			this.insertar("/","/","Símbolo no permitido");
			this.insertar("#","#","Símbolo no permitido");
			this.insertar("$","$","Símbolo no permitido");
			this.insertar("%","%","Símbolo no permitido");
			this.insertar("&","&","Símbolo no permitido");
			this.insertar("(","(","Símbolo no permitido");
			this.insertar(")",")","Símbolo no permitido");
			this.insertar("=","=","Símbolo no permitido");
	
		}
		
		
		public Simbolo insertar(String id, String nombre, String valor){
			Simbolo s = new Simbolo(id, nombre, valor);
			t.put(id, s);
			return s;
		}
		
		public Simbolo buscar(String nombre){
			return (Simbolo) (t.get(nombre));
		}
		
		public void imprimir(int lim){
				for (int i = 0; i < lim; i++){
					Simbolo s = buscar("id "+i);
					System.out.println(s.id+"-- "+s.nombre+":"+s.valor);
				}
							
		}
		
		public int length() {
			return t.size();
		} 
}
