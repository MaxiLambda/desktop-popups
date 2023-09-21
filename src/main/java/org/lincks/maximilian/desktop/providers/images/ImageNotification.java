package org.lincks.maximilian.desktop.providers.images;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;

import javax.swing.*;
import java.util.function.BiConsumer;

public class ImageNotification implements Notification {

    private final ImageIcon image;
    private static final int maxSize = 500;

    public ImageNotification(String imageUrl) {
        ImageIcon rawImage = new ImageIcon(imageUrl);
        //sets the maximum size of the image to 500px in each dimension
        //scales the picture if it is too big
        if (rawImage.getIconWidth() > maxSize) {
            int newHeight = rawImage.getIconHeight() * maxSize / rawImage.getIconWidth();
            this.image = new ImageIcon(rawImage
                    .getImage()
                    .getScaledInstance(maxSize, newHeight, java.awt.Image.SCALE_SMOOTH));
        } else if (rawImage.getIconHeight() > maxSize) {
            int newWidth = rawImage.getIconWidth() * maxSize / rawImage.getIconHeight();
            this.image = new ImageIcon(rawImage
                    .getImage()
                    .getScaledInstance(newWidth, maxSize, java.awt.Image.SCALE_SMOOTH));
        } else {
            this.image = rawImage;
        }

    }
// x > 500 => 500 / x = y | y < 1


    @Override
    public JPanel create() {
        JPanel panel = new JPanel();
        panel.add(new JLabel(image));
        panel.setSize(image.getIconWidth(), image.getIconHeight());
        return panel;
    }

    @Override
    public BiConsumer<JFrame, JPanel> setUp() {
        return (frame, panel) -> {
            CloseButtonSetupFunctionFactory.getSetupFunction(closeBtn ->
                            frame.setSize(image.getIconWidth(), image.getIconHeight() + 80))
                    .accept(frame, panel);
            frame.setSize(image.getIconWidth(), image.getIconHeight());
        };
    }
}
