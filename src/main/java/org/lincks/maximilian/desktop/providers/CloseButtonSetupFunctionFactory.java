package org.lincks.maximilian.desktop.providers;

import org.lincks.maximilian.desktop.UiTexts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CloseButtonSetupFunctionFactory {

    private final UiTexts uiTexts;

    public CloseButtonSetupFunctionFactory(UiTexts uiTexts) {
        this.uiTexts = uiTexts;
    }

    public BiConsumer<JFrame, JPanel> getSetupFunction() {
        return getSetupFunction(__ -> {});
    }
    public BiConsumer<JFrame, JPanel> getSetupFunction(Consumer<JButton> onMouseEnter) {
        return (frame, panel) -> {
            final JButton closeBtn = new JButton(uiTexts.getText("closeButton"));
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
