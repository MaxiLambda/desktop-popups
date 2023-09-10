package org.lincks.maximilian.desktop;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class Messages {


    private static final List<String> messageTexts;

    private static final Random random = new Random();

    static {
        try {
            messageTexts = Files.readAllLines(Path.of("src/main/resources/messages.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Notification random() {
        String message = messageTexts.get(random.nextInt(messageTexts.size()));
        return new Notification() {
            @Override
            public JPanel create() {
                JPanel panel = new JPanel();
                panel.add(new JLabel(message));
                panel.setSize(200, 100);
                return panel;
            }

            @Override
            public BiConsumer<JFrame, JPanel> setUp() {
                return (frame,panel) -> {
                    frame.setSize(200, 100);
                };
            }
        };
    }
}
