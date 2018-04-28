import javax.swing.*;

public class Test extends JFrame {
    public static void main(String[] args) {
        FrameSett f = new FrameSett();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
    }
}
