package org.lincks.maximilian.desktop.providers.images;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;

public class ImagesProvider implements NotificationProvider {
  private final List<String> imagesUrls;
  private final Random random = new Random();
  private final CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory;

  public ImagesProvider(
      CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory, String path) {
    this.closeButtonSetupFunctionFactory = closeButtonSetupFunctionFactory;
    File imagesDir = new File(path);
    if (!imagesDir.exists() || !imagesDir.isDirectory())
      throw new IllegalStateException("Images directory does not exist");

    imagesUrls =
        Arrays.stream(imagesDir.listFiles(((dir, name) -> name.endsWith(".jpg"))))
            .map(File::getAbsolutePath)
            .toList();
  }

  @Override
  public Notification random() {
    return new ImageNotification(closeButtonSetupFunctionFactory, randomImageUrl());
  }

  public String randomImageUrl() {
    return imagesUrls.get(random.nextInt(imagesUrls.size()));
  }

  @Override
  public int weight() {
    return imagesUrls.size();
  }
}
