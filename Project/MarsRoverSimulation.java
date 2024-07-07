import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarsRoverSimulation {
    private static final Logger logger = Logger.getLogger(MarsRoverSimulation.class.getName());
    public static boolean ObstacleDetected=false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter grid width: ");
            int gridWidth = scanner.nextInt();
            System.out.print("Enter grid height: ");
            int gridHeight = scanner.nextInt();
            validateGridSize(gridWidth, gridHeight);

            Grid grid = new Grid(gridWidth, gridHeight);

            System.out.print("\nEnter number of obstacles: ");
            int numOfObstacles = scanner.nextInt();
            validateObstacleCount(numOfObstacles);
            for (int i = 0; i < numOfObstacles; i++) {
                System.out.print("\nEnter obstacle " + (i + 1) + " position (x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                validatePosition(x, y, gridWidth, gridHeight);
                grid.add(new Obstacle(x, y));
            }

            System.out.print("\nEnter initial rover position (x y): ");
            int initialX = scanner.nextInt();
            int initialY = scanner.nextInt();
            validatePosition(initialX, initialY, gridWidth, gridHeight);
            System.out.print("\nEnter initial rover direction (N/E/S/W): ");
            String initialDirection = scanner.next().toUpperCase();
            validateDirection(initialDirection);

            Rover rover = new Rover(initialX, initialY, initialDirection, grid);

            System.out.print("\nEnter commands (in the form of MMRMLM): ");
            String commandString = scanner.next();
            List<String> commands = new ArrayList<>();
            for (char command : commandString.toCharArray()) {
                commands.add(String.valueOf(command));
            }

            for (String command : commands) {
                executeCommand(rover, command);
            }

            StatusReport statusReport = new StatusReport(rover);
            System.out.println(statusReport.generateReport());

        } catch (Exception e) {
            System.out.println("An error occured : "+e);
            logger.log(Level.SEVERE, "An error occurred during the simulation. "+e);
        } finally {
            System.out.println("Observations are logged.");
            scanner.close();
        }
    }

    private static void validateGridSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid dimensions must be positive.");
        }
    }

    private static void validateObstacleCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Number of obstacles cannot be negative.");
        }
    }

    private static void validatePosition(int x, int y, int maxWidth, int maxHeight) {
        if (x < 0 || y < 0 || x >= maxWidth || y >= maxHeight) {
            throw new IllegalArgumentException("Position out of grid bounds.");
        }
    }

    private static void validateDirection(String direction) {
        if (!"NSEW".contains(direction)) {
            throw new IllegalArgumentException("Invalid direction. Directions must be one of N, S, E, W.");
        }
    }

    private static void executeCommand(Rover rover, String command) {
        Command cmd;
        switch (command) {
            case "M":
                cmd = new MoveCommand(rover);
                break;
            case "L":
                cmd = new TurnLeftCommand(rover);
                break;
            case "R":
                cmd = new TurnRightCommand(rover);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
        cmd.execute();
    }
}
