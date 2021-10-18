package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    ConcurrentLinkedQueue<Integer> clientCallCenter = new ConcurrentLinkedQueue<>();
    volatile boolean cycle = true;
    String str;
    public void addCall(int i){
        clientCallCenter.add(i);
        System.out.println("****Добавлен звонок в очередь " + i);
    }

    public void getCall(){
        str = Integer.toString(clientCallCenter.poll());
        if(!(str.equals(null))) {
            System.out.println("-----Принят звонок " + str);
        }
    }
    public void editCycle(){
        cycle = false;
    }
}
