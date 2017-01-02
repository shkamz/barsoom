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
public class Cross extends Piece {
    
    //The Cross can only move diagonally, but can go any distance.
    public Cross(String owner){
        super(owner);
    }
    
    @Override
    public ArrayList<RowCol> legals(int nowX, int nowY){
        ArrayList<RowCol> legals = new ArrayList();
        
        for(int diffY = 0; diffY < 8 - nowY; diffY++){
            for (int diffX = 0; diffX < 5 - nowX; diffX++){
                if (diffX == 0 && diffY == 0){
                    // same xy, illegal
                    continue;
                }
                
                if ((0 <= nowY + diffY) && (nowY + diffY < 8)){
                    if ((0 <= nowX + diffX) && (nowX + diffX < 5)){
                        legals.add(new RowCol(nowY + diffY, nowX + diffX));
                    }
                    
                    if ((0 <= nowX - diffX) && (nowX - diffX < 5)){
                        legals.add(new RowCol(nowY + diffY, nowX - diffX));
                    }
                }
                
                if ((0 <= nowY - diffY) && (nowY - diffY < 8)){
                    if ((0 <= nowX + diffX) && (nowX + diffX < 5)){
                        legals.add(new RowCol(nowY - diffY, nowX + diffX));
                    }
                    
                    if ((0 <= nowX - diffX) && (nowX - diffX < 5)){
                        legals.add(new RowCol(nowY - diffY, nowX - diffX));
                    }
                }
            }
        }
        
        return legals;
    }
    
    @Override
    public String toString() {
        return "Cross";
    }
}
