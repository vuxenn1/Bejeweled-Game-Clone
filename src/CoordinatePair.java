import java.util.HashMap;

class CoordinatePair {
    private final int x;
    private final int y;

    public CoordinatePair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatePair intPair = (CoordinatePair) o;
        return x == intPair.x && y == intPair.y;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }
}