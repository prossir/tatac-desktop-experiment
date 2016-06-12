package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import view.ImageCanvas;

/**
 * @author paolo
 */
public class ImageFrame extends Frame {

    private ImageCanvas c;
    private Image i;

    ImageFrame(Image i) {
        this.i = i;
        c = new ImageCanvas(i, this);
        //add(c);
    }

    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();

        //Debug 1
        File file = new File("c:\\juba\\used.bmp");
        System.out.println("File exists: "
                + file.exists());
        Image im = tk.getImage("c:\\juba\\used.bmp");
        ImageFrame f = new ImageFrame(im);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            }

        });
        f.setSize(300, 300);
        f.show();
    }
}