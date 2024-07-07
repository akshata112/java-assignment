import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class GridComponent {
    abstract void add(GridComponent component);
    abstract void remove(GridComponent component);
    abstract boolean isObstacle(int x, int y);
}


class Grid extends GridComponent {
    private static final Logger logger = Logger.getLogger(Grid.class.getName());
    private int width;
    private int height;
    private List<GridComponent> components = new ArrayList<>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        logger.log(Level.INFO, "Grid initialized with size ({0}x{1}).", new Object[]{width, height});
    }

    @Override
    void add(GridComponent component) {
        components.add(component);
    }

    @Override
    void remove(GridComponent component) {
        components.remove(component);
    }

    @Override
    boolean isObstacle(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return true;
        }
        for (GridComponent component : components) {
            if (component.isObstacle(x, y)) {
                return true;
            }
        }
        return false;
    }
}