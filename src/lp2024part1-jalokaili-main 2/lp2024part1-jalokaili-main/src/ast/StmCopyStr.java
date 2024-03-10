public class StmCopyStr extends Stm
{
    public StmCopyStr(StmAssignStr s1,StmAssignStr s2) {
        s1.setVariableName((s2.getVariableName()));
    }
    @Override
    public void compile() {

    }
}
