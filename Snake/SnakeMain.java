package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;

public class SnakeMain implements Runnable,KeyListener{
	private int height;
	private int width;
	private String title;
	private Thread thread;
	private Display display;
	private BufferStrategy buffer;
	private Graphics g;
	private LinkedList<Point> snake;
	private int direction= Direction.no_direction ;
	private int speed;
	private int n=1;
	
	//rectangle setup
	
	public static final int HEIGHT =45;//15
	public static final int WIDTH =45;//15
	public static final int BOX_HEIGHT = 16;//30
	public static final int BOX_WIDTH = 16;//30
	
	//fruit
	private Point fruite;
	
	public SnakeMain(String title,int width,int height,int speed){
		this.title=title;
		this.width=width;
		this.height=height;
		if(speed==1){
			this.speed=100;
		}
		if(speed==2){
			this.speed=60;
		}
		if(speed==3){
			this.speed=40;
		}
	}
	
	public void init(){
		direction=Direction.up;
		display= new Display(title,width,height);
		display.getFrame().addKeyListener(this);
		display.getCanvas().addKeyListener(this);
		direction=Direction.up;
		snake = new LinkedList<Point>();
		restart();
		randomFruite();
		
	}
	
	public void draw(Graphics g){
		drawNewRect(g);
		drawSnake(g);
		drawFruite(g);
	}
	
	public void drawScore(Graphics g,String score){
		g.drawString(score,500,20);
		g.setColor(Color.red);
		Font font4= new Font("Arial",Font.BOLD,30);
		g.setFont(font4);
	}
	
	public void drawSnake(Graphics g){
		g.setColor(Color.BLUE);
		for(Point p:snake){
			g.fillRect(p.x*BOX_WIDTH,p.y*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		}
	}
	
	public void drawFruite(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(fruite.x*BOX_WIDTH,fruite.y*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		g.setColor(Color.black);
	}
	
	public void randomFruite(){
		Random rand = new Random();
		int randX=rand.nextInt(WIDTH);
		int randY=rand.nextInt(HEIGHT);
		fruite= new Point(randX,randY);
		while(snake.contains(fruite)){
			fruite= new Point(randX,randY);
		}
		
	}
	
	public void move(){
		Point head= snake.peekFirst();
		Point newPoint=head;
		switch(direction){
		case Direction.up:
			newPoint =new Point (head.x,head.y-1);
			break;
		case Direction.down:
			newPoint= new Point(head.x,head.y+1);
			break;
		case Direction.left:
			newPoint = new Point(head.x-1,head.y);
			break;
		case Direction.right:
			newPoint = new Point(head.x+1,head.y);
			break;
		}
		
		if(snake.contains(newPoint)){
			restart();
			return;
		}
		
		if(head.x>WIDTH){
			newPoint = new Point(head.x=0,head.y);
		}else if(head.x<0){
			newPoint= new Point(head.x=WIDTH-1,head.y);
		}
		
		if(head.y>HEIGHT){
			newPoint = new Point(head.x,head.y=0);
		}else if(head.y<0){
			newPoint = new Point (head.x,head.y=HEIGHT-1);
		}
		
		snake.remove(snake.peekLast());
		if(newPoint.equals(fruite)){
			eatMusic();
			Point add= (Point) newPoint.clone();
			snake.push(add);
			n+=1;
			if(n>5&&n<10){
				this.speed-=15;
			}if(n>=10&&n<15){
				this.speed-=10;
			}if(n>15&&n<20){
				this.speed-=10;
			}if(n>20&&n<25){
				this.speed-=10;
			}
			//snake.add(new Point(add));
			randomFruite();
		}
		
		snake.push(newPoint);
	}
	
	public void render(){
		buffer= display.getCanvas().getBufferStrategy();
		if(buffer==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
	g= buffer.getDrawGraphics();
	g.clearRect(0, 0, width, height);
	//here we go
		draw(g);
		//here we finish
		buffer.show();
		g.dispose();
		
	}
	
	public void restart(){
		direction=Direction.no_direction;
		
		snake.clear();
		
		snake.add(new Point(9,7));
		snake.add(new Point(8,7));
		snake.add(new Point(7,7));
	}
	
	public void drawNewRect(Graphics g){
		Color color = new Color(179,250,130);
		g.setColor(color);
		 g.drawRect(0, 0, WIDTH*BOX_WIDTH, HEIGHT*BOX_HEIGHT);
		 for (int x=BOX_WIDTH;x<BOX_WIDTH*WIDTH;x+=BOX_WIDTH){
			 g.drawLine(x,0,x,BOX_HEIGHT*HEIGHT);
		 }
		 for (int y=BOX_HEIGHT;y<BOX_HEIGHT*HEIGHT;y+=BOX_HEIGHT){
			 g.drawLine(0, y,BOX_WIDTH*WIDTH,y );
		 }
	}
	
	public synchronized void start(){
		thread= new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		init();
		//direction=Direction.up;
		while(true){
			move();
			render();
			Thread.currentThread();
			try{
				Thread.sleep(this.speed);
				System.out.println(this.speed);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){	
			case KeyEvent.VK_UP:
				if(direction != Direction.down)
				direction=Direction.up;
				System.out.println("pressed");
				clickMusic();
				break;
				
			case KeyEvent.VK_DOWN:
				if(direction != Direction.up)
				direction=Direction.down;
				System.out.println("pressed");
				clickMusic();
				break;
				
			case KeyEvent.VK_LEFT:
				if(direction != Direction.right)
				direction=Direction.left;
				System.out.println("pressed");
				clickMusic();
				break;
				
			case KeyEvent.VK_RIGHT:
				if(direction != Direction.left)
				direction=Direction.right;
				System.out.println("pressed");
				clickMusic();
				break;
			}
	}
	
	public static void eatMusic() {
		  try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("f.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	}
	
	public void clickMusic(){
	 try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("click.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void deadMusic(){
		 try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("dead.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	}
	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
}