/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
/**
 *
 * @author rfd lab
 */
public class Player {
    private int score;
    private String name;
    private boolean isWhite;
    
    public Player(String name, boolean isWhite){
        this.score = 0;
        this.name = name;
        this.isWhite = isWhite;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addScore(){
        this.score++;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public boolean isWhite(){
        return this.isWhite;
    }
}
