package org.lincks.maximilian.desktop.providers.messages;

import org.lincks.maximilian.desktop.core.notification.Notification;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class MessageProvider implements NotificationProvider {

    private final List<String> messageTexts;

    private final Random random = new Random();

    public MessageProvider() throws IOException {
        messageTexts = Files.readAllLines(Path.of("src/main/resources/messages.txt"));
    }

    public Notification random() {
        String message = messageTexts.get(random.nextInt(messageTexts.size()));
        return new MessageNotification(message);
    }

    @Override
    public int weight() {
        return messageTexts.size();
    }
}
