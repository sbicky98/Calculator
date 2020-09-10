package calculator;

/**
 * File Name:       CalculatorViewController.java
 * Author:          Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * Course:          CST8221 - JAP
 * Assignment:      1 Part 2
 * Date:           
 * Professor:       Daniel Cormier
 * Purpose:         The class CalculatorViewController is responsible
 *                  for building the calculator GUI.  
 * Class list:      CalculatorViewController, Controller
 *                  
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is going to build the GUI for calculator.
 * 
 * @author Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * @version 1
 * @see calculator
 * @since 1.8.0_251
 *
 */
public class CalculatorViewController extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5376124899040494286L;
	private JTextField display1; // the calculator display1 field reference
	private JTextField display2; // the calculator display2 field reference
	private JLabel error; // the mode/error display label reference
	private JButton dotButton; // the decimal point (dot) button reference
	private JCheckBox checkBox;
	JRadioButton singleJRadioButton;
	JRadioButton doubleJRadioButton;
	JRadioButton sciJRadioButton;

	/** array that store the numbers and operators */
	private static final String[] nums = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0",
			"\u00B1", "+" };

	/**
	 * This default constructor is used building the GUI of calculator.
	 */
	public CalculatorViewController() {


		/* reference to Controller class to handle events */
		Controller controller = new Controller();
		JPanel north = new JPanel();
		JPanel display = new JPanel();
		JButton backspace = new JButton();
		JPanel backspacePanel = new JPanel();
		JPanel checkBoxPanel = new JPanel();
		JPanel innerModePanel = new JPanel();
		JPanel modePanel = new JPanel();
		checkBox = new JCheckBox("Int");
		JPanel radios = new JPanel();
		singleJRadioButton = new JRadioButton(".0", false);
		doubleJRadioButton = new JRadioButton(".00", true);
		sciJRadioButton = new JRadioButton("sci", false);

		Box box = Box.createHorizontalBox();

		/** to group all the radio buttons together */
		ButtonGroup group = new ButtonGroup();

		JPanel outerPanel = new JPanel();
		JPanel innerPanel = new JPanel();
		JPanel keypad = new JPanel();
		/** Right panel for "C" and "=" buttons */
		JPanel operator_RightSide = new JPanel();
		/** left panel for "C" and "=" buttons */
		JPanel operator_LeftSide = new JPanel();

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

		north.setLayout(new BorderLayout());

		error = new JLabel("F");
		error.setPreferredSize(new Dimension(52, 55));
		error.setOpaque(true);
		error.setBackground(Color.YELLOW);
		error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));
		error.setHorizontalAlignment(JLabel.CENTER);
		error.setFont(new Font(error.getFont().getName(), error.getFont().getStyle(), 20));

		display.setLayout(new GridLayout(2, 0));
		display.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		display1 = new JTextField();
		display1.setPreferredSize(new Dimension(14, 30));
		display1.setBackground(Color.WHITE);
		display1.setEditable(false);
		display1.setColumns(14);
		display1.setHorizontalAlignment(JTextField.RIGHT);
		display1.setBorder(BorderFactory.createEmptyBorder());

		display2 = new JTextField();
		display2.setPreferredSize(new Dimension(14, 30));
		display2.setColumns(14);
		display2.setBackground(Color.WHITE);
		display2.setEditable(false);
		display2.setHorizontalAlignment(JTextField.RIGHT);
		/** display "0.0" at the default */
		display2.setText("0.0");
		display2.setBorder(BorderFactory.createEmptyBorder());

		/** To set up the backspace button */
		backspace.setPreferredSize(new Dimension(52, 55));
		// backspace.setBackground(Color.YELLOW);
		backspace.setOpaque(false);
		backspace.setContentAreaFilled(false);
		backspace.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
		/** text Unicode for left arrow */
		backspace.setText("\u21da");
		backspace.setFont(new Font(backspace.getFont().getName(), Font.BOLD, 25));
		/** add the tool tip */
		backspace.setToolTipText("Backspace(Alt-B)");
		/** react with Alt-B key mnemonic */
		backspace.setMnemonic('B');
		/** setting action command for backspace button */
		backspace.setActionCommand("\u21da");
		/** setting action listener for backspace button */
		backspace.addActionListener(controller);
		/** setting layout for backspace panel */
		backspacePanel.setLayout(new BorderLayout());
		/** setting background colour for backspace panel */
		backspacePanel.setBackground(Color.YELLOW);
		/** adding backspace button to banckspacePanel */
		backspacePanel.add(backspace);

		/** adding display1 and display2 to display panel */
		display.add(display1);
		display.add(display2);

		/**
		 * adding error label, display panel and backspacePanel to north panel at
		 * respective positions
		 */
		north.add(error, BorderLayout.WEST);
		north.add(display, BorderLayout.CENTER);
		north.add(backspacePanel, BorderLayout.EAST);

		/**
		 * setting layout and background color to modepanel and creating empty border
		 */
		modePanel.setLayout(new BorderLayout());
		modePanel.setBackground(Color.BLACK);
		modePanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));

		/** setting background colour of checkbox button */
		checkBox.setBackground(Color.GREEN);
		checkBox.addActionListener(controller);

		/** setting layout of checkBoxPanel */
		checkBoxPanel.setLayout(new BorderLayout());
		/** adding checkbox to checkBoxPanel */
		checkBoxPanel.add(checkBox);
		/** Setting size of checkBoxPanel */
		checkBoxPanel.setPreferredSize(new Dimension(error.getPreferredSize().width, 0));
		/** creating black matte border around checkBoxPanel */
		checkBoxPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));

		/** setting bckground colour and adding actionlistner to radio buttons */
		singleJRadioButton.setBackground(Color.YELLOW);
		singleJRadioButton.addActionListener(controller);
		doubleJRadioButton.setBackground(Color.YELLOW);
		doubleJRadioButton.addActionListener(controller);
		sciJRadioButton.setBackground(Color.YELLOW);
		sciJRadioButton.addActionListener(controller);

		/** setting layout and adding radiobuttons to radios panel */
		radios.setLayout(new GridLayout(1, 1, 5, 5));
		radios.add(singleJRadioButton);
		radios.add(doubleJRadioButton);
		radios.add(sciJRadioButton);

		/**
		 * setting backgroun colour and adding radiobuttons to box that contains them
		 */
		box.setBackground(Color.BLACK);
		box.add(singleJRadioButton);
		box.add(doubleJRadioButton);
		box.add(sciJRadioButton);

		/** checkBox and the radioButtons included in a button group */
		group.add(checkBox);
		group.add(singleJRadioButton);
		group.add(doubleJRadioButton);
		group.add(sciJRadioButton);

		/** adding checkBoxPanel and box to modePanel */
		modePanel.add(checkBoxPanel, BorderLayout.WEST);
		modePanel.add(box, BorderLayout.EAST);

		/** to add the boxPanel into north panel at the South position */
		north.add(modePanel, BorderLayout.SOUTH);

		outerPanel.setLayout(new BorderLayout());
		innerPanel.setLayout(new BorderLayout());

		keypad.setLayout(new GridLayout(4, 4, 3, 3));
		keypad.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

		operator_RightSide.setLayout(new GridLayout(2, 1, 3, 3));
		operator_RightSide.setBackground(Color.BLACK);
		operator_RightSide.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));

		operator_LeftSide.setLayout(new GridLayout(2, 1, 3, 3));
		operator_LeftSide.setBackground(Color.BLACK);
		operator_LeftSide.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));

		/** a for loop to display the buttons into different panel */
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].equals(".")) {
				dotButton = createButton(".", ".", Color.BLACK, Color.MAGENTA, controller);
				keypad.add(dotButton);
			} else if (nums[i].equals("\u00B1")) {
				keypad.add(createButton(nums[i], nums[i], Color.BLACK, Color.MAGENTA, controller));
			} else if (nums[i].equals("+") || nums[i].equals("-") || nums[i].equals("*") || nums[i].equals("/")) {
				keypad.add(createButton(nums[i], nums[i], Color.BLACK, Color.CYAN, controller));
			} else {
				keypad.add(createButton(nums[i], nums[i], Color.BLACK, Color.BLUE, controller));
			}
		}

		/** adding "C" and "=" to right side of the panel */
		operator_RightSide.add(createButton("C", "C", Color.BLACK, Color.RED, controller));
		operator_RightSide.add(createButton("=", "=", Color.BLACK, Color.YELLOW, controller));

		/** adding "C" and "=" to left side of the panel */
		operator_LeftSide.add(createButton("=", "=", Color.BLACK, Color.YELLOW,controller));
		operator_LeftSide.add(createButton("C", "C", Color.BLACK, Color.RED,controller));

		/** Creating decimal button */
		JButton decimalButton = new JButton();
		decimalButton.setPreferredSize(new Dimension(0, 45));
		decimalButton.setText("Decimal");
		decimalButton.setFont(new Font(decimalButton.getFont().getName(), Font.BOLD, 20));
		decimalButton.setForeground(Color.BLACK);
		decimalButton.setBackground(Color.WHITE);
		/** making the button transparent */
		decimalButton.setOpaque(false);
		/** making it disabled */
		decimalButton.setEnabled(false);

		/** Creating standard button */
		JButton standardButton = new JButton();
		standardButton.setPreferredSize(new Dimension(0, 45));
		standardButton.setText("Standard");
		standardButton.setFont(new Font(standardButton.getFont().getName(), Font.BOLD, 20));
		standardButton.setForeground(Color.BLACK);
		standardButton.setBackground(Color.WHITE);
		/** making the button transparent */
		standardButton.setOpaque(false);
		/** making it disabled */
		standardButton.setEnabled(false);

		/** adding decimalButton, keypad and standard button to innerPanel */
		innerPanel.add(decimalButton, BorderLayout.NORTH);
		innerPanel.add(keypad, BorderLayout.CENTER);
		innerPanel.add(standardButton, BorderLayout.SOUTH);

		/** adding panels at respective positions */
		outerPanel.add(operator_RightSide, BorderLayout.EAST);
		outerPanel.add(innerPanel, BorderLayout.CENTER);
		outerPanel.add(operator_LeftSide, BorderLayout.WEST);

		/** add the kouter panel into the whole panel at the NORTH position */
		add(north, BorderLayout.NORTH);
		/** add the kouter panel into the whole panel at the Center position */
		add(outerPanel, BorderLayout.CENTER);

	}

	/**
	 * The method is responsible for the creation of group of related buttons with
	 * the same basic properties.default constructor is used building the GUI of
	 * calculator.
	 * 
	 * @param text    - the button text label
	 * @param ac      - the action command string for that button
	 * @param fg      - the foreground color of the button
	 * @param bg      - the background color of the button
	 * @param handler - the reference to instance of the event handler class
	 * 
	 * @return JButton button - the reference to the created button
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {
		JButton button = new JButton(text);
		button.setForeground(fg);
		button.setBackground(bg);

		/** Set the action command for the button */
		if (ac != null) {
			button.setActionCommand(ac);
		}
		/** Set the properties of the button font */
		button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
		button.addActionListener(handler);
		/** Returns a reference to the created button */
		return button;
	}

	/**
	 * To display the textField and show other features based on the number on
	 * floating point or integer mode
	 * 
	 * @param enable - true or false when choose integer or float mode
	 */
	public void display(boolean enable) {
		/** when in mode other than Int */
		if (enable) {
			dotButton.setBackground(Color.MAGENTA);
			error.setText("F");
			error.setBackground(Color.YELLOW);
		} else {
			/** If user clicked "Int" mode */
			dotButton.setBackground(Color.GRAY);
			error.setText("I");
			error.setBackground(Color.GREEN);
		}
		dotButton.setEnabled(enable);
	}

	/**
	 * This class is a private inner class inside the CalculatorViewController
	 * class.
	 * 
	 * @author Arpandeep Singh-040950261, Bikramjeet Singh-040955651
	 * @version 1
	 * @see calculator
	 *
	 * 
	 */
	private class Controller implements ActionListener {
		
		CalculatorModel cmodel = new CalculatorModel();
		/** the flag for calculator in default state */
		boolean inDefaultMode = true; 
		/** if calculator is in integer mode */
		boolean inIntegerMode = false; 
		/** if the text can be overridden or replaced */
		boolean overrideFlag = true;
		/** if calculator is in float mode */
		boolean inFloatMode = false; 
		/** if backspace is enabled */
		boolean backspaceEnabled=false;
		
		@Override
		public void actionPerformed(ActionEvent event) {
		    
			/**holds the action command from the user*/
			String inputFromUser= event.getActionCommand();
			
			/*Handles different cases depending upon the */
			switch(inputFromUser) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
				/** To handle events when numbers is clicked */
				if (!cmodel.getError()) 
					numbers(inputFromUser);
				backspaceEnabled=true;
				break;
							
			case "*":
			case "/":
			case "+":
			case "-":
				/** To handle events when operators is clicked */
				if (!cmodel.getError()) {
					operations(inputFromUser);
					inFloatMode = false;
				}
				backspaceEnabled=true;
				break;
				
			case "=":
				/** To handle events when equal sign is clicked */
				if (!cmodel.getError()) {
					equals();
					if(!cmodel.integerMode())inFloatMode=true;
				}
				backspaceEnabled=false;
				break;
					
			case ".":
				/** To handle events when dot operators is clicked */
				if (!cmodel.getError()) {  
					if (!inFloatMode) {
						if (overrideFlag) {
							display2.setText(".");
							overrideFlag = false;
							inDefaultMode = false;
						} else display2.setText(display2.getText().concat("."));
						
						inFloatMode = true;
					}
				}
				break;
				
			case "\u21DA":
				/** To handle events when backspace is clicked */
				if(!backspaceEnabled) return;
				if (!cmodel.getError()) {
					/** If not in default state for the display */
					if (!overrideFlag) {
						/** if there are more than 1 digits in the number, remove the last digit */
						if (display2.getText().length() >= 1) { 
							/** If the last is an "-" operator, clear the textField */
							if ((display2.getText().length() == 2 && display2.getText().contains("-"))|| (display2.getText().length() == 1) ) {
								defaultDisplay(); 
								cmodel.clear();
								/** To reset the flag in default display */
                                overrideFlag = true;
                                inFloatMode = false;
                                inDefaultMode = true;
                                break;
							}
							display2.setText(display2.getText().substring(0, display2.getText().length() - 1));
						} else {
							defaultDisplay(); 
							cmodel.clear();
							/** To reset the flag in default display */
                            overrideFlag = true;
                            inFloatMode = false;
                            inDefaultMode = true;
						}
					}

				}
				break;
				
			case "\u00B1":
				/** To handle events when plus minus sign is clicked */
				if (!cmodel.getError()) {
					/** To handle the plus minus sign to convert a number */
					if (display2.getText().startsWith("-")) 
						display2.setText(display2.getText().substring(1));
					
					else display2.setText("-".concat(display2.getText()));
					
				}
				backspaceEnabled=true;
				break;
				
			case "C":
				/** To handle event when "C" is clicked */
				if (cmodel.getError()) display(!cmodel.integerMode());
				
				/** To reset the display in textField */
				defaultDisplay();
				cmodel.clear(); 
				
				/** To reset the flags*/
                overrideFlag = true;
                inFloatMode = false;
                inDefaultMode = true;
				break;
		
			case ".0":
				/** when user chose .0 mode */
				inIntegerMode = false;
				cmodel.setPrecision(CalculatorModel.FP_0);
				cmodel.setOperationMode(CalculatorModel.FLOAT);
				
				if (!cmodel.getError()) {
					display(true);
					/** To convert a number to different mode */
					defaultDisplay(); 
				}
				break;
				
			case ".00":
				
				/** To handle events when choose .00 mode */
				inIntegerMode = false;
				cmodel.setPrecision(CalculatorModel.FP_00);
				cmodel.setOperationMode(CalculatorModel.FLOAT);
				
				if (!cmodel.getError()) {
					display(true);
					defaultDisplay();	 
				}
				
				break;
				
			case "sci":
			
				/** To handle events when choose sci mode */
				inIntegerMode = false;
				cmodel.setPrecision(CalculatorModel.FP_SCI);
				cmodel.setOperationMode(CalculatorModel.FLOAT);
				
				if (!cmodel.getError()) {
					display(true);
					defaultDisplay(); 
				}
				
				break;
				
			case "Int":
				/** To re-click the checkBox */ 
				
			    if (inIntegerMode) { 
			    	doubleJRadioButton.doClick(); 
			    	break;
			    }  
				
			    /** set the "Int" is clicked */
				inIntegerMode = true; 
				cmodel.setOperationMode(CalculatorModel.INTEGER);
				
				/*when mode is changed*/
				if (!cmodel.getError()) {
					display(false);
					defaultDisplay();
				}
				break;	
			default:
				break;
			}
			
			/*To handle the events when mode is changed*/
			if (cmodel.getError()) {
				error.setText("E");
				error.setBackground(Color.RED); 
				display2.setText(cmodel.getErrorText());		
			}
		
		} 		
		
		/**
		 * Handle the numbers that user entered into textField.
		 * @param s - the number user entered 
		 */ 
		public void numbers(String s) {
			/** To make sure the number digits entered less than the width of the calculator */
			if (display2.getText().length() < display2.getColumns()) {
				
				/** To display the numbers on the textField based on op1 and op2 */
				switch(cmodel.getState()) {
				case CalculatorModel.OPERAND_1:
					if (overrideFlag) {
						display2.setText(s); 
						overrideFlag = false;
						inDefaultMode = false;
						break;
					} 
					display2.setText(display2.getText().concat(s));
					break;
					
				case CalculatorModel.OPERAND_2: 
					if (overrideFlag) {
						display2.setText(s);
						overrideFlag = false; 
						break;
					}
					display2.setText(display2.getText().concat(s));
					break;
										
				default:
					cmodel.setError(true);
					break;
				}	
			} else {
				/** If longer than the current width of the display, not display */
				display2.setText("");
				cmodel.clear();
			}
		}
		
		/**
		 * To handle the event that "=" sign is clicked by user. 
		 */
		public void equals() {
			/** To calculate and display the result on the textField */
			switch(cmodel.getState()) {	
			case CalculatorModel.OPERAND_1:
				break;
			case CalculatorModel.OPERAND_2: 
				cmodel.setOperand2(display2.getText());				
				String results = cmodel.getResult();
				display2.setText(results);
				if (results != null) {
					display1.setText("");
					/** If the result longer than the current width of the display */
					if (display2.getText().length() > display2.getColumns()) { 
						cmodel.setErrorText("Result to large to display");
						cmodel.setError(true);
						break;
					}  
					overrideFlag=true;
					break;
				}
				cmodel.setError(true);
				break;
			default:
				cmodel.setError(true);
				break;
			}	
		}
		
		/**
		 * To handle the event that arithmetic operation is clicked by user.
		 * @param s - arithmetic operation 
		 */
		public void operations(String s) { 
			/** To display the numbers and the operator on the textField */
			switch(cmodel.getState()) {
			case CalculatorModel.OPERAND_1:
				overrideFlag = true;
				cmodel.setOperand1(display2.getText());
				cmodel.setOperation(s); 
				display1.setText(display2.getText().concat(s)); 
				break;
				
			case CalculatorModel.OPERAND_2:
				if (overrideFlag) { 
					cmodel.setOperation(s);  
					display1.setText(display2.getText().concat(s));
					break;
				} 
				break;			
			default:
				cmodel.setError(true);
				break;
			}	
		}
		
		/**
		 * To reset the display based on the mode user entered 
		 */
		public void defaultDisplay() {
			/**if in Integer mode, display 0 else display 0.0 */
			if (cmodel.integerMode()) {
				display1.setText(" ");
				display2.setText("0");
			} else {
				display1.setText(" ");
				display2.setText("0.0");
			}
			overrideFlag = true;
		}		
		
	}  
}
