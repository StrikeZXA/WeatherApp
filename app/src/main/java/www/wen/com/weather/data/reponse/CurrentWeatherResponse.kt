package www.wen.com.weather.data

import com.google.gson.annotations.SerializedName
import www.wen.com.weather.data.reponse.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,

    val location: Location
)