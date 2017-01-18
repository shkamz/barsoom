/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rfd lab
 */
public class ChessGUI extends JFrame implements ActionListener{
    
    private static final int row = 8;
    private static final int col = 5;   
    
    private int turn;
    private Player p1;
    private Player p2; 
    private Player currentPlayer;
    private Player winner;
    
    private Box now;
    private Box desired;
    
    private Box[] buttons;
    
    public ChessGUI(){
        super("Barsoom Chess by Team Chill");
        buttons = new Box[row * col];
        
        p1 = new Player("p1", true);
        p2 = new Player("p2", false);
        currentPlayer = p1;
        JPanel buttonPanel = createButtonsOnBoard();        
        
        buttons[0].setBackground(null);
        
        setContentPane(buttonPanel);        
        pack();
        setVisible(true);
    }
    
    public JPanel createButtonsOnBoard(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(row, col, 2, 2));
        
        for(int i = 0; i < row * col; i++){
            int r = getRow(i);
            int c = getCol(i);

            buttons[i] = new Box(null);
            
            buttons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    int nowIndex = getIndex(r, c);
                    
                    if (now == null){
                        now = buttons[nowIndex];
                        
                        ArrayList<RowCol> legals = now.getPiece().legals(c, r);
                        
                        for(int k = 0; k < legals.size(); k++){
                            int legalRow = legals.get(k).r();
                            int legalCol = legals.get(k).c();
                            int legalId = getIndex(legalRow, legalCol);                            
                            
                            if (buttons[legalId].hasPiece()){
                                if (buttons[legalId].isEnemyOf(currentPlayer)){
                                    buttons[legalId].setColor(Color.BLUE); // edible
                                } else {
                                    buttons[legalId].setColor(Color.GRAY); // cant move here, because his
                                }
                            } else {
                                buttons[legalId].setColor(Color.GREEN); // moveable
                            }
                        }
                        
                        desired = null;
                    } else if (desired == null){
                        desired = buttons[nowIndex];                        
                        
                        if (desired.getColor().equals(Color.BLUE) || desired.getColor().equals(Color.GREEN)){
                            // edible / moveable
                            desired.setPiece(now.getPiece());
                            now.deset();
                        } else {
                            // illegal
                        }
                        
                        desired = null;
                        now = null;
                        
                        for(int k = 0; k < row * col; k++){
                            buttons[k].setColor(null);
                        }
                    }
                }
            });

            buttonPanel.add(buttons[i]);
        }
        
        initPieces();
        
        return buttonPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initPieces(){
        buttons[getIndex(0, 0)].setPiece(new Star(p1));
        buttons[getIndex(0, 1)].setPiece(new Cross(p1));
        buttons[getIndex(0, 2)].setPiece(new Heart(p1));
        buttons[getIndex(0, 3)].setPiece(new Cross(p1));
        buttons[getIndex(0, 4)].setPiece(new Star(p1));
        
        buttons[getIndex(1, 1)].setPiece(new Arrow(p1, true));
        buttons[getIndex(1, 2)].setPiece(new Arrow(p1, true));
        buttons[getIndex(1, 3)].setPiece(new Arrow(p1, true));
        
        buttons[getIndex(6, 1)].setPiece(new Arrow(p2, false));
        buttons[getIndex(6, 2)].setPiece(new Arrow(p2, false));
        buttons[getIndex(6, 3)].setPiece(new Arrow(p2, false));
        
        buttons[getIndex(7, 0)].setPiece(new Star(p2));
        buttons[getIndex(7, 1)].setPiece(new Cross(p2));
        buttons[getIndex(7, 2)].setPiece(new Heart(p2));
        buttons[getIndex(7, 3)].setPiece(new Cross(p2));
        buttons[getIndex(7, 4)].setPiece(new Star(p2));
    }
    
    public boolean hasHeart(Player player){
        
        for (int k = 0; k < row * col; k++){
            if (buttons[k].hasPiece()){
                Piece piece = buttons[k].getPiece();
                Player owner = piece.getOwner();
                String type = piece.toString();

                if (player.equals(owner) && type.equals("Heart")){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void playAudio(String audioPath){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(audioPath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public int getIndex(int drow, int dcol){
        return drow * this.col + dcol;
    }
    
    public int getRow(int index){
        return index / this.col;
    }
    
    public int getCol(int index){
        return index % this.col;
    }
}
