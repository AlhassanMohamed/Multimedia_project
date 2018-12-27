
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Resize {

	public  BufferedImage resize(BufferedImage image,int width,int height){
            
                BufferedImage im = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D g = (Graphics2D)im.getGraphics();
                g.drawImage(image, 0, 0, width, height, null);
                return im;
	}

	
	
    
}


