package tahminOyunu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class tahminOyunu extends JFrame {
	

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tahminOyunu frame = new tahminOyunu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	 public Random r;
	 public int a=0;
	 int count=0;
	 private JTextField txt1;
	public tahminOyunu() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("NUMBER GUESS\u0130NG GAME");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("Generate Number");
		btn1.setBackground(Color.LIGHT_GRAY);
		
		btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn1.setBounds(184, 21, 164, 36);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Guess");
		btn2.setBackground(Color.GREEN);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn2.setBounds(10, 66, 164, 34);
		contentPane.add(btn2);
		btn2.setEnabled(false);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt1.setBounds(10, 21, 164, 34);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btns = new JButton("Delete");
		
		btns.setBackground(Color.RED);
		btns.setFont(new Font("Tahoma", Font.BOLD, 14));
		btns.setBounds(184, 68, 164, 32);
		contentPane.add(btns);
		btns.setEnabled(false);
		
		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(10, 111, 316, 42);
		contentPane.add(lbl);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random r = new Random();
		        a = r.nextInt(100);
		        btn2.setEnabled(true);
		        btns.setEnabled(true);
                count=0;
                lbl.setText(null);
                txt1.setText(null);
                }
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
		        btn1.setEnabled(false);
				int guess=Integer.parseInt(txt1.getText());
				if (a==guess) 
				{
					lbl.setText("<html>Congrats you guessed right :)<br/> Number of guesses: "+count);
					btn2.setEnabled(false);
					btn1.setEnabled(true);
					btns.setEnabled(false);
				}
				else if (a>guess) 
				{
					lbl.setText("Enter a bigger number! ");
				}
				else if (a<guess)
				{
					lbl.setText("Enter a smaller number!");
				}
				
				btns.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txt1.setText(null);
						
					}
				});
				
				
				
			}
		});
		
		
		
		
		
		
	}
}