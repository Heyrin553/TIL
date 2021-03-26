/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kitchenscreen;

import javax.swing.JFrame;

/**
 *
 * @author heyrin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame.setDefaultLookAndFeelDecorated(true);
        Ui ui=new Ui();
        ui.setBounds(300, 200, 400, 300);
        ui.setVisible(true);
    }
    
}
