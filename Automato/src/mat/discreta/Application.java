package mat.discreta;

/**
 * @author Daniel Henrique Pereira e Isabela Queiroz
 */

import java.util.Scanner;

/**
 * Testar o Automato Finito Deterministico (AFD)
 */
public class Application
{
    /**
    * Constructor
    */
    private Application()
    {

    }
    /**
    * 
    * Método Principal (Main)
    * 
    */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Analise a sentença: ");
        String sentence = scanner.nextLine().trim();

        scanner.close();

        if(sentence.indexOf("$") >= 0)
        {
            System.out.println("A sentença \"" + sentence + "\" é inválida");

        return;
        }

        AFD afd = new AFD();

        afd.recognize(sentence);
    }
}
