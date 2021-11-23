# GestioneRegistroEta
Scrivi un programma GestioneRegistroEta che permetta di gestire un registro con le informazioni degli studenti di un corso di laurea. 
Il programma deve leggere/salvare le informazioni da/in un file, utilizzando la serializzazione degli oggetti.
Il programma, dopo aver richiesto all’utente il nome del file di registro, dovrà presentare il seguente menù:
- Visualizza registro, per visualizzare l’intera classe;
- Aggiungi elemento, per aggiungere un nuovo studente;
- Incrementa età, per incrementare di 1 l’età di un particolare studente;
- Salva dati, per salvare il registro su file.
- Esci, per uscire dal programma.

Tutte le operazioni di inserimento/modifica dei dati del registro dovranno essere effettuate utilizzando i vettori. 
Il registro verrà salvato su file solo dopo aver scelto l’opzione “Salva dati” dal menù. Se l’utente sceglie di uscire dal programma senza aver salvato il registro, controllare se il registro ha subito modifiche rispetto al file originale. Se ci sono state modifiche, occorre avvertire l’utente per non fargli perdere quelle modifiche.
Concludendo, in generale il programma dovrà prevedere:
- una classe NomeEta, che associa un nome a una età, e gestisce l’incremento dell’età;
- una classe RegistroEtaCompleto, che contiene un vettore di oggetti NomeEta e diverse funzionalità;
- una classe GestioneRegistroEta che contiene la funzione main(), con un menu per accedere alle varie funzionalità di RegistroEtaCompleto.

Infine, gestire tutte le possibili eccezioni che potrebbero essere lanciate dal programma.
