  
package calculator;
/**
 * File Name:       CalculatorSplashScreen.java
 * Author:          Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * Course:          CST8221 - JAP
 * Assignment:      1, Part 1
 * Date:            
 * Professor:       Svillen Ranev
 * Purpose:         The class Controller is responsible for displaying
 *                  a splash screen before the launch of the application.  
 * Class list:      CalculatorSplashScreen                
 */
import java.awt.*;
import javax.swing.*; 

/**
 * This class is responsible for displaying the splash screen.
 *  
 * @author Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * @version 1
 * @see calculator
 * @since 1.8.0_251
 *
 */
public class CalculatorSplashScreen extends JWindow{
	
/** Splash screen duration time */
private final int duration;
Image splashScreen;
ImageIcon imageIcon;

/**
 * This default constructor to set the show time of the splash screen.
 * @param duration - set the duration time of splash
 */
public CalculatorSplashScreen(int duration) {
	this.duration=duration;
}

/**
 * The method is responsible for showing a splash screen
 */
public void showSplashWindow() {
	
	/** To create a main content pane */
	JPanel mainPanel = new JPanel(new BorderLayout());
	/** To set the progressBar to show the loading progress */
	JProgressBar bar = new JProgressBar();
	/** To display the content when progressing */
	JLabel progressLabel = new JLabel("Loading Calculator. Please wait...");
	/** create panel to hold process component */
	JPanel progressPanel = new JPanel(new BorderLayout());
	
	/** Set the window's bounds*/
	int width = 534;
	int height = 236+20;
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screen.width-width)/2;
	int y = (screen.height - height)/2;
	

    setLocation(x,y);
 
	
	JLabel label = new JLabel(new ImageIcon(getClass().getResource("goldentemple.jpg")));
	JLabel names = new JLabel("Arpandeep Singh-040950261, Bikramjeet Singh-040955651",JLabel.CENTER);

	bar.setMinimum(0);
	bar.setMaximum(duration);
	bar.setBackground(Color.WHITE);
	bar.setForeground(Color.ORANGE);
	bar.setPreferredSize(new Dimension(10, 20));
	
	progressLabel.setBackground(Color.GRAY);
	progressLabel.setHorizontalAlignment(JLabel.CENTER);
	progressLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
    progressLabel.setOpaque(false);
	
    /** To add processBar into panel */
    progressPanel.add(bar, BorderLayout.NORTH);
    progressPanel.add(progressLabel, BorderLayout.SOUTH);
	setBounds(x, y, width, height); 
	mainPanel.setBackground(Color.GRAY);
	mainPanel.add(progressPanel,BorderLayout.NORTH);
	mainPanel.add(label,BorderLayout.CENTER);
	mainPanel.add(names,BorderLayout.SOUTH);

	 setContentPane(mainPanel);
	 setVisible(true);
	 
	 try {
			for (int i = 0 ; i < duration; ++i) {
				bar.setValue(i);
				Thread.sleep(1);
			}
		} catch(InterruptedException e) {
		}
    dispose();	
}
}