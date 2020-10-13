package www.wen.com.weather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import www.wen.com.weather.data.CurrentWeatherEntry

/**
 * @author WEN
 * @Description:
 * @date 2020/10/13 11:15
 */
@Database(
    entities=[CurrentWeatherEntry::class],
    version = 1)
abstract class ForecastDatabase:RoomDatabase(){

    /**
     * 返回CurrentWeatherDao类
     */
    abstract fun currentWeatherDao(): CurrentWeatherDao


    /**
     * 下面这段看得不太懂，伴生对象应该是线程安全的，这里不明白为什么要加锁
     */
    companion object{

        @Volatile  private var insatance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = insatance ?: synchronized(LOCK){
            insatance?:buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java, "forecast.db")
                .build()

    }


}