package www.wen.com.weather.data.repository

import androidx.lifecycle.LiveData
import www.wen.com.weather.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

/**
 * @author WEN
 * @Description:
 * @date 2020/10/14 3:22
 */
interface ForecastRepository {

    suspend fun getCurrentWeather(metric:Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

}