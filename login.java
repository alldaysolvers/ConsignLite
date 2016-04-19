/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consignlite;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author lhuang, sheetal
 */
public class login {
    
	JFrame f;
	JPanel p1, p2, p3, p4,p5;
	JLabel l1,l2,l3;
	static JTextField tf_Uname;
	JPasswordField pf_Upassword;
	JButton b_login;
	JButton b_cancel;
	
	login() {
		
		f = new JFrame("Login");
		f.setSize(300, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("                   ID: ");
		l2 = new JLabel("    Password: ");
		l3 = new JLabel("Login to ConsignLite");
		tf_Uname = new JTextField(15);
		pf_Upassword = new JPasswordField(15);
		
		p1 = new JPanel(new GridLayout(4, 1, 5, 5));
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));//(FlowLayout.CENTER)
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4 = new JPanel(new FlowLayout());
		p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.setLocationRelativeTo(null);
		
		Border border = BorderFactory.createLoweredBevelBorder();
		Border borderTitled = BorderFactory.createTitledBorder(border,"");
		p1.setBorder(borderTitled);
		
		b_login = new JButton("OK");
		b_cancel = new JButton("Quit");
		
		//rb_manager = new JRadioButton("ÓÃ»§");
		//rb_admin = new JRadioButton("¹ÜÀíÔ±");
		//rb_rest = new JRadioButton("ÉÌ¼Ò");
//		btnGroup = new ButtonGroup();
//		btnGroup.add(rb_manager);
//		btnGroup.add(this.rb_admin);
//		btnGroup.add(this.rb_rest);
//		rb_manager.setSelected(true);
//		p4.add(rb_manager);
//		p4.add(rb_admin);
//		p4.add(rb_rest);
		
		Border border2=BorderFactory.createEmptyBorder(15,2,2,2);
		p5.add(l3);
                p1.setBorder(border2);
		p1.add(p5);
		
		
		p2.add(l1);
		p2.add(tf_Uname);
		p1.add(p2);
		
		p3.add(l2);
		p3.add(pf_Upassword);
		p1.add(p3);
		
		p4.add(b_login);
		p4.add(b_cancel);
		p1.add(p4);
		
		f.add(p1);
		f.setVisible(true);
		b_login.addActionListener(new ButtonEvent1(this));
		b_cancel.addActionListener(new ButtonEvent2(this));
	}
	public static void main(String[] args) {
		login l=new login();
	}
}

class ButtonEvent1 implements ActionListener {
	login l;
	homePage hp;

	public ButtonEvent1(login l) {
		this.l = l;
	}

	public void actionPerformed(ActionEvent e) {
		
			System.out.print(l.tf_Uname.getText());
			
			if (l.tf_Uname.getText().compareTo("") == 0|| new String(l.pf_Upassword.getPassword()).compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Invalid ID or Password!");
					return;
			}
			else
			{
				String name = "";
				String psw = "";
				boolean b = false;
					
				
				if (l.tf_Uname.getText().compareTo("manager") == 0 || l.tf_Uname.getText().compareTo("salesperson") == 0 ) {
							b = true;
							
				}
			
					
			    if (b == false) {
						JOptionPane.showMessageDialog(null, "Invalid ID or Password");
						l.tf_Uname.setText("");
						l.pf_Upassword.setText("");
						return;
				} else {
					if (l.tf_Uname.getText().compareTo("manager") == 0 && new String(l.pf_Upassword.getPassword()).compareTo("manager") == 0 ||l.tf_Uname.getText().compareTo("salesperson") == 0 && new String(l.pf_Upassword.getPassword()).compareTo("salesperson") == 0) {
							
							l.f.setVisible(false);
							if(l.tf_Uname.getText().compareTo("manager") == 0)
							{
								hp=new homePage(1);
							}
							else
							{
								hp=new homePage(0);
							}

							System.out.print(" login succeed");
							//UserModify um=new UserModify();
						} else {
							JOptionPane.showMessageDialog(null, "Invalid ID or Password");
							l.tf_Uname.setText("");
							l.pf_Upassword.setText("");
						}
					}
				}
			}
	}


class ButtonEvent2 implements ActionListener {
	login l;
	
	public ButtonEvent2(login l) {
		this.l = l;
	}
	public void actionPerformed(ActionEvent e){
		l.f.setVisible(false);
        l.f.dispose();
        System.exit(0);
	}
	
	
}
