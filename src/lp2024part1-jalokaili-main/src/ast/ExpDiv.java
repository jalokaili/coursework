public class ExpDiv extends Exp {
    public final Exp left;
    public final Exp right;

    public ExpDiv(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void compile() {
        left.compile();  // Compile the left expression
        right.compile(); // Compile the right expression
        emit("div");     // Emit the SSM instruction to divide the top two values on the stack
    }
}
