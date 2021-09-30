package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    ConcurrentLinkedQueue<Integer> clientCallCenter = new ConcurrentLinkedQueue<>();

    public void addCall(int i){
        clientCallCenter.add(i);
        System.out.println("****Добавлен звонок в очередь " + i);
    }

    public void getCall(){
        System.out.println("-----Принят звонок " + clientCallCenter.remove());
    }
}
