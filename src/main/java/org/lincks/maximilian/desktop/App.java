package org.lincks.maximilian.desktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.lincks.maximilian.desktop.core.notification.NotificationManager;
import org.lincks.maximilian.desktop.providers.images.ImagesProvider;
import org.lincks.maximilian.desktop.providers.messages.MessageProvider;
import org.lincks.maximilian.desktop.providers.overlay.OverlayProvider;

import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        //setup
        System.out.println("Starting application...");
        FlatDarculaLaf.setup();

        String resourcesDir = System.getenv("RES_DIR");

        //create providers
        ImagesProvider imagesProvider = new ImagesProvider(resourcesDir + "images");
        MessageProvider messageProvider = new MessageProvider(List.of(
                resourcesDir + "messages/messages.txt",
                resourcesDir + "messages/text-only-messages.txt"));
        MessageProvider overlayMessageProvider = new MessageProvider(List.of(
                resourcesDir + "messages/text-only-messages.txt"));

        //run app with selected providers
        new NotificationManager(List.of(
//                imagesProvider,
                messageProvider,
                new OverlayProvider(overlayMessageProvider, imagesProvider)));
    }
}
