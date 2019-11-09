package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator {
	// main frame
	JFrame mainFrame;
	// main Panel
    Panel mainPanel;
	// label
	private Label operator, equalSign, result;
	// text field
	private JTextField firstOperand, secondOperand;
	// buttons
	private Button plus, minus, multiply, divide, ok;
	// cell size
	private int cellSize = 100;
	// margin
	private int margin = 20;
	// padding
	private int padding = 10;
	
	public void manageLayout() {
	    // mainFrame
	    mainFrame = new JFrame("Calculator");
	    mainFrame.setSize(cellSize*5 + padding*2 + margin*5, 2*cellSize + padding*2 + margin*3);
	    mainFrame.setLayout(null);
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.setDefaultLookAndFeelDecorated(true);
	    
	    // mainPanel
	    mainPanel = new Panel();
	    mainPanel.setSize(cellSize*5+padding*2+margin*4, 2*cellSize + padding*2 + margin);
	    mainPanel.setLocation(0, 0);
	    mainPanel.setLayout(null);
	    
	    // first operand
	    firstOperand = new JTextField();
	    firstOperand.setSize(cellSize, cellSize);
	    firstOperand.setLocation(padding, padding);
	    firstOperand.setHorizontalAlignment(JTextField.CENTER);
	    
	    // operator
	    operator = new Label("",Label.CENTER);
	    operator.setSize(cellSize, cellSize);
	    operator.setLocation(padding+cellSize+margin,padding);
	    
	    
	    // second operand
	    secondOperand = new JTextField();
	    secondOperand.setSize(cellSize, cellSize);
	    secondOperand.setLocation(padding+cellSize*2+margin*2 ,padding);
	    secondOperand.setHorizontalAlignment(JTextField.CENTER);

	    // equal sign
	    equalSign = new Label("=",Label.CENTER);
	    equalSign.setSize(cellSize, cellSize);
	    equalSign.setLocation(padding+cellSize*3+margin*3,padding);
	    
	    
	    // result
	    result = new Label("",Label.CENTER);
	    result.setSize(cellSize, cellSize);
	    result.setLocation(padding+cellSize*4+margin*4,padding);
	    
	    
	    // plus
	    plus = new Button("+");
	    plus.setSize(cellSize,cellSize);
	    plus.setLocation(padding, padding+margin+cellSize);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator.setText("+");
			}
		});
	    
	    // minus
	    minus = new Button("-");
	    minus.setSize(cellSize,cellSize);
	    minus.setLocation(padding+cellSize+margin, padding+margin+cellSize);
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator.setText("-");
			}
		});
	    
	    // multiply
	    multiply = new Button("*");
	    multiply.setSize(cellSize,cellSize);
	    multiply.setLocation(padding+cellSize*2+margin*2, padding+margin+cellSize);
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator.setText("*");
			}
		});
	    
	    
	    // divide
	    divide = new Button("/");
	    divide.setSize(cellSize,cellSize);
	    divide.setLocation(padding+cellSize*3+margin*3, padding+margin+cellSize);
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator.setText("/");
			}
		});
	    
	    
	    // ok
	    ok = new Button("OK");
	    ok.setSize(cellSize,cellSize);
	    ok.setLocation(padding+cellSize*4+margin*4, padding+margin+cellSize);
	    ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstnum = firstOperand.getText();
				String secondnum = secondOperand.getText();
				if(isNum(firstnum) && isNum(secondnum)) {
					double first = Double.valueOf(firstnum);
					double second = Double.valueOf(secondnum);
					double ans = 0;
					String op = operator.getText();
					if(op == "+") {
						ans = first+second;
						result.setText(Double.toString(ans));
					}
					else if(op == "-") {
						ans = first-second;
						result.setText(Double.toString(ans));
					}
					else if(op == "*") {
						ans = first*second;
						result.setText(Double.toString(ans));
					}
					else if(op == "/") {
						ans = first/second;
						result.setText(Double.toString(ans));
					}
				}
			}
		});
	    
	    
	    mainPanel.add(firstOperand);
	    mainPanel.add(operator);
	    mainPanel.add(secondOperand);
	    mainPanel.add(equalSign);
	    mainPanel.add(result);
	    mainPanel.add(plus);
	    mainPanel.add(minus);
	    mainPanel.add(multiply);
	    mainPanel.add(divide);
	    mainPanel.add(ok);
	    mainFrame.add(mainPanel);
	    mainFrame.setVisible(true);

	}
	
	public Calculator() {

	    manageLayout();
	    
	}
	
	// check input
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
