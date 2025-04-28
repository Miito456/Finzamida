package finzamida;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class UIUtils {

    public static class LogoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/Logo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public static Font loadCustomFont(String fontPath) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            return customFont.deriveFont(Font.PLAIN, 16);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 16);
        }
    }

    public static void setFontRecursively(Component component, Font baseFont) {
        if (component instanceof JComponent) {
            Font currentFont = component.getFont();
            if (currentFont != null) {
                Font newFont = baseFont.deriveFont(currentFont.getStyle(), currentFont.getSize());
                component.setFont(newFont);
            }
        }

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setFontRecursively(child, baseFont);
            }
        }
    }
}
