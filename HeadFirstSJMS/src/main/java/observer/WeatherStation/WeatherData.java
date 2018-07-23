package observer.WeatherStation;

import java.util.*;

public class WeatherData implements Subject {
	
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	public void registerObserver(java.util.Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(java.util.Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	@Override
	public void registerObserver(observer.WeatherStation.Observer o) {
	
	}
	
	@Override
	public void removeObserver(observer.WeatherStation.Observer o) {
	
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observer.WeatherStation.Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	// other WeatherData methods here
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
