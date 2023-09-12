package org.lincks.maximilian.desktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.lincks.maximilian.desktop.core.notification.NotificationManager;
import org.lincks.maximilian.desktop.providers.images.ImagesProvider;
import org.lincks.maximilian.desktop.providers.messages.MessageProvider;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException, IOException {
        //setup
        System.out.println("Starting application...");
        FlatDarculaLaf.setup();
        new NotificationManager(List.of(new ImagesProvider(), new MessageProvider()));
    }
}
