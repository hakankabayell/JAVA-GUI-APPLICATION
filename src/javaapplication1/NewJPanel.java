/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
/**
 *
 * @author Hakan KABAYEL
 */
public class NewJPanel extends javax.swing.JPanel {
    private final ArrayList<Ball> ballList;
    private final Timer timer;
    private final int DELAY = 16; 
    private final String username = "hakankabayel";
    private final String password = "hakankabayel";

    private boolean login = false;
    
    public NewJPanel() {
        initComponents();
        ballList = new ArrayList<>();
        setBackground(Color.BLACK);
        JOptionPane.showMessageDialog(null, "PLEASE ENTER USERNAME AND PASSWORD", "WARNING", JOptionPane.WARNING_MESSAGE);
        UIManager UI=new UIManager();
        progressBar.setStringPainted(true);
        
        addMouseListener(new Event());
        addMouseMotionListener(new Event());
        addMouseWheelListener(new Event());
        
        timer = new Timer(DELAY, new Event());
    }


    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball k : ballList) {

            g.setColor(k.color);
            g.drawOval(k.x, k.y, k.size, k.size);

        }

        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(ballList.size()), 40, 40);

    }

    private class Event implements MouseListener,MouseMotionListener, MouseWheelListener, ActionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int slider_size = slider.getValue();
            if (!login) {
            UIManager.put("Panel.background", Color.red);
            UIManager.put("OptionPane.background", Color.red);
            JOptionPane.showMessageDialog(jPanel1, "ENTER USERNAME AND PASSWORD FIRST.!"); 
            }
            else{
                if (ballList.size()>= 1000) {

                }
                else{
                    ballList.add(new Ball(e.getX(), e.getY(), slider_size));                     
                    progressBar.setValue(ballList.size()/10);

                }
                repaint();  
            }
                                      
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            timer.start();
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Ball i : ballList) {
                for (Ball k : ballList) {
                    double xDif = i.x - k.x;
                    double yDif = i.y - k.y;
                    double distanceSquared = xDif * xDif + yDif * yDif;
                    boolean collision = distanceSquared < ((i.size)/2 + (k.size)/2) * ((i.size)/2 + (k.size)/2);
                    if (collision){
                        i.update();
                        k.update();

                    }
                }
            }

            repaint();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            e.getWheelRotation();

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int slider_size = slider.getValue();
            if (ballList.size() < 1000 && login) {
                ballList.add(new Ball(e.getX(), e.getY(), slider_size)); 
               
            }
            progressBar.setValue(ballList.size()/10);
            
            if (ballList.size() >= 1000) {
                UIManager.put("Panel.background", Color.green);
                UIManager.put("OptionPane.background", Color.green);
                JOptionPane.showMessageDialog(jPanel1, "CAPACITY IS FULL !!");
                
            }
 
        }
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    private class Ball {

        public int x, y, size, xspeed, yspeed;
        public Color color;
        private final int MAX_SPEED = 5;

        public Ball(int x, int y, int size) {
            this.x = x - size /2;
            this.y = y - size/2;
            this.size = size;

            if (this.x + size >= getWidth()){
                this.x -= size/2;
            }

            if (this.x - size <= 0){
                this.x += size/2;

            }

            if (this.y + size >= getHeight()){
                this.y -= size/2;

            }

            color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            
            if (xspeed == 0 || yspeed == 0) {
                
                xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
                yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
                
            }
        }

        public void update() {
            x += xspeed;
            y += yspeed;

            if (x <= 0 || x+size >= getWidth()) {
                xspeed = -xspeed;
            }
            if (y <= 0 || y+size >= getHeight()) {
                yspeed = -yspeed;
            }
            
            if (xspeed == 0 || yspeed == 0) {
                
                xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
                yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
                
            }
        }
        
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slider = new javax.swing.JSlider();
        increaseButton = new javax.swing.JButton();
        decreaseButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        _username = new javax.swing.JTextField();
        _password = new javax.swing.JPasswordField();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sliderMouseEntered(evt);
            }
        });

        increaseButton.setText("Increase");
        increaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                increaseButtonMouseEntered(evt);
            }
        });

        decreaseButton.setText("Decrease");
        decreaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                decreaseButtonMouseEntered(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetButtonMouseEntered(evt);
            }
        });

        exitButton.setText("EXIT");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        loginButton.setText("LOGIN");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_username)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(_password))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(increaseButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(decreaseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton))
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseButton)
                    .addComponent(decreaseButton)
                    .addComponent(resetButton)
                    .addComponent(exitButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void sliderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderMouseEntered
        timer.start();
    }//GEN-LAST:event_sliderMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        
    }//GEN-LAST:event_formMouseExited

    private void increaseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseButtonMouseEntered
        timer.start();
    }//GEN-LAST:event_increaseButtonMouseEntered

    private void decreaseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseButtonMouseEntered
        timer.start();
    }//GEN-LAST:event_decreaseButtonMouseEntered

    private void resetButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseEntered
        timer.start();
    }//GEN-LAST:event_resetButtonMouseEntered

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        String passText = new String(_password.getPassword());
        if (password.equals(passText) && username.equals(_username.getText())) {
            UIManager.put("Panel.background", Color.green);
            UIManager.put("OptionPane.background", Color.green);
            JOptionPane.showMessageDialog(jPanel1, "LOGIN SUCCESFULL");
            timer.start();
            remove(jPanel1);
            login = true;
        }
        else{
            UIManager.put("Panel.background", Color.red);
            UIManager.put("OptionPane.background", Color.red);
            JOptionPane.showMessageDialog(loginButton, "WRONG INPUTS");
            
        }
        
        
    }//GEN-LAST:event_loginButtonMouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        timer.start();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void increaseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseButtonMouseClicked
            int slider_size = slider.getValue();

            for (int i = 0; i < 10; i++) {
            if (ballList.size() < 1000 && login) {
                ballList.add(new Ball((int) (Math.random()*getWidth()) ,(int) (Math.random()*getHeight()), slider_size)); 
               
            }
            progressBar.setValue(ballList.size()/10);

        }
    }//GEN-LAST:event_increaseButtonMouseClicked

    private void decreaseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseButtonMouseClicked
            for (int i = 0; i < 10; i++) {
            if (!ballList.isEmpty() && ballList.size() <= 1000 && login) {
                int index = ballList.size() - 1;
                ballList.remove(index);
               
            }
            progressBar.setValue(ballList.size()/10);

        }
    }//GEN-LAST:event_decreaseButtonMouseClicked

    private void resetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseClicked
        while (!ballList.isEmpty()) {
            int index = ballList.size() - 1;
            ballList.remove(index);
        }
        progressBar.setValue(ballList.size()/10);

    }//GEN-LAST:event_resetButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField _password;
    private javax.swing.JTextField _username;
    private javax.swing.JButton decreaseButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton increaseButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton resetButton;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
