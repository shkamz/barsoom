/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author rfd lab
 */
public class Piece {
    private Player owner;
    private boolean isWhite;
    
    public Piece(Player owner){
        this.owner = owner;
        this.isWhite = owner.isWhite();
    }
    
    public ArrayList<RowCol> legals(int nowX, int nowY){
        return null;
    }
    
    public String getFilename(){
        return null;
    }
    
    public Player getOwner(){
        return this.owner;
    }
    
    public boolean isWhite(){
        return this.isWhite;
    }
}
