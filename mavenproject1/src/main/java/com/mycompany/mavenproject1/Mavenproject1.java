/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mavenproject1 extends JFrame {
    // GUI Components
    private JLabel lblItem, lblPrice, lblDiscount, lblFinalPrice, lblCategory, lblTitle;
    private JTextField txtItem, txtPrice, txtDiscount, txtFinalPrice;
    private JRadioButton rbMen, rbWomen, rbKids;
    private JCheckBox chCardHolder;
    private JButton btnClear, btnTest, btnCalculate, btnExit;
    private ButtonGroup categoryGroup;

    public Mavenproject1() {
        // Frame Setup
        setTitle("MEGA MALL Billing");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Title
        lblTitle = new JLabel("MEGA MALL");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(200, 10, 150, 30);
        add(lblTitle);

        // Labels and TextFields
        lblItem = new JLabel("Item:");
        lblItem.setBounds(50, 60, 100, 30);
        txtItem = new JTextField();
        txtItem.setBounds(150, 60, 150, 30);

        lblPrice = new JLabel("Price:");
        lblPrice.setBounds(50, 100, 100, 30);
        txtPrice = new JTextField();
        txtPrice.setBounds(150, 100, 150, 30);

        lblDiscount = new JLabel("Discount:");
        lblDiscount.setBounds(50, 180, 100, 30);
        txtDiscount = new JTextField();
        txtDiscount.setBounds(150, 180, 150, 30);
        txtDiscount.setEditable(false);

        lblFinalPrice = new JLabel("Final Price:");
        lblFinalPrice.setBounds(50, 220, 100, 30);
        txtFinalPrice = new JTextField();
        txtFinalPrice.setBounds(150, 220, 150, 30);
        txtFinalPrice.setEditable(false);

        // Category Selection
        lblCategory = new JLabel("Category:");
        lblCategory.setBounds(50, 140, 100, 30);
        rbMen = new JRadioButton("Men's");
        rbMen.setBounds(150, 140, 70, 30);
        rbWomen = new JRadioButton("Women's");
        rbWomen.setBounds(220, 140, 90, 30);
        rbKids = new JRadioButton("Kid's");
        rbKids.setBounds(310, 140, 70, 30);

        // Group Radio Buttons
        categoryGroup = new ButtonGroup();
        categoryGroup.add(rbMen);
        categoryGroup.add(rbWomen);
        categoryGroup.add(rbKids);

        // Card Holder Checkbox
        chCardHolder = new JCheckBox("Card Holder");
        chCardHolder.setBounds(150, 260, 150, 30);

        // Buttons
        btnClear = new JButton("Clear");
        btnClear.setBounds(50, 310, 90, 30);
        btnTest = new JButton("Test Data");
        btnTest.setBounds(150, 310, 90, 30);
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(250, 310, 100, 30);
        btnExit = new JButton("Exit");
        btnExit.setBounds(360, 310, 70, 30);

        // Adding components to the frame
        add(lblItem);
        add(txtItem);
        add(lblPrice);
        add(txtPrice);
        add(lblDiscount);
        add(txtDiscount);
        add(lblFinalPrice);
        add(txtFinalPrice);
        add(lblCategory);
        add(rbMen);
        add(rbWomen);
        add(rbKids);
        add(chCardHolder);
        add(btnClear);
        add(btnTest);
        add(btnCalculate);
        add(btnExit);

        // Event Handling
        btnClear.addActionListener(e -> clearFields());
        btnTest.addActionListener(e -> validateItem());
        btnCalculate.addActionListener(e -> calculatePrice());
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // Clear all fields
    private void clearFields() {
        txtItem.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        txtFinalPrice.setText("");
        categoryGroup.clearSelection();
        chCardHolder.setSelected(false);
    }

    // Validate item price
    private void validateItem() {
        try {
            double price = Double.parseDouble(txtItem.getText());
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than zero!", "Warning", JOptionPane.WARNING_MESSAGE);
                txtItem.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            txtItem.setText("");
        }
    }

    // Calculate discount and final price
    private void calculatePrice() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            double discount = 0;

            // Category-based discounts
            if (rbMen.isSelected()) {
                discount = price * 0.10; // 10% for Men's
            } else if (rbWomen.isSelected()) {
                discount = price * 0.20; // 20% for Women's
            } else if (rbKids.isSelected()) {
                discount = price * 0.30; // 30% for Kid's
            } else {
                JOptionPane.showMessageDialog(this, "Please select a category!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Additional 5% discount for cardholders
            if (chCardHolder.isSelected()) {
                discount += price * 0.05;
            }

            double finalPrice = price - discount;

            // Display results
            txtDiscount.setText(String.format("%.2f", discount));
            txtFinalPrice.setText(String.format("%.2f", finalPrice));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid price! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method
    public static void main(String[] args) {
        new Mavenproject1();
    }
}
