package Banca;
import java.util.Scanner;

public class ContoCorrente {
	Scanner input = new Scanner(System.in);

	private double saldo;
	private int idConto;
	private static int idUltimoConto = 1000;

	public static double tasso = 0.10;
	private static double tassoFamily = 0.12;
	private static double tassoBusiness = 0.15;
	
	//Costruttore
	ContoCorrente(double primoSaldo) {
		saldo = primoSaldo;
		idUltimoConto++;
		idConto = idUltimoConto;
	}
	
	//Metodo per versare una certa somma nel conto corrente
	public void versa(double versamento) {
		saldo += versamento ;
		System.out.println(" Versati: " + versamento + "euro");
	}
	
	//Metodo per prelevare dal conto corrente
	public boolean preleva(double prelievo) {
		if ( saldo < prelievo ) 
			return false ;
		else {
			saldo -= prelievo;
			System.out.println("Prelevati: " + prelievo + "euro");
			return true ;
		}
	}
	
	//Vari metodi get e set
	public double getSaldo () {
		return saldo ;
	}

	public double getNumero() {
		return idConto;
	}
	
	//Metodo per il calcolo degli interessi
	public void maturaInteressi(String cliente) {
		if(cliente.equals("family") || cliente.equals("Family"))
			saldo += saldo*tassoFamily;
		else if(cliente.equals("business") || cliente.equals("Business"))
			saldo += saldo*tassoBusiness;
	}

	public void setTassoFamily(double tF) {
		tassoFamily = tF;		
	}

	public void setTassoBusiness(double tB) {
		tassoBusiness = tB;		
	}

}
