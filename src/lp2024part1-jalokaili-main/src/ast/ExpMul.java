// Define the AST class for multiplication expressions
public class ExpMul extends Exp {
    public final Exp left;
    public final Exp right;

    public ExpMul(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void compile() {
        left.compile();  // Compile the left expression
        right.compile(); // Compile the right expression
        emit("mul");     // Emit the SSM instruction to multiply the top two values on the stack
    }
}
