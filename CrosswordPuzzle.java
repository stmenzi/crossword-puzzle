/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crosswordpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ACER_User
 */
public class CrosswordPuzzle{

    /**
     * @param args the command line arguments
     */
    JComboBox[] puzzleLeters = new JComboBox[40];
    JLabel[] correctLeters = new JLabel[40];
    int countLetters = 0;
    
       
    
    public static void main(String[] args) {
        // TODO code application logic here
        new CrosswordPuzzle();
    }
    
    


    public CrosswordPuzzle(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Crossword Puzzle");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }


        });
    }



    public class TestPane extends JPanel{
        public TestPane(){
            setLayout(new GridBagLayout());
            String[][] positionsPuzzle = {{"-","-","V","-","-","-","-","-","-","-","-","-"}, 
                                                {"-","-","I","-","-","-","-","-","-","-","-","-"},
                                                {"-","-","S","-","-","-","-","-","-","-","-","-"},
                                                {"-","-","U","-","-","-","-","-","-","B","-","-"}, 
                                                {"-","-","A","-","-","P","-","-","-","I","-","-"},
                                                {"-","-","L","E","A","R","N","I","N","G","-","-"},
                                                {"-","-","I","-","-","O","-","-","-","-","-","-"}, 
                                                {"-","-","S","-","-","G","-","-","-","-","-","-"},
                                                {"-","-","A","-","-","R","-","-","-","-","-","-"},
                                                {"D","A","T","A","-","A","-","-","-","-","-","-"}, 
                                                {"-","-","I","-","-","M","A","C","H","I","N","E"},
                                                {"-","-","O","-","-","M","-","-","-","-","-","-"},
                                                {"-","-","N","-","-","E","-","-","-","-","-","-"}, 
                                                {"-","-","-","-","-","R","-","-","-","-","-","-"}
                                                };
            GridBagConstraints gbc = new GridBagConstraints();
                      
                        
            for (int row = 0; row < 14; row++) {
                for (int col = 0; col < 12; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;
                    
                    if(positionsPuzzle[row][col] == "-"){
                        JTextField blacks = new JTextField();
                        blacks.setPreferredSize(new Dimension(40,40));
                        blacks.setBackground(Color.black);
                        blacks.disable();
                        gbc.gridheight = 1;
                        gbc.weightx = 1;
                        add(blacks, gbc);
                    }
                    else {
                        String alphabet[]={"A","B","C","D","E","F","G","H","I","J", 
                                       "K","L","M","N","O","R","P","Q","S","T","U","V",
                                       "W","Y","Z"};        
                       JComboBox letters=new JComboBox(alphabet);
                       letters.setPreferredSize(new Dimension(40,40));
                       puzzleLeters[countLetters]=letters;
                       gbc.gridheight = 1;
                       gbc.weightx = 1;
                       letters.setBackground(Color.white);
                       add(puzzleLeters[countLetters], gbc);
                       JLabel correctLetter = new JLabel(positionsPuzzle[row][col]); 
                       correctLetter.setPreferredSize(new Dimension(40,40));
                       correctLeters[countLetters] = correctLetter;
                       add(correctLeters[countLetters], gbc);
                       correctLetter.disable();
                       countLetters++;
                    }
                    
                    CellPane cellPane = new CellPane();
                    
                    Border border = null;
                    if (row < 14) {
                        if (col < 12) {
                            border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                        }
                    } else {
                        if (col < 12) {
                            border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);           
                }
             }

            puzzleLeters[0].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            
            puzzleLeters[1].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();;
                        puzzleLeters[2].disable();;
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();;
                        puzzleLeters[8].disable();;                        
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                       
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            
            puzzleLeters[2].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                        
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[3].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        puzzleLeters[0].disable();;
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                     
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[4].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[4].getSelectedItem()== correctLeters[4].getText())&
                            (puzzleLeters[7].getSelectedItem()== correctLeters[7].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        puzzleLeters[4].disable();
                        puzzleLeters[7].disable();
                        puzzleLeters[15].disable();
                    }//if
                }
            });
            puzzleLeters[5].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                     
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                       
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[6].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();                    
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                       
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[7].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[4].getSelectedItem()== correctLeters[4].getText())&
                            (puzzleLeters[7].getSelectedItem()== correctLeters[7].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        puzzleLeters[4].disable();
                        puzzleLeters[7].disable();
                        puzzleLeters[15].disable();
                    }//if
                    
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                      
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                     
                        puzzleLeters[24].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[8].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if of word "LEARNING
                    
                    /* WORD VISUALISATION*/
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                      
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[9].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                }
            });
            puzzleLeters[10].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                }
            });
            puzzleLeters[11].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if of word "LEARNING"
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();                     
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                        
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[12].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                }
            });
            puzzleLeters[13].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                }
            });
            
            puzzleLeters[14].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                }
            });
            puzzleLeters[15].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[4].getSelectedItem()== correctLeters[4].getText())&
                            (puzzleLeters[7].getSelectedItem()== correctLeters[7].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        puzzleLeters[4].setForeground(Color.green);
                        puzzleLeters[7].setForeground(Color.green);
                        puzzleLeters[15].setForeground(Color.green);
                    }//if of word "BIG"
                    /*WORD LEARNING*/
                    if((puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[9].getSelectedItem()== correctLeters[9].getText())&
                            (puzzleLeters[10].getSelectedItem()== correctLeters[10].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[12].getSelectedItem()== correctLeters[12].getText())&
                            (puzzleLeters[13].getSelectedItem()== correctLeters[13].getText())&
                            (puzzleLeters[14].getSelectedItem()== correctLeters[14].getText())&
                            (puzzleLeters[15].getSelectedItem()== correctLeters[15].getText())){
                        
                        puzzleLeters[8].disable();
                        puzzleLeters[9].disable();
                        puzzleLeters[10].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[12].disable();
                        puzzleLeters[13].disable();
                        puzzleLeters[14].disable();
                        puzzleLeters[15].disable();

                    }//if
                
                }
            });
            puzzleLeters[16].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[17].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                        
                    }//if of word "PROGRAMMER"
                }
            });
            puzzleLeters[18].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                       
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[19].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[20].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                        
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[21].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                      
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[22].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[22].getSelectedItem()== correctLeters[22].getText())&
                            (puzzleLeters[23].getSelectedItem()== correctLeters[23].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[25].getSelectedItem()== correctLeters[25].getText())){
                        
                        puzzleLeters[22].disable();
                        puzzleLeters[23].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[25].disable();

                    }//if
                }
            });
            puzzleLeters[23].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[22].getSelectedItem()== correctLeters[22].getText())&
                            (puzzleLeters[23].getSelectedItem()== correctLeters[23].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[25].getSelectedItem()== correctLeters[25].getText())){
                        
                        puzzleLeters[22].disable();
                        puzzleLeters[23].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[25].disable();

                    }//if
                }
            });
            puzzleLeters[24].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[22].getSelectedItem()== correctLeters[22].getText())&
                            (puzzleLeters[23].getSelectedItem()== correctLeters[23].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[25].getSelectedItem()== correctLeters[25].getText())){
                        
                        puzzleLeters[22].disable();
                        puzzleLeters[23].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[25].disable();

                    }//if OF WORD "DATA"
                    
                    /*WORD VISUALISATION*/
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[25].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[22].getSelectedItem()== correctLeters[22].getText())&
                            (puzzleLeters[23].getSelectedItem()== correctLeters[23].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[25].getSelectedItem()== correctLeters[25].getText())){
                        
                        puzzleLeters[22].disable();
                        puzzleLeters[23].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[25].disable();

                    }//if
                }
            });
            puzzleLeters[26].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();                    
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                        
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[27].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                        
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[28].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();                        
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();
                    }//if of word "MACHINE"
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();                     
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                      
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[29].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();                        
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();                       
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[30].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();                        
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();                        
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[31].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();                       
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[32].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();                     
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[33].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();                        
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();                      
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[34].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[29].getSelectedItem()== correctLeters[29].getText())&
                            (puzzleLeters[30].getSelectedItem()== correctLeters[30].getText())&
                            (puzzleLeters[31].getSelectedItem()== correctLeters[31].getText())&
                            (puzzleLeters[32].getSelectedItem()== correctLeters[32].getText())&
                            (puzzleLeters[33].getSelectedItem()== correctLeters[33].getText())&
                            (puzzleLeters[34].getSelectedItem()== correctLeters[34].getText())){
                        
                        puzzleLeters[28].disable();
                        puzzleLeters[29].disable();
                        puzzleLeters[30].disable();
                        puzzleLeters[31].disable();
                        puzzleLeters[32].disable();                        
                        puzzleLeters[33].disable();
                        puzzleLeters[34].disable();
                    }//if of word "MACHINE"  
                }
            });
            puzzleLeters[35].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[36].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();                     
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();                       
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[37].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    if((puzzleLeters[0].getSelectedItem()== correctLeters[0].getText())&
                            (puzzleLeters[1].getSelectedItem()== correctLeters[1].getText())&
                            (puzzleLeters[2].getSelectedItem()== correctLeters[2].getText())&
                            (puzzleLeters[3].getSelectedItem()== correctLeters[3].getText())&
                            (puzzleLeters[5].getSelectedItem()== correctLeters[5].getText())&
                            (puzzleLeters[8].getSelectedItem()== correctLeters[8].getText())&
                            (puzzleLeters[16].getSelectedItem()== correctLeters[16].getText())&
                            (puzzleLeters[18].getSelectedItem()== correctLeters[18].getText())&
                            (puzzleLeters[20].getSelectedItem()== correctLeters[20].getText())&
                            (puzzleLeters[24].getSelectedItem()== correctLeters[24].getText())&
                            (puzzleLeters[27].getSelectedItem()== correctLeters[27].getText())&
                            (puzzleLeters[35].getSelectedItem()== correctLeters[35].getText())&
                            (puzzleLeters[37].getSelectedItem()== correctLeters[37].getText())){
                        
                        puzzleLeters[0].disable();
                        puzzleLeters[1].disable();
                        puzzleLeters[2].disable();
                        puzzleLeters[3].disable();
                        puzzleLeters[5].disable();
                        puzzleLeters[8].disable();                        
                        puzzleLeters[16].disable();
                        puzzleLeters[18].disable();
                        puzzleLeters[20].disable();                        
                        puzzleLeters[24].disable();
                        puzzleLeters[27].disable();
                        puzzleLeters[35].disable();
                        puzzleLeters[37].disable();
                    }//if
                }
            });
            puzzleLeters[38].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();
                    }//if of word "MACHINE"
                }
            });
            puzzleLeters[39].addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent e) {
                    /*WORD "PROGRAMMER*/
                    if((puzzleLeters[6].getSelectedItem()== correctLeters[6].getText())&
                            (puzzleLeters[11].getSelectedItem()== correctLeters[11].getText())&
                            (puzzleLeters[17].getSelectedItem()== correctLeters[17].getText())&
                            (puzzleLeters[19].getSelectedItem()== correctLeters[19].getText())&
                            (puzzleLeters[21].getSelectedItem()== correctLeters[21].getText())&
                            (puzzleLeters[26].getSelectedItem()== correctLeters[26].getText())&
                            (puzzleLeters[28].getSelectedItem()== correctLeters[28].getText())&
                            (puzzleLeters[36].getSelectedItem()== correctLeters[36].getText())&
                            (puzzleLeters[38].getSelectedItem()== correctLeters[38].getText())&
                            (puzzleLeters[39].getSelectedItem()== correctLeters[39].getText())){
                        
                        puzzleLeters[6].disable();
                        puzzleLeters[11].disable();
                        puzzleLeters[17].disable();
                        puzzleLeters[19].disable();
                        puzzleLeters[21].disable();
                        puzzleLeters[26].disable();
                        puzzleLeters[28].disable();
                        puzzleLeters[36].disable();
                        puzzleLeters[38].disable();
                        puzzleLeters[39].disable();
                    }//if of word "MACHINE"
                }
            });
        }
    }
    
    public class CellPane extends JPanel{

        private Color defaultBackground;

        public CellPane(){
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(40, 40);
        }
    }
    
}
