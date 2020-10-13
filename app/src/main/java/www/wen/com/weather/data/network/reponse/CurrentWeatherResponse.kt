package www.wen.com.weather.data

import com.google.gson.annotations.SerializedName
import www.wen.com.weather.data.db.entity.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,

    val location: Location
)