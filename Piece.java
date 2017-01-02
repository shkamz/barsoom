/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author rfd lab
 */
public class Piece {
    private String owner;
    
    public Piece(String owner){
        this.owner = owner;
    }
    
    public ArrayList<RowCol> legals(int nowX, int nowY){
        return null;
    }
    
    public String getOwner(){
        return this.owner;
    }
}
