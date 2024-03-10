public class ExpSub extends Exp {
    public final Exp left;
    public final Exp right;

    public ExpSub(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void compile() {
        left.compile();
        right.compile();
        emit("sub");
    }
}