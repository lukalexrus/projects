package Timer;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;



public class Timer_v1 {

	private JFrame frame;
	private JTextField textField;
	private Timer timer;

	String countdown;
	int count;
	JLabel label_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer_v1 window = new Timer_v1();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}


	
	
	
	
	
	/**
	 * Create the application.
	 */
	public Timer_v1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(175, 30, 111, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041D\u0430\u0447\u0430\u043B\u043E \u043E\u0442\u0441\u0447\u0435\u0442\u0430");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(39, 30, 130, 30);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 99));
		label_1.setBounds(162, 90, 188, 123);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("\u0421\u0442\u0430\u0440\u0442");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				countdown= textField.getText();
				count = Integer.parseInt(countdown);
				if(countdown.equals(""))
				{
					JOptionPane.showMessageDialog(frame, "¬ведите секунды");
				}
				
				else{
				timer = new Timer(1000, new TimerTick());
                timer.start();
				
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(316, 30, 89, 30);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	class TimerTick implements ActionListener {
	    
	    
		
	     @Override
	     public void actionPerformed(ActionEvent e) {
	    	 label_1.setText(String.valueOf(count));
	    	 count--; 	
	         if (count == -1) {
	             timer.stop();
	             
	             
	             Clip c;
	             AudioInputStream ais;
				try {
					c = AudioSystem.getClip();
					ais = AudioSystem.getAudioInputStream(new File("D:\\EDU\\java\\workplace\\Timer\\src\\Timer\\play.wav"));
					c.open(ais);
					c.loop(0);
					Thread.sleep(1000);
				}
				catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	         }
	     }
	     
	 }
}
