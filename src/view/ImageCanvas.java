package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import javafx.scene.canvas.Canvas;
import main.ImageFrame;

/**
 * @author paolo
 */
public class ImageCanvas extends Canvas {
    Image i;
    ImageFrame iFrame;

    public ImageCanvas(Image i, ImageFrame iFrame) {
        this.i = i;
        MediaTracker mt = new MediaTracker(iFrame);
        mt.addImage(i, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
            //Debug 2
            System.out.println("Couldn't wait for load!");
        }
        //Debug 3
        System.out.println("Error loading: "
                + mt.isErrorAny());
    }

    public void paint(Graphics g) {
        boolean b = g.drawImage(i, 0, 0, iFrame);
        //Debug 4
        System.out.println("drawImage: " + b);
        if (!b) {
            //repaint();
        }
    }

    public Dimension getPreferredSize() {
        int w = i.getWidth(iFrame);
        int h = i.getHeight(iFrame);
        return new Dimension(w, h);
    }
}
