import java.awt.*;


import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
public class consumer_loan_assistant implements ActionListener{
	JTextField a1=new JTextField();
	JTextField a2=new JTextField();
	JTextField a3=new JTextField();
	JTextField a4=new JTextField();
	JButton q=new JButton("New loan analysis");
	JButton S=new JButton("Compute monthly payment");
	JButton b=new JButton("X");
	JButton c=new JButton("X");
	TextArea g=new TextArea();
	JFrame w =new JFrame();
	JFrame k=new JFrame("loan assistant");
	String d=new String("hi");
	//JOptionPane o=new JOptionPane("invalid input");
	int months;
	JButton mo=new JButton("Exit");
	String aa=new String();
public void v()
{
		// TODO Auto-generated method stub
		//Panel k=new Panel();
		k.setSize(700,300);
		//l.setSize(700,600);
		k.setLayout(null);
		Label l1,l2,l3,l4;
		l1=new Label("Loan Balance:");
		l2=new Label("interest rate:");
		l3=new Label("number of payment:");
		l4=new Label("monthly payment:");
		l1.setBounds(10,20,80,20);
		l2.setBounds(10,50,80,20);
		l3.setBounds(10,80,120,20);
		l4.setBounds(10,110,100,20);
		//l1.deriveFont(20);
		k.add(l1);
		k.add(l2);
		k.add(l3);
		k.add(l4);
		a1.setBounds(135,20,150,20);
		a2.setBounds(135,50,150,20);
		a3.setBounds(135,80,150,20);
		a4.setBounds(135,110,150,20);
		k.add(a2);
		k.add(a3);
		k.add(a4);
		b.setBounds(300,80,50,27);
		k.add(b);
		c.setBounds(300,107,50,27);
		S.setBounds(65,150,200,27);
		k.add(S);
		k.add(c);
		q.setBounds(82,185,165,27);
		k.add(q);
		Label h=new Label("Loan analysis");
		h.setBounds(355,20,120,20);
		k.add(h);
		
		g.setBounds(355,50,300,117);
		k.add(g);
		
		mo.setBounds(470,185,70,20);
		k.add(mo);
		S.addActionListener(this);
		q.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		k.add(a1);	
		k.setVisible(true);
		q.setEnabled(false);
		c.setVisible(false);
		a3.setBackground(Color.white);
		a4.setBackground(Color.yellow);
		a4.setEditable(false);
		//k.setDefaultCloseOperation();
		k.setResizable(false);
}

public void actionPerformed (ActionEvent e)
{ if(e.getSource()==b)
	{
		b.setVisible(false);
		c.setVisible(true);	
		a3.setEditable(false);
		a4.setEditable(true);
		a3.setBackground(Color.yellow);
		a4.setBackground(Color.white);
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
		
	}
else if(e.getSource()==mo)
{
System.exit(0);
k.dispose();
}
	else if(e.getSource()==c)
	{
		c.setVisible(false);
		b.setVisible(true);
		a4.setBackground(Color.yellow);
		a3.setBackground(Color.white);
		a4.setEditable(false);
		a3.setEditable(true);
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
	}
	else if(e.getSource()==q)
	{
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
		S.setEnabled(true);
		q.setEnabled(false);
	}
if(e.getSource()==S)
{
			double  interest = 0, payment = 0;
			int months = 0,balance = 0;
			double monthlyInterest, multiplier;
			double loanBalance, finalPayment;
			if (a1.getText().equalsIgnoreCase(""))
			{
			JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPleasecorrect.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			balance =Integer.valueOf(a1.getText()).intValue();		
			}
			if (a2.getText().equalsIgnoreCase(""))
			{
			JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPleasecorrect.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				interest =
						Double.valueOf(a2.getText()).doubleValue();
			}
			monthlyInterest = interest / 1200;
			if(a3.getText().equalsIgnoreCase("") && a4.getText()!=""){
			// Compute loan payment
				if (interest == 0)
				{
				months = (int)(balance / payment);
				}
				else if(a4.getText().equalsIgnoreCase("")){
					JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Paymentsentry.\nPlease correct.", "Number of Payments Input Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					payment =
							Double.valueOf(a4.getText()).doubleValue();
						
				months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) /

				Math.log(1 + monthlyInterest));}
				a3.setText(String.valueOf(months));
			}
			//return;
			else if(a4.getText().equalsIgnoreCase("") && a3.getText()!="") {
			if (interest == 0)
			{
			payment = balance / months;
			}
			else if(a4.getText().equalsIgnoreCase(""))
			{
				months =
						Integer.valueOf(a3.getText()).intValue();
				
			multiplier = Math.pow(1 + monthlyInterest, months);
			payment = balance * monthlyInterest * multiplier / (multiplier - 1);
			}
			a4.setText(new DecimalFormat("0.00").format(payment));
			}
			q.setEnabled(true);
			S.setEnabled(false);
			g.setText("Loan Balance: $" + new
					DecimalFormat("0.00").format(balance));
					g.append("\n" + "Interest Rate: " + new
					DecimalFormat("0.00").format(interest) + "%");
					// process all but last payment
					loanBalance = balance;
					for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
					{
					loanBalance += loanBalance * monthlyInterest - payment;
					}
					// find final payment
					finalPayment = loanBalance;
					if (finalPayment > payment)
					{
					// apply one more payment
					loanBalance += loanBalance * monthlyInterest - payment;
					finalPayment = loanBalance;
					months++;
					a3.setText(String.valueOf(months));
					}
					g.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new
					DecimalFormat("0.00").format(payment));
					g.append("\n" + "Final Payment of: $" + new
					DecimalFormat("0.00").format(finalPayment));
					g.append("\n" + "Total Payments: $" + new
					DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
					g.append("\n" + "Interest Paid $" + new

					DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
}				
}

			//a4.setText(new DecimalFormat("0.00").format(payment));
			// Compute number of payments
			/*if (e.getSource()==S && a3.getText().equalsIgnoreCase(""))
			{
			payment =
			Double.valueOf(a4.getText()).doubleValue();
			if (payment <= (balance * monthlyInterest + 1.0))
			{
			if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do youwant to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)

			{
			a4.setText(new DecimalFormat("0.00").format((int)(balance *

			monthlyInterest + 1.0)));

			payment =

			Double.valueOf(a4.getText()).doubleValue();

			}
			else
			{
			a4.requestFocus();
			return;

			}
			}
			}
			else
			{
			JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Paymententry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE);

			return;
			}
			if (interest == 0)
			{
			months = (int)(balance / payment);
			}
			else


			{
			
			// reset payment prior to analysis to fix at two decimals
			payment =
			Double.valueOf(a4.getText()).doubleValue();
			// show analysis
			
			}}
		/*balance =
		Double.valueOf(a1.getText()).doubleValue();
		interest =
		Double.valueOf(a2.getText()).doubleValue();
		monthlyInterest = interest / 1200;
		// Compute loan payment
		if(a4.getText().equalsIgnoreCase(""))
		{	
		months =
		Integer.valueOf(a3.getText()).intValue();
		multiplier = Math.pow(1 + monthlyInterest, months);
		payment = balance * monthlyInterest * multiplier / (multiplier - 1);
		aa=Double.toString(payment);
		a4.setText(aa);
		}
		else
		{
			//Compute number of payments
			payment =
			Double.valueOf(a4.getText()).doubleValue();
			months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) /
			Math.log(1 + monthlyInterest));
			a3.setText(String.valueOf(months));
			}
		g.setText("Loan Balance: $" + new
				DecimalFormat("0.00").format(balance));
				g.append("\n" + "Interest Rate: " + new
				DecimalFormat("0.00").format(interest) + "%");
				// process all but last payment
				loanBalance = balance;
				for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
				{
				loanBalance += loanBalance * monthlyInterest - payment;
				}
				// find final payment
				finalPayment = loanBalance;
				if (finalPayment > payment)
				{
				// apply one more payment
				loanBalance += loanBalance * monthlyInterest - payment;
				finalPayment = loanBalance;
				months++;
				g.setText(String.valueOf(months));
				}
				g.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new
				DecimalFormat("0.00").format(payment));
				g.append("\n" + "Final Payment of: $" + new
				DecimalFormat("0.00").format(finalPayment));
				g.append("\n" + "Total Payments: $" + new
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
				g.append("\n" + "Interest Paid $" + new
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
				//computeButton.setEnabled(false);
				//newLoanButton.setEnabled(true);
				//newLoanButton.requestFocus();
				*/
private boolean validateDecimalNumber(JTextField a42) {
	// TODO Auto-generated method stub
	return false;
}
/*(else if(e.getSource()==b)
{
	b.setVisible(false);
	c.setVisible(true);	
	a3.setEditable(false);
	a4.setEditable(true);
	a3.setBackground(Color.yellow);
	a4.setBackground(Color.white);
	
}
else if(e.getSource()==c)
{
	c.setVisible(false);
	b.setVisible(true);
	a4.setBackground(Color.yellow);
	a3.setBackground(Color.white);
	a4.setEditable(false);
	a3.setEditable(true);
}
else if(e.getSource()==q)
{
	a1.setText("");
	a2.setText("");
	a3.setText("");
	a4.setText("");
	g.setText("");
	S.setEnabled(true);
	q.setEnabled(false);
}
	
}

private boolean validateDecimalNumber(JTextField a12) {
	// TODO Auto-generated method stub
	return false;
}
		
private boolean validateDecimalNumber(JTextField a12) {
	// TODO Auto-generated method stub
	return false;
}*/
public static void main(String[]args)
{
	consumer_loan_assistant fq=new consumer_loan_assistant();
	fq.v();
}
}