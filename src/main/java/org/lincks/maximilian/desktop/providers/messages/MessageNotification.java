package org.lincks.maximilian.desktop.providers.messages;

import org.lincks.maximilian.desktop.core.notification.Notification;

import javax.swing.*;
import java.util.function.BiConsumer;

public class MessageNotification implements Notification {

    private final String message;

    public MessageNotification(String message) {
        this.message = message;
    }

    @Override
    public JPanel create() {
        JPanel panel = new JPanel();
        panel.add(new JLabel(message));
        panel.setSize(200, 100);
        return panel;
    }

    @Override
    public BiConsumer<JFrame, JPanel> setUp() {
        return (frame, panel) -> frame.setSize(200, 100);
    }
}
