package creepingLine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class creepingLine {

	private JFrame frame;
	private JTextField textField;

	private JLabel label;
	
	String spase="          ";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creepingLine window = new creepingLine();
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
	public creepingLine() {
		initialize();
	}

	private void funct(String a) throws InterruptedException
	{
		new Thread() {
			 
            @Override
            public void run() {
            	String b=spase.concat(a);
            	String c="";
            	String []arr=new String[spase.length()];
            	String []arr2=new String[spase.length()];
            	arr=b.split("");
		for(int i=0;i<b.length()+16;i++)
		{
			c="";
			for (int j=i;j<i+10;j++)
			{
				if(j<b.length())
				{
				c+=arr[j];
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			label.setText(c);//convertStringArrayToString(arr2));
			
		}
            }
            }.start();
	}
	
	 private static String convertStringArrayToString(String[] strArr) {
	        StringBuilder sb = new StringBuilder();
	        for(String str : strArr) sb.append(str);
	        return sb.toString();
	    }
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u0417\u0430\u043F\u0443\u0441\u043A");
		
		btnNewButton.setBounds(335, 31, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(47, 32, 230, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setBounds(47, 81, 230, 26);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		frame.getContentPane().add(slider);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 86));
		label.setBounds(10, 118, 520, 163);
		frame.getContentPane().add(label);
		
		// ������� �����������
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=textField.getText();
				try {
					funct(a);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//label.setText(funct(a));				
			}
		});
	}
}
