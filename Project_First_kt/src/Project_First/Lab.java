package Project_First;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lab extends JPanel {
	JFrame jfa = new JFrame();
	JFrame jfb = new JFrame();
	JPanel jpa = new JPanel(new FlowLayout());
	JPanel jpb = new JPanel(new GridLayout(2,1));
	JPanel jpc = new JPanel();
	JLabel jla = new JLabel("무------------"+"\n"+"호");
	JLabel jlb = new JLabel("야------------");
	
	
	Lab(){
		jpa.setBackground(Color.BLUE);
		jpb.setBackground(Color.green);
		jpc.setBackground(Color.pink);
		jpa.add(jla);
		jpa.add(jlb);
		this.setLayout(new GridLayout(2,1));
		this.add("North", jpa);
		this.add("Center",jpc );
		jfa.add(this);
		jfa.setSize(500,500);
		jfa.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Lab();
	}
}
