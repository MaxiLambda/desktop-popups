package org.lincks.maximilian.desktop.providers.overlay;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;
import org.lincks.maximilian.desktop.providers.images.ImagesProvider;
import org.lincks.maximilian.desktop.providers.messages.MessageProvider;

public class OverlayProvider implements NotificationProvider {

  private final MessageProvider messageProvider;
  private final ImagesProvider imagesProvider;

  private final CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory;

  public OverlayProvider(
      MessageProvider messageProvider,
      ImagesProvider imagesProvider,
      CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory) {
    this.messageProvider = messageProvider;
    this.imagesProvider = imagesProvider;
    this.closeButtonSetupFunctionFactory = closeButtonSetupFunctionFactory;
  }

  @Override
  public Notification random() {
    return new MessageImageNotification(
        closeButtonSetupFunctionFactory,
        imagesProvider.randomImageUrl(),
        messageProvider.randomMessageString());
  }

  @Override
  public int weight() {
    return (messageProvider.weight() + imagesProvider.weight()) / 2;
  }
}
