
import java.util.Scanner;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Path;

public class MuseoASCII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String benvenuto = Files.readString(Path.of("opere", "saluti", "benvenuto.txt"));
            System.out.println(benvenuto);
        } catch (Exception e) {
            System.out.println("Errore nella lettura del file di benvenuto.");
        }

        String[] opere = {
                "opere/shoummo/1.txt",
                "opere/shoummo/2.txt",
                "opere/shoummo/3.txt",
                "opere/bislu/1.txt",
                "opere/bislu/2.txt",
                "opere/bislu/3.txt",
                "opere/pasquiz/1.txt",
                "opere/pasquiz/2.txt",
                "opere/pasquiz/3.txt",
                "opere/speciale/1.txt",
                "opere/speciale/2.txt",
                "opere/speciale/3.txt"
        };

        String[] nomi = {
                "Ma non mi dire???",
                "Epstein e la sua quarterzip",
                "Enrico Papi versione cattivo con laser",
                "Bislu e Osama Bin Laden",
                "Ragazzo swag asiatico che si fa un selfie",
                "Tizio disegnato a caso",
                "IShowSpeed emote",
                "Ragebait",
                "Troll face",
                "Pikachu sorpreso",
                "Gumball sciolto",
                "Occhio lungo di Shrek"
        };

        String[] collezioni = {
                "Shoummo Bar",
                "Shoummo Bar",
                "Shoummo Bar",
                "Tommaso Poli",
                "Tommaso Poli",
                "Tommaso Poli",
                "Simone Gatta",
                "Simone Gatta",
                "Simone Gatta",
                "COLLEZIONE SPECIFICA CARTONI LIMITED EDITION",
                "COLLEZIONE SPECIFICA CARTONI LIMITED EDITION",
                "COLLEZIONE SPECIFICA CARTONI LIMITED EDITION"
        };

        String cerca, contenuto, comando, nomeCollezione = "", tipoBiglietto = "Nessuno";

        int eta = 0, scelta = 0, sceltaMenu = 0, sceltaCollezione = 0;
        int posizione = 0, operaCasuale;

        double prezzo = 0, sconto = 0, totale;

        boolean trovato, accessoSpeciale = false;

        Random random = new Random();

        while (true) {
            System.out.println("Inserisci l'eta: ");

            try {
                eta = input.nextInt();
                input.nextLine();

                if (eta < 0 || eta > 120) {
                    System.out.println("Inserisci un'età tra 0 e 120");
                    continue;
                }

                break;

            } catch (Exception e) {
                input.nextLine();
                System.out.println("Inserisci un numero valido");
            }
        }

        if (eta < 26) {
            sconto = 100;
        } else if (eta >= 65) {
            sconto = 20;
        }

        System.out.println("1. Biglietto noob");
        System.out.println("2. Biglietto hacker");
        System.out.println("3. Uscire senza biglietto");

        while (true) {
            System.out.println("Scegli: ");

            try {
                scelta = input.nextInt();
                input.nextLine();

                if (scelta < 1 || scelta > 3) {
                    System.out.println("Inserisci un valore tra 1 e 3");
                    continue;
                }

                break;

            } catch (Exception e) {
                input.nextLine();
                System.out.println("Inserisci un numero valido");
            }
        }

        if (scelta == 1) {
            tipoBiglietto = "Noob";
            prezzo = 6.7;
            accessoSpeciale = false;

        } else if (scelta == 2) {
            tipoBiglietto = "Hacker";
            prezzo = 10.4;
            accessoSpeciale = true;
        }

        if (scelta != 3) {

            do {
                System.out.println("1. Visualizzare opera random");
                System.out.println("2. Visualizzare opere per collezione");
                System.out.println("3. Cercare opera per nome");
                System.out.println("4. Uscire");

                while (true) {
                    System.out.println("Scegli: ");

                    try {
                        sceltaMenu = input.nextInt();
                        input.nextLine();

                        if (sceltaMenu < 1 || sceltaMenu > 4) {
                            System.out.println("Inserisci un valore tra 1 e 4");
                            continue;
                        }

                        break;

                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Inserisci un numero valido");
                    }
                }

                switch (sceltaMenu) {

                    case 1:
                        if (accessoSpeciale) {
                            operaCasuale = random.nextInt(12);
                        } else {
                            operaCasuale = random.nextInt(9);
                        }

                        try {
                            contenuto = Files.readString(Path.of(opere[operaCasuale]));
                            System.out.println(contenuto);
                        } catch (Exception e) {
                            System.out.println("Errore: Impossibile leggere il file " + opere[operaCasuale]);
                        }

                        System.out.println("Nome: " + nomi[operaCasuale]);
                        System.out.println("Collezione: " + collezioni[operaCasuale]);
                        break;

                    case 2:
                        System.out.println("1. Shoummo Bar");
                        System.out.println("2. Tommaso Poli");
                        System.out.println("3. Simone Gatta");

                        if (accessoSpeciale) {
                            System.out.println("4. COLLEZIONE SPECIFICA CARTONI LIMITED EDITION");
                            System.out.println("5. Tornare al menu principale");
                        } else {
                            System.out.println("4. Tornare al menu principale");
                        }

                        while (true) {
                            System.out.println("Scegli la collezione: ");

                            try {
                                sceltaCollezione = input.nextInt();
                                input.nextLine();

                                if (accessoSpeciale) {
                                    if (sceltaCollezione < 1 || sceltaCollezione > 5) {
                                        System.out.println("Inserisci un valore tra 1 e 5");
                                        continue;
                                    }
                                } else {
                                    if (sceltaCollezione < 1 || sceltaCollezione > 4) {
                                        System.out.println("Inserisci un valore tra 1 e 4");
                                        continue;
                                    }
                                }

                                break;

                            } catch (Exception e) {
                                input.nextLine();
                                System.out.println("Inserisci un numero valido");
                            }
                        }

                        if (accessoSpeciale && sceltaCollezione == 5 || !accessoSpeciale && sceltaCollezione == 4) {
                            break;
                        }

                        switch (sceltaCollezione) {
                            case 1:
                                nomeCollezione = "Shoummo Bar";
                                break;

                            case 2:
                                nomeCollezione = "Tommaso Poli";
                                break;

                            case 3:
                                nomeCollezione = "Simone Gatta";
                                break;

                            case 4:
                                nomeCollezione = "COLLEZIONE SPECIFICA CARTONI LIMITED EDITION";
                                break;
                        }

                        for (int i = 0; i < opere.length; i++) {
                            if (collezioni[i].equalsIgnoreCase(nomeCollezione)) {

                                try {
                                    contenuto = Files.readString(Path.of(opere[i]));
                                    System.out.println(contenuto);
                                } catch (Exception e) {
                                    System.out.println("Errore: Impossibile leggere il file " + opere[i]);
                                }

                                System.out.println("Nome: " + nomi[i]);
                                System.out.println("Collezione: " + collezioni[i]);
                                System.out.println("Invio: prossima opera | i: precedente | e: esci");
                                comando = input.nextLine();

                                if (comando.equalsIgnoreCase("e")) {
                                    break;
                                }

                                if (comando.equalsIgnoreCase("i")) {
                                    if (i > 0 && collezioni[i - 1].equalsIgnoreCase(nomeCollezione)) {
                                        i = i - 2;
                                    } else {
                                        System.out.println("Sei già alla prima opera");
                                        i--;
                                    }
                                }
                            }
                        }

                        break;

                    case 3:
                        System.out.println("Inserisci il nome da ricercare: ");
                        cerca = input.nextLine();

                        trovato = false;

                        for (int i = 0; i < nomi.length; i++) {
                            if (nomi[i].equalsIgnoreCase(cerca) && (accessoSpeciale || !collezioni[i].equalsIgnoreCase("COLLEZIONE SPECIFICA CARTONI LIMITED EDITION"))) {
                                trovato = true;
                                posizione = i;
                                break;
                            }
                        }

                        if (trovato) {
                            System.out.println("L'opera è stata trovata");

                            try {
                                contenuto = Files.readString(Path.of(opere[posizione]));
                                System.out.println(contenuto);
                            } catch (Exception e) {
                                System.out.println("Errore: Impossibile leggere il file " + opere[posizione]);
                            }

                            System.out.println("Nome: " + nomi[posizione]);
                            System.out.println("Collezione: " + collezioni[posizione]);

                        } else {
                            System.out.println("Impossibile trovare l'opera");
                        }

                        break;
                }

            } while (sceltaMenu != 4);
        }

        System.out.println("--- CREDITI ---");
        System.out.println("Museo ASCII");
        System.out.println("Ideato da Shoummo Bar, Simone Gatta e Tommaso Poli");
        System.out.println("e tanta fantasia");
        System.out.println("Grazie per la visita");

        if (scelta != 3) {
            totale = prezzo - (prezzo * sconto / 100);

            System.out.println("--- SCONTRINO ---");
            System.out.println("Eta: " + eta);
            System.out.println("Biglietto: " + tipoBiglietto);
            System.out.println("Prezzo: " + prezzo + " euro");
            System.out.println("Sconto: " + sconto + "%");
            System.out.println("Totale: " + totale + " euro");

        } else {
            System.out.println("Nessun biglietto acquistato.");
        }

        try {
            String saluto = Files.readString(Path.of("opere", "saluti", "saluto.txt"));
            System.out.println(saluto);
        } catch (Exception e) {
            System.out.println("Errore: Impossibile leggere il file di saluto.");
        }

        input.close();
    }
}
