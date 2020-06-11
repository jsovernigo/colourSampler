import java.awt.*;
import javax.swing.*;

public class Sampler extends JFrame {
	private JLabel red;
	private JLabel green;
	private JLabel blue;

	private JPanel left;
	private JPanel right;
	private JPanel main;
	private Robot rob;

	public Sampler() throws AWTException {
		super();

		this.setLayout(new FlowLayout());
		this.setSize(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.left = new JPanel();
		this.right = new JPanel();
		this.main = new JPanel();

		this.left.setVisible(true);
		this.right.setVisible(true);
		this.main.setVisible(true);

		this.red = new JLabel("R: ");
		this.green = new JLabel("G: ");
		this.blue = new JLabel("B: ");

		this.right.add(this.red);
		this.right.add(this.green);
		this.right.add(this.blue);

		this.main.add(this.left);
		this.main.add(this.right);

		this.left.setBackground( new Color(255, 255, 255));

		this.add(main);

		this.rob = new Robot();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			int x = MouseInfo.getPointerInfo().getLocation().x;
			int y = MouseInfo.getPointerInfo().getLocation().y;
            Sampler s = new Sampler();

			Color colour = s.rob.getPixelColor(x, y);

			System.out.println("x: " + x + " y: " + y);
			System.out.println("r: " + colour.getRed());
			System.out.println("g: " + colour.getGreen());
			System.out.println("b: " + colour.getBlue());
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
