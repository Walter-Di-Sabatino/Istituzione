package Banca;
import java.util.Scanner;

public class Utente {
	Scanner input = new Scanner(System.in);

	private int id;
	private static int idUltimo = 1000;
	private String utente;
	private String password;
	private String tipoUtente;
	private ContoCorrente primoConto;

	public Utente(String u, String type, String p, double primoSaldo) {
		idUltimo++;
		id = idUltimo;
		utente = u;
		tipoUtente = type;
		password = p;
		primoConto = new ContoCorrente(primoSaldo);

	}

	public boolean cambiaPassword(String pwd, String newPwd) {
		if(password.equals(pwd)) {
			pwd = newPwd;
			this.password = pwd;
			System.out.println("La tua password è stata cambiata con successo");
			return true;
		}
		else {
			System.out.println("Vecchia password errata, il procedimento di cambio password è fallito");
		return false;
		}
	}

	public ContoCorrente getConto() {
		return primoConto;
	}

	public String getTipoUtente() {
		return tipoUtente;
	}

	public String getUtente() {
		return utente;
	}

	public String getPassword() {
		return password;
	}
	
	public int getId() {
		return id;
	}
}
