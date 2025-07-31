package org.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SPRINGAPPLICATION {
public static void main(String[]args){
    ApplicationContext ctx= SpringApplication.run(SPRINGAPPLICATION.class,args);
    for(String bean:ctx.getBeanDefinitionNames()){
        Object o= ctx.getBean(bean);
        if(o instanceof CacheToDBSyncManager){
            CacheToDBSyncManager syncManager=(CacheToDBSyncManager) o;
            new Thread(syncManager).start();
        }
    }

}

}
