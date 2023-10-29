/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package jansen.lottogenerator;

import jansen.lottogenerator.model.SixOfFortyNinePojo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hauptprogramm des Lottozahlengenerators. Erzeugt wird die gewünschte Anzahl
 * Zahlenreihen für "Lotto 6/49". Wahlweise können die Zahlenreihen in eine
 * Datenbank geschrieben werden.
 *
 * @author Rolf
 */
public class LottoGenerator {

    public static void main(String[] args) {
        int t = 0;
        String s;
        Boolean saveToDb = true;
        HibernateUtil hibernateUtil = new HibernateUtil();
        ArrayList<SixOfFortyNinePojo> rows = new ArrayList<>();
        SixOfFortyNine sixOfFortyNine = new SixOfFortyNine();
        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(System.in));
        // Eingabe der gewünschten Anzahl Zahlenreihen
        System.out.println("Wie viele Lotto 6/49 Zahlenreihen sollen es werden?");
        try {
            t = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        br = new BufferedReader(new InputStreamReader(System.in));
        // Angabe, ob in die Datenbank gespeichert werden soll
        System.out.println("Soll in die Datenbank gespeichert werden (J/n)?");
        try {
            String[] no = {"N", "n"};
            s = br.readLine();
            if (Arrays.asList(no).contains(s)) {
                saveToDb = false;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("****************");

        // Zahlenreihen erzeugen
        for (int a = 1; a <= t; a++) {
            rows.add(sixOfFortyNine.CreateRow());
        }

        int i = 1;  // Zähler für die gespeicherte Zahlenreihen
        for (SixOfFortyNinePojo row : rows) {
            if (saveToDb) {
                hibernateUtil.save(row);
            }
            // Fortschrittanzeige
            System.out.println(String.format("%07d\t\t%s", i++, row.toString()));
        }
    }
}
