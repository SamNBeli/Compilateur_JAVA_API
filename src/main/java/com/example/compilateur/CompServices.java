package com.example.compilateur;

import jdk.jshell.JShell;
import jdk.jshell.JShellException;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service

public class CompServices {
    public static String result;
    public static String status;
    public static String exceptions;
    private static List<SnippetEvent> events;
    public static HashMap<String, JShell> idenf =  new HashMap<String, JShell>();
    public static HashMap<String, Timer> timet =  new HashMap<String, Timer>();

    public static void creetmr(String id){
        Comp cmp2 = new Comp(new Timer(), id);
        timet.put(Comp.getID(), Comp.getTm());
        System.out.println("le temps");
        System.out.println(timet.keySet().toString());
    }

    public static void sessTimeOut(String key){
        timet.get(key).cancel();
        timet.get(key).purge();
        Comp cmp2 = new Comp(new Timer(), key);
        timet.put(Comp.getID(), Comp.getTm());
        timet.get(key).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(idenf.keySet().toString());
                idenf.remove(key);
                System.out.println(idenf.keySet().toString());
            }
        },600000);
    }

    public static void strt(){
        result = "No results";
        status = "No status";
        exceptions = "No exceptions";
    }
    public static void creeJsh(String id){
        strt();
        System.out.println("L'api a demarrer ");
        Comp cmp1 = new Comp(JShell.create(), id);
        idenf.put(Comp.getID(), Comp.getJs());
    }

    public static void redemarrer(){
        strt();
        System.out.println("L'api a redemarrer");
    }
    public static void lire(String code, String id) {
        strt();

            String input = code;
        System.out.println(code);
            events = idenf.get(id).eval(input);
            Snippet s = events.get(0).snippet();
        idenf.get(id).diagnostics(s).forEach(d ->exceptions = d.getMessage(Locale.getDefault()));
            for (SnippetEvent e : events) {


                if (e.causeSnippet() == null) {
                    //  We have a snippet creation event
                    switch (e.status()) {

                        case VALID:
                            status = "Successful execution ";
                            break;
                        case RECOVERABLE_DEFINED:
                            status = "With unresolved references ";
                            break;
                        case RECOVERABLE_NOT_DEFINED:
                            status = "Possibly reparable, failed  ";
                            break;
                        case REJECTED:
                            status = "Failed execute";
                            break;
                    }
                    JShellException ev = e.exception();
                    if (ev != null) {
                        exceptions = "\n" + e.exception();
                    }


                    if (e.value() != null) {
                        result = e.value();
                    }
                    System.out.flush();
                }
            }

    }

}
