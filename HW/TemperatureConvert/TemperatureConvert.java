import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TemperatureConvert extends JFrame implements ActionListener{

    private Container pane;

    private JButton toF, toC;
    private JLabel label1, label2;
    private JTextField fahrenheit, celsius;

    public void actionPerformed(ActionEvent e){
	String temp = e.getActionCommand();
	if(temp.equals("F")){
	    String tmp = celsius.getText();
	    double cel = Double.parseDouble(tmp);
	    double result = ((cel * 9) / 5) + 32;
	    fahrenheit.setText(String.valueOf(result));
	}else if(temp.equals("C")){
	    String tmp2 = fahrenheit.getText();
	    double fah = Double.parseDouble(tmp2);
	    double result2 = ((fah - 32)*(5/9));
	    celsius.setText(String.valueOf(result2));
	}
    }

    public TemperatureConvert(){
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(null);

	toF = new JButton("C to F");
	toF.addActionListener(this);
	toF.setActionCommand("F");
	
	toC = new JButton("F to C");
	toC.addActionListener(this);
	toC.setActionCommand("C");

	fahrenheit = new JTextField(12);
	celsius = new JTextField(12);
	
	label1 = new JLabel("Fahrenheit");
	label2 = new JLabel("Celsius");

	pane.add(toF);
	pane.add(toC);
	pane.add(label1);
	pane.add(fahrenheit);
	pane.add(label2);
	pane.add(celsius);

	label1.setBounds(270, 25, 100, 40);
	fahrenheit.setBounds(240, 65, 120, 25);
	toF.setBounds(100, 150, 150, 50);
	toC.setBounds(350, 150, 150, 50);
	label2.setBounds(280, 240, 100, 40);
	celsius.setBounds(240, 280, 120, 25);
    }

    public static void main(String[] args){
	TemperatureConvert a = new TemperatureConvert();
	a.setVisible(true);
    }
}
