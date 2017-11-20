package pesquisas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author daniel.pereira
 */

public class BinarySearchTree {
    
    //Root de teste (Raíz)
    public static Node root;
    ////////////////////////
    public static Node root1;
    public static Node root2;
    public static Node root3;
    
    public int[] vetor1 = new int[10];
    public int[] vetor2;
    public int[] vetor3;
    
    //Instanciando classe Random
    Random random = new Random();
    
    public int randomTamanho;
    
    public BinarySearchTree(int [] vetor1, int [] vetor2, int [] vetor3, int randomTamanho){
        this.root = null;
        this.root1 = null;
        this.root2 = null;
        this.root3 = null;
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
        this.randomTamanho = randomTamanho;
    }

    //Método que pesqusa nas árvores binárias
    //São feito pesquisas de 100 valores aleatórios de 0 à 100.000
    public void pesquisaBinaria(){
        
        int randomValor;
        int valorBuscado;
        int contArvore1 = 0;
        int contArvore2 = 0;
        int contArvore3 = 0;
        int numComparacoes1 = 0;
        int numComparacoes2 = 0;
        int numComparacoes3 = 0;
        
        //ArrayLists que recebem os valores encontrados na Busca
        ArrayList<Integer> valoresEncontradosArvore1 = new ArrayList<>();
        ArrayList<Integer> valoresEncontradosArvore2 = new ArrayList<>();      
        ArrayList<Integer> valoresEncontradosArvore3 = new ArrayList<>();
        
        //ArrayLists para eliminação de pesquisa de um mesmo valor
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> nums3 = new ArrayList<>();
        
        //Arraylist recebe randomTamanho valores em suas randomTamanho posições
        for(int i = 0; i < 20000; i++){
            nums1.add(i);
        }
        
        //Arraylist recebe randomTamanho valores em suas randomTamanho posições
        for(int i = 0; i < 20000; i++){
            nums2.add(i);
        }
        
        //Arraylist recebe randomTamanho valores em suas randomTamanho posições
        for(int i = 0; i < 20000; i++){
            nums3.add(i);
        }
        
        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime1 = System.nanoTime();
        
        //Node current percorre toda a árvore
        //Current recebe primariamente a raíz, para percorre-la
        Node current1 = root1;
        for(int i = 0; i < 100; i++){
             //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums1.size()); //
            valorBuscado = nums1.get(randomValor); //valor a ser buscado recebe o valor do array no indice (randomValor)
            nums1.remove(randomValor); //Remover o indice sorteado para eliminar as repetições
            while(current1 != null){ //Enquanto current for null (Existir nós), percorre a árvore em busca do valor
                if(current1.data == valorBuscado){ //Se encontrar
                    contArvore1++; //contador de valores encontrados recebe +1;
                    numComparacoes1++; //Valor de comparacões recebe +1
                //    valoresEncontradosArvore1.add(current1.data); //ArrayList de valores encontrados recebe o valor
                }else if(current1.data > valorBuscado){ //Se o campo data de Current for maior que o valor buscado
                    current1 = current1.left; //Current recebe seu nó esquerdo (Node esquerdo)
                }else{ //Senão for maior, for menor
                    current1 = current1.right; //Current recebe seu nó direito
            }
        }}
        
        long timeNano = System.nanoTime() - startTime1;

        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime2 = System.nanoTime();
        
        //Node current percorre toda a árvore
        //Current recebe primariamente a raíz, para percorre-la
        Node current2 = root2;
        for(int i = 0; i < 100; i++){
             //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums2.size()); //
            valorBuscado = nums2.get(randomValor); //valor a ser buscado recebe o valor do array no indice (randomValor)
            nums2.remove(randomValor); //Remover o indice sorteado para eliminar as repetições
            while(current2 != null){ //Enquanto current for null (Existir nós), percorre a árvore em busca do valor
                if(current2.data == valorBuscado){ //Se encontrar
                    contArvore2++; //contador de valores encontrados recebe +1;
                    numComparacoes2++; //Valor de comparacões recebe +1
                //    valoresEncontradosArvore2.add(current2.data); //ArrayList de valores encontrados recebe o valor
                }else if(current2.data > valorBuscado){ //Se o campo data de Current for maior que o valor buscado
                    current2 = current2.left; //Current recebe seu nó esquerdo (Node esquerdo)
                }else{ //Senão for maior, for menor
                    current2 = current2.right; //Current recebe seu nó direito
            }
        }}
        
        long timeNano2 = System.nanoTime() - startTime2;
        
        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime3 = System.nanoTime();
        
        //Node current percorre toda a árvore
        //Current recebe primariamente a raíz, para percorre-la
        Node current3 = root3;
        for(int i = 0; i < 100; i++){
             //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums3.size()); //
            valorBuscado = nums3.get(randomValor); //valor a ser buscado recebe o valor do array no indice (randomValor)
            nums3.remove(randomValor); //Remover o indice sorteado para eliminar as repetições
            while(current3 != null){ //Enquanto current for null (Existir nós), percorre a árvore em busca do valor
                if(current3.data == valorBuscado){ //Se encontrar
                    contArvore3++; //contador de valores encontrados recebe +1;
                    numComparacoes3++; //Valor de comparacões recebe +1
                //    valoresEncontradosArvore3.add(current3.data); //ArrayList de valores encontrados recebe o valor
                }else if(current3.data > valorBuscado){ //Se o campo data de Current for maior que o valor buscado
                    current3 = current3.left; //Current recebe seu nó esquerdo (Node esquerdo)
                }else{ //Senão for maior, for menor
                    current3 = current3.right; //Current recebe seu nó direito
            }
        }}
        
        long timeNano3 = System.nanoTime() - startTime3;
        
        //Impressão das informações:
        //Numeros de valores encontrados em cada Arvore
        //Array de valores encontrados em cada Arvore
        //Numero de comparacoes do valor buscado com a posição na Arvore de cada Arvore (1, 2 e 3)
        System.out.println("Foram encontrados " + contArvore1 + " valores na pesquisa randômica da Arvore 1");
        System.out.print("Valores encontrados na Arvore 1: ");
//        for(int i = 0; i < valoresEncontradosArvore1.size(); i++){
//            System.out.print(valoresEncontradosArvore1.get(i) + " ");
//        }
        System.out.println("\nNumero de comparacoes na Arvore 1 é: " + numComparacoes1);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano / 1000000);
        
