import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
class EventDemo  {
    JLabel jlb;

    EventDemo()throws Exception{


        JFrame jfr=new JFrame("");jfr.setUndecorated(true);
        jfr.setLayout(new FlowLayout());
        jfr.setSize(64,64);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                jfr.setLocation(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                //jfr.setLocation(e.getXOnScreen(), e.getYOnScreen());
            }
        });
        BufferedImage img;
        img= ImageIO.read(new File("C:\\Users\\PK\\IdeaProjects\\GitGate\\Lab-19\\src\\esand_jet.png"));
        jlb= new JLabel(new ImageIcon(img));
        jfr.setIconImage(img);
        jfr.add(jlb);
        jlb.setLocation(0,0);
        jfr.setBackground(Color.RED);
        //jfr.getI
        jfr.setShape(contour(img));
        jfr.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new EventDemo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//time to wololo
    }


    static Shape contour(final BufferedImage i) {
        final int w = i.getWidth();
        final int h = i.getHeight();
        final Area s = new Area(new Rectangle(w, h));
        final Rectangle r = new Rectangle(0, 0, 1, 1);
        for (r.y = 0; r.y < h; r.y++) {
            System.out.println(r.y + "/" + h);
            for (r.x = 0; r.x < w; r.x++) {
                if ((i.getRGB(r.x, r.y) & 0xFF000000) != 0xFF000000) {
                    s.subtract(new Area( r ));
                }
            }
        }
        return s;
    }
}
//java create shape code: 26.04