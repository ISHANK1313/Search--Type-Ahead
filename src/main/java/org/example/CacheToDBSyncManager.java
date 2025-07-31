package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheToDBSyncManager implements Runnable{
    private final SuggestionDataStructure dataStructure;
    @Autowired
    public CacheToDBSyncManager(SuggestionDataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    @Override
    public void run() {
        sync();
    }
    public void sync(){
        while(true){
            try {
                Thread.sleep(30000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("starting to sync...");
            this.dataStructure.reload();
            System.out.println("finished sync...");
        }
    }
}
