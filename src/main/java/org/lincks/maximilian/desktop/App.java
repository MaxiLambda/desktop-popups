package org.lincks.maximilian.desktop;

import com.formdev.flatlaf.FlatDarculaLaf;


public class App {

    public App() throws InterruptedException {
        new NotificationManager();
    }


    public static void main(String[] args) throws InterruptedException {
        //setup
        System.out.println("Starting application...");
        FlatDarculaLaf.setup();
        new App();
    }
}
