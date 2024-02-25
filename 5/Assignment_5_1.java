/*	Graeme Jeffreys
	100908108
	2023-08-11
	assignment 5
	UI:
	-creates a UI that allows addition, subtraction, multiplication, and divide
	
*/


//all imports from design + colour for buttons
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Assignment_5_1 {

	private JFrame frame;
	private JTextField n1;
	private JTextField n2;
	private JTextField res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment_5_1 window = new Assignment_5_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Assignment_5_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel num1 = new JLabel("Number 1");
		num1.setBounds(10, 29, 81, 36);
		frame.getContentPane().add(num1);
		
		JLabel num2 = new JLabel("Number 2");
		num2.setBounds(10, 75, 81, 36);
		frame.getContentPane().add(num2);
		
		n1 = new JTextField();
		n1.setBounds(101, 38, 96, 19);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setBounds(101, 84, 96, 19);
		frame.getContentPane().add(n2);
		n2.setColumns(10);
		
		//buttons
		JButton addition = new JButton("+");
		addition.setBounds(10, 121, 45, 21);
		frame.getContentPane().add(addition);
		
		JButton subtract = new JButton("-");
		subtract.setBounds(65, 121, 45, 21);
		frame.getContentPane().add(subtract);
		
		JButton multiply = new JButton("*");
		multiply.setBounds(120, 121, 45, 21);
		frame.getContentPane().add(multiply);
		
		JButton divide = new JButton("/");
		divide.setBounds(175, 121, 45, 21);
		frame.getContentPane().add(divide);
		
		//result
		JLabel result = new JLabel("Result");
		result.setBounds(10, 165, 45, 13);
		frame.getContentPane().add(result);
		
		res = new JTextField();
		res.setBounds(10, 193, 96, 19);
		frame.getContentPane().add(res);
		res.setColumns(10);
		
		//uses action listener to set calculate to the proper operand for the switch block later
		//sets the button to blue after its clicked using an action listener
		addition.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        calculate('+');
		        JButton button = (JButton) e.getSource();
		        button.setBackground(new Color(0, 0, 200));
		    }
		});

		subtract.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        calculate('-');
		        JButton button = (JButton) e.getSource();
		        button.setBackground(new Color(0, 0, 200));
		    }
		});

		multiply.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        calculate('*');
		        JButton button = (JButton) e.getSource();
		        button.setBackground(new Color(0, 0, 200));
		    }
		});

		divide.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        calculate('/');
		        JButton button = (JButton) e.getSource();
		        button.setBackground(new Color(0, 0, 200));
		    }
		});
	}
	// calculate function to set string text to int and then perform operation based on switch case
	private void calculate(char operator) {
		try {
			  int number1 = Integer.parseInt(n1.getText());
			  int number2 = Integer.parseInt(n2.getText());
			  int result = 0;
			        
			  switch (operator) {
			       case '+':
			       result = number1 + number2;
			       break;
			       case '-':
			       result = number1 - number2;
			       break;
			       case '*':
			       result = number1 * number2;
			       break;
			       case '/':
			    	   if (number2 != 0) {
			    		   result = number1 / number2;
			    	   } else {
			    		   res.setText("Cannot divide by zero");
			    		   return;
			    	   }
			    	   break;
			  	}
			        
			  	res.setText(String.valueOf(result));
				} catch (NumberFormatException ex) {
			        res.setText("Invalid input");
				}
		}
}
