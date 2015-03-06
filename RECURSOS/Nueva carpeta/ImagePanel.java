/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    public BufferedImage background;
    public BufferedImage image;
    Graphics g;

    public ImagePanel() {
       try {
          background = ImageIO.read(new File("assets/background.png"));
          image = null;
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(background, 0,0, null);
        if(image!=null)
        {
            g.drawImage(image, 0,0, null);
        }
    }
    
    void setImage(String path)
    {
        if(path==null)
        {
            image=null;
            update();
            return;
        }
            
        try {
          image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
            // handle exception...
        }
        update();
    }
    
    void setBackground(String path)
    {
        if(path==null)
        {
            background=null;
            update();
            return;
        }
            
        try {
          background = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
            // handle exception...
        }
        update();
    }
    
    void update()
    {
        repaint();
    }
}