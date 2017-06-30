package mat.discreta;

/**
 * @author Daniel Henrique Pereira and Isabela Queiroz
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Automato Finito Deterministico (AFD)
 */
public class AFD
{
    /**
    * Estados do Automato Finito Deterministico (AFD)
    */
    private Map<Integer, State> states;

    /**
    * Constructor
    */
    public AFD()
    {
        states = new HashMap<>();

        State q0 = new State(false);
        q0.addTransition('+', 1);
        q0.addTransition('-', 1);
        q0.addTransition(',', 1);
        q0.addTransition('0', 3);
        q0.addTransition('1', 3);
        q0.addTransition('2', 3);
        q0.addTransition('3', 3);
        q0.addTransition('4', 3);
        q0.addTransition('5', 3);
        q0.addTransition('6', 3);
        q0.addTransition('8', 3);
        q0.addTransition('9', 3);
        q0.addTransition('E', 2);
        q0.addTransition('.', 2);
        states.put(0, q0);

        State q1 = new State(false);
        q1.addTransition('0', 3);
        q1.addTransition('1', 3);
        q1.addTransition('2', 3);
        q1.addTransition('3', 3);
        q1.addTransition('4', 3);
        q1.addTransition('5', 3);
        q1.addTransition('6', 3);
        q1.addTransition('8', 3);
        q1.addTransition('9', 3);
        q1.addTransition('.', 2);
        states.put(1, q1);

        State q2 = new State(false);
        q2.addTransition('0', 5);
        q2.addTransition('1', 5);
        q2.addTransition('2', 5);
        q2.addTransition('3', 5);
        q2.addTransition('4', 5);
        q2.addTransition('5', 5);
        q2.addTransition('6', 5);
        q2.addTransition('8', 5);
        q2.addTransition('9', 5);
        states.put(2, q2);

        State q3 = new State(true);
        q3.addTransition('E', 6);
        q3.addTransition('0', 3);
        q3.addTransition('1', 3);
        q3.addTransition('2', 3);
        q3.addTransition('3', 3);
        q3.addTransition('4', 3);
        q3.addTransition('5', 3);
        q3.addTransition('6', 3);
        q3.addTransition('8', 3);
        q3.addTransition('9', 3);
        q3.addTransition('.', 4);
        q3.addTransition('$', 3);
        states.put(3, q3);

        State q4 = new State(false);
        q4.addTransition('0', 5);
        q4.addTransition('1', 5);
        q4.addTransition('2', 5);
        q4.addTransition('3', 5);
        q4.addTransition('4', 5);
        q4.addTransition('5', 5);
        q4.addTransition('6', 5);
        q4.addTransition('8', 5);
        q4.addTransition('9', 5);
        states.put(4, q4);

        State q5 = new State(true);
        q5.addTransition('0', 5);
        q5.addTransition('1', 5);
        q5.addTransition('2', 5);
        q5.addTransition('3', 5);
        q5.addTransition('4', 5);
        q5.addTransition('5', 5);
        q5.addTransition('6', 5);
        q5.addTransition('8', 5);
        q5.addTransition('9', 5);
        q5.addTransition('E', 6);
        q5.addTransition('$', 5);
        states.put(5, q5);

        State q6 = new State(false);
        q6.addTransition('+', 8);
        q6.addTransition('-', 8);
        q6.addTransition(',', 8);
        q6.addTransition('0', 9);
        q6.addTransition('1', 9);
        q6.addTransition('2', 9);
        q6.addTransition('3', 9);
        q6.addTransition('4', 9);
        q6.addTransition('5', 9);
        q6.addTransition('6', 9);
        q6.addTransition('8', 9);
        q6.addTransition('9', 9);
        states.put(6, q6);

        State q8 = new State(false);
        q8.addTransition('0', 9);
        q8.addTransition('1', 9);
        q8.addTransition('2', 9);
        q8.addTransition('3', 9);
        q8.addTransition('4', 9);
        q8.addTransition('5', 9);
        q8.addTransition('6', 9);
        q8.addTransition('8', 9);
        q8.addTransition('9', 9);
        states.put(8, q8);

        State q9 = new State(true);
        q9.addTransition('0', 9);
        q9.addTransition('1', 9);
        q9.addTransition('2', 9);
        q9.addTransition('3', 9);
        q9.addTransition('4', 9);
        q9.addTransition('5', 9);
        q9.addTransition('6', 9);
        q9.addTransition('8', 9);
        q9.addTransition('9', 9);
        q9.addTransition('$', 9);
        states.put(9, q9);
    }

    /**
     * Formatar o estado para impressao
     *
     * @param state estado
     * @return estado formatado para impressao
     */
    private String formatState(Integer state)
    {
        if((states.size() < 100) && (state < 10))
        {
            return "\nq" + state + "  - ";
        }

        return "\nq" + state + " - ";
    }

    /**
     * Reconhecer a sentenca de entrada
     *
     * @param sentence sentenca de entrada
     * @return true caso a sentenca de entrada pertenca a linguagem,
     *   false em caso contrario
     */
    public boolean recognize(String sentence)
    {
        String input = sentence + "$";

        System.out.print("Observação: \"$\" representa o fim da sentença");

        Integer state = 0;

        int length = input.length();

        for(int symbol = 0; symbol < length; symbol++)
        {
            System.out.print(formatState(state));

            for(int index = 0; index < length; index++)
            {
                if(index != symbol)
                {
                    System.out.print(" " + input.charAt(index) + " ");
                }
                else
                {
                    System.out.print("[" + input.charAt(index) + "]");
                }
            }

            state = states.get(state).getTransition(input.charAt(symbol));

            if(state == null)
            {
                System.out.println(" - REJEITA");

                return false;
            }
        }

        if(states.get(state).isAccept())
        {
            System.out.println(" - ACEITA");
        }
        else
        {
            System.out.println(" - REJEITA");
        }

        return states.get(state).isAccept();
    }
}