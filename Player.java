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
    
    public Player(String name){
        this.score = 0;
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return this.score;
    }
}
