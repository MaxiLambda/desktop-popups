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

    public MessageProvider(List<String> paths) {
        messageTexts = paths.stream()
                .map(Path::of)
                .map(path -> {
                    try {
                        return Files.readAllLines(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .flatMap(List::stream)
                .toList();
    }

    public Notification random() {
        return new MessageNotification(randomMessageString());
    }

    public String randomMessageString(){
        return messageTexts.get(random.nextInt(messageTexts.size()));
    }

    @Override
    public int weight() {
        return messageTexts.size() * 3 / 2;
    }
}
