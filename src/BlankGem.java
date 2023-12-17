public class BlankGem extends Gems {
    public BlankGem(int clmn, int row) {
        super(0, ' ', clmn, row);
    }
    @Override
    public boolean isBlank() {
        return true;
    }
}