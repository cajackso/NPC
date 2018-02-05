package com.User;
import com.Login.Credentials;

import java.sql.Timestamp;

    public class User {
        String DatabaseId;
        Credentials creds;
        String SessionString;
        String UserName;
        String Password;
        String firstName;
        String email;
        String currency;
        Timestamp lastAction;

        public Timestamp getLastAction() {
            return lastAction;
        }

        public void setLastAction(Timestamp lastAction) {
            this.lastAction = lastAction;
        }

        public void GenerateLastAction() {
            this.lastAction= new Timestamp(System.currentTimeMillis());
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        String lastName;

        public Credentials getCreds() {
            return creds;
        }

        public void setCreds(Credentials creds) {
            this.creds = creds;
        }

        public String getSessionString() {
            return SessionString;
        }

        public void setSessionString(String sessionString) {
            SessionString = sessionString;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public String getDatabaseId() {
            return DatabaseId;
        }

        public void setDatabaseId(String databaseId) {
            DatabaseId = databaseId;
        }

    }


