/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Applets;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends Applet implements ActionListener {
    
    private TextArea area;
    Graphics graph;
    private Button btnSave , btnReset;
    public void init(){
        this.setSize(420, 340);
        this.setBackground(Color.gray);
        btnSave = new Button("Save");
        btnReset = new Button("Reset");
        area = new TextArea("");        
        add(area);
        add(btnSave);
        add(btnReset);
        area.setBounds(5, 5, this.getWidth()-10, this.getHeight()-40);
        btnSave.setBounds(50,310,40,20);
        btnReset.setBounds(150,310,40,20);
        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        this.setLayout(null);
    }
    
    public void paint(Graphics g){
    	graph = g;
    }

    public void actionPerformed(ActionEvent e) {

            if(e.getSource() == btnSave){			
//			area.setText("save button");
                    writeDataToFile(area.getText());

            }else{
                    area.setText("");
            }	
    }

    private void writeDataToFile(String data){
        try{
            File file = new File("savedFile.txt");
            if(!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
            System.out.println("Done");
        }catch(IOException e){
            System.out.println("File error");
            e.printStackTrace();
        }

    }
}
