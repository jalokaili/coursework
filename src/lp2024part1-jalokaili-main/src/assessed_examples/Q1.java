import ast.*;


import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This example outputs 32 72, each on a separate line.
 */
public class Q1 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");

        // Note: println outputs the standard decimal representation
        // of an integer, followed be a newline
        //
        // begin
        //  println 5 + (3 * 9);
        //  println (5 + 3) * 9;
        // end
        // ============================================================

        Exp exp1 = new ExpAdd(new ExpInteger(5), new ExpMul(new ExpInteger(3), new ExpInteger(9)));
        Exp exp2 = new ExpMul(new ExpAdd(new ExpInteger(5), new ExpInteger(3)), new ExpInteger(9));
        Program p = new Program(
                new StmPrintln(exp1), // 5 + (3 * 9)
                new StmPrintln(exp2)  // (5 + 3) * 9


        );
        // ============================================================

        System.out.println("Compiling " + exampleName + "...");
        p.compile();
        System.out.println("Writing...");
        AST.write(outpath);
        System.out.println("... SSM assembly code written to " + outpath);
    }
}
