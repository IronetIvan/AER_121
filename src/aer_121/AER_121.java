/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aer_121;

import java.util.Scanner;

/**
 *
 * @author irone
 */
public class AER_121 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {

            int cambio = in.nextInt();  // numero minimo de chicles para oferta
            int oferta = in.nextInt();  // numero de chicles por oferta
            int totalInicial = in.nextInt();  // numero total de chicles

            if ((cambio == 0) && (oferta == 0) && (totalInicial == 0)) {
                break;
            }

            if (oferta >= cambio) {
                System.out.println("RUINA");
                System.exit(0);
            }

            boolean error = false;

            int paraCanjear = totalInicial;
            int comidos = totalInicial;
            //int resto = 0;
            int anterior = 0;

            while (paraCanjear >= cambio) {

                anterior = paraCanjear;

                // Canjeo
                int regalo = ((int) (paraCanjear / cambio)) * oferta;
                paraCanjear = ((int) (paraCanjear % cambio));

                comidos = comidos + regalo;
                paraCanjear = paraCanjear + regalo;

                if (paraCanjear >= anterior) {
                    error = true;
                    break;
                }
            }

            if (error) {
                System.out.println("RUINA");
            } else {
                System.out.println(comidos + " " + paraCanjear);
            }

        }
    }
}
