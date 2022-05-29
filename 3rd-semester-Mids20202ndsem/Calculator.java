import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
//import java.applet.Applet.*;

class MyCalculator extends JFrame implements ActionListener, MouseListener,Runnable{
	Container  c;
	JTextArea text,answerArea;
	JTextField num1Field, num2Field, operationField, timeField;
	JButton  plus,minus,multiply,divide,clearBtn,equalBtn,closeBtn; 
	float  answer,num1,num2;
	
	MyCalculator(){
		c= this.getContentPane();
		c.setLayout(null);
		Font font=new Font("Arial",Font.BOLD,25);
		Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
		

		///////////text area where user writes////
		text=new JTextArea("");
		text.setBounds(20,20,200,100);
		text.setFont(font);
		
		/////////////1st number's field///// 
		num1Field=new JTextField("");
		num1Field.setBounds(230,20,90,25);
		num1Field.setFont(font);
		num1Field.setEditable(false);
		

		///////operation's field which   to be performed//////
		operationField=new JTextField("");
		operationField.setBounds(260,60,30,25);
		operationField.setFont(font);
		operationField.setEditable(false);
		

		//////////2nd numbers's field/////////
		num2Field=new JTextField("");
		num2Field.setBounds(230,100,90,25);
		num2Field.setFont(font);
		num2Field.setEditable(false);
		

		////////answer area//////
		answerArea=new JTextArea("Previous Answers:\n");
		answerArea.setBounds(30,250,180,190);
		answerArea.setEditable(false);
		

		//////////////time field where time is ticking/////
		timeField=new JTextField("");
		timeField.setBounds(230,320,150,50);
		timeField.setFont(font);
		timeField.setEditable(false);
		timeField.setForeground(Color.BLACK);
		

		////////plus button/////////
		plus=new JButton("+");
		plus.setBounds(20,160,50,30);
		plus.setCursor(cursor);
		plus.setFont(font);
		

		///////////minus button//////
		minus=new JButton("-");
		minus.setBounds(80,160,50,30);
		minus.setCursor(cursor);
		minus.setFont(font);
		

		////////////multiply button//////
		multiply=new JButton("x");
		multiply.setBounds(140,160,50,30);
		multiply.setCursor(cursor);
		multiply.setFont(font);
		

		///////////divide button/////////
		divide=new JButton("/");
		divide.setBounds(200,160,50,30);
		divide.setCursor(cursor);
		divide.setFont(font);
		

		//////////equal button/////// 
		equalBtn=new JButton("=");
		equalBtn.setBounds(260,160,50,30);
		equalBtn.setCursor(cursor);
		equalBtn.setFont(font);
		

		/////////////clear button//////////
		clearBtn=new JButton("Clear");
		clearBtn.setBounds(200,200,80,30);
		clearBtn.setCursor(cursor);
		

		///////////close button/////////
		closeBtn=new JButton("Close");
		closeBtn.setBounds(100,200,80,30);
		closeBtn.setCursor(cursor);
		

		
		

		//////////addding actionlisteners to buttons/////
		plus.addActionListener(this);
		minus.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		clearBtn.addActionListener(this);
		equalBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		

		//////////addding Mouselisteners to buttons/////
		plus.addMouseListener(this);
		minus.addMouseListener(this);
		multiply.addMouseListener(this);
		divide.addMouseListener(this);
		clearBtn.addMouseListener(this);
		equalBtn.addMouseListener(this);
		closeBtn.addMouseListener(this);
		
		
		//////////addding Mouselisteners to textAreas and fields/////
		text.addMouseListener(this);
		answerArea.addMouseListener(this);
		num1Field.addMouseListener(this);
		operationField.addMouseListener(this);
		num2Field.addMouseListener(this);
		timeField.addMouseListener(this);
		

		//////////addding Mouselisteners to container/////
		c.addMouseListener(this);


		/////////adding components////////////
		c.add(text);
		c.add(answerArea);
		c.add(plus);
		c.add(minus);
		c.add(multiply);
		c.add(divide);
		c.add(clearBtn);
		c.add(equalBtn);
		c.add(closeBtn);
		c.add(num1Field);
		c.add(num2Field);
		c.add(timeField);
		c.add(operationField);

		
	}
	

