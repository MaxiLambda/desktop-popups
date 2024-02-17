package org.lincks.maximilian.desktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.util.List;
import org.lincks.maximilian.desktop.core.notification.NotificationManager;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;
import org.lincks.maximilian.desktop.providers.images.ImagesProvider;
import org.lincks.maximilian.desktop.providers.messages.MessageProvider;
import org.lincks.maximilian.desktop.providers.overlay.OverlayProvider;

public class App {

  public static int delay = 15;
  public static int maxDuration = 90;
  public static int minDuration = 30;

  public static void main(String[] args) throws InterruptedException {

    if(args.length > 2) {
      delay = Integer.parseInt(args[0]);
      maxDuration = Integer.parseInt(args[1]);
      minDuration = Integer.parseInt(args[2]);
    }

    // setup
    System.out.println("Starting application...");
    FlatDarculaLaf.setup();

    String resourcesDir = System.getenv("RES_DIR");

    System.out.println(resourcesDir);
    CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory =
        new CloseButtonSetupFunctionFactory(new UiTexts(resourcesDir));
    // create providers
    ImagesProvider imagesProvider =
        new ImagesProvider(closeButtonSetupFunctionFactory, resourcesDir + "/images");
    MessageProvider messageProvider =
        new MessageProvider(
            closeButtonSetupFunctionFactory,
            List.of(
                resourcesDir + "/messages/messages.txt",
                resourcesDir + "/messages/text-only-messages.txt"));
    MessageProvider overlayMessageProvider =
        new MessageProvider(
            closeButtonSetupFunctionFactory,
            List.of(resourcesDir + "/messages/text-only-messages.txt"));

    // run app with selected providers
    new NotificationManager(
        List.of(
            //                imagesProvider,
            messageProvider,
            new OverlayProvider(
                overlayMessageProvider, imagesProvider, closeButtonSetupFunctionFactory)));
  }
}
