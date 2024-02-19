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





public class customerform implements ActionListener{
	
	JFrame frame;
	JLabel idlb=new JLabel("id");
	JLabel namelb=new JLabel("name");
	JLabel addresslb=new JLabel("address");
	JLabel phonelb=new JLabel("phone");
	JLabel Emaillb=new JLabel("email");
	
	
	JTextField idTextField=new JTextField();
	JTextField nameTextField=new JTextField();
	JTextField addressTextField=new JTextField();
	JTextField phoneTextField=new JTextField();
	JTextField EmailTextField=new JTextField();
	
	
	JButton insertButton=new JButton("INSERT");
	JButton readButton=new JButton("READ");
	JButton updateButton=new JButton("UPDATE");
	JButton deleteButton=new JButton("DELETE");

	
	
public customerform() {
	createwindows();}

private void createwindows() {
frame= new JFrame();
frame.setTitle("customerFORM");
frame.setBounds(10,10 ,400, 350);
frame.getContentPane().setBackground(Color.GREEN);
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
phonelb.setBounds(10,130,200,30);
Emaillb.setBounds(10,170,200,30);

idTextField.setBounds(160,10,130,30);
nameTextField.setBounds(160,50,150,30);
addressTextField.setBounds(160,90,170,30);
phoneTextField.setBounds(160,130,190,30);
EmailTextField.setBounds(160,170,210,30);

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
frame.add(phonelb);
frame.add(Emaillb);


frame.add(idTextField);
frame.add(nameTextField);
frame.add(addressTextField);
frame.add(phoneTextField);
frame.add(EmailTextField);

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
			
			String query="INSERT INTO customer VALUES(?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(query);
			pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
			pStatement.setString(2, nameTextField.getText());
			pStatement.setString(3, addressTextField.getText());
			pStatement.setString(4, phoneTextField.getText());
			pStatement.setString(5, EmailTextField.getText());
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
			String sql="UPDATE payment SET  name=?,address=?,phone=?,Email=? WHERE id=?";
			PreparedStatement stm=connection.prepareStatement(sql);
		
			stm.setString(1, nameTextField.getText());
			stm.setString(2, addressTextField.getText());
			stm.setString(3, phoneTextField .getText());
			stm.setString(4, EmailTextField .getText());
			stm.setInt(5,Integer.parseInt(idTextField.getText()));
			
			
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
			String sql="DELETE FROM customer  WHERE id=?";
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
	namelb.setFont(fontii);
	addresslb.setFont(fontii);
	phonelb.setFont(fontii);
	Emaillb.setFont(fontii);
	
	
	idTextField.setFont(fontii);
	nameTextField.setFont(fontii);
	addressTextField.setFont(fontii);
	phoneTextField.setFont(fontii);
	EmailTextField.setFont(fontii);
	
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
customerform cf=new customerform();

}

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
	// TODO Auto-generated method stub
	
}}



	
