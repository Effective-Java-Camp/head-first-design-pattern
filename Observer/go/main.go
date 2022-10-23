package main

import (
	"fmt"
	"observer/observable"
	"observer/observer"
)

func main() {
	// Init subject (observable instance)
	weatherData := observable.NewWeatherData()

	// Init observers
	currentDisplay := observer.NewCurrentConditionsDisplay()
	statisticsDisplay := observer.NewStatisticsDisplay()
	forecastDisplay := observer.NewForecastDisplay()
	heatIndexDisplay := observer.NewHeatIndexDisplay()

	// Register observers at subject
	weatherData.RegisterObserver(currentDisplay)
	weatherData.RegisterObserver(statisticsDisplay)
	weatherData.RegisterObserver(forecastDisplay)
	weatherData.RegisterObserver(heatIndexDisplay)

	// Update value of subject
	fmt.Println("\nMeasurements #1")
	weatherData.SetMeasurements(80, 65, 30.4)

	// Update value of subject
	fmt.Println("\nMeasurements #2")
	weatherData.RemoveObserver(forecastDisplay)
	weatherData.SetMeasurements(82, 70, 29.2)

	// Update value of subject
	fmt.Println("\nMeasurements #3")
	weatherData.SetMeasurements(78, 90, 29.2)
}
