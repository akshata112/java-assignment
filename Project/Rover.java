import java.util.logging.Level;
import java.util.logging.Logger;

class Rover {
    private static final Logger logger = Logger.getLogger(Rover.class.getName());
    private int x;
    private int y;
    private String direction;
    private Grid grid;
    public static final String[] DIRECTIONS = {"N", "E", "S", "W"};

    public Rover(int x, int y, String direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
        logger.log(Level.INFO, "Rover initialized at position ({0},{1}) facing {2}.", new Object[]{x, y, direction});
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
        logger.log(Level.INFO, "Rover moved to position ({0},{1}).", new Object[]{x, y});
    }

    public void setY(int y) {
        this.y = y;
        logger.log(Level.INFO, "Rover moved to position ({0},{1}).", new Object[]{x, y});
    }

    public void setDirection(String direction) {
        this.direction = direction;
        logger.log(Level.INFO, "Rover turned to face {0}.", direction);
    }

    public Grid getGrid() {
        return grid;
    }
}
