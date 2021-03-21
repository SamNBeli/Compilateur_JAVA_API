package com.example.compilateur;

import jdk.jshell.JShell;
import jdk.jshell.JShellException;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompServices {
    public static int stop = 1;
    public static String result;
    public static String status;
    public static String exceptions;
    private static List<SnippetEvent> events;

    public void lire1(){

}
    static JShell js = JShell.create();

    public static void lire(String code) {

         result = "aucun resultat";
         status = "aucun status";
        exceptions = "aucune exception";

            String input = code;

            events = js.eval(input);
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
                    }
                    System.out.flush();
                }
            }

    }


}
