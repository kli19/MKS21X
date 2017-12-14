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
	String str = e.getActionCommand();
	System.out.println(str);
         if (str.equals("Celcius to Fahrenheit")){
	    double result = CF(Double.parseDouble(text.getText()));
	    text.setText( result + "");
	}     

	if (str.equals("Fahrenheit To Celcius")){
	    double result = FC(Double.parseDouble(text.getText()));
	    text.setText(result + "");
	}  	
	
    }

    public static double CF(double c){
	return (9.0/5)*c + 32;
    }

    public static double FC(double f){
	return (5.0/9)*(f -32);
    }


    public static void main(String[]args){
	Temperature x = new Temperature();
	x.setVisible(true);
	
    }
}

