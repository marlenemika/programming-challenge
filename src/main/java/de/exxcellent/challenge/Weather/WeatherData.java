package de.exxcellent.challenge.Weather;

public class WeatherData {

    private int day, maxTemp, minTemp;

    public WeatherData(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public WeatherData(String[] contents) {
        this.day = Integer.parseInt(contents[0]);
        this.maxTemp = Integer.parseInt(contents[1]);
        this.minTemp = Integer.parseInt(contents[2]);
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    /**
     * @return the absolute difference between maxTemp and minTemp
     */
    public int getTempSpread() {
        return Math.abs(maxTemp - minTemp);
    }

    @Override
    public String toString() {
        return String.format("Day: %d, maxTemp: %d, minTemp: %d", day, maxTemp, minTemp);
    }

    @Override
    public boolean equals(Object obj) {

        // Object is compared with itself
        if (obj == this) return true;

        // Comparing object is not instance of WeatherData
        if (!(obj instanceof WeatherData)) return false;

        // Parse comparing object to WeatherData object in order to compare its fields
        WeatherData other = (WeatherData) obj;

        return other.day == this.day && 
                other.maxTemp == this.maxTemp &&
                other.minTemp == this.minTemp;
    }
}
