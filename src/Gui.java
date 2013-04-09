import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Gui extends JFrame implements ActionListener{

	public JPanel p1,p2,p3;
	public JLabel l1,l2,l3,l4,l5;
	public JTextField t2,t3,t4;
	public JTextArea t1;
	public JButton b1,b2,b3,b4,b5;
	public JComboBox c1;
	public ArrayList<Exp> l;

	public Gui()
	{
		
		
		
		

		
		
		
		this.b1=new JButton("Read File");
		this.b2=new JButton("Read Keyboard");
		this.b3=new JButton("Check");
		this.b4=new JButton("Convert");
		this.b5=new JButton("Save to File");
		
		this.t1=new JTextArea(10,10);
		this.t2=new JTextField(10);
		this.t3=new JTextField(10);
		this.t4=new JTextField(10);
		
		
		this.p1=new JPanel(new FlowLayout());
		this.p2=new JPanel(new GridLayout(1,1));
		this.p3=new JPanel(new FlowLayout());
		t1.setText("(b * b ) * ( f * g )");
		//this.p1.add(this.l1);
		this.p2.add(this.t1);
		this.p3.add(this.b1);
		this.p3.add(this.b2);
		


		
		this.p3.add(this.b3);
		this.p3.add(this.b4);
		this.p3.add(this.b5);
		
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		this.b3.addActionListener(this);
		this.b4.addActionListener(this);
		this.b5.addActionListener(this);
		
		
		this.add(p2,BorderLayout.NORTH);
	//	this.add(p2,BorderLayout.CENTER);
		this.add(p3,BorderLayout.SOUTH);
		
		this.setTitle("Ayyah Frame");
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.b1)//write
		{
			 l=new ArrayList<Exp>();
			TextIO te=new TextIO();
			
			te.readFile();
			t1.setText(te.text);
			for( String x : te.stringToArray()){
		
			Exp ex=new Exp(x);
			l.add(ex);
			}
			
		}
		
		if(e.getSource()==this.b5)//write
		{
		
			
	String str=this.t1.getText();

			TextIO te=new TextIO();
			
			try {
				te.WiteFile(str);
				JOptionPane.showMessageDialog(null, "Write Done : \n output.txt");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==this.b2)
		{
			
			 l=new ArrayList<Exp>();
			
	
			Exp st=new Exp(this.t1.getText());
		
			l.add(st);

			JOptionPane.showMessageDialog(null, "Done");
			
			
		}
		if(e.getSource()==this.b3)
		{
			JOptionPane.showMessageDialog(null, "Done,click convert");
		}
		if(e.getSource()==this.b4)
		{
		
			String str="";
			for(String x : t1.getText().split("\n") )
			{
				Exp st=new Exp(x);
				Infix2Postfix inf=new Infix2Postfix(st.exp);
				str+="infix : "+st.exp+"\n"+"postfix : "+inf.returnS+"\n---------------\n";
			}
			t1.setText(str);

		//	System.out.println();
			

			}
		// TODO Auto-generated method stub
	}

}
