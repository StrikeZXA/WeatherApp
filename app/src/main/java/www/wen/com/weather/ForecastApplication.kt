package www.wen.com.weather

import android.app.Application
import com.resocoder.forecastmvvm.data.network.ConnectivityInterceptor
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import www.wen.com.weather.data.ApixuWeatherApiService
import www.wen.com.weather.data.db.ForecastDatabase
import www.wen.com.weather.data.network.ConnectivityInterceptorImpl
import www.wen.com.weather.data.network.WeatherNetworkDataSource
import www.wen.com.weather.data.network.WeatherNetworkDataSourceImpl
import www.wen.com.weather.data.repository.ForecastRepository
import www.wen.com.weather.data.repository.ForecastRepositoryImpl
import www.wen.com.weather.ui.weather.current.CurrentWeatherFactory

/**
 * @author WEN
 * @Description:
 * @date 2020/10/14 2:19
 */
class ForecastApplication:Application(), DIAware {

    override val di: DI by DI.lazy {
        //可以为Fragment、Activity等提供上下文各种服务
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase.invoke(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with provider { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService.invoke(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
        bind<CurrentWeatherFactory>() with provider { CurrentWeatherFactory(instance()) }
    }
}