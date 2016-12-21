import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConvert extends JFrame implements ActionListener{

    private Container pane;

    private JButton toF, toC;
    private JLabel label;
    private JTextField textbox;

    public void actionPerformed(ActionEvent e){
	

    }

    public TemperatureConvert(){
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new CardLayout());

    }

    public static void main(String[] args){
	TemperatureConvert a = new TemperatureConvert();
	a.setVisible(true);
    }
}
