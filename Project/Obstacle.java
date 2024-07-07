import java.util.logging.Level;
import java.util.logging.Logger;

class Obstacle extends GridComponent {
    private static final Logger logger = Logger.getLogger(Obstacle.class.getName());
    private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
        logger.log(Level.INFO, "Obstacle created at position ({0},{1}).", new Object[]{x, y});
    }

    @Override
    void add(GridComponent component) {
        throw new UnsupportedOperationException("Cannot add to an obstacle.");
    }

    @Override
    void remove(GridComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an obstacle.");
    }

    @Override
    boolean isObstacle(int x, int y) {
        return this.x == x && this.y == y;
    }
}
