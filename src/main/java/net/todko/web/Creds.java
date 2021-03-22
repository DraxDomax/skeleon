package net.todko.web;

public class Creds {
    public String user;
    public String pass;

    public static Creds resolveCreds (String type) {
        Creds currentCreds = new Creds();

        if (type.equals("right")) {
            currentCreds.user = "admin";
            currentCreds.pass = "passadm";
        } else if (type.equals("wrong")) {
            currentCreds.user = "wrong";
            currentCreds.pass = "wrong";
        } else {
            currentCreds.user = "undefined";
            currentCreds.pass = "undefined";
        }

        return currentCreds;
    }
}
