import ast.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This example outputs 88.
 */
public class Q4 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");

        // begin
        //  x := 20;
        //  if (x) {
        //      x := x - 7;
        //      if (x - 13) {
        //          println x;
        //      } else {
        //          println 88;
        //      }
        //  } else {
        //      println 99;
        //  }
        // end
        // ============================================================
        Program p = new Program(
            // your sequence of Stm ASTs goes here
                new StmIfElse(
                        new ExpVar("x"),
                        Arrays.asList(
                                new StmAssign("x", new ExpSub(new ExpVar("x"), new ExpInteger(7))),
                                new StmIfElse(
                                        new ExpSub(new ExpVar("x"), new ExpInteger(13)),
                                        Arrays.asList(
                                                new StmPrintln(new ExpVar("x"))
                                        ),
                                        Arrays.asList(
                                                new StmPrintln(new ExpInteger(88))
                                        )
                                )
                        ),
                        Arrays.asList(
                                new StmPrintln(new ExpInteger(99))
                        )
                )
        );

        Map<String, Integer> data=new HashMap<String, Integer>() {{
            put("x", 20);
        }};
        p.data=data;
        // ============================================================

        System.out.println("Compiling " + exampleName + "...");
        p.compile();
        System.out.println("Writing...");
        AST.write(outpath);
        System.out.println("... SSM assembly code written to " + outpath);
    }
}
