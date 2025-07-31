package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.db.FrequencyCount;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
 populateDB();
    }
    public static void populateDB(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("AccountPersistence");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<FrequencyCount> data=generateData();
        for(FrequencyCount frequencyCount:data){
            em.persist(frequencyCount);
        }
        em.getTransaction().commit();
        em.close();
    }
    public static List<FrequencyCount> generateData(){
        List<FrequencyCount>data=new ArrayList<>();
        String alphabets="abc";
        Map<String,Integer>freqMap=new HashMap<>();
        Random r= new Random();
        for(int i=0;i<100000;i++){
            int length=r.nextInt(1,7);
            String query="";
            for(int j=0;j<length;j++){
                query+=alphabets.charAt(r.nextInt(0,3));
            }
            if(freqMap.containsKey(query)){
                freqMap.put(query, freqMap.get(query)+1);
            }
            else{
                freqMap.put(query,1);
            }
        }
        for(Map.Entry<String,Integer>entry:freqMap.entrySet()){
            FrequencyCount frequencyCount=new FrequencyCount();
            frequencyCount.setQuery(entry.getKey());
            frequencyCount.setFrequency(entry.getValue());
            data.add(frequencyCount);
        }
        return data;
    }
}