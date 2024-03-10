public class StmAssign extends Stm {
    public final String varName;
    public final Exp exp;

    public StmAssign(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public void compile() {
        exp.compile(); // Compile the expression
        emit("push " + makeSafe(varName), "store");
    }
}
