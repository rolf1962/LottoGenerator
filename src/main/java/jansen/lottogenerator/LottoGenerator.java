/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package jansen.lottogenerator;

import jansen.lottogenerator.model.SixOfFortyNinePojo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Rolf
 */
public class LottoGenerator {

    public static void main(String[] args) {
        int t = 0;
        ArrayList<SixOfFortyNinePojo> rows = new ArrayList<>();
        SixOfFortyNine sixOfFortyNine = new SixOfFortyNine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // user input for number of rows to generate
        System.out.println("How many Lotto 6/49 rows do you wish to generate?");
        try {
            t = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("****************");

        for (int a = 1; a <= t; a++) {
            rows.add(sixOfFortyNine.CreateRow());
        }

        for (SixOfFortyNinePojo sixOfFortyNinePojo : rows) {
            System.out.println(sixOfFortyNinePojo.toString());
        }
    }
}
