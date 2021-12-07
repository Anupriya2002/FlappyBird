package flappyBird;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {

    public static FlappyBird fb;
    public final int WIDTH = 800, HEIGHT = 800;

    public Renderer renderer;

    public Rectangle bird;
    public ArrayList<Rectangle> columns;
    public Random rand;


    public FlappyBird(){
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);
        renderer = new Renderer();
        rand = new Random();
        jframe.add(renderer);
        jframe.setTitle("FLAPPY BIRD");
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false); //cannot resize frame
        jframe.setVisible(true);

        bird = new Rectangle(WIDTH/2-10, HEIGHT /2 -10, 20, 20);
        columns = new ArrayList<Rectangle>();

        addColumn(true);
        timer.start();


    }

    public void addColumn(boolean start){
        int space = 300; //space between the columns
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start){
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + (columns.size() -1)*300, 0, width, HEIGHT - height - space));
        } else{
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
        }




    }
    public void paintColumn(Graphics g, Rectangle column){
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        renderer.repaint();
    }



    public void repaint(Graphics g) {
        //BACKGROUND
        g.setColor(Color.cyan);
        g.fillRect(0,0, WIDTH, HEIGHT);

        //GROUND
        g.setColor(Color.orange);
        g.fillRect(0,HEIGHT-120, WIDTH, 150);

        //GRASS
        g.setColor(Color.green);
        g.fillRect(0, HEIGHT-120, WIDTH, 20);

        //BIRD
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);




    }

    public static void main(String[] args){

        fb = new FlappyBird();

    }



}


//START FROM 33:01