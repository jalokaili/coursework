import java.util.List;

public class StmIfElse extends Stm {
    public final Exp condition;
    public final List<Stm> trueBranch;
    public final List<Stm> falseBranch;

    public StmIfElse(Exp condition, List<Stm> trueBranch, List<Stm> falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public void compile() {
        String trueLabel = freshName("true_branch");
        String endLabel = freshName("if_end");

        condition.compile();
        emit("push " + trueLabel, "jump_z"); // Jump to true branch if condition is negative

        for (Stm stm : trueBranch) {
            stm.compile();
        }

        emit("push " + endLabel, "jump"); // Jump to end of if-else construct

        emit(trueLabel + ":");


        for (Stm stm : falseBranch) {
            stm.compile();
        }

        emit(endLabel + ":");
    }
}
