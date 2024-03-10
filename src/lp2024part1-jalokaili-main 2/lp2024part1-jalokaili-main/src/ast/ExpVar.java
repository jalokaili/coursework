public class ExpVar extends Exp {
    public final String varName;

    public ExpVar(String varName) {
        this.varName = varName;
    }

    @Override
    public void compile() {
        emit("push " + makeSafe(varName)); // Emit the SSM instruction to load the variable's value
        emit("load");
    }
}