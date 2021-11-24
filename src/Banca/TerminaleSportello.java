package Banca;
import java.util.Scanner;

public class TerminaleSportello {
	Scanner input = new Scanner(System.in);

	private int utenteDesignato;
	
	//Costruttore
	public TerminaleSportello(Utente[] array) {

		boolean tf = true;

		do {
			if(login(array)) {
				tf = false;
				menu(array[utenteDesignato]);
			}
			else
				System.out.println("Hai inserito dati errati, riprova");
		} while(tf);
	}
	
	//Metodo per effettuare il login
	public boolean login(Utente[] array) {

		String utente, tipoUtente, password;
		System.out.println("Inserisci nome utente:");
		utente = input.next();
		System.out.println("Inserisci tipo utente:");
		tipoUtente = input.next();
		System.out.println("Inserisci password:");
		password = input.next();

		for(int i = 0; i < array.length; i++) {
			if(array[i].getUtente().equals(utente)) {
				if(array[i].getTipoUtente().equals(tipoUtente))
					if(array[i].getPassword().equals(password)) {
						utenteDesignato = i;
						return true;
					}
			}
		}

		return false;
	}
	
	//Metodo che rispecchia l'impostazione del menù del terminale
	public void menu(Utente utente) {

		int valore;

		do {
			System.out.println("MENU':");
			System.out.println("1) Per versare");
			System.out.println("2) Per prelevare");
			System.out.println("3) Per vedere il proprio saldo");
			System.out.println("4) Per cambiare password");
			System.out.println("5) Per calcolare interessi");
			System.out.println("0) Per uscire");
			System.out.println("Scelta: ");
			valore = input.nextInt();

			switch(valore) {
			case 0:
				System.out.println("Arrivederci!");
				break;
			case 1:
				System.out.println("Inserisci la somma da versare:");
				double versamento = input.nextDouble();
				utente.getConto().versa(versamento);
				break;
			case 2:
				System.out.println("Inserisci la somma da prelevare:");
				double prelievo=input.nextDouble();
				utente.getConto().preleva(prelievo);
				break;
			case 3:
				System.out.println("Il tuo saldo è di "+ utente.getConto().getSaldo() +" euro");
				break;
			case 4:
				String oldPsw,newPsw;
				do {
					System.out.println("Inserisci la tua vecchia password:");
					oldPsw=input.next();
					System.out.println("Inserisci la tua nuova password:");
					newPsw=input.next();
				}while(!utente.cambiaPassword(oldPsw, newPsw));
				break;
			case 5:
				utente.getConto().maturaInteressi(utente.getTipoUtente());
				System.out.println("Hai maturato degli interessi, ora il tuo saldo è di "+ utente.getConto().getSaldo() +" euro");
				break;
			default:
				System.out.println("Hai inserito un numero errato");
			}

		} while(valore != 0);


	}

}
