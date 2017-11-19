/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetoloop;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author danih
 */

public class TimeToLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int cont = 0;
        long startTime = System.nanoTime();

        for(int i=0; i < 1000000000; i++) {

            cont++;
            
        }

        long timeNano = System.nanoTime() - startTime;
        
        
        System.out.printf("The average time taken was %3.6f ms%n", (double) timeNano / 1000000000);
        
        
    }
    
}
