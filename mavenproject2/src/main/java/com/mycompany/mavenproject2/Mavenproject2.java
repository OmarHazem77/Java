/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mavenproject2 extends JFrame {
    // GUI Components
    private JLabel lblItemName, lblMaterialQuality, lblCost, lblMessage;
    private JTextField txtItemName, txtCost;
    private JComboBox<String> cmbMaterialQuality;
    private JButton btnCalculate, btnClear;

    public Mavenproject2() {
        // Frame setup
        setTitle("Material Cost Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        setResizable(false);
        setLocationRelativeTo(null); // Center the window

        // Item Name Label and TextField
        lblItemName = new JLabel("Item Name:");
        txtItemName = new JTextField(15);

        // Material Quality Label and ComboBox
        lblMaterialQuality = new JLabel("Material Quality:");
        cmbMaterialQuality = new JComboBox<>(new String[]{"Economic", "Business", "Luxury"});
        cmbMaterialQuality.setSelectedItem("Luxury"); // Default selection

        // Cost Label and TextField
        lblCost = new JLabel("Cost/sqm:");
        txtCost = new JTextField(15);
        txtCost.setEditable(false); // Non-editable

        // Buttons
        btnCalculate = new JButton("Calculate");
        btnClear = new JButton("Clear");

        // Message Label
        lblMessage = new JLabel("");
        lblMessage.setForeground(Color.BLUE);
        lblMessage.setPreferredSize(new Dimension(300, 20));

        // Adding components to frame
        add(lblItemName);
        add(txtItemName);

        add(lblMaterialQuality);
        add(cmbMaterialQuality);

        add(lblCost);
        add(txtCost);

        add(btnCalculate);
        add(btnClear);
        add(lblMessage);

        // Event Handling for Calculate Button
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCost();
            }
        });

        // Event Handling for Clear Button
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        setVisible(true);
    }

    // Method to calculate cost and display message
    private void calculateCost() {
        String selectedQuality = (String) cmbMaterialQuality.getSelectedItem();
        int cost = 0;

        // Determine cost based on selected quality
        if ("Economic".equals(selectedQuality)) {
            cost = 50;
        } else if ("Business".equals(selectedQuality)) {
            cost = 80;
        } else if ("Luxury".equals(selectedQuality)) {
            cost = 120;
        }

        // Display the cost and message
        txtCost.setText(String.valueOf(cost));
        lblMessage.setText("Material: " + selectedQuality + ", Cost: " + cost + " LE/sqm");
    }

    // Method to clear all fields
    private void clearFields() {
        txtItemName.setText("");
        cmbMaterialQuality.setSelectedItem("Luxury");
        txtCost.setText("");
        lblMessage.setText("");
    }

    // Main Method
    public static void main(String[] args) {
        new Mavenproject2();
    }
}

