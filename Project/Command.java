import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Command {
    protected Rover rover;
    private static final Logger logger = Logger.getLogger(Command.class.getName());

    public Command(Rover rover) {
        this.rover = rover;
    }

    abstract void execute();

    protected void logExecution(String command) {
        logger.log(Level.INFO, "Executing command: {0}", command);
    }
}



class MoveCommand extends Command {
    private static final Logger logger = Logger.getLogger(MoveCommand.class.getName());

    public MoveCommand(Rover rover) {
        super(rover);
    }

    @Override
    void execute() {
        logExecution("Move");
        int x = rover.getX();
        int y = rover.getY();
        String direction = rover.getDirection();
        Grid grid = rover.getGrid();

        switch (direction) {
            case "N":
                y += 1;
                break;
            case "S":
                y -= 1;
                break;
            case "E":
                x += 1;
                break;
            case "W":
                x -= 1;
                break;
            default:
                logger.log(Level.SEVERE, "Invalid direction: {0}", direction);
                throw new IllegalStateException("Unknown direction: " + direction);
        }

        if (!grid.isObstacle(x, y)) {
            rover.setX(x);
            rover.setY(y);
        } else {
            MarsRoverSimulation.ObstacleDetected=true;
            logger.log(Level.WARNING, "Obstacle detected at position ({0},{1}). Move aborted.", new Object[]{x, y});
        }
    }
}



class TurnLeftCommand extends Command {
    private static final Logger logger = Logger.getLogger(TurnLeftCommand.class.getName());

    public TurnLeftCommand(Rover rover) {
        super(rover);
    }

    @Override
    void execute() {
        logExecution("Turn Left");
        String direction = rover.getDirection();
        int currentIndex = -1;

        for (int i = 0; i < Rover.DIRECTIONS.length; i++) {
            if (Rover.DIRECTIONS[i].equals(direction)) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) {
            logger.log(Level.SEVERE, "Invalid direction: {0}", direction);
            throw new IllegalStateException("Unknown direction: " + direction);
        }

        int newIndex = (currentIndex + 3) % 4;
        rover.setDirection(Rover.DIRECTIONS[newIndex]);
    }
}


class TurnRightCommand extends Command {
    private static final Logger logger = Logger.getLogger(TurnRightCommand.class.getName());

    public TurnRightCommand(Rover rover) {
        super(rover);
    }

    @Override
    void execute() {
        logExecution("Turn Right");
        String direction = rover.getDirection();
        int currentIndex = -1;

        for (int i = 0; i < Rover.DIRECTIONS.length; i++) {
            if (Rover.DIRECTIONS[i].equals(direction)) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) {
            logger.log(Level.SEVERE, "Invalid direction: {0}", direction);
            throw new IllegalStateException("Unknown direction: " + direction);
        }

        int newIndex = (currentIndex + 1) % 4; 
        rover.setDirection(Rover.DIRECTIONS[newIndex]);
    }
}


