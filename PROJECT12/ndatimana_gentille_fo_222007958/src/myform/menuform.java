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

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.xdevapi.DeleteStatement;





public class menuform implements ActionListener{
	
	JFrame frame;
	JLabel idlb=new JLabel("id");
	JLabel pricelb=new JLabel("price");
	JLabel availabilitylb=new JLabel("availability");
	
	
	JTextField idTextField=new JTextField();
	JTextField priceField=new JTextField();
	JTextField availabilityTextField=new JTextField();
	
	
	JButton insertButton=new JButton("INSERT");
	JButton readButton=new JButton("READ");
	JButton updateButton=new JButton("UPDATE");
	JButton deleteButton=new JButton("DELETE");
	
	

	
	




public menuform() {
	createwindows();}

private void createwindows() {
frame= new JFrame();
frame.setTitle("MENUFORM");
frame.setBounds(10,10 ,400, 350);
frame.getContentPane().setBackground(Color.PINK);
frame.getContentPane().setLayout(null);
frame.setResizable(true);
frame.setVisible(true);
setsizeandLocation();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private void setsizeandLocation() {

idlb.setBounds(10,10,200,30);
pricelb.setBounds(10,50,200,30);
availabilitylb.setBounds(10,90,200,30);

idTextField.setBounds(160,10,130,30);
priceField.setBounds(160,50,150,30);
availabilityTextField.setBounds(160,90,130,30);

insertButton.setBounds(10,200,85,30);
readButton.setBounds(100,200,85,30);
updateButton.setBounds(190,200,85,30);
deleteButton.setBounds(280, 200, 85, 30);
addcomponenttoframe();
}
private void addcomponenttoframe() {
frame.add(idlb);
frame.add(pricelb);
frame.add(availabilitylb);


frame.add(idTextField);
frame.add(priceField);
frame.add(availabilityTextField);

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
			String query="INSERT INTO menu VALUES(?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(query);
			pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
			pStatement.setString(2, priceField.getText());
			pStatement.setString(3, availabilityTextField.getText());
			
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
			String sql="UPDATE menu SET  price=?,availability=? WHERE id=?";
			PreparedStatement stm=connection.prepareStatement(sql);
		
			stm.setString(1, priceField.getText());
			stm.setString(2, availabilityTextField.getText());
			stm.setInt(3,Integer.parseInt(idTextField.getText()));
			
			
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
			String sql="DELETE FROM menu  WHERE id=?";
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
	pricelb.setFont(fontii);
	availabilitylb.setFont(fontii);
	
	
	idTextField.setFont(fontii);
	priceField.setFont(fontii);
	availabilityTextField.setFont(fontii);
	
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
menuform mf=new menuform();

}

public void actionPerformed(java.awt.event.ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}}








	
