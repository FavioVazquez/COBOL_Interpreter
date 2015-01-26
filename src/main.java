


import java.util.Scanner;
import java.util.regex.*;

public class main {
	static boolean valida = false;
	static boolean exprvalida = true;
	static TablaSimbolos gramatica = new TablaSimbolos();
	static TablaSimbolos cobol = new TablaSimbolos();
	static Simbolo s = new Simbolo("default","default","default");
	static Scanner sc = new Scanner(System.in);
	static int contador = 0;
	
	
	public static void validateBuffer(String buffer) {
		buffer = buffer.toUpperCase();
		s =  gramatica.buscar(buffer);
		if (s==null){
			cobol.insertar("id "+contador,buffer,"Variable");
		}
		else{
		cobol.insertar("id "+contador,s.nombre, s.valor);
		}
		contador++;
	}
	
	
	

	public static void main(String[] args) {
		int count = 0;
		gramatica.startDefault();
        System.out.println("Ingrese una expresión aritmética en COBOL");
        String expresion = sc.nextLine();
        
        validacion val = new validacion();
        
        //Pattern y Matcher
        
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_]");
        Matcher mat;
        
        String expr[] = expresion.split(" ");
        String buffer = "";
        
        // Búsqueda e inserción 
        
        for (int i=0; i< expr.length; i++){
        	
        	for (int j=0; j<expr[i].length();j++){
        		mat = pat.matcher(expr[i].substring(j, j+1));
        		if ( mat.matches()){
        			buffer += expr[i].charAt(j);
        		}
        		
        		else {
        			validateBuffer(buffer);
        			buffer = "";        			
        		}
        		if (expr[i].substring(j, j+1).equals(".")){
        			validateBuffer(".");
        		}
        		if ( expr[i].substring(j, j+1).equals("*"))
        		{
        			validateBuffer("*");
        		}
        		if ( expr[i].substring(j, j+1).equals("+"))
        		{
        			validateBuffer("+");
        		}
        		if ( expr[i].substring(j, j+1).equals("-"))
        		{
        			validateBuffer("-");
        		}
        		if ( expr[i].substring(j, j+1).equals("/"))
        		{
        			validateBuffer("/");
        		}
        		if ( expr[i].substring(j, j+1).equals("#"))
        		{
        			validateBuffer("#");
        		}
        		if ( expr[i].substring(j, j+1).equals("$"))
        		{
        			validateBuffer("$");
        		}
        		if ( expr[i].substring(j, j+1).equals("%"))
        		{
        			validateBuffer("%");
        		}
        		if ( expr[i].substring(j, j+1).equals("&"))
        		{
        			validateBuffer("&");
        		}
        		if ( expr[i].substring(j, j+1).equals("("))
        		{
        			validateBuffer("(");
        		}
        		if ( expr[i].substring(j, j+1).equals(")"))
        		{
        			validateBuffer(")");
        		}
        		if ( expr[i].substring(j, j+1).equals("="))
        		{
        			validateBuffer("=");
        		}
        	}  
	        
        	if (buffer != "") {
        		validateBuffer(buffer);
        		buffer = "";

        	}
        }
        
        
      cobol.imprimir(contador);
      
        /*
        //Validar Suma
        for (int i=0;i<cobol.length();i++){
			s = cobol.buscar("id "+i);
			valida = val.validateSuma(s.valor, i);
			if (valida == false) {
				exprvalida = false;
			}
			else {
				exprvalida = true;
			}
        }
        
      //Validar Resta
        for (int i=0;i<cobol.length();i++){
			s = cobol.buscar("id "+i);
			valida = val.validateResta(s.valor, i);
			if (valida == false) {
				exprvalida = false;
			}
			else {
				exprvalida = true;
			}
        }
        
      //Validar Multiplicacion
        for (int i=0;i<cobol.length();i++){
			s = cobol.buscar("id "+i);
			valida = val.validateMultiplicacion(s.valor, i);
			if (valida == false) {
				exprvalida = false;
			}
			else {
				exprvalida = true;
			}
        }   
      //Validar Division
        for (int i=0;i<cobol.length();i++){
			s = cobol.buscar("id "+i);
			valida = val.validateDivision(s.valor, i);
			if (valida == false) {
				exprvalida = false;
			}
			else {
				exprvalida = true;
			}
        }  
       */
      
        s = cobol.buscar("id " + 0);
        count = 0;
        switch (s.nombre) {
        case "ADD":
        	System.out.println("SE HA DETECTADO UNA SUMA");
        	do {
        		s = cobol.buscar("id " + count);
        		if (s.valor == "Palabra reservada" || s.valor == "Fin de instrucción") {
        			valida = val.validateSuma(s.nombre, count);	
        		}
   
        		else {
        			valida = val.validateSuma(s.valor, count);
        		}
        		
        		if (valida == false) {
        			exprvalida = false;
        		}
        		count++;
        	} while (count < cobol.length() && exprvalida == true);
        	break;
        case "SUBTRACT":
        	System.out.println("SE HA DETECTADO UNA RESTA");
        	do {
        		s = cobol.buscar("id " + count);
        		if (s.valor == "Palabra reservada" || s.valor == "Fin de instrucción") {
        			valida = val.validateResta(s.nombre, count);	
        		}
   
        		else {
        			valida = val.validateResta(s.valor, count);
        		}
        		if (valida == false) {
        			exprvalida = false;
        		}
        		count++;
        	} while (count < cobol.length() && exprvalida == true);
        	break;
        case "DIVIDE":
        	System.out.println("SE HA DETECTADO UNA DIVISIÓN");
        	do {
        		s = cobol.buscar("id " + count);
        		if (s.valor == "Palabra reservada" || s.valor == "Fin de instrucción") {
        			valida = val.validateDivision(s.nombre, count);	
        		}
   
        		else {
        			valida = val.validateDivision(s.valor, count);
        		}
        		if (valida == false) {
        			exprvalida = false;
        		}
        		count++;
        	} while (count < cobol.length() && exprvalida == true);
        	break;
        case "MULTIPLY":
        	System.out.println("SE HA DETECTADO UNA MULTIPLICACIÓN");
        	do {
        		s = cobol.buscar("id " + count);
        		if (s.valor == "Palabra reservada" || s.valor == "Fin de instrucción") {
        			valida = val.validateMultiplicacion(s.nombre, count);	
        		}
   
        		else {
        			valida = val.validateMultiplicacion(s.valor, count);
        		}
        		if (valida == false) {
        			exprvalida = false;
        		}
        		count++;
        	} while (count < cobol.length() && exprvalida == true);
        	break;
        default: 
        	exprvalida = false;
        	break;
        
        }
        
       if (exprvalida==true){
    	   System.out.println("Expresión Válida");
       }
       else{
    	   System.out.println("Expresión No Válida");

       }
	    
}
	}
	
