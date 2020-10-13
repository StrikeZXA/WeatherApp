package www.wen.com.weather.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import www.wen.com.weather.R
import www.wen.com.weather.data.ApixuWeatherApiService
import www.wen.com.weather.data.network.ConnectivityInterceptorImpl
import www.wen.com.weather.data.network.WeatherNetworkDataSourceImpl

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        val weatherNetworkDataSource =  WeatherNetworkDataSourceImpl( ApixuWeatherApiService.invoke(ConnectivityInterceptorImpl(requireContext())))
        weatherNetworkDataSource.downloadCurrentWeather.observe(viewLifecycleOwner, Observer {
            textView.text = it.toString()
        })
        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather("London","en")
        }
    }

}