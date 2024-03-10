public class ExpString extends Exp {
    private final String value;

    public ExpString(String value) {
        this.value = value;
    }

    @Override
    public void compile() {
        emit("push " + value);
    }
}