package myform;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;





public class paymentform implements ActionListener{
	
	JFrame frame;
	JLabel idlb=new JLabel("id");
	JLabel datelb=new JLabel("date");
	JLabel amauntlb=new JLabel("amaunt");
	JLabel methodlb=new JLabel("method");
	
	
	
	JTextField idTextField=new JTextField();
	JTextField dateField=new JTextField();
	JTextField amountTextField=new JTextField();
	JTextField methodTextField=new JTextField();
	
	
	JButton insertButton=new JButton("INSERT");
	JButton readButton=new JButton("READ");
	JButton updateButton=new JButton("UPDATE");
	JButton deleteButton=new JButton("DELETE");

	
	
public paymentform() {
	createwindows();}

private void createwindows() {
frame= new JFrame();
frame.setTitle("paymentFORM");
frame.setBounds(10,10 ,500, 340);
frame.getContentPane().setBackground(Color.red);
frame.getContentPane().setLayout(null);
frame.setResizable(true);
frame.setVisible(true);
setsizeandLocation();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
private void setsizeandLocation() {

idlb.setBounds(10,10,200,30);
datelb.setBounds(10,50,200,30);
amauntlb.setBounds(10,90,200,30);
methodlb.setBounds(10,130,200,30);

idTextField.setBounds(160,10,130,30);
dateField.setBounds(160,50,130,30);
amountTextField.setBounds(160,90,130,30);
methodTextField.setBounds(160,130,130,30);


insertButton.setBounds(10,200,85,30);
readButton.setBounds(100,200,85,30);
updateButton.setBounds(190,200,85,30);
deleteButton.setBounds(280, 200, 85, 30);
addcomponenttoframe();
}
private void addcomponenttoframe() {
frame.add(idlb);
frame.add(datelb);
frame.add(amauntlb);
frame.add(methodlb);



frame.add(idTextField);
frame.add(dateField);
frame.add(amountTextField);
frame.add(methodTextField);

frame.add(insertButton);
frame.add(readButton);
frame.add(updateButton);
frame.add(deleteButton);


	
ActionEvent();
}

private void ActionEvent() {


insertButton.addActionListener(this);
insertButton.addActionListener(new ActionListener() {
	
	public void actionPerformed(java.awt.event.ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ndatimana_gentille_fo_222007958","root","");
			String query="INSERT INTO payment VALUES(?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(query);
			pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
			pStatement.setString(2, dateField.getText());
			pStatement.setString(3,amountTextField.getText());
			pStatement.setString(4, methodTextField.getText());
			
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(insertButton, "data inserted well");
			pStatement.close();
			connection.close();	
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

		}
		});	
readButton.addActionListener(this);

updateButton.addActionListener(this);
updateButton.addActionListener(new ActionListener() {

public void actionPerformed(java.awt.event.ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ndatimana_gentille_fo_222007958","root","");
			String sql="UPDATE payment SET  date=?,amaunt=?,method=? WHERE id=?";
			PreparedStatement stm=connection.prepareStatement(sql);
		
			stm.setString(1, dateField.getText());
			stm.setString(2, amountTextField.getText());
			stm.setString(3, methodTextField.getText());
			stm.setInt(4,Integer.parseInt(idTextField.getText()));
			
			
			stm.executeUpdate();
			
			JOptionPane.showMessageDialog(updateButton, "update data!");
			stm.close();
			connection.close();	
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
	}
			});



	

deleteButton.addActionListener(this);
deleteButton.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(java.awt.event.ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ndatimana_gentille_fo_222007958","root","");
			String sql="DELETE FROM payment  WHERE id=?";
			int brtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:"));
			
			
			PreparedStatement stm=connection.prepareStatement(sql);
			
			
			
			
			stm.setInt(1,brtxf);
			
			JOptionPane.showMessageDialog(deleteButton, "recorded out!!!!!!!!!");
			Component delete;
			stm.executeUpdate();
			stm.close();
			
			connection.close();	
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
	}
});	



}		
	
private void setallfont() {
	
	Font fontii=new Font("georgia",Font.ITALIC,18);
	idlb.setFont(fontii);
	datelb.setFont(fontii);
	amauntlb.setFont(fontii);
	methodlb.setFont(fontii);

	
	
	idTextField.setFont(fontii);
	dateField.setFont(fontii);
	amountTextField.setFont(fontii);
	methodTextField.setFont(fontii);
	
	
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
paymentform pf=new paymentform();

}

public void actionPerformed(java.awt.event.ActionEvent e) {
	// TODO Auto-generated method stub
	
}}
