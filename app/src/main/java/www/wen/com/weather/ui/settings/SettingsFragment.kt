package www.wen.com.weather.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import www.wen.com.weather.R

/**
 * @author WEN
 * @Description:
 * @date 2020/9/28 21:05
 */
class SettingsFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detail_weather_fragment,container,false)
    }


}