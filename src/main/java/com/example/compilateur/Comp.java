package com.example.compilateur;

public class Comp {
    private String status;
    private String result;
    private String exceptions;

    public Comp(String status, String result, String exceptions) {
        this.status = status;
        this.result = result;
        this.exceptions = exceptions;
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
