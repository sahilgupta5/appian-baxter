/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appian.appianbaxter.domainentity;

/**
 *
 * @author serdar
 */
public class ReturnEntity {
    private String commandResult;
    private Status baxterStatus;
    public String getCommandResult() {
        return commandResult;
    }

    public void setCommandResult(String commandResult) {
        this.commandResult = commandResult;
    }

    public Status getBaxterStatus() {
        return baxterStatus;
    }

    public void setBaxterStatus(Status baxterStatus) {
        this.baxterStatus = baxterStatus;
    }
    
    
}