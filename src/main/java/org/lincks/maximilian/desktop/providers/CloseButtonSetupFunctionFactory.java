package org.lincks.maximilian.desktop.providers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CloseButtonSetupFunctionFactory {

    public static BiConsumer<JFrame, JPanel> getSetupFunction() {
        return getSetupFunction(__ -> {});
    }
    public static BiConsumer<JFrame, JPanel> getSetupFunction(Consumer<JButton> onMouseEnter) {
        return (frame, panel) -> {
            //maybe make the text configurable
            final JButton closeBtn = new JButton("  ❤️");
            MouseListener listener = new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    closeBtn.setVisible(true);
                    onMouseEnter.accept(closeBtn);
                }

            };

            closeBtn.setVisible(false);
            closeBtn.addActionListener(e -> {
                frame.dispose();
                frame.removeMouseListener(listener);
            });

            panel.add(closeBtn, BorderLayout.SOUTH);

            frame.addMouseListener(listener);
        };
    }
}
