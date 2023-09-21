package org.lincks.maximilian.desktop.providers.messages;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.providers.CloseButtonSetupFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

public class MessageNotification implements Notification {

    private final String message;

    public MessageNotification(String message) {
        this.message = message;
    }

    @Override
    public JPanel create() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5,5));
        panel.add(new JLabel(message), BorderLayout.CENTER);
        panel.setSize(250, 100);
        return panel;
    }

    @Override
    public BiConsumer<JFrame, JPanel> setUp() {
        return (frame, panel) -> {
            CloseButtonSetupFunctionFactory.getSetupFunction().accept(frame, panel);
            frame.setSize(250, 100);
        };
    }
}
