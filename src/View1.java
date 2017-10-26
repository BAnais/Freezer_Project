import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.JOptionPane;

public class View1 extends JFrame {

	public JPanel contentPane;
	public JSlider slide;
	public JFChart chart;
	public JLabel rosee;
	public JSpinner spinner;
	public JProgressBar progressBar;
	public JLabel temp;
	private JLabel lblc;
	public boolean alertDoorOpen = false;
	public boolean dewPoint = false;
	public boolean temperatureReached = false;
	// public JFrame frame;
	/**
	 * Create the frame.
	 *
	 */
	public View1(){
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.DARK_GRAY);
		setTitle("Pimp My Fridge ");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		this.setSize(1019,719);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);

		JLabel lblNewLabel = new JLabel("Donn\u00E9es Interne");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblRglageDeLa = new JLabel("R\u00E9glage de la temp\u00E9rature");
		lblRglageDeLa.setForeground(new Color(0, 191, 255));
		lblRglageDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));


		JPanel panel_chart = new JPanel();
		panel_chart.setBackground(Color.BLACK);
		chart = new JFChart("Temperature (°C)");
		panel_chart.add(chart);

		JLabel lblPimpMyFridge = new JLabel("Pimp My Fridge ");
		lblPimpMyFridge.setForeground(new Color(0, 191, 255));
		lblPimpMyFridge.setFont(new Font("Rosewood Std Regular", Font.PLAIN, 38));

		//Selma :



		JPanel panel_logo = new JPanel();
		panel_logo.setBackground(new Color(128, 128, 128));

		JLabel labelImage = new JLabel();

		try{
			File file = new File(this.getClass().getResource("/img/logo.png").toURI());
			ImageIcon imgIcon = new ImageIcon(ImageIO.read(file));
			labelImage.setIcon(imgIcon);
			panel_logo.add(labelImage);
		}catch(Exception e){
			System.out.println("Logo introuvable");
		}

		if (temperatureReached){
			JFrame parent = new JFrame();
			JOptionPane.showMessageDialog(parent, "Printing complete");
		}


		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(110)
								.addComponent(panel_chart, GroupLayout.PREFERRED_SIZE, 759, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(134, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)
								.addGap(3)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(31)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
												.addComponent(lblRglageDeLa, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
												.addGap(198))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblPimpMyFridge)
												.addPreferredGap(ComponentPlacement.RELATED, 586, Short.MAX_VALUE)
												.addComponent(panel_logo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
												.addGap(27))))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPimpMyFridge)
										.addComponent(panel_logo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_chart, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
								.addGap(13)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addComponent(lblRglageDeLa, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
		);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 206, 209));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		progressBar.setStringPainted(true);

		JLabel lblHumidit = new JLabel("Humidit\u00E9 :");
		lblHumidit.setForeground(new Color(0, 206, 209));
		lblHumidit.setFont(new Font("Tahoma", Font.BOLD, 20));

		temp = new JLabel("0 \u00B0C");
		temp.setForeground(new Color(255, 0, 0));
		temp.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblTemprature = new JLabel("Temp\u00E9rature :");
		lblTemprature.setForeground(new Color(255, 0, 0));
		lblTemprature.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(26)
												.addComponent(lblTemprature))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(71)
												.addComponent(temp)))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(70)
												.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(121)
												.addComponent(lblHumidit, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
								.addGap(110))
		);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap(25, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTemprature)
										.addComponent(lblHumidit))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(temp)
										.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(23))
		);
		panel_1.setLayout(gl_panel_1);

		slide = new JSlider();
		slide.setBackground(Color.DARK_GRAY);
		slide.setForeground(Color.DARK_GRAY);
		slide.setValue(0);
		slide.setMaximum(30);



		spinner = new JSpinner(new SpinnerNumberModel(0,0,30,1));
		spinner.setForeground(Color.DARK_GRAY);
		spinner.setBackground(Color.DARK_GRAY);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblc = new JLabel("\u00B0C");
		lblc.setForeground(Color.LIGHT_GRAY);
		lblc.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblTempratureSouhaite = new JLabel("Temp\u00E9rature souhait\u00E9e : ");
		lblTempratureSouhaite.setForeground(new Color(188, 143, 143));
		lblTempratureSouhaite.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(37)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(slide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(66))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblTempratureSouhaite)
												.addGap(18)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblc)
								.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap(21, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblTempratureSouhaite)
												.addGap(18)
												.addComponent(slide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblc)))
								.addGap(28))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);



	}

/*	class ImageLoader {

		private BufferedImage image = null;

		public static BufferedImage loadImage(String path){
			try {
				return ImageIO.read(ImageLoader.class.getResource(path ));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ImgIcon = new ImageIcon(image);
		}
	}*/
}