/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appian.appianbaxter;

import com.appian.appianbaxter.domainentity.Command;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * An object that manages IO to/from baxter
 *
 * @author serdar
 */
public class BaxterIO {

    private final BufferedReader reader;
    private final BufferedWriter writer;

    public BaxterIO(Process process) {
        this.reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        this.writer = new BufferedWriter(
                new OutputStreamWriter(process.getOutputStream()));
    }
    
    public BaxterIO(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    public void sendCommand(Command command) throws IOException {
        writer.write(command.getCommand()+"\n");
        writer.flush(); 
    }
    
    public String getResult() throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        do {
            line = reader.readLine();
            sb.append(line).append("\n");
            System.out.println("Stdout: " + line);
        } while(reader.ready() && line != null && !line.trim().equals("--EOF--"));
        return sb.toString();
    }
}
