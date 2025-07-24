
import javax.swing.*;
import java.awt.*;

public class GUI {

    private int height;
    private int width;
    private JFrame frame;

    public GUI() {
        this.frame = new JFrame();
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GUI(int width, int height, String title) {
        this.height = height;
        this.width = width;
        this.frame = new JFrame();
        frame.setSize(width,height);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void addHistogram()
    {
        Histogram histogramComponent = new Histogram();
        frame.add(histogramComponent);
    }

    public void SalaryGUI()
    {

        SalaryGUI salaryGUI = new SalaryGUI();
        frame.add(salaryGUI);

    }


}