        System.out.println("\nForam encontrados " + contArvore2 + " valores na pesquisa randômica da Arvore 2"); 
        System.out.print("Valores encontrados na Arvore 2: ");
//        for(int i = 0; i < valoresEncontradosArvore2.size(); i++){
//            System.out.print(valoresEncontradosArvore2.get(i) + " ");
//        }
        System.out.println("\nNumero de comparacoes na Arvore 2 é: " + numComparacoes2);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano2 / 1000000);
        
        System.out.println("\nForam encontrados " + contArvore3 + " valores na pesquisa randômica da Arvore 3"); 
        System.out.print("Valores encontrados na Arvore 3: ");
//        for(int i = 0; i < valoresEncontradosArvore3.size(); i++){
//            System.out.print(valoresEncontradosArvore3.get(i) + " ");
//        }
        System.out.println("\nNumero de comparacoes na Arvore 3 é: " + numComparacoes3);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano3 / 1000000);
        System.out.println("\n");

    }
//    
//    public boolean delete(int id){
//        Node parent = root;
//        Node current = root;
//        boolean isLeftChild = false;
//        while(current.data!=id){
//            parent = current;
//            if(current.data>id){
//                    isLeftChild = true;
//                    current = current.left;
//            }else{
//                    isLeftChild = false;
//                    current = current.right;
//            }
//            if(current ==null){
//                    return false;
//            }
//        }
//        //if i am here that means we have found the node
//        //Case 1: if node to be deleted has no children
//        if(current.left==null && current.right==null){
//            if(current==root){
//                    root = null;
//            }
//            if(isLeftChild ==true){
//                    parent.left = null;
//            }else{
//                    parent.right = null;
//            }
//        }
//        
//        //Case 2 : if node to be deleted has only one child
//        else if(current.right==null){
//            if(current==root){
//                    root = current.left;
//            }else if(isLeftChild){
//                    parent.left = current.left;
//            }else{
//                    parent.right = current.left;
//            }
//        }
//        else if(current.left==null){
//            if(current==root){
//                    root = current.right;
//            }else if(isLeftChild){
//                    parent.left = current.right;
//            }else{
//                    parent.right = current.right;
//            }
//        }else if(current.left!=null && current.right!=null){
//
//            //now we have found the minimum element in the right sub tree
//            Node successor	 = getSuccessor(current);
//            if(current==root){
//                    root = successor;
//            }else if(isLeftChild){
//                    parent.left = successor;
//            }else{
//                    parent.right = successor;
//            }			
//            successor.left = current.left;
//        }		
//        return true;		
//    }

