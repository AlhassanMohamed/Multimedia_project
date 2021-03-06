/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageCropper extends JFrame implements MouseListener, MouseMotionListener {
    int x1, x2, y1, y2;
    int w, h;
    int x3,y3,w3,h3;
    BufferedImage im,subim;
    private final JLabel k;
    String filepath;
    
    private final Vector< Rectangle > rectangles = new Vector< Rectangle >();
    private boolean isNewRect = true;
    private void Dispose()
    {
        this.dispose();
    }
    public ImageCropper(BufferedImage im) throws IOException {
        super( "Image Cropper" );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        
        setLayout(null);

      
        w=im.getWidth();
        h=im.getHeight();
        ImageIcon op=new ImageIcon(im);
        k=new JLabel(op);
        k.setBounds(0, 0, w, h);
        getContentPane().add(k);
        
        JButton but=new JButton("segment");
        but.setBounds(0, h+10, w, 100);
        getContentPane().add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subim=im.getSubimage(x3, y3-30, w3, h3);
                MainFrame.img=subim;
                MainFrame.jLabel2.setIcon(new ImageIcon(subim));
                Dispose();
            }
        });
        addMouseListener( this ); // listens for own mouse and
        addMouseMotionListener( this ); // mouse-motion events
        //setSize( w, h+100 );
        setVisible( true );
    }
    public void mouseClicked( final MouseEvent event ) {
        repaint();
    }
    public void mousePressed( final MouseEvent event ) {
        this.x1 = event.getX();
        this.y1 = event.getY();
        repaint();
    }
    public void mouseReleased( final MouseEvent event ) {
        this.x2 = event.getX();
        this.y2 = event.getY();
        Rectangle rectangle = getRectangleFromPoints();
        this.rectangles.add( rectangle );
        this.x1 = this.y1 = this.x2 = this.y2 = 0;
        this.isNewRect = true;
        repaint();
    }
    private Rectangle getRectangleFromPoints() {
        int width = this.x1 - this.x2;
        int height = this.y1 - this.y2;
        Rectangle rectangle = new Rectangle( width < 0 ? this.x1
                : this.x2, height < 0 ? this.y1
                : this.y2, Math.abs( width ), Math.abs( height ) );
        return rectangle;
    }
    public void mouseEntered( final MouseEvent event ) {
        repaint();
    }
    public void mouseExited( final MouseEvent event ) {
        repaint();
    }
    public void mouseDragged( final MouseEvent event ) {
        this.x2 = event.getX();
        this.y2 = event.getY();
        this.isNewRect = false;
        repaint();
    }
    public void mouseMoved( final MouseEvent event ) {
        repaint();
    }
    @Override
    public void paint( final Graphics g ) {
        super.paint( g ); // clear the frame surface
        Rectangle newRectangle = getRectangleFromPoints();
        if ( !this.isNewRect ) {
                g.drawRect( newRectangle.x, newRectangle.y, newRectangle.width, newRectangle.height );
        }
        if(rectangles.size()==2){
            rectangles.removeElementAt(0);
        }
        for( Rectangle rectangle : this.rectangles ) {
                g.drawRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );
                x3=rectangle.x;
                y3=rectangle.y;
                w3=rectangle.width;
                h3=rectangle.height;
        }
    }
}