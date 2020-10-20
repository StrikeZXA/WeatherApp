package www.wen.com.weather.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import www.wen.com.weather.data.repository.ForecastRepository

/**
 * @author WEN
 * @Description:
 * @date 2020/10/15 11:26
 */
class CurrentWeatherFactory(val forecastRepository: ForecastRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository) as T
    }

}