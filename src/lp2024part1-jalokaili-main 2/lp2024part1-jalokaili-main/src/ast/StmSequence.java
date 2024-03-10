import java.util.Arrays;
import java.util.List;

public class StmSequence extends Stm {
    private final List<Stm> statements;

    public StmSequence(List<Stm> statements) {
        this.statements = statements;
    }

    public StmSequence(Stm... statements) {
        this.statements = Arrays.asList(statements);
    }

    @Override
    public void compile() {
        for (Stm stm : statements) {
            stm.compile();
        }
    }
}
