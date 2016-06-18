package main;

import java.awt.*;
import javax.swing.JFrame;
import view.BattleInterface;
import view.ImageCanvas;
import view.BattleInterface;

/**
 * @author paolo
 */
public class ImageFrame extends JFrame {

    ImageFrame() {
        getContentPane().add(new ImageCanvas(this, null), BorderLayout.CENTER);

        setSize(600, 600);
        setDefaultCloseOperation(3);
    }

    public static void main(String[] args) {
        //ImageFrame imageFrame = new ImageFrame();

        BattleInterface bti = new BattleInterface();
        bti.setVisible(true);
//imageFrame.setVisible(true);
    }
}
