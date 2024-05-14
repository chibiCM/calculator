package Main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtScreen;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator2 frame = new Calculator2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String numSTR[];
	
	String empSTR1;
	String empSTR2;
	String ansSTR;
	

	float empFLT1;
	float empFLT2;
	float ansFLT;
	
	boolean specificOp;
	boolean addi = false;
	boolean minus = false;
	boolean times = false;
	boolean dividedby = false;
	
	boolean positiveNum = true;
	boolean negativeNum = false;
	
	String turnToFloat = "";
	
	void pressedButton(Object theButton) {
		txtScreen.setText(txtScreen.getText() + theButton);
	}
	
	boolean operation(boolean specificOp) {
		specificOp = true;
		empSTR1 = txtScreen.getText();
		
		empFLT1 = Float.parseFloat(empSTR1);
		if(negativeNum) {
			empFLT1 = -empFLT1;
		}
		txtScreen.setText("");
		return specificOp;
		
	}
	
	public Calculator2() {
		setResizable(false);
		setTitle("calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtScreen = new JTextField();
		txtScreen.setBounds(50, 31, 269, 47);
		contentPane.add(txtScreen);
		txtScreen.setColumns(10);
		txtScreen.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		
		
		int theBTNheight = 40;
		int theBTNwidth = 60;
		int thebuttonSpace = 50;
		int yAxis = 90;
		for(int i=1; i<=9; i++) {
			for(int j = i; j <= i+2; j++) {
				String iValue = String.valueOf(j);
				JButton theBTN = new JButton(iValue);
				theBTN.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
				theBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pressedButton(theBTN.getText());
					}
				});
				if(j == 1 || j == 4 || j == 7) {
					theBTN.setBounds(thebuttonSpace, yAxis, theBTNwidth, theBTNheight);
				}else if (j == 2 || j == 5 || j == 8){
					theBTN.setBounds(thebuttonSpace+70, yAxis, theBTNwidth, theBTNheight);
				}else {
					theBTN.setBounds(thebuttonSpace+140, yAxis, theBTNwidth, theBTNheight);
				}
				contentPane.add(theBTN);
			}
			yAxis = yAxis + 50;
			i = i +2;
		}
		
		
		JButton btnZero = new JButton("0");
		btnZero.setBounds(thebuttonSpace, 90+(theBTNheight+10)*3, 60, 40);
		contentPane.add(btnZero);
		btnZero.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnZero.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	pressedButton(btnZero.getText());
		    }
		});
		
		JButton btnPoNe = new JButton("+/-");
		btnPoNe.setBounds(thebuttonSpace+70, 90+(theBTNheight+10)*3, 60, 40);
		contentPane.add(btnPoNe);
		btnPoNe.setFont(new Font("Poppins SemiBold", Font.PLAIN, 13));
		btnPoNe.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(positiveNum && !txtScreen.getText().isEmpty()) {
					 positiveNum = false;
	                 negativeNum = true;
	                 
	                 if(txtScreen.getText().startsWith("-")) {
                        txtScreen.setText(txtScreen.getText().substring(1));
                    }else {
                   	 txtScreen.setText("-"+txtScreen.getText());
                    }
				 }
				  positiveNum = true;
				  negativeNum = false;
		    }
		});
		
		
		JButton btnDOT = new JButton(".");
		btnDOT.setBounds(thebuttonSpace+70*2, 90+(theBTNheight+10)*3, 60, 40);
		contentPane.add(btnDOT);
		btnDOT.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnDOT.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(txtScreen.getText().contains(".")) {
		    		txtScreen.setText(txtScreen.getText());
		    	}else {
		    		txtScreen.setText(txtScreen.getText()+".");
		    	}

		    }
		});
		
		JButton btnCLR = new JButton("CLR");
		btnCLR.setBounds(thebuttonSpace, 90+(theBTNheight+10)*4, 60, 40);
		contentPane.add(btnCLR);
		btnCLR.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		btnCLR.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	txtScreen.setText("");
		    }
		});
		
		JButton btnCE = new JButton("CE");
		btnCE.setBounds(thebuttonSpace+70, 90+(theBTNheight+10)*4, 60, 40);
		contentPane.add(btnCE);
		btnCE.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		btnCE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	txtScreen.setText(txtScreen.getText().substring(0, txtScreen.getText().length()-1));
		    }
		});
		
		
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(260, 90, 60, 40);
		contentPane.add(btnAdd);
		btnAdd.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	addi = operation(addi); 	
		    }
		});
		
		JButton btnSub = new JButton("-");
		btnSub.setBounds(260, 90+(theBTNheight*1)+10, 60, 40);
		contentPane.add(btnSub);
		btnSub.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnSub.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	minus = operation(minus);
		    }
		});
		
		JButton btnMul = new JButton("*");
		btnMul.setBounds(260, 90+(theBTNheight+10)*2, 60, 40);
		contentPane.add(btnMul);
		btnMul.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnMul.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	times = operation(times);
		    }
		});
		
		JButton btnDiv = new JButton("/");
		btnDiv.setBounds(260, 90+(theBTNheight+10)*3, 60, 40);
		contentPane.add(btnDiv);
		btnDiv.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnDiv.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	dividedby = operation(dividedby);
		    }
		});
		
		JButton btnEqual = new JButton("=");
		btnEqual.setBounds(260-70, 90+(theBTNheight+10)*4, 130, 40);
		contentPane.add(btnEqual);
		btnEqual.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
		btnEqual.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
				empSTR2 = txtScreen.getText();
				

				empFLT1 = Float.parseFloat(empSTR1);
				empFLT2 = Float.parseFloat(empSTR2);
					
				if(addi) ansFLT = empFLT1 + empFLT2;
				if(minus) ansFLT = empFLT1 - empFLT2;
				if(times) ansFLT = empFLT1 * empFLT2;
				if(dividedby) ansFLT = empFLT1 / empFLT2;
					
				ansSTR = String.valueOf(ansFLT);
					
				txtScreen.setText(ansSTR);
				
				addi = false;
				minus = false;
				times = false;
				dividedby = false;

		    }
		});
		
	}
}

