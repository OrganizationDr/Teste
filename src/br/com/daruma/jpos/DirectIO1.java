package br.com.daruma.jpos;

import jpos.FiscalPrinter;

public class DirectIO1 {

	public static void main(String[] args) throws Exception {
		
		FiscalPrinter fiscalPrinter = new FiscalPrinter();
		fiscalPrinter.open("Daruma Jpos");
		fiscalPrinter.claim(0);
		fiscalPrinter.setDeviceEnabled(true);
		
		fiscalPrinter.printXReport();
		
		/// rLerAliquotas
		char [] info = new char[300];
		int [] retorno = new int[1];
		
		fiscalPrinter.directIO(DarumaDirectIOExecutor.rLerAliquotas, retorno, new Object[]{
			info
		});
		
		System.out.println("Retorno rLerAliquotas: " + retorno[0]);
		System.out.println("rLerAliquotas: " + String.valueOf(info).trim());
		
		
		// leituraX via directIO
		fiscalPrinter.directIO(DarumaDirectIOExecutor.iLeituraX, retorno, null);
		System.out.println("Retorno iLeituraX: " + retorno[0]);
		
		// regRetornaValorChave
		
		char [] separador = new char[100];
		fiscalPrinter.directIO(DarumaDirectIOExecutor.regRetornaValorChave, retorno, new Object[]{
				"ECF",
				"CaracterSeparador",
				separador
		});
		
		System.out.println("Retorno regRetornaValorChave: " + retorno[0]);
		System.out.println("Separador: " + String.valueOf(separador).trim());
		
		
		
	}
}
