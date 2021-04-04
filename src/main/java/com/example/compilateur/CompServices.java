package com.example.compilateur;

import jdk.jshell.JShell;
import jdk.jshell.JShellException;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service

public class CompServices {
    public static int stop = 1;
    public static String result;
    public static String status;
    public static String exceptions;
    private static List<SnippetEvent> events;


    static JShell js = JShell.create();

    public static void redemarrer(){
        result = "aucun resultat";
        status = "aucun status";
        exceptions = "aucune exception";
        System.out.println("redemarre est la!");
      //  js.drop(events);
    }
    public static void lire(String code) {

         result = "aucun resultat";
         status = "aucun status";
        exceptions = "aucune exception";

            String input = code;

            events = js.eval(input);
            Snippet s = js.eval(input).get(0).snippet();
        js.diagnostics(s).forEach(d ->exceptions = d.getMessage(Locale.getDefault()));
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
                            status = "Failed execute, Syntax error ";
                            break;
                    }
                    JShellException ev = e.exception();
                    if (ev != null) {
                        exceptions = "\n" + e.exception();
                    }


                    if (e.value() != null) {
                        result = e.value();
                        System.out.println(e.value());
                    }
                    System.out.flush();
                }
            }

    }


}
