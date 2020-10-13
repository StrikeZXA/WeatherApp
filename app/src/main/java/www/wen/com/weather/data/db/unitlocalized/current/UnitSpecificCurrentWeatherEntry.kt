package www.wen.com.weather.data.db.unitlocalized.current

/**
 * @author WEN
 * @Description:
 * @date 2020/10/13 10:34
 */
interface UnitSpecificCurrentWeatherEntry {

    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double

}