package com.example.compilateur;

import jdk.jshell.JShell;

import java.util.Timer;

public class Comp {
    public static Timer tm;
    public static JShell js;
    public static String ID;
    private String status;
    private String result;
    private String exceptions;
    public Comp(Timer tm, String id){
        this.tm = tm;
        this.ID = id;
    }
    public Comp (JShell js, String id){
        this.js = js;
        this.ID =id;
    }

    public Comp(String status, String result, String exceptions) {
        this.status = status;
        this.result = result;
        this.exceptions = exceptions;
    }

    public static Timer getTm() {
        return tm;
    }

    public static void setTm(Timer tm) {
        Comp.tm = tm;
    }

    public static JShell getJs() {
        return js;
    }

    public static void setJs(JShell js) {
        Comp.js = js;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Comp.ID = ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExceptions() {
        return exceptions;
    }

    public void setExceptions(String exceptions) {
        this.exceptions = exceptions;
    }
}
