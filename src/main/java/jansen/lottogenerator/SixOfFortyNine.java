/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jansen.lottogenerator;

import jansen.lottogenerator.model.SixOfFortyNinePojo;

/**
 * Klasse zur Erzeugung von Zahlenreihen (Lotto 6 aus 49). 
 * @see jansen.lottogenerator.model.SixOfFortyNinePojo.SixOfFortyNinePojo
 * @author Rolf
 */
public class SixOfFortyNine {

    private static final int MAX = 49;
    private static final int MIN = 1;
    private static final int RANGE = MAX - MIN + 1;

    /**
     * Erzeugt eine zufällige, sortierte Zahlenreihe ohne Duplikate
     * 
     * @return A row of @see jansen.lottogenerator.model.SixOfFortyNinePojo.SixOfFortyNinePojo
     */
    public SixOfFortyNinePojo CreateRow() {
        SixOfFortyNinePojo returnValue = new SixOfFortyNinePojo();
        int num[] = new int[6];

        for (int i = 0; i < 6; i++) {
            num[i] = (int) (Math.random() * RANGE) + MIN;

            // duplicate check
            for (int x = 0; x < i; x++) {
                if (num[x] == num[i]) {
                    i--;
                }
            } // end check
        }

        // start sort
        for (int p = 0; p < 6; p++) {
            for (int q = 0; q < 6; q++) {
                if (num[p] < num[q]) {
                    int temp = num[p];
                    num[p] = num[q];
                    num[q] = temp;
                }
            }
        } // end sort

        returnValue.setZ1(num[0]);
        returnValue.setZ2(num[1]);
        returnValue.setZ3(num[2]);
        returnValue.setZ4(num[3]);
        returnValue.setZ5(num[4]);
        returnValue.setZ6(num[5]);

        return returnValue;
    }
}
