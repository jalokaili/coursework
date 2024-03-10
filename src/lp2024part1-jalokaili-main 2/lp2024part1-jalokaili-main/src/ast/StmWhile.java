public class StmWhile extends Stm {
    private final Exp condition;
    private final Stm body;

    public StmWhile(Exp condition, Stm body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void compile() {
        String startLoop = freshName("loop");
        String endLoop = freshName("end");

        emit(startLoop + ":");
        condition.compile();
        emit("push "+endLoop, "jump_z");
        body.compile();
        emit("push " + startLoop);
        emit("jump");

        emit(endLoop + ":");
    }
}

