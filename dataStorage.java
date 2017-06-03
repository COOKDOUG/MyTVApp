/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytvapp;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;

/**
 *
 * @author cookd
 */
public class dataStorage {
    private String currentLine;
    private boolean movieExists;
    
    public dataStorage(){
        
    }
    public File checkDataStorage(File parentFile, String s){
        // Supposed to check for the Data Storage text file containing 
        File dataLocation = new File(parentFile.toString().concat(s));
        try {
            dataLocation.createNewFile();
        } catch (IOException e){
            System.out.println("Caught an IO Exception in dataStorage class "+e);
        }
        return dataLocation;
    }
    
    public void writeToFile(File fileLocation, String content){
        // Writes Movies to the Movie text file, TV Shows to the TV Show file.
        String s = fileLocation.toString();
        BufferedWriter bw = null;
        FileWriter fw = null;
        movieExists = false; 
        int line = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.equals(content)){
                    movieExists = true;
                    continue;
                } else {
                    
                };
                line ++;
            }  
            if (!movieExists){
                fw = new FileWriter(fileLocation, true);
                bw = new BufferedWriter(fw, line);
                bw.newLine();
                bw.write(content);
            }
        } catch (IOException e) {
            System.out.println("Caught an IO Exception in dataStorage writeToFile class "+e);
//            e.printStackTrace();
        } finally {
            // Closing the buffered writer and file writer.
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null){
                    fw.close();
                }
            } catch (IOException ex) {
//                ex.printStackTrace();
            }
        }
    }
}