//    public Node getSuccessor(Node deleleNode){
//        Node successsor =null;
//        Node successsorParent =null;
//        Node current = deleleNode.right;
//        while(current!=null){
//                successsorParent = successsor;
//                successsor = current;
//                current = current.left;
//        }
//        //check if successor has the right child, it cannot have left child for sure
//        // if it does have the right child, add it to the left of successorParent.
////		successsorParent
//        if(successsor!=deleleNode.right){
//            successsorParent.left = successsor.right;
//            successsor.right = deleleNode.right;
//        }
//        return successsor;
//    }
    
    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
                root = newNode;
                return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){				
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    public void insertVetor1(int id){
        Node newNode = new Node(id);
        if(root1==null){
            root1 = newNode;
            return;
        }
        Node current = root1;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){				
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    
    public void insertVetor2(int id){
        Node newNode = new Node(id);
        if(root2==null){
            root2 = newNode;
            return;
        }
        Node current = root2;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){				
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    public void insertVetor3(int id){
        Node newNode = new Node(id);
        if(root3==null){
            root3 = newNode;
            return;
        }
        Node current = root3;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){				
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
     
    public void display(Node root){
        if(root != null){
            display(root.left);
            System.out.print(" "  + root.data);
            display(root.right);
        }
    }
    
    public void dados(){
        
        this.insert(3);this.insert(8);
        this.insert(1);this.insert(4);this.insert(6);this.insert(2);this.insert(10);this.insert(9);
        this.insert(20);this.insert(25);this.insert(15);this.insert(16);
        
        //Inserindo na árvore do Vetor 1
        for(int i = 0; i < vetor1.length; i++){
            this.insertVetor1(vetor1[i]);
        }
        
        //Inserindo na árvore do Vetor 2
        for(int i = 0; i < vetor2.length; i++){
            this.insertVetor2(vetor2[i]);
        }
        
        //Inserindo na árvore do Vetor 3
        for(int i = 0; i < vetor3.length; i++){
            this.insertVetor3(vetor3[i]);
        }   
        
        System.out.print("Árvore de Teste:");
        this.display(this.root);
        System.out.println("\n");
        
        System.out.print("Árvore 1:");
        this.display(this.root1);
        System.out.println("\n");
        System.out.print("Árvore 2:");
        this.display(this.root2);
        System.out.println("\n");
        System.out.print("Árvore 3:");
        this.display(this.root3);
        System.out.println("\n");
        
        System.out.println("");
 //       System.out.println("Check whether Node with value 4 exists : " + this.pesquisaBinaria());
//        System.out.println("Delete Node with no children (2) : " + b.delete(2));		
//        b.display(root);
//        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
//        b.display(root);
//        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
//        b.display(root);
//        System.out.println("\n");

    }
}
    

