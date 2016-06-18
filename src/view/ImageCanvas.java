package view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import main.ImageFrame;

/**
 * @author paolo
 */
public class ImageCanvas extends Canvas {

    Image image = Toolkit.getDefaultToolkit().getImage("assets/victini_opponent.png");
    ImageFrame iFrame;

    public ImageCanvas() {

    }

    public ImageCanvas(ImageFrame iFrame, Image image) {
        //this.image = image;
        this.iFrame = iFrame;
    }

    public void paint(Graphics g) {
        boolean b = g.drawImage(image, 5, 5, this);
    }

//    public Dimension getPreferredSize() {
//        int w = i.getWidth(iFrame);
//        int h = i.getHeight(iFrame);
//        return new Dimension(w, h);
//    }
}
