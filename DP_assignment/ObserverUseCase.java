import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature, float humidity, float pressure);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

class Display implements Observer {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current Conditions: Temp: " + temperature + "C, Humidity: " + humidity + "%, Pressure: " + pressure + "hPa");
    }
}

public class ObserverUseCase {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Display Display = new Display();

        weatherStation.registerObserver(Display);

        weatherStation.setWeatherData(25.0f, 60.0f, 1013.0f);
        weatherStation.setWeatherData(26.0f, 55.0f, 1012.0f);
    }
}
