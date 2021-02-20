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
    public static String result = "aucun resultat";
    public static String status = "aucun status";
    public static String exceptions = "aucune exception";
    private static List<SnippetEvent> events;


    public static void lire(String code) {

        try (JShell js = JShell.create()) {
            //do {
            //System.out.print("Enter some Java code: ");
            String input = code;
            // if (input == null) {
            //   break;
            //  }
            events = js.eval(input);
            for (SnippetEvent e : events) {
                // StringBuilder sb = new StringBuilder();

                if (e.causeSnippet() == null) {
                    //  We have a snippet creation event
                    switch (e.status()) {

                        case VALID:
                            //sb.append("Successful execution ");
                            status = "Successful execution ";
                            break;
                        case RECOVERABLE_DEFINED:
                            //sb.append("With unresolved references ");
                            status = "With unresolved references ";
                            break;
                        case RECOVERABLE_NOT_DEFINED:
                            //sb.append("Possibly reparable, failed  ");
                            status = "Possibly reparable, failed  ";
                            break;
                        case REJECTED:
                            //sb.append("Failed execute, Syntax error ");
                            status = "Failed execute, Syntax error ";
                            break;
                    }
                    if (e.previousStatus() == Snippet.Status.NONEXISTENT) {
                        //  sb.append("addition");
                    } else {
                        //  sb.append("modification");
                    }
                    //sb.append(" of ");
                    //sb.append(e.snippet().source());
                    JShellException ev = e.exception();
                    if (ev != null) {
                        // sb.append("\nEnd up with an exception");
                        // sb.append("\n"+e.exception());
                        exceptions = "\n" + e.exception();
                    }

                    //System.out.println(sb);


                    if (e.value() != null) {
                        //System.out.printf("Value is: %s\n", e.value());
                        result = e.value();
                        // System.out.println(result);
                    }
                    System.out.flush();
                }
            }


            //} while (stop == 1);

        }
    }
}
