import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{

	static Container c;
	static JButton btn1 ;
	static JTextArea[] ta= new JTextArea[250];
	static JTextArea[] ta2= new JTextArea[250];
	static JTextArea[] ta3= new JTextArea[250];
	Color []array= {Color.RED, Color.YELLOW, Color.BLACK,Color.CYAN, Color.GRAY,Color.MAGENTA,Color.GREEN, Color.PINK, 
					Color.LIGHT_GRAY, Color.ORANGE, Color.DARK_GRAY};
	int bgcolorCount=0, frcolorCount=1;
	MyFrame(){

		ImageIcon icon= new ImageIcon("C:\\Users\\zohai\\Desktop\\zohaib1.png");	
		JLabel bgImage= new JLabel(icon);
		bgImage.setBounds(0,0,this.getWidth(),this.getHeight());
		
		this.setContentPane(bgImage);
		c= this.getContentPane();
		c.setLayout(null);

		/*btn1= new JButton("New Game");
		btn1.setBounds(150,70,120,30);
		//btn1.setaont(new Font("Arial",Font.BOLD,18));	
		btn1.addActionListener(this);
		

		c.add(btn1);*/
		
		
		for(int i=0; i<250; i++){
			
			ta[i]= new JTextArea();
			ta[i].setBounds(50,0+i,1,1);
			ta[i].setBackground(array[0]);
			ta[i].setEditable(false);
			
			ta2[i]= new JTextArea();
			ta2[i].setBounds(51,0+i,1,1);
			ta2[i].setBackground(array[9]);
			ta2[i].setEditable(false);
			
			ta3[i]= new JTextArea();
			ta3[i].setBounds(52,0+i,1,1);
			ta3[i].setBackground(array[2]);
			ta3[i].setEditable(false);
			
			c.add(ta[i]);
			c.add(ta2[i]);
			c.add(ta3[i]);
		}
		
		
	}
	public void actionPerformed(ActionEvent event){
		/*JButton btn= (JButton)event.getSource();
			btn.setVisible(false);
			c.remove(btn);
			btn=null;
			JTextaield ta= new JTextaield("welcome to the game...");
			ta.setBounds(5,10,150,25);
			c.add(ta);
			String color= (JOptionPane.showInputDialog(null,"Enter color name"));
			color= color.toUpperCase();
			ta.setText(color);*/
	}
	
	/*public void start(){
		for (int i=1 ;i<3*array.length ;i++ ) {
			try{Thread.sleep(400);}
			catch(InterruptedException ie){  }
			//btn1.setBounds(80,(i*5),50,30);
			btn1.setBackground(array[bgcolorCount]);
			btn1.setaoreground(array[frcolorCount]);
			frcolorCount++;
			bgcolorCount++;
			if(bgcolorCount==array.length){
			bgcolorCount=0;
			}

			if(frcolorCount==array.length){
			frcolorCount=0;
			}
		}
	}*/
}
public class Project{
	public static void main(String[] args){
		MyFrame myFrame= new MyFrame();
		myFrame.setTitle("19SW42 Java Project ");
		myFrame.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setBounds(50,50,400,300);
		//myFrame.start();		
	}
}