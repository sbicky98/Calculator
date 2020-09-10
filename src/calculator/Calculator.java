 
package calculator;
/**
 * File Name:       Calculator.java

 * Author:          Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * Course:          CST8221 - JAP
 * Assignment:      1, Part 2
 * Date:            
 * Professor:       Daniel Cormier
 * Purpose:         This class is responsible for launching the application.
 * Class list:      Calculator                 
 */
import java.awt.Dimension;

import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * This class is responsible for launching the application.
 *  
 * @author  Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * @version 1
 * @see calculator
 * @since 1.8.0_251
 *
 */
public class Calculator {

	/**
	 * The main method to launch the frame.
	 * @param args - command line arguments
	 */
  public static void main(String[] args) {
	  CalculatorSplashScreen obj = new CalculatorSplashScreen(5000);  
		CalculatorViewController controller = new CalculatorViewController();
		obj.showSplashWindow();
		
		/**
		 * The EventQueue.invokeLater method to invoke the frame.
		 * @param new Runnable - to run the frame
		 */
		EventQueue.invokeLater(new Runnable() {
			/**
			 * The run method to run the frame.
			 */
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				frame.setTitle("Calculator");
				frame.setMinimumSize(new Dimension(380,520));
				frame.setContentPane(controller);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
			}
			
		});
  }
}
