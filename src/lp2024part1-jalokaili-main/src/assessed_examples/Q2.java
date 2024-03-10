import ast.*;


import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This example outputs 9.
 */
public class Q2 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");

        Map<String, Integer> data;

        // Note: the / operator is integer division
        //
        // begin
        //  x := 72;
        //  y := (6 + (x - 9)) / 7;
        //  println y;
        // end
        // ============================================================
        Program p = new Program(
            // your sequence of Stm ASTs goes here
                new StmAssign("y", new ExpDiv(
                        new ExpAdd(
                                new ExpInteger(6),
                                new ExpSub(
                                        new ExpVar("x"),
                                        new ExpInteger(9)
                                )
                        ),
                        new ExpInteger(7)
                )),
                new StmPrintln(new ExpVar("y"))


        );
        data=new HashMap<String, Integer>() {{
            put("x", 72);
            put("y", 0);
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
