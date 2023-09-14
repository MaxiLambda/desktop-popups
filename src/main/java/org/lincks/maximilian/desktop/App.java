package org.lincks.maximilian.desktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.lincks.maximilian.desktop.core.notification.NotificationManager;
import org.lincks.maximilian.desktop.providers.images.ImagesProvider;
import org.lincks.maximilian.desktop.providers.messages.MessageProvider;
import org.lincks.maximilian.desktop.providers.overlay.OverlayProvider;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException, IOException {
        //setup
        System.out.println("Starting application...");
        FlatDarculaLaf.setup();

        //create providers
        ImagesProvider imagesProvider = new ImagesProvider("src/main/resources/images");
        MessageProvider messageProvider = new MessageProvider(List.of(
                "src/main/resources/messages/messages.txt",
                "src/main/resources/messages/text-only-messages.txt"));
        MessageProvider overlayMessageProvider = new MessageProvider(List.of(
                "src/main/resources/messages/text-only-messages.txt"));

        //run app with selected providers
        new NotificationManager(List.of(
//                imagesProvider,
                messageProvider,
                new OverlayProvider(overlayMessageProvider, imagesProvider)));
    }
}
