/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulation;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Ambesh Tiwari
 */
public class Ball {
    public float x;
    public float y;
    public float xspeed;
    public float yspeed;
    public float xacc, yacc;
    public int radius;
    public float mass;
    
    Ball(float x,float y,float mass, int radius){
        this.x=x; this.y=y; 
        this.mass= mass;
        this.radius=radius;
        
    }
    
    public void update(){
        x+=xspeed; y+=yspeed;
        xspeed+=xacc; yspeed+=yacc;
        if(x<=0||x>=GravitySimulation.f.getWidth())xspeed*=-1;
        if(y<=0||y>=GravitySimulation.f.getHeight()-200)yspeed*=-1;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval((int)x-radius, (int)y-radius, radius, radius);
    }
}
