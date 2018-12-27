import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
 class GrayScaleImage{

        public BufferedImage GrayScale(BufferedImage img) {
            BufferedImage inng =new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color color = new Color(img.getRGB(x, y));
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    red = green = blue = (int)(red * 0.3 + green * 0.6 + blue * 0.1);
                    color = new Color(red, green, blue);
                    int rgb = color.getRGB();
                    img.setRGB(x, y, rgb);
                    inng.setRGB(x, y, rgb);
               }
           }
           return img;
        }
    }