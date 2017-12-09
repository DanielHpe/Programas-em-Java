public class Main {
    
    public static void main(String[] args){
        
        Main.printNumberLine(0, 5);
        System.out.println("\n");
        
        Main.printNumberDiamond(5);
        System.out.println("");
    }
    
    public static void printNumberLine(int seqCenter, int length) {

        int sentence = 0;
        int numberOfSpaces;
        int i = 0;

        if(seqCenter == 0){
            sentence = 1;
        }     

        if(seqCenter > 0){
           sentence = (seqCenter + 1) + seqCenter;
        } 

        numberOfSpaces = (length - sentence) / 2;

        System.out.print("(");
        for(i = 0; i < numberOfSpaces; i++){
            System.out.print(" ");
        }

        for(i = 0; i <= seqCenter; i++){
            System.out.print(i);
        }

        for(i = seqCenter - 1; i >= 0; i--){        
            System.out.print(i);        
        }

        for(i = 0; i < numberOfSpaces; i++){
            System.out.print(" ");
        }     
        System.out.print(")");
        
    }
    
    public static void printNumberDiamond(int diaCenter) {
        
        int sentence = 0;
        int numberOfSpaces = 0;
        int condicao = 0;
        int i = 0;
        int contEspacos = diaCenter;
        
        while(condicao <= diaCenter){
            
            numberOfSpaces = contEspacos;
            
            for(i = 0; i < numberOfSpaces; i++){
                System.out.print(" ");
            } 
            for(i = 0; i <= condicao; i++){
                System.out.print(i);
            }
            for(i = condicao - 1; i >= 0; i--){        
                System.out.print(i);        
            }
            for(i = 0; i < numberOfSpaces; i++){
                System.out.print(" ");
            }     
            
            contEspacos--;
            condicao++;
            System.out.println("");
                 
        }
       
        condicao = diaCenter - 1;
        contEspacos = 0;
        
        while(condicao >= 0){
            
       
            contEspacos++;
            numberOfSpaces = contEspacos;
            
            for(i = 0; i < numberOfSpaces; i++){
                System.out.print(" ");
            } 
            for(i = 0; i <= condicao; i++){
                System.out.print(i);
            }
            for(i = condicao - 1; i >= 0; i--){        
                System.out.print(i);        
            }
            for(i = 0; i < numberOfSpaces; i++){
                System.out.print(" ");
            }     
            
            condicao--;
            System.out.println("");
        }
    
    }
    
}

