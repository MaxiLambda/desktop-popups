package org.lincks.maximilian.desktop.providers.images;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;

public class ImagesProvider implements NotificationProvider {
    //TODO get all pictures from resources/images
    @Override
    public Notification random() {
        return new ImageNotification("src/main/resources/images/test.jpg");
    }

    @Override
    public int weight() {
        //TODO adjust weight based on number of images
        return 10;
    }
}
