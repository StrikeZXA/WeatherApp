package www.wen.com.weather.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import www.wen.com.weather.data.ApixuWeatherApiService
import www.wen.com.weather.data.network.reponse.CurrentWeatherResponse
import www.wen.com.weather.internal.NoConnectivityException

/**
 * @author WEN
 * @Description:
 * @date 2020/10/13 19:46
 */
class WeatherNetworkDataSourceImpl(private val apixuWeatherApiService: ApixuWeatherApiService):WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, language: String) {
        try {
            val  fetchedCurrentWeather=  apixuWeatherApiService.getCurrentWeather(location,language).await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }catch (e:NoConnectivityException){
            Log.e("Connectivity", "No internet connection.", e)
        }

    }

}