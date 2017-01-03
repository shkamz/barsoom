/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rfd lab
 */
public class ChessGUI  extends JFrame implements ActionListener{
    
    public ChessGUI(){
        super("Barsoom Chess by Team Chill");
        
        JPanel buttonPanel = createButtonsOnBoard(8, 5);
        
        setContentPane(buttonPanel);        
        pack();
        setVisible(true);
    }
    
    public JPanel createButtonsOnBoard(int row, int col){
        JButton[] buttons = new JButton[row * col];
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(row, col, 2, 2));
        for(int i = 0; i < row * col; i++){
            int r = i / col;
            int c = i % col;

            buttons[i] = new JButton("(" + r +" , "+ c +" )");

            buttons[i].addActionListener((ActionEvent e) -> {
                //the buttons function
                /*
                JButton button = (JButton)e.getSource(); 
                button.setVisible(false);
                */
                int index = r * col + c;
                //buttons[index].setVisible(false);
                System.out.print("Row: " + r + ", Col: " + c+ ", Index: "+index + "\n");
            });

            buttonPanel.add(buttons[i]);
        }
        
        return buttonPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
