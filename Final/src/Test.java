import java.awt.BorderLayout;
/* w  w  w .  ja v  a  2 s  . c  o m*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {

  public Test() {

    JButton btn1 = new JButton("Button1");
    JButton btn2 = new JButton("Button2");
    JButton btn3 = new JButton("Button3");
    JButton btn4 = new JButton("Button4");
    JButton btn5 = new JButton("Button5");
    JButton btn6 = new JButton("Button6");

    setLayout(new BorderLayout());

    add("North", btn1);
    add("West", btn2);
    add("Center", btn3);
    add("Center", btn4);
    add("South", btn5);
    add("East", btn6);

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Test());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}