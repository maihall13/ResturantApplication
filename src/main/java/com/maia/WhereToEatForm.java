/*
 * Created by JFormDesigner on Sat Apr 22 13:12:31 CDT 2017
 */

package com.maia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Maia Hall
 */
public class WhereToEatForm extends Frame {
    public String loc;

    public WhereToEatForm() {
        initComponents();
        setVisible(true);
        pack();
    }

    public void searchButtonActionPerformed(ActionEvent e) {
        loc = locationTextbox.getText();
        Main.GetPlace();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Maia Hall
        label1 = new JLabel();
        locationTextbox = new JTextField();
        searchButton = new JButton();

        //======== this ========
        setLayout(new FormLayout(
            "2*(default, $lcgap), default",
            "2*(default, $lgap), default"));

        //---- label1 ----
        label1.setText("Location");
        add(label1, CC.xy(1, 1));
        add(locationTextbox, CC.xywh(3, 1, 3, 1));

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonActionPerformed(e);
            }
        });
        add(searchButton, CC.xy(3, 3));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Maia Hall
    private JLabel label1;
    private JTextField locationTextbox;
    private JButton searchButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public String getLoc(){
        return loc;
    }
}
