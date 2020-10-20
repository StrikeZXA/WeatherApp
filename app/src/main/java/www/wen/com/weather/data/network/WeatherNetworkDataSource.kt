package www.wen.com.weather.data.network

import androidx.lifecycle.LiveData
import www.wen.com.weather.data.network.reponse.CurrentWeatherResponse

/**
 * @author WEN
 * @Description:
 * @date 2020/10/13 18:45
 */
interface WeatherNetworkDataSource{

    val downloadCurrentWeather:LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location:String,
        language:String
    )

}