package com.example.compilateur;


public class CompServices {
    public static String greetingTemplate = "Hello, %s!";

    /*

      public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        try (JShell js = JShell.create()) {
            do {
                System.out.print("Enter some Java code: ");
                String input = console.nextLine();
                if (input == null) {
                    break;
                }
                List<SnippetEvent> events = js.eval(input);
                for (SnippetEvent e : events) {
                    StringBuilder sb = new StringBuilder();

                    if (e.causeSnippet() == null) {
                        //  We have a snippet creation event
                        switch (e.status()) {

                            case VALID:
                                sb.append("Successful execution ");
                                break;
                            case RECOVERABLE_DEFINED:
                                sb.append("With unresolved references ");
                                break;
                            case RECOVERABLE_NOT_DEFINED:
                                sb.append("Possibly reparable, failed  ");
                                break;
                            case REJECTED:
                                sb.append("Failed execute, Syntax error ");
                                JShellException ev = e.exception();
                                sb.append("\n"+e.exception());
                                break;
                        }
                        if (e.previousStatus() == Status.NONEXISTENT) {
                          //  sb.append("addition");
                        } else {
                          //  sb.append("modification");
                        }
                        //sb.append(" of ");
                        //sb.append(e.snippet().source());
                        JShellException ev = e.exception();
                        if (ev != null) {
                            sb.append("\nEnd up with an exception");
                            sb.append("\n"+e.exception());
                        }

                        System.out.println(sb);


                        if (e.value() != null) {
                            System.out.printf("Value is: %s\n", e.value());
                        }
                        System.out.flush();
                    }
                }


            } while (true);

        }

        System.out.println("\nGoodbye");
    }

     */
}
