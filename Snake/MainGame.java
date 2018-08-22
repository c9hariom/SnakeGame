package Snake;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sun.audio.*;


public class MainGame {
	private Graphics g;
	private static int speed;
	private int speedx=1;
	private int speedy=2;
	private int speedz=3;
	public static void main(String args[]){
		//SnakeMain snakemain = new SnakeMain("Snake Game By <PH>",800,800);
		//snakemain.start();
		final int kl;
		final JFrame frame= new JFrame();
		frame.setSize(500,700);
		frame.setBackground(Color.red);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		final JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setSize(new Dimension(200,700));
		frame.add(panel);
		JLabel label = new JLabel();
		label.setText("           Main Menu");
		panel.add(label);
		
		Font font1= new Font("Arial",Font.BOLD,50);
		label.setAlignmentX(123);
		label.setFont(font1);
		label.setForeground(Color.black);
		label.setPreferredSize(new Dimension(300,100));
		label.setBackground(Color.BLACK);
		Border border= BorderFactory.createLineBorder(Color.red, 10);
		label.setBorder(border);
			
		Dimension dimension= new Dimension(400,60);
		
		final JButton button1= new JButton("Start");
		
		button1.setPreferredSize(dimension);
		button1.setAlignmentX(40);
		button1.setAlignmentY(40);
		
		panel.add(button1);
		
		button1.setBackground(Color.green);
		
		Border border2 = BorderFactory.createLineBorder(Color.CYAN,5);
		
		button1.setBorder(border2);
		
		final JRadioButton rb3= new JRadioButton("Easy");
		final JRadioButton rb4= new JRadioButton("Medium");
		final JRadioButton rb5= new JRadioButton("Hard");
		
		Font fontx= new Font("Tahoma",Font.ITALIC,25);
		Dimension dimensionx= new Dimension(130,60);
		
		rb3.setPreferredSize(dimensionx);
		rb4.setPreferredSize(dimensionx);
		rb5.setPreferredSize(dimensionx);
		
		//rb3.setBackground
		
		
		rb3.setFont(fontx);
		rb4.setFont(fontx);
		rb5.setFont(fontx);
		
		panel.add(rb3);
		panel.add(rb4);
		panel.add(rb5);
		
		rb3.setBackground(Color.orange);
		rb4.setBackground(Color.pink);
		rb5.setBackground(Color.red);
		
		rb3.setSelected(true);
		rb4.setSelected(false);
		rb5.setSelected(false);
		
		rb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				if(e2.getSource()==rb3){
					rb3.setSelected(true);
					rb4.setSelected(false);
					rb5.setSelected(false);
				}
			}
		});
		
		rb4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e3){
				if (e3.getSource()==rb4){
					rb4.setSelected(true);
					rb3.setSelected(false);
					rb5.setSelected(false);
				}
			}
		});
		
		rb5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e4){
				if(e4.getSource()==rb5){
					rb5.setSelected(true);
					rb3.setSelected(false);
					rb4.setSelected(false);
				}
			}
		});
		
		final JButton button2 = new JButton("About");
		button2.setPreferredSize(dimension);
		button2.setAlignmentX(40);
		button2.setAlignmentY(40);

		button2.setBorder(border2);
		button2.setBackground(Color.MAGENTA);
		
		panel.add(button2);
		
		final JButton button3 = new JButton("Exit");
		button3.setPreferredSize(dimension);
		button3.setAlignmentX(40);
		button3.setAlignmentY(40);

		button3.setBorder(border2);
		button3.setBackground(Color.blue);
		
		final JRadioButton rb1= new JRadioButton("Music OFF");
		rb1.setPreferredSize(new Dimension(195,60));
		panel.add(rb1);
		rb1.setBorder(border2);
		rb1.setBackground(Color.blue);
		
		final JRadioButton rb2= new JRadioButton("Music ON");
		rb2.setPreferredSize(new Dimension(195,60));
		panel.add(rb2);
		rb2.setBorder(border2);
		rb2.setBackground(Color.pink);
		rb2.setBackground(Color.GREEN);
		rb1.setBackground(Color.red);
		
		
		rb1.setSelected(true);
		rb2.setSelected(false);
		panel.add(button3);
		
		final JLabel label2= new JLabel();
		label2.setText(null);
		label2.setForeground(Color.BLACK);
		Border border4= BorderFactory.createLineBorder(Color.BLACK, 2);
		Font font4= new Font("Arial",Font.PLAIN,25);
		label2.setPreferredSize(new Dimension(580,30));
		label.setFont(font4);
		label2.setBorder(border4);
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean jk= rb3.isSelected();
				boolean mk= rb4.isSelected();
				boolean sk= rb5.isSelected();
				
				System.out.println(rb3.isEnabled());
				System.out.println(rb4.isEnabled());
				System.out.println(rb5.isEnabled());
				
				
				if(e.getSource()==button1 && jk){
					SnakeMain snakemain = new SnakeMain("Snake Game By <PH>",800,800,1);
					snakemain.start();
					frame.dispose();
				}
				
				if(e.getSource()==button1 && mk){
					SnakeMain snakemain = new SnakeMain("Snake Game By <PH>",800,800,2);
					snakemain.start();
					frame.dispose();
					
				}
				
				if(e.getSource()==button1 && sk){
					SnakeMain snakemain = new SnakeMain("Snake Game By <PH>",800,800,3);
					snakemain.start();
					frame.dispose();
				}
			}
		});

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==button2){
					
					final JOptionPane pane= new JOptionPane("Developer proogrammer @ <Hariom Singh ph>",JOptionPane.WARNING_MESSAGE);
					JDialog dialog = pane.createDialog("About Developer!");
					pane.setPreferredSize(new Dimension(400,180));
					pane.setBackground(Color.red);
					pane.setForeground(Color.GREEN);
					pane.addKeyListener(new KeyListener(){
						public void keyPressed(KeyEvent e) {
							switch(e.getKeyCode()){
							case KeyEvent.VK_ENTER:
								pane.setVisible(false);
							}
							
						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					panel.add(label2);
					label2.setText(" .......                   		  Developed By <<Hariom Singh PH>>");
				
				}
			}
		});
		
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();				
			}
		});
		
		rb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==rb1){
					rb2.setSelected(false);
					rb1.setSelected(true);
				}
			}
		});
		
		rb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==rb2){
					rb2.setSelected(true);
					rb1.setSelected(false);
					mainMusic();
				}
			}
		});
		
		frame.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				switch(e.KEY_PRESSED){
				case KeyEvent.VK_ENTER:
					SnakeMain snakemain = new SnakeMain("Snake Game By <PH>",800,800,1);
					snakemain.start();
					frame.dispose();
					break;
				case KeyEvent.VK_ESCAPE:
					frame.dispose();
					break;
				case KeyEvent.VK_BACK_SPACE :
					frame.dispose();
					break;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void mainMusic() {
		  try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("theme-music.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	}
}