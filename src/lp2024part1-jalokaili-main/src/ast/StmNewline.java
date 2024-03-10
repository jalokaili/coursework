public class StmNewline extends Stm {

    @Override
    public void compile() {
        emit("push 2", "sysc");
    }
}