package Banca;
import java.util.Scanner;

public class GestioneBanca {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numeroUtenti;

		System.out.println("Salve, quanti utenti vuoi inserire?");
		numeroUtenti = input.nextInt();
		Utente[] utenti = new Utente[numeroUtenti];

		String utente;
		String tipoUtente;
		String password;
		double pSaldo;
		boolean tf = false;

		for(int i = 0; i < numeroUtenti; i++) {
			System.out.println("Inserisci dati cliente numero: "+ i);
			System.out.println("Insersci il nome utente");
			utente = input.next();
			System.out.println("Inserisci tipologia utente: ");

			do {
				tf = false;
				tipoUtente = input.next();
				switch(tipoUtente) {
				case "Family":
				case "family":
				case "Business":
				case "business":
					break;
				default:
					System.out.println("Hai inserito dati errati, reinseriscili");
					tf = true;
				}
			} while(tf);

			System.out.println("Inserisci la password: ");
			password = input.next();

			System.out.println("Inserisci il primo saldo: ");
			do {
				pSaldo = input.nextDouble();
				if(pSaldo < 0)
					System.out.println("Non puoi inserire valori negativi, riprova: ");
			} while(pSaldo < 0);

			utenti[i] = new Utente(utente, tipoUtente, password, pSaldo);

		}

		System.out.println("Esegui il login:");
		TerminaleSportello terminale = new TerminaleSportello(utenti);

		input.close();
	}

}
