package calculator;
/**
 * File Name:       Calculator.java
 * Author:          Arpandeep Singh-040950261, Bikramjeet Singh-040955651
 * Course:          CST8221 - JAP
 * Assignment:      1, Part 2
 * Date:            
 * Professor:       Daniel Cormier
 * Purpose:         This class handles all the calculations
 * Class list:      Calculator                 
 */
public class CalculatorModel {
	
	/** floating point precision '.0' */
	public static final int FP_0=0;
	/** floating point precision '.0' */
	public static final int FP_00=1;
	/** floating point precision 'sci' */
	public static final int FP_SCI=2;
	public static final int INTEGER=3;
	public static final int FLOAT=4;
	/**state when adding to operand 1*/
	public static final int OPERAND_1=5;
	/**state when adding to operand 2*/
	public static final int OPERAND_2=6;
	/**state of the calculator*/
	public int state;
	/**holds the airthemtic operations*/
	private String operand1;
	private String operand2;
	private String operation;
	String result="";
	/**holds the precsion mode*/
	private int precisionMode;
	/**holds the operational mode*/
	private int operationalMode;
	/**holds the error state*/
	private boolean errorState;
	/**holds the error text*/
	private String error=null;
	
	public CalculatorModel() {
		this.state=this.OPERAND_1;
		this.operand1=null;
		this.operand2=null;
		this.precisionMode=FP_00;
		this.operationalMode=FLOAT;
		this.errorState=false;
	}
	
	/**
	 * set methods for setting the operand1
	 * @param op1 - the first operand to set 
	 */
	public void setOperand1(String op1) {
		this.operand1=op1;
		
	}
	/**
	 * set methods for setting the arithmetic operation
	 * @param operation - the arithmetic operation
	 */
	public void setOperation(String operation) {
		this.operation=operation;
		state=this.OPERAND_2;
	}
	/**
	 * set methods for setting the operand2
	 * @param op1 - the first operand to set 
	 */
	public void setOperand2(String op2) {
		this.operand2=op2;
		state=this.OPERAND_1;
	}
	/**
	 * set methods for setting the operational mode(Integer or Float)
	 * @param mode - the operational mode
	 */
	public void setOperationMode(final int mode) {
		this.operationalMode=mode;
	}

	/**
	 * To return Integer mode if the calculator is integer
	 * @return operationalMode - integer mode 
	 */
	public boolean integerMode() {
		if(this.operationalMode==INTEGER)return true;
		return false;	
	}
	/** 
	 * set method to set the floating-point precision.
	 * @param precision - the three types precision
	 */
	public void setPrecision(final int precision) {
		this.precisionMode=precision;
	}
	/** 
	 * set method to set the error state .
	 * @param error - True or false
	 */
	public void setError(boolean error) {
		this.errorState=error;
	}
	/** 
	 * get method to get the floating-point precision.
	 * @return errorState - true or false
	 */
	public boolean getError() {
		return this.errorState;
	}
	/** 
	 * set method to set the error text
	 * @param errorText - Text to display as error
	 */
	public void setErrorText(String errorText) {
		this.error = errorText;
	}
	/** 
	 * get method to get the floating-point precision.
	 * @return error - error text
	 */
	public String getErrorText() {
		return this.error;
	}
	/** 
	 * get method to set the results of calculation
	 * @return - results of calculation
	 */
	public String getResult() {
		return calculate();
	}
	/** 
	 * get method to get the state of calculator
	 * @param state - state of calculator
	 */
	public int getState() {
		return this.state;
	}
	/** 
	 * reset all values to default
	 */
	public void clear() {
		this.state=this.OPERAND_1;
		this.errorState=false;
		this.operation=null;
		this.operand1=null;
		this.operand2=null;
	}
	/** 
	 * set method to set the floating-point precision.
	 * @return results - result of calculation
	 */
	private String calculate() {
		   
		   float tempNum = 0.0f;  
		   state=this.OPERAND_1;
		   
		    switch (operationalMode) {
		      case INTEGER:
		    	 int op1=0;
		    	 int op2=0;
		    	 try {
		    		 op1=Integer.parseInt(operand1);
		    		 op2=Integer.parseInt(operand2);
		    	 }catch(NumberFormatException e) {
		    		 this.errorState=true;
		    		 
		    		 return null;
		    		 
		    	 }
		        switch (operation) {
		          case "+":
		            return Integer.toString(op1+op2);
		           
		          case "-":
		             return Integer.toString(op1-op2);
		            
		          case "/":

		            if (op1==0 && op2==0) {
		            	this.errorState=true;
		              this.error = "Result is undefined";
		             return null;
		            }
		            else if (op2==0) {
		            	this.errorState=true;
		                this.error = "Cannot divide by zero";
		                return null;
		            }
		            else return Integer.toString(op1 / op2);
		           
		          case "*":
		            return Integer.toString(op1 * op2);
		            
		        }
		        break;

		      default:
		    	  float op1_float=Float.parseFloat(operand1);
		    	  float op2_float=Float.parseFloat(operand2);
		    	  if (op1_float==0 && op2_float==0) {
		            	this.errorState=true;
		              this.error = "Result is undefined";
		             return null;
		            }
		            else if (op2_float==0) {
		            	this.errorState=true;
		                this.error = "Cannot divide by zero";
		                return null;
		            }
		    	
		    	 
		        switch (operation) {
		          case "+":
		            tempNum = (op1_float + op2_float);
		            break;
		          case "-":
		            tempNum = (op1_float - op2_float);
		            break;
		          case "*":
		            tempNum = (op1_float * op2_float);
		            break;
		          case "/":
		            tempNum = (op1_float / op2_float);
		            break;
		        }

		        switch (precisionMode) {
		          case FP_0:
		            return String.format("%.1f", tempNum);
		           
		          case FP_00:
		            return  String.format("%.2f", tempNum);
		           
		          case FP_SCI:
		           return String.format("%.4e", tempNum);
		            
		        }
		        
		    }
			return null;
	}
	
}