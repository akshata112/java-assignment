import java.util.logging.Level;
import java.util.logging.Logger;

class StatusReport {
    private static final Logger logger = Logger.getLogger(StatusReport.class.getName());
    private Rover rover;

    public StatusReport(Rover rover) {
        this.rover = rover;
    }

    public String generateReport() {
        System.out.println("\nFinal Position: (" + rover.getX() + "," + rover.getY() + "," + rover.getDirection() + ")\n");

        if (MarsRoverSimulation.ObstacleDetected==false){
            String report = String.format("Rover is at (%d, %d) facing %s. No Obstacles detected.",
                rover.getX(), rover.getY(), rover.getDirection());
                logger.log(Level.INFO, "Status report generated: {0}", report);
            return report;
        }
        else{
            String report = String.format("Rover is at (%d, %d) facing %s. Obstacles detected in path.",
                rover.getX(), rover.getY(), rover.getDirection());
                logger.log(Level.INFO, "Status report generated: {0}", report);
            return report;
        }
    }
}
