package chess;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rfd lab
 */
public class Board {
    private final Box[][] boxes;
    
    public Board(String p1Name, String p2Name){
        boxes = new Box[8][5];
        
        //init position of the pieces
        //top
        boxes[0][0] = new Box(new Star(p1Name));
        boxes[0][1] = new Box(new Cross(p1Name));
        boxes[0][2] = new Box(new Heart(p1Name));
        boxes[0][3] = new Box(new Cross(p1Name));
        boxes[0][4] = new Box(new Star(p1Name));
        
        boxes[1][1] = new Box(new Arrow(p1Name, true));
        boxes[1][2] = new Box(new Arrow(p1Name, true));
        boxes[1][3] = new Box(new Arrow(p1Name, true));
        
        // bottom
        boxes[6][1] = new Box(new Arrow(p2Name, false));
        boxes[6][2] = new Box(new Arrow(p2Name, false));
        boxes[6][3] = new Box(new Arrow(p2Name, false));
        
        boxes[7][0] = new Box(new Star(p2Name));
        boxes[7][1] = new Box(new Cross(p2Name));
        boxes[7][2] = new Box(new Heart(p2Name));
        boxes[7][3] = new Box(new Cross(p2Name));
        boxes[7][4] = new Box(new Star(p2Name));
    }
    
    /// to call this function, make sure it is legal
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol, String mover){
        Box from = boxes[fromRow][fromCol];
        
        Piece fromPiece = from.getPiece();        
        String fromOwner = fromPiece.getOwner();
        
        // the owner is moving his piece
        if (fromOwner.equals(mover)){
            ArrayList<RowCol> legals = fromPiece.legals(fromCol, fromRow);
            
            for(int i=0; i < legals.size(); i++){
                //if destination is legal
                if (legals.get(i).check(toRow, toCol)){
                    boxes[toRow][toCol] = new Box(fromPiece);
                    boxes[fromRow][fromCol].deset();
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void swapStarCross(){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 5; col++){
                Box box = boxes[row][col]; // current Box
                Piece pis = box.getPiece(); // Piece inside the Box
                String owner = pis.getOwner(); // Owner of the piece
                String type = pis.toString(); // type of Piece
                
                if (type.equals("Star")){
                    box.setPiece(new Cross(owner));
                } else if (type.equals("Cross")){
                    box.setPiece(new Star(owner));
                }
            }
        }
    }
    
    public int countPiece(String enemy){
        int pieceCount = 0;
        
        for(int row = 0; row < 8; row++){
            for (int col = 0; col < 5; col++){
                Box box = boxes[row][col];
                
                if (box.hasPiece()){
                    String owner = box.getPiece().getOwner();
                
                    if (enemy.equals(owner)){
                        pieceCount++;
                    }
                }
            }
        }
        
        return pieceCount;
    }
    
    public int searchHeart(String playerName){
        int heart = 0;
        
        for(int row = 0; row < 8; row++){
            for (int col = 0; col < 5; col++){
                Box box = boxes[row][col];
                
                if (box.hasPiece()){
                    Piece piece = box.getPiece();
                    String owner = piece.getOwner();
                    String type = piece.toString();
                
                    if (playerName.equals(owner) && type.equals("Heart")){
                        heart++;
                    }
                }
            }
        }
        
        return heart;
    }
}