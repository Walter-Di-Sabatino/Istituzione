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

	ContoCorrente(double primoSaldo) {
		saldo = primoSaldo;
		idUltimoConto++;
		idConto = idUltimoConto;
	}

	public void versa(double versamento) {
		saldo += versamento ;
		System.out.println(" Versati: " + versamento + "euro");
	}

	public boolean preleva(double prelievo) {
		if ( saldo < prelievo ) 
			return false ;
		else {
			saldo -= prelievo;
			System.out.println("Prelevati: " + prelievo + "euro");
			return true ;
		}
	}

	public double getSaldo () {
		return saldo ;
	}

	public double getNumero() {
		return idConto;
	}

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
