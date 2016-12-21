import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window3 extends JFrame implements ActionListener {
    private Container pane;

    private JButton b, b2;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;

    public void actionPerformed(ActionEvent e){
	//this runs when an event triggers
	String cmd = e.getActionCommand();
	if(cmd.equals("Byte")){
	    t.setText(t.getText() + "Ow!");
	}
	if(cmd.equals("NoByte")){
	    t.setText("Yay!");
	}
    }
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window3() {
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	b = new JButton("Byte");
	b.addActionListener(this);
	b.setActionCommand("Byte");
       
	b2 = new JButton("No Byte");
	b2.addActionListener(this);
	b2.setActionCommand("NoByte");

	l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
	t = new JTextField(12);
	c = new JCheckBox("Overclock!!!");
	pane.add(l);
	pane.add(b);
	pane.add(b2);
	pane.add(t);
	pane.add(c);
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window3 g = new Window3();
	g.setVisible(true);
    }
}