	/////////////////functionality of buttons when clicked////////////
	public void actionPerformed(ActionEvent event){

		JButton clickedBtn=(JButton)event.getSource();

		if(clickedBtn.equals(plus)){
			try{
				num1= Float.parseFloat(text.getText());
				
				num1Field.setText(Float.toString(num1));
				operationField.setText("+");
				text.setText("");
				text.requestFocus();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"error occurred while adding!","Warning!",JOptionPane.WARNING_MESSAGE);	
				text.setText("");
				text.requestFocus();
			}
		}
		
		if(clickedBtn.equals(minus)){
			try{
				num1= Float.parseFloat(text.getText());
				num1Field.setText(Float.toString(num1));
				operationField.setText("-");
				text.setText("");
				text.requestFocus();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"error occurred while subtracting !","Warning!",JOptionPane.WARNING_MESSAGE);	
				text.setText("");
				text.requestFocus();
			}
		}
		
		if(clickedBtn.equals(multiply)){
			try{
				num1= Float.parseFloat(text.getText());
				num1Field.setText(Float.toString(num1));
				operationField.setText("X");
				text.setText("");
				text.requestFocus();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"error occurred while multiplying!","Warning!",JOptionPane.WARNING_MESSAGE);					
				text.setText("");
				text.requestFocus();
			}
		}
		
		if(clickedBtn.equals(divide)){
			try{
				num1= Float.parseFloat(text.getText());
				num1Field.setText(Float.toString(num1));
				operationField.setText("/");
				text.setText("");
				text.requestFocus();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"error occurred while dividing","Warning!",JOptionPane.WARNING_MESSAGE);						
				text.setText("");
				text.requestFocus();
			}
		}
		
		////////////perform operation//////////
		
		if(clickedBtn.equals(equalBtn)){
			try{
				
				char operationSign= operationField.getText().charAt(0);
				num2Field.setText(text.getText());

				num1= Float.parseFloat(num1Field.getText());				
				num2= Float.parseFloat(num2Field.getText());				
				text.setText("");
				
				try{
					switch(operationSign){
						
						case '+':
							answer=num1+num2;
							text.setText(num1+"+"+num2+": \n\n"+answer);
							answerArea.append(num1+plus.getText()+num2+": "+Float.toString(answer)+"\n");
							break;
							
						case '-':
							answer=num1-num2;
							text.setText(num1+"-"+num2+": \n\n"+answer);
							answerArea.append(num1+minus.getText()+num2+": "+Float.toString(answer)+"\n");
							break;
						
						case 'X':
							answer=num1*num2;
							text.setText(num1+"X"+num2+": \n\n"+answer);
							answerArea.append(num1+multiply.getText()+num2+": "+Float.toString(answer)+"\n");
							break;
							
						case '/':
							answer=num1/num2;
							text.setText(num1+"/"+num2+": \n\n"+answer);
							answerArea.append(num1+divide.getText()+num2+": "+Float.toString(answer)+"\n");
							break;
							
						default:
						   text.setText("error!");
						
					}
				}
				catch(ArithmeticException ae){ 
												//////if 2nd number is zero////
					JOptionPane.showMessageDialog(null,"Divide by zero","Warning!",JOptionPane.WARNING_MESSAGE);	
					num2Field.setText("");
					num1Field.setText("");
					operationField.setText("");
					text.requestFocus();
				}
				text.requestFocus();
			}
			catch(Exception e){
					JOptionPane.showMessageDialog(null,"error!","Warning!",JOptionPane.WARNING_MESSAGE);
					text.requestFocus();
			}
		}
		
		if(clickedBtn.equals(clearBtn)){
			text.setText("");
			num2Field.setText("");
			num1Field.setText("");
			operationField.setText("");
			
			text.requestFocus();
		}
		
		if(clickedBtn.equals(closeBtn)){
			text.setText("");
			System.exit(0);	
		}
		
	}	


	//////////////////when mouse enter into a component///////////
	public void mouseEntered(MouseEvent event){
		
		Component enteredBtn=(Component)event.getSource();

		if(enteredBtn.equals(c)){
			c.setBackground(Color.CYAN);
		}
		
		if(enteredBtn.equals(text)){
			text.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(answerArea)){
			answerArea.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(num1Field)){
			num1Field.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(num2Field)){
			num2Field.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(timeField)){
			timeField.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(operationField)){
			operationField.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(plus)){
			plus.setBackground(Color.MAGENTA);
		}
		
		if(enteredBtn.equals(minus)){
			minus.setBackground(Color.YELLOW);
		}
		
		if(enteredBtn.equals(multiply)){
			multiply.setBackground(Color.CYAN);
		}
		
		if(enteredBtn.equals(divide)){
			divide.setBackground(Color.ORANGE);
		}
		
		if(enteredBtn.equals(clearBtn)){
			clearBtn.setBackground(Color.GREEN);
		}
		
		if(enteredBtn.equals(equalBtn)){
			equalBtn.setBackground(Color.BLUE);
		}
		
		if(enteredBtn.equals(closeBtn)){
			closeBtn.setBackground(Color.RED);
		}
		
	}
	
	//////////////////when mouse exit from a component///////////
	public void mouseExited(MouseEvent event){
		
		if(event.getSource().equals(c)){
			c.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(text)){
			text.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(answerArea)){
			answerArea.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(num1Field)){
			num1Field.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(timeField)){
			timeField.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(num2Field)){
			num2Field.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(operationField)){
			operationField.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(plus)){
			plus.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(minus)){
			minus.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(multiply)){
			multiply.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(divide)){
			divide.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(equalBtn)){
			equalBtn.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(clearBtn)){
			clearBtn.setBackground(new JButton().getBackground());
		}
		
		if(event.getSource().equals(closeBtn)){
			closeBtn.setBackground(new JButton().getBackground());
		}
	}
	
	public void mousePressed(MouseEvent event){
		if(event.getSource().equals(text)){
			text.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(answerArea)){
			answerArea.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(num1Field)){
			num1Field.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(num2Field)){
			num2Field.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(timeField)){
			timeField.setBackground(Color.WHITE);
		}
		
		if(event.getSource().equals(operationField)){
			operationField.setBackground(Color.WHITE);
		}
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseReleased(MouseEvent event){
		
	}

		//////////////////run() method of Runnable interface////////// 
	public void run(){
		while(true){

			///////initializing calender object////
			Calendar time = new GregorianCalendar();

            int hour = time.get(Calendar.HOUR);
            int minutes = time.get(Calendar.MINUTE);
            int seconds = time.get(Calendar.SECOND);
            int amOrPm= time.get(Calendar.AM_PM);
           
           if(hour==0)                      ///as GregorianCalendar has max value 12 for hour 
					hour=12;
            if(amOrPm==10)
                timeField.setText(hour + ":" + minutes + ":" + seconds+" AM");
            else
                timeField.setText(hour + ":" + minutes + ":" + seconds+" PM");

			/////////////after evry one second repeat the loop//////
			try{	Thread.sleep(1000);       }
			catch(InterruptedException ie){	/**/  }
		}
	}
}                  
//////////////class ended/////////////////////////

public class Calculator{
	public static void main(String args[]){
		
		MyCalculator cal= new MyCalculator();
		cal.setBounds(50,20,400,550);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cal.setVisible(true);
		cal.setResizable(false);	
		cal.setTitle("Calculator By 19SW121");
		
		//////for time running concurrently///////
		Thread timeThread= new Thread(cal,"My Time Thread");
		timeThread.start();
		
	}
}