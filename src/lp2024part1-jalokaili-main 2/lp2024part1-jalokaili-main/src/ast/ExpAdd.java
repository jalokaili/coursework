public class ExpAdd extends Exp {
    public final Exp left;
    public final Exp right;

    public ExpAdd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void compile() {
        left.compile();  // Compile the left expression
        right.compile(); // Compile the right expression
        emit("add");     // Emit the SSM instruction to add the top two values on the stack
    }
}