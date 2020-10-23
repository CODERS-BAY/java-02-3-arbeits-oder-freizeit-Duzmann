/*
# Java

## Zuweisungs- und logische Operatoren

### Aufgabe 2.3 Arbeits- oder Freizeit?

In der CODERS.BAY arbeiten wir von 8 bis 16 Uhr. Schreibe ein Programm, dass eine Zahl
von der Konsole einliest und ausgibt ob die Stunde in der Arbeitszeit liegt oder nicht.

Bonus: von 12 bis 13 Uhr ist immer Mittagspause, gib also in der Zeit aus, dass Mittag ist.

 */


import java.util.Scanner;

public class ArbeitFreizeit {


    public static void main(String[] args) {


        //Variablen

        int stunde10er = 0, stunde1er = 0, minute10er = 0, minute1er = 0;
        int abfrageStunde = 0;
        int abfrageMinute = 0;
        int digitCounter = 0;
        int arbeitsBeginnStunde = 8;
        int arbeitsBeginnMinute = 0;
        int arbeitsEndeStunde = 16;
        int arbeitsEndeMinute = 0;
        int mittagsPauseBeginnStunde = 12;
        int mittagsPauseBeginnMinute = 0;
        int mittagsPauseEndeStunde = 13;
        int mittagsPauseEndeMinute = 0;
        Scanner eingabe = new Scanner(System.in);
        boolean terminatorTooManyOrTooLittleDigits = false;
        boolean arbeitsZeit = false;

        //Formular


        System.out.println("- - - - - - - - - - - - - - -\n");

        System.out.print("Du möchtest wissen, wann die Leute in der Codersbay arbeiten?\nGib eine Uhrzeit ein --> ");
        String uhrZeitEingabe = eingabe.nextLine();

        if ((uhrZeitEingabe.length() == 4) || (uhrZeitEingabe.length() == 5)) {

            for (int i = 0; i < uhrZeitEingabe.length(); i++) {
                if (Character.isDigit(uhrZeitEingabe.charAt(i))) {

                    digitCounter++;

                    switch (digitCounter) {
                        case 1:
                            stunde10er = 10 * (Character.getNumericValue(uhrZeitEingabe.charAt(i)));
                            break;
                        case 2:
                            stunde1er = Character.getNumericValue(uhrZeitEingabe.charAt(i));
                            break;
                        case 3:
                            minute10er = 10 * (Character.getNumericValue(uhrZeitEingabe.charAt(i)));
                            break;
                        case 4:
                            minute1er = Character.getNumericValue(uhrZeitEingabe.charAt(i));
                            break;
                        case 5:
                            terminatorTooManyOrTooLittleDigits = true;
                            break;


                    }

                }

            }
            abfrageStunde = (stunde10er + stunde1er);
            abfrageMinute = (minute10er + minute1er);
            if (abfrageStunde > 23 || abfrageMinute > 59) {
                terminatorTooManyOrTooLittleDigits = true;
            }

        } else {
            terminatorTooManyOrTooLittleDigits = true;
        }

        if (terminatorTooManyOrTooLittleDigits == true) {
            System.out.println("Bitte verwenden Sie eine gültige Formattierung für Uhrzeiten (Beispiel: 23:45)\nProgramm beendet.");
        } else {

            // END Analyse der Eingabe

            // Vergleich Abfrage mit Öffnungszeiten

            if (abfrageStunde >= arbeitsBeginnStunde && abfrageStunde <= arbeitsEndeStunde) {
                if (abfrageStunde <= mittagsPauseBeginnStunde && abfrageStunde >= mittagsPauseEndeStunde) {
                    if (abfrageMinute >= arbeitsBeginnMinute && abfrageMinute <= arbeitsEndeMinute) {
                        if (abfrageMinute <= mittagsPauseBeginnMinute && abfrageMinute >= mittagsPauseEndeMinute) {
                            arbeitsZeit = true;
                        }
                    }

                }

            }
            if (arbeitsZeit == true) {
                System.out.println("Um " + abfrageStunde + ":" + abfrageMinute + " wird in der Codersbay gearbeitet");
            } else {
                System.out.println("Um " + abfrageStunde + ":" + abfrageMinute + " ist die Codersbay geschlossen");
            }
        }
    }


}


