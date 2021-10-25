package org.example;

import java.util.concurrent.LinkedBlockingQueue;

public class App
{
    public static void main(String[] args) {
    LinkedBlockingQueue<Integer> callCenter = new LinkedBlockingQueue<>();

    IncomingCalls incomingCalls = new IncomingCalls(callCenter);
    AnswerCallCenter answerCallCenter = new AnswerCallCenter(callCenter);

        (new Thread(incomingCalls)).start();
        (new Thread(answerCallCenter)).start();

    }
}
