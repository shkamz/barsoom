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
public class Box {
    private Piece piece;
    
    public Box(Piece piece){
        setPiece(piece);
    }
    
    public void setPiece(Piece piece){
        this.piece = piece;
    }
    
    public void deset(){
        this.piece = null;
    }
    
    public boolean hasPiece(){
        return this.piece != null;
    }
    
    public Piece getPiece(){
        return this.piece;
    }
}
