
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class CentroMedico {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));

        Random random = new Random();

        boolean datoValido = false;
        int maxPazienti = 0;

        // Numero massimo di prenotazioni
        while (!datoValido) {
            System.out.print("Inserisci il numero massimo di prenotazioni: ");
            String testo = buffer.readLine();

            try {
                maxPazienti = Integer.parseInt(testo);

                if (maxPazienti > 0) {
                    datoValido = true;
                } else {
                    System.out.println("Il numero deve essere maggiore di zero!");
                }

            } catch (Exception e) {
                System.out.println("Errore! Inserisci un numero intero.");
            }
        }

        // Tre array paralleli
        String[] nomePaziente = new String[maxPazienti];
        int[] oraVisita = new int[maxPazienti];
        int[] numeroAmbulatorio = new int[maxPazienti];

        int n = 0;
        int scelta = 0;

        do {
            System.out.println("\n--- CENTRO MEDICO ---");
            System.out.println("1. Inserire una nuova prenotazione");
            System.out.println("2. Visualizzare tutte le prenotazioni");
            System.out.println("3. Cercare una prenotazione");
            System.out.println("4. Modificare l'ora di una visita");
            System.out.println("5. Visualizzare le visite prima delle 13");
            System.out.println("6. Prima e ultima visita della giornata");
            System.out.println("7. Prenotazioni per ambulatorio");
            System.out.println("8. Cancellare una prenotazione");
            System.out.println("9. Uscire");

            // Controllo scelta menu
            datoValido = false;

            while (!datoValido) {
                System.out.print("Scelta: ");
                String testo = buffer.readLine();

                try {
                    scelta = Integer.parseInt(testo);

                    if (scelta >= 1 && scelta <= 9) {
                        datoValido = true;
                    } else {
                        System.out.println("Scelta non valida!");
                    }

                } catch (Exception e) {
                    System.out.println("Errore! Inserisci un numero intero.");
                }
            }

            switch (scelta) {

                case 1: {
                    if (n == maxPazienti) {
                        System.out.println("Prenotazioni al completo!");
                    } else {
                        // Inserimento nome
                        String nome = "";

                        while (nome.equals("")) {
                            System.out.print("Nome del paziente: ");
                            nome = buffer.readLine();

                            if (nome.equals("")) {
                                System.out.println("Il nome non puo essere vuoto!");
                            }
                        }

                        // Inserimento ora
                        int ora = 0;
                        datoValido = false;

                        while (!datoValido) {
                            System.out.print("Ora della visita (8-18): ");
                            String testo = buffer.readLine();

                            try {
                                ora = Integer.parseInt(testo);

                                if (ora >= 8 && ora <= 18) {
                                    datoValido = true;
                                } else {
                                    System.out.println("Ora non valida!");
                                }

                            } catch (Exception e) {
                                System.out.println("Errore! Inserisci un numero intero.");
                            }
                        }

                        // Salvataggio prenotazione
                        nomePaziente[n] = nome;
                        oraVisita[n] = ora;
                        numeroAmbulatorio[n] = random.nextInt(3 - 1 + 1) + 1;

                        System.out.println("Ambulatorio assegnato: "
                                + numeroAmbulatorio[n]);

                        n++;

                        System.out.println("Prenotazione inserita!");
                    }
                    break;
                }

                case 2: {
                    if (n == 0) {
                        System.out.println("Nessuna prenotazione presente!");
                    } else {
                        System.out.println("NOME PAZIENTE\tORA\tAMBULATORIO");

                        for (int i = 0; i < n; i++) {
                            System.out.println(nomePaziente[i] + "\t" + oraVisita[i] + "\t" + numeroAmbulatorio[i]);
                        }
                    }
                    break;
                }

                case 3: {
                    if (n == 0) {
                        System.out.println("Nessuna prenotazione presente!");
                    } else {
                        String nomeRicerca = "";

                        while (nomeRicerca.equals("")) {
                            System.out.print("Nome del paziente da cercare: ");
                            nomeRicerca = buffer.readLine();

                            if (nomeRicerca.equals("")) {
                                System.out.println("Il nome non puo essere vuoto!");
                            }
                        }

                        int indice = -1;

                        for (int i = 0; i < n; i++) {
                            if (nomePaziente[i].equalsIgnoreCase(nomeRicerca)) {
                                indice = i;
                                break;
                            }
                        }

                        if (indice == -1) {
                            System.out.println("Prenotazione non trovata!");
                        } else {
                            System.out.println("Nome: " + nomePaziente[indice]);
                            System.out.println("Ora: " + oraVisita[indice]);
                            System.out.println("Ambulatorio: "
                                    + numeroAmbulatorio[indice]);
                        }
                    }
                    break;
                }

                case 4: {
                    if (n == 0) {
                        System.out.println("Nessuna prenotazione presente!");
                    } else {
                        String nomeRicerca = "";

                        while (nomeRicerca.equals("")) {
                            System.out.print("Nome del paziente: ");
                            nomeRicerca = buffer.readLine();

                            if (nomeRicerca.equals("")) {
                                System.out.println("Il nome non puo essere vuoto!");
                            }
                        }

                        int indice = -1;

                        for (int i = 0; i < n; i++) {
                            if (nomePaziente[i].equalsIgnoreCase(nomeRicerca)) {
                                indice = i;
                                break;
                            }
                        }

                        if (indice == -1) {
                            System.out.println("Prenotazione non trovata!");
                        } else {
                            int nuovaOra = 0;
                            datoValido = false;

                            while (!datoValido) {
                                System.out.print("Nuova ora della visita (8-18): ");
                                String testo = buffer.readLine();

                                try {
                                    nuovaOra = Integer.parseInt(testo);

                                    if (nuovaOra >= 8 && nuovaOra <= 18) {
                                        datoValido = true;
                                    } else {
                                        System.out.println("Ora non valida!");
                                    }

                                } catch (Exception e) {
                                    System.out.println("Errore! Inserisci un numero intero.");
                                }
                            }

                            oraVisita[indice] = nuovaOra;

                            System.out.println("Ora modificata!");
                        }
                    }
                    break;
                }

                case 5: {
                    boolean trovata = false;

                    for (int i = 0; i < n; i++) {
                        if (oraVisita[i] < 13) {
                            if (!trovata) {
                                System.out.println(
                                        "NOME PAZIENTE\tORA\tAMBULATORIO");
                            }

                            System.out.println(nomePaziente[i] + "\t"
                                    + oraVisita[i] + "\t"
                                    + numeroAmbulatorio[i]);

                            trovata = true;
                        }
                    }

                    if (!trovata) {
                        System.out.println("Nessuna visita prima delle 13!");
                    }
                    break;
                }

                case 6: {
                    if (n == 0) {
                        System.out.println("Nessuna prenotazione presente!");
                    } else {
                        int prima = 0;
                        int ultima = 0;

                        for (int i = 1; i < n; i++) {
                            if (oraVisita[i] < oraVisita[prima]) {
                                prima = i;
                            }

                            if (oraVisita[i] > oraVisita[ultima]) {
                                ultima = i;
                            }
                        }

                        System.out.println("PRIMA VISITA:");
                        System.out.println(nomePaziente[prima] + "\t"
                                + oraVisita[prima] + "\t"
                                + numeroAmbulatorio[prima]);

                        System.out.println("ULTIMA VISITA:");
                        System.out.println(nomePaziente[ultima] + "\t"
                                + oraVisita[ultima] + "\t"
                                + numeroAmbulatorio[ultima]);
                    }
                    break;
                }

                case 7: {
                    int amb1 = 0;
                    int amb2 = 0;
                    int amb3 = 0;

                    for (int i = 0; i < n; i++) {
                        if (numeroAmbulatorio[i] == 1) {
                            amb1++;
                        } else if (numeroAmbulatorio[i] == 2) {
                            amb2++;
                        } else if (numeroAmbulatorio[i] == 3) {
                            amb3++;
                        }
                    }

                    System.out.println("Ambulatorio 1: " + amb1);
                    System.out.println("Ambulatorio 2: " + amb2);
                    System.out.println("Ambulatorio 3: " + amb3);
                    break;
                }

                case 8: {
                    if (n == 0) {
                        System.out.println("Nessuna prenotazione presente!");
                    } else {
                        String nomeRicerca = "";

                        while (nomeRicerca.equals("")) {
                            System.out.print("Nome del paziente da cancellare: ");
                            nomeRicerca = buffer.readLine();

                            if (nomeRicerca.equals("")) {
                                System.out.println("Il nome non puo essere vuoto!");
                            }
                        }

                        int indice = -1;

                        for (int i = 0; i < n; i++) {
                            if (nomePaziente[i].equalsIgnoreCase(nomeRicerca)) {
                                indice = i;
                                break;
                            }
                        }

                        if (indice == -1) {
                            System.out.println("Prenotazione non trovata!");
                        } else {
                            for (int i = indice; i < n - 1; i++) {
                                nomePaziente[i] = nomePaziente[i + 1];
                                oraVisita[i] = oraVisita[i + 1];
                                numeroAmbulatorio[i] = numeroAmbulatorio[i + 1];
                            }

                            n--;

                            nomePaziente[n] = null;
                            oraVisita[n] = 0;
                            numeroAmbulatorio[n] = 0;

                            System.out.println("Prenotazione cancellata!");
                        }
                    }
                    break;
                }

                case 9:
                    System.out.println("Programma terminato.");
                    break;
            }

        } while (scelta != 9);
    }
}
