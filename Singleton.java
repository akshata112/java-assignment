class ConfigurationManager {

    private static ConfigurationManager instance;
    
    private String databaseUrl;
    private String apiKey;
    private int maxConnections;

    private ConfigurationManager() {
        this.databaseUrl = "My database Url";
        this.apiKey = "Apikey";
        this.maxConnections = 10;
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

}

public class Singleton {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        String dbUrl = configManager.getDatabaseUrl();
        String apiKey = configManager.getApiKey();
        int maxConnections = configManager.getMaxConnections();

        System.out.println("Database URL: " + dbUrl);
        System.out.println("API Key: " + apiKey);
        System.out.println("Max Connections: " + maxConnections);
    }
}
