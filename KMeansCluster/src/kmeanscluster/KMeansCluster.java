/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeanscluster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author daniel
 */


public class KMeansCluster {
    
    // Group count
    int cont = 0;
    
    // All ages by key
    public HashMap<Integer, Integer> hashmap = new HashMap();
    
    // Clusters
    public HashMap<Integer, Integer> cluster1 = new HashMap<>();
    public HashMap<Integer, Integer> cluster2 = new HashMap<>();
    public HashMap<Integer, Integer> cluster3 = new HashMap<>();
    public HashMap<Integer, Integer> cluster4 = new HashMap<>();
    public HashMap<Integer, Integer> cluster5 = new HashMap<>();
    public HashMap<Integer, Integer> cluster6 = new HashMap<>();
    public HashMap<Integer, Integer> cluster7 = new HashMap<>();
   
    public KMeansCluster(String file){
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String text = sb.toString();
            clustering(text);
            br.close();
            
        } catch(FileNotFoundException e){
            e.printStackTrace();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void clustering(String everything) throws IOException{
        
        int chaves = 1;
       
        String [] array = everything.split("::");
        for(int i = 2; i < array.length; i+=4){
            hashmap.put(chaves, Integer.parseInt(array[i]));
            chaves++;     
        }
        
        System.out.println("Age Cluster: ");
        System.out.println(hashmap);
        System.out.println("");
        
        for(Integer i : hashmap.keySet()){
            switch(hashmap.get(i)){
                case 1:
                    cluster1(i);
                break;
                case 18:
                    cluster2(i);
                break;
                case 25:
                    cluster3(i);
                break;
                case 35:
                    cluster4(i);
                break;
                case 45:
                    cluster5(i);
                break;
                case 50:
                    cluster6(i);
                break;
                case 56:
                    cluster7(i);
                break;
                default:
                    System.out.println("Nothing to cluster");
                            
            }
        }
        
        writeCluster(cluster1);
        writeCluster(cluster2);
        writeCluster(cluster3);
        writeCluster(cluster4);
        writeCluster(cluster5);
        writeCluster(cluster6);
        writeCluster(cluster7);
        
    }
    
    private void cluster1(Integer element) throws IOException{
        
        cluster1.put(element, hashmap.get(element));

    }
    
    private void cluster2(Integer element){
        
        cluster2.put(element, hashmap.get(element));
       
    }
    
    private void cluster3(Integer element){
        
        cluster3.put(element, hashmap.get(element));
       
    }
        
    private void cluster4(Integer element){
        
        cluster4.put(element, hashmap.get(element));

    }

    private void cluster5(Integer element){
        
        cluster5.put(element, hashmap.get(element));

    }
    
    private void cluster6(Integer element){
        
        cluster6.put(element, hashmap.get(element));    

    }
    
    private void cluster7(Integer element){
        
        cluster7.put(element, hashmap.get(element));
       
    }
    
    public void writeCluster(HashMap<Integer, Integer> cluster) throws IOException{
         
        FileWriter fstream;
        BufferedWriter out;
        
        cont++;

        fstream = new FileWriter("Group_" + cont + "_Size_" + cluster.size() + "_.txt");
        out = new BufferedWriter(fstream);

        int count = 0;

        Iterator<Entry<Integer, Integer>> it = cluster.entrySet().iterator();
        out.write("ID::Idade\n");

        while (it.hasNext() && count < cluster.size()) {

            Map.Entry<Integer, Integer> pairs = it.next();

            out.write(pairs.getKey() + "::" + pairs.getValue() + "\n");
            count++;
        }
        
        out.close();
        
    }
    
    public void printClusters(){
        
        System.out.println("Cluster 1:");
        System.out.println(cluster1);
        
        System.out.println("Cluster 2:");
        System.out.println(cluster2);
        
        System.out.println("Cluster 3:");
        System.out.println(cluster3);
           
        System.out.println("Cluster 4:");
        System.out.println(cluster4);
        
        System.out.println("Cluster 5:");
        System.out.println(cluster5);
                
        System.out.println("Cluster 6:");
        System.out.println(cluster6);
        
        System.out.println("Cluster 7:");
        System.out.println(cluster7);
        
    }
    
   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        KMeansCluster kMeansCluster = new KMeansCluster("pessoas.txt");
        kMeansCluster.printClusters();
     
    }
    
}
