package org.lincks.maximilian.desktop.providers.images;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ImagesProvider implements NotificationProvider {
    List<String> imagesUrls;
    private final Random random = new Random();

    public ImagesProvider() {
        File imagesDir = new File("src/main/resources/images");
        if (!imagesDir.exists() || !imagesDir.isDirectory())
            throw new IllegalStateException("Images directory does not exist");

        imagesUrls = Arrays.stream(imagesDir.listFiles(((dir, name) -> name.endsWith(".jpg"))))
                .map(File::getAbsolutePath)
                .toList();
    }

    @Override
    public Notification random() {
        String imageUrl = imagesUrls.get(random.nextInt(imagesUrls.size()));
        return new ImageNotification(imageUrl);
    }

    @Override
    public int weight() {
        return imagesUrls.size();
    }
}
