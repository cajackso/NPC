package com.Login;

import java.util.UUID;


public class SessionObj {
    String sessionId;
    boolean hasAccount;

    public String getSessionId(){
        return this.sessionId;
    }

    public boolean isHasAccount() {
        return hasAccount;
    }

    public void setHasAccount(boolean hasAccount) {
        this.hasAccount = hasAccount;
    }

    public void setSessionId(String id){
        this.sessionId=id;
    }

    public void generateSession() {
        UUID session = UUID.randomUUID();
        this.setSessionId(session.toString());
    }
}
