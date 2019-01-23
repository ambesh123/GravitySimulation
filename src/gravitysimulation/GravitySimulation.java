/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Ambesh Tiwari
 */
public class GravitySimulation extends JPanel implements MouseListener{

    static float mX=600,mY=400;
    static JFrame f;
    static BallController bc;
    Image bi; Graphics bg; Boolean firstTime=true;  //Buffered Graphcis and Images
    Thread thread = new Thread(){
      public void run(){
          while(true){
              bc.update();
              repaint();
              try{sleep(20);}catch(Exception e){}
          }
      }  
    };
    
    public static void main(String[] args) {
        GravitySimulation g= new GravitySimulation();
        f= new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,1000);
        f.setLocation(100,0);
        f.setVisible(true);
        f.add(g);
        bc=  new BallController();
        for(int i=0;i<1;i++)bc.addBall(new Ball((float)Math.abs(Math.random())*1000,(float)Math.abs(Math.random())*1000,5,20));
        g.addMouseListener(g);
        g.thread.start();
    }
    
    @Override
    public void paint(Graphics g){
       
        if(firstTime){
            g.setFont(new Font("Cooper",Font.BOLD,48));
            g.drawString("GRAVITY SIMULATION", 500, 100);
            firstTime=false;
        }
        bi= createImage(f.getWidth(),f.getHeight()-200);
        bg= bi.getGraphics();
        bc.draw(bg);
        paintIt(g);
    }
    
    public void paintIt(Graphics g){
        g.drawImage(bi, 0, 200, f);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        mX= me.getX(); mY= me.getY()-200;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
