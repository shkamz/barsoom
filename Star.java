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
public class Star extends Piece {
    
    //The Star can move1 or two steps in any direction.
    public Star(String owner){
        super(owner);
    }
    
    @Override
    public ArrayList<RowCol> legals(int nowX, int nowY){
        ArrayList<RowCol> legals = new ArrayList();
        
        for(int y = nowY - 2; y < nowY + 2; y++){
            for (int x = nowX - 2; x < nowX + 2; x++){
                if ((0 <= y) && (y < 8) && (0 <= x) && (x < 5)){
                    if (y == nowY && x == nowX){
                        // because we dont want to register "moving to original position" as a move
                        continue;
                    }
                    
                    legals.add(new RowCol(y, x));
                }
            }
        }
        
        return legals;
    }
    
    @Override
    public String toString() {
        return "Star";
    }
}
