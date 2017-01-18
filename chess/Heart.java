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
public class Heart extends Piece {
    
    //The Heart can move only 1 step in any direction. 
    //The game ends when the heart is captured by the other side.
    public Heart(Player owner){
        super(owner);
    }
    
    @Override
    public ArrayList<RowCol> legals(int nowX, int nowY){
        ArrayList<RowCol> legals = new ArrayList();
        
        for(int y = nowY - 1; y <= nowY + 1; y++){
            for (int x = nowX - 1; x <= nowX + 1; x++){
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
    public String getFilename(){
        if (isWhite()){
            return "/assets/whiteHeart.png";
        } else {
            return "/assets/blackHeart.png";
        }
    }
    
    @Override
    public String toString() {
        return "Heart";
    }
}
