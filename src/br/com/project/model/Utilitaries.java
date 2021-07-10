package br.com.project.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitaries {
    
    public void limpatela(JPanel p){
        Component comp[] = p.getComponents();
        for (Component component : comp){
            if (component instanceof JTextField) {
            ((JTextField)component).setText(null);
            
                    }
        }
    }
    
}

