/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulation;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Ambesh Tiwari
 */
public class BallController {
    ArrayList<Ball> balls;
    
    BallController(){
        balls= new ArrayList<>();
    }
    
    public void addBall(Ball b){
        balls.add(b);   
    }
    
    public void removeBall(){
        balls.remove(0);
    }
    
    public void update(){
        for(int i=0; i<balls.size();i++){
            balls.get(i).update();
            
            //Logic 1
            balls.get(i).xacc= (GravitySimulation.mX-balls.get(i).x)/1000;
            balls.get(i).yacc= (GravitySimulation.mY-balls.get(i).y)/1000;  
            
            //Logic 2
     /*       float d2= (float)((GravitySimulation.mX-balls.get(i).x)*(GravitySimulation.mX-balls.get(i).x)+(GravitySimulation.mY-balls.get(i).y)*(GravitySimulation.mY-balls.get(i).y));
            
            
               float av = 10000/d2;
            //System.out.println(d2);
                float cos = (GravitySimulation.mX-balls.get(i).x)/(float)Math.sqrt(d2);
                float sin = (GravitySimulation.mY-balls.get(i).y)/(float)Math.sqrt(d2);
               if(d2>2000){ balls.get(i).xacc= av*cos; balls.get(i).yacc= av*sin;}
               else { balls.get(i).xacc= 5*cos; balls.get(i).yacc= 5*sin;  }*/
                
            
            for(int j=0; j<balls.size();j++){
                if(i!=j){
                   if(Math.abs(balls.get(i).x - balls.get(j).x) < 20 && Math.abs(balls.get(i).y - balls.get(j).y) < 20){
                      float tempX= balls.get(i).xspeed;
                      float tempY= balls.get(i).yspeed;
                      balls.get(i).xspeed = balls.get(j).xspeed;
                      balls.get(i).yspeed = balls.get(j).yspeed;
                      balls.get(j).xspeed=tempX;
                      balls.get(j).yspeed=tempY;
                   }
                }
            }
        }
    }
    
    public void draw(Graphics g){
        for(int i=0; i<balls.size();i++)balls.get(i).draw(g);
    }
}
