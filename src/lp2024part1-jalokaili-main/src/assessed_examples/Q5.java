import ast.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This example outputs the following line:
 *      To Be, or not To Be?
 */
public class Q5 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");

        // Note: printstr outputs a string
        //
        // begin
        //  tobe := "To Be";
        //  ornot := ", or not ";
        //  printstr tobe;
        //  printstr ornot;
        //  ornot := tobe;
        //  printstr ornot;
        //  printstr "?";
        //  newline;
        // end
        // ============================================================
        StmAssignStr s1=new StmAssignStr("tobe", "To Be");
        StmAssignStr s2=    new StmAssignStr("ornot", ", or not ");
        Program p = new Program(
            // your sequence of Stm ASTs goes here

                new StmPrintStr(s1.getVariableName()),
                new StmPrintStr(s2.getVariableName()),
                new StmCopyStr(s2,s1), // This will copy the reference of "tobe" to "ornot"
                new StmPrintStr(s2.getVariableName()),
                new StmPrintStr("?"),
                new StmNewline()
        );

        // ============================================================

        System.out.println("Compiling " + exampleName + "...");
        p.compile();
        System.out.println("Writing...");
        AST.write(outpath);
        System.out.println("... SSM assembly code written to " + outpath);
    }
}
