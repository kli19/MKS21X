import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame implements ActionListener{

    private Container pane;
    private JTextField text;
    private JButton FToC;
    private JButton CToF;
    
    public Temperature(){
	this.setTitle("Temperature");
	this.setSize(200,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	text = new JTextField(5);
	pane.add(text);

	CToF = new JButton("Celcius to Fahrenheit");
	pane.add(CToF);

        FToC = new JButton("Fahrenheit To Celcius");
	pane.add(FToC);

	text.addActionListener(this);
	CToF.addActionListener(this);
	FToC.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
    }


    public static void main(String[]args){
	Temperature x = new Temperature();
	x.setVisible(true);
	
    }
}

