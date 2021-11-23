import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GestioneRegistroEta
{
	public static void main(String args[])
	{
		// inizializzazione registro delle eta e dello scanner
		RegistroEtaCompleto regeta = new RegistroEtaCompleto();
		Scanner in = new Scanner(System.in);
		
		// chiedo il nome del file da leggere. se questo non esiste verrà creato un nuovo registro vuoto
		// che verrà poi salvato in quel file
		String nomefile;
		System.out.println("Benvenuto nel Registro delle Eta'.");
		System.out.println("Inserire il nome del file da leggere: se non e' presente, verra' creato un nuovo file a partire da quel nome.");
		System.out.print("> ");
		nomefile = in.nextLine();
		
		try
		{
			regeta.leggiFile(nomefile);
			System.out.println("Dati di " + nomefile + " caricati.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Verra' creato un nuovo file di nome " + nomefile);
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("Errore di lettura del file " + nomefile + ": " + e.getMessage());
			return;
		}
		catch (IOException e)
		{
			System.err.println("Errore di I/O: " + e.getMessage());
			return;
		}
		
		// qui inizia il menu del programma
		int scelta;
		Boolean modificato = false;
		
		do
		{
			System.out.println("MENU");
			System.out.println("1 - visualizza registro");
			System.out.println("2 - aggiungi studente");
			System.out.println("3 - incrementa eta' di uno studente");
			System.out.println("4 - salva modifiche");
			System.out.println("0 - chiudi programma");
			
			System.out.print("> Digitare un comando: ");
			scelta = in.nextInt();
			
			// pulisco il buffer dello scanner dai caratteri speciali (es.: \n e \0)
			in.nextLine();
			
			switch (scelta)
			{
				case 1:
					// visualizza registro
					System.out.println(regeta.toString());
					break;
				case 2:
					// aggiungi studente
					String nomeDaAggiungere;
					int eta;
					
					System.out.print("Inserire nome dello studente da aggiungere: ");
					nomeDaAggiungere = in.nextLine();
					System.out.print("Inserire la sua eta': ");
					eta = in.nextInt();
					
					NomeEta ne = new NomeEta(nomeDaAggiungere, eta);
					regeta.aggiungiStudente(ne);
					modificato = true;
					
					break;
				case 3:
					// incrementa età di uno studente
					String nomeDaIncrementare;
					
					System.out.print("Inserire il nome dello studente a cui incrementare l'eta': ");
					nomeDaIncrementare = in.nextLine();
					
					if (regeta.incrementaEta(nomeDaIncrementare))
					{
						System.out.println("L'eta' dello studente " + nomeDaIncrementare + " e' stata correttamente aumentata di 1");
						modificato = true;
					}
					else
						System.err.println("Impossibile aumentare l'eta' di " + nomeDaIncrementare);

					break;
				case 4:
					// salva modifiche
					try
					{
						regeta.salvaFile(nomefile);
						modificato = false;
						System.out.println("File " + nomefile + " salvato correttamente.");
					} 
					catch (IOException e)
					{
						System.err.println("Impossibile salvare le modifiche: " + e.getMessage());
					}
					
					break;
				case 0:
					// chiusura programma
					// se ci sono state delle modifiche chiedo all'utente se davvero vuole uscire. se ricambia idea e quindi vuole
					// continuare l'esecuzione del programma la scelta viene impostata a 999, in modo tale che, una volta usciti
					// dallo switch, il ciclo while del menu (riga 131) non si interrompa e continui l'esecuzione del programma
					if (modificato)
					{
						char x;
						System.out.print("Ci sono delle modifiche non salvate. Vuoi veramente chiudere il programma? (S/N) ");
						x = in.next().charAt(0);
						
						if (x == 's' || x == 'S')
							System.out.println("Arrivederci!!");
						else if (x == 'n' || x == 'N')
							scelta = 999;
						else
						{
							System.err.println("Carattere non valido - l'esecuzione del programma continuera'");
							scelta = 999;
						}
					}
					
			}
		} while (scelta != 0);
	}
}
