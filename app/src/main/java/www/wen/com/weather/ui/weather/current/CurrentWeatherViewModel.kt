package www.wen.com.weather.ui.weather.current

import androidx.lifecycle.ViewModel
import www.wen.com.weather.data.repository.ForecastRepository
import www.wen.com.weather.internal.UnitSystem
import www.wen.com.weather.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC

    private val isMetric:Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred{
        forecastRepository.getCurrentWeather(isMetric)
    }


}