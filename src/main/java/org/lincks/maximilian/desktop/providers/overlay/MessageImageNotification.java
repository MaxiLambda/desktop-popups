package org.lincks.maximilian.desktop.providers.overlay;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

public class MessageImageNotification implements Notification {

    private final ImageIcon image;
    private final String messageText;
    private static final int maxSize = 500;

    private final CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory;
    public MessageImageNotification(CloseButtonSetupFunctionFactory closeButtonSetupFunctionFactory, String imageUrl, String messageText) {
        this.closeButtonSetupFunctionFactory = closeButtonSetupFunctionFactory;
        this.messageText = messageText;
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

    @Override
    public JPanel create() {
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BorderLayout(5,5));

        JPanel panel = new JPanel();
        OverlayLayout layout = new OverlayLayout(panel);
        panel.setLayout(layout);

        JLabel textLabel = new JLabel(messageText);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
        textLabel.setAlignmentX(0.5f);
        textLabel.setAlignmentY(0.5f);
        panel.add(textLabel);

        JLabel imageLabel = new JLabel(image);
        imageLabel.setAlignmentX(0.5f);
        panel.add(imageLabel);

        panel.setSize(image.getIconWidth(), image.getIconHeight());
        wrapperPanel.add(panel, BorderLayout.CENTER);
        return wrapperPanel;
    }

    @Override
    public BiConsumer<JFrame, JPanel> setUp() {
        return (frame, panel) -> {
            closeButtonSetupFunctionFactory.getSetupFunction(closeBtn ->
                            frame.setSize(image.getIconWidth(), image.getIconHeight() + 80))
                    .accept(frame, panel);
            frame.setSize(image.getIconWidth(), image.getIconHeight());
        };
    }
}
