package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private String title;
	private int height;
	private int width;
	private JFrame frame;
	private Canvas canvas;
	
	public Display(String title,int height,int width){
		this.title=title;
		this.height=height;
		this.width=width;
		createDisplay();
	}
	
	public void createDisplay(){
		frame= new JFrame(title);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.WHITE);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(800,800));
		Color color = new Color(179,250,130);
		canvas.setBackground(color);
		frame.add(canvas);
		frame.setResizable(false);

	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame  getFrame(){
		return frame;
	}
}
