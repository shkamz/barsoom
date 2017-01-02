package chess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rfd lab
 */
public class Game {
    private int turn;
    
    private Player p1;
    private Player p2; 
    private Player current;
    private Player winner;
    
    private Board board;
    
    public Game(String p1name, String p2name){
        turn = 0;
        p1 = new Player(p1name);
        p2 = new Player(p2name);
        current = p1;
        
        board = new Board(p1name, p2name);
    }
    
    
    public void nextTurn(){
        this.turn = this.turn + 1;
        
        if (this.turn % 4 == 0){
            // for each 4 turns, swap the Stars with Crosses and vice versa
            this.board.swapStarCross();
        }
        
        // swap turns
        if (current.equals(p1)) current = p2;
        else current = p1;
        
        // count scores
        p1.setScore(8 - this.board.countPiece(p2.getName()));
        p2.setScore(8 - this.board.countPiece(p1.getName()));
        
        // check their heart
        if (this.board.searchHeart(p1.getName()) < 1){
            winner = p2;
        } else if (this.board.searchHeart(p2.getName()) < 1){
            winner = p1;
        }
        
        if (winner != null){
            // stop the game and announce the winner
        }
    }
    
    public void move(int fromRow, int fromCol, int toRow, int toCol){
        if (this.board.movePiece(fromRow, fromCol, toRow, toCol, current.getName())){
            // if the moving is success, count it as a turn
            nextTurn();
        }
    }
    
}
