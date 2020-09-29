package www.wen.com.weather.data


import com.google.gson.annotations.SerializedName

data class CurrentWeatherEntry(
    val cloud: Int,
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelslikeC: Int,
    @SerializedName("feelslike_f")
    val feelslikeF: Double,
    val humidty: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int,
    @SerializedName("precip_in")
    val precipIn: Int,
    @SerializedName("precip_mn")
    val precipMn: Int,
    @SerializedName("pressure_in")
    val pressureIn: Double,
    @SerializedName("pressure_mb")
    val pressureMb: Int,
    @SerializedName("temp_c")
    val tempC: Int,
    @SerializedName("temp_f")
    val tempF: Double,
    @SerializedName("vis_km")
    val visKm: Int,
    @SerializedName("vis_miles")
    val visMiles: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Int,
    @SerializedName("wind_mph")
    val windMph: Int
)