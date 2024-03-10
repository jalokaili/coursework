import java.util.*;

/**
 * Abstract Syntax Trees for programs.
 */
public class Program extends AST {

    public  Map<String, Integer> data=null;
    public  Map<String, String> data_str=null;

    public final List<Stm> statements;

    public Program(List<Stm> statements) {
        this.statements = Collections.unmodifiableList(statements);
    }



    public Program(Stm ...stms) {
        this(Arrays.asList(stms));
    }

    /**
     * Emit SSM assembly code which implements this program.
     */
    public void compile() {
        for(Stm stm: statements) {
            stm.compile();
        }
        emit("halt");
        emit(".data");
        // SSM code to allocate statically allocated variables
        // should be emitted here, if needed
        if(data!=null) {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                emit(makeSafe(entry.getKey()) + ": " + entry.getValue());
            }
        }

        if(data_str!=null) {
            for (Map.Entry<String, String> entry : data_str.entrySet()) {
                emit(makeSafe(entry.getKey()) + ": " + entry.getValue());
            }
        }

    }
}
