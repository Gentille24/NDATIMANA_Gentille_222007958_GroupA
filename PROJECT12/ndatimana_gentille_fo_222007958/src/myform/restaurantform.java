package myform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;





public class restaurantform implements ActionListener{
	
	JFrame frame;
	JLabel idlb=new JLabel("id");
	JLabel namelb=new JLabel("name");
	JLabel addresslb=new JLabel("address");
	JLabel numberlb=new JLabel("number");

	
	
	JTextField idTextField=new JTextField();
	JTextField nameField=new JTextField();
	JTextField addressTextField=new JTextField();
	JTextField numberTextField=new JTextField();
	
	
	
	JButton insertButton=new JButton("INSERT");
	JButton readButton=new JButton("READ");
	JButton updateButton=new JButton("UPDATE");
	JButton deleteButton=new JButton("DELETE");

	
	
public restaurantform() {
	createwindows();}

private void createwindows() {
frame= new JFrame();
frame.setTitle("restaurantFORM");
frame.setBounds(10,10 ,400, 350);
frame.getContentPane().setBackground(Color.blue);
frame.getContentPane().setLayout(null);
frame.setResizable(true);
frame.setVisible(true);
setsizeandLocation();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private void setsizeandLocation() {

idlb.setBounds(10,10,200,30);
namelb.setBounds(10,50,200,30);
addresslb.setBounds(10,90,200,30);
numberlb.setBounds(10,130,200,30);


idTextField.setBounds(160,10,130,30);
nameField.setBounds(160,50,150,30);
addressTextField.setBounds(160,90,170,30);
numberTextField.setBounds(160,130,190,30);


insertButton.setBounds(10,200,85,30);
readButton.setBounds(100,200,85,30);
updateButton.setBounds(190,200,85,30);
deleteButton.setBounds(280, 200, 85, 30);
addcomponenttoframe();
}
private void addcomponenttoframe() {
frame.add(idlb);
frame.add(namelb);
frame.add(addresslb);
frame.add(numberlb);



frame.add(idTextField);
frame.add(nameField);
frame.add(addressTextField);
frame.add(numberlb);


frame.add(insertButton);
frame.add(readButton);
frame.add(updateButton);
frame.add(deleteButton);


	
ActionEvent();
}

private void ActionEvent() {


insertButton.addActionListener(this);
readButton.addActionListener(this);
updateButton.addActionListener(this);
deleteButton.addActionListener(this);

}		
	
private void setallfont() {
	
	Font fontii=new Font("georgia",Font.ITALIC,18);
	idlb.setFont(fontii);
	namelb.setFont(fontii);
	addresslb.setFont(fontii);
	numberlb.setFont(fontii);
	
	
	
	idTextField.setFont(fontii);
	nameField.setFont(fontii);
	addressTextField.setFont(fontii);
	numberTextField.setFont(fontii);

	
Font fii=new Font("courierNew",Font.BOLD,12);
insertButton.setFont(fontii);
readButton.setFont(fontii);
updateButton.setFont(fontii);
deleteButton.setFont(fontii);
}

public void actionperformed1 (ActionEvent e) {
// TODO Auto_generated method stub
}
public static void main (String[]args) {
restaurantform rf=new restaurantform();

}

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
	// TODO Auto-generated method stub
	
}}