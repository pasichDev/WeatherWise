package com.pasichdev.weatherwise.utils

import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.data.model.WeatherIcon


fun getWeatherIcon(codeToFind: Int): Int{

    return WeatherIcons.find { it.code == codeToFind }?.icon ?: R.drawable.w_112
}


val WeatherIcons = arrayOf(
    WeatherIcon(1000, R.drawable.w_113),
    WeatherIcon(1003, R.drawable.w_116),
    WeatherIcon(1006, R.drawable.w_119),
 //   WeatherIcon(1009, R.drawable.w_122),
    WeatherIcon(1030, R.drawable.w_143),
    WeatherIcon(1063, R.drawable.w_176),
    WeatherIcon(1066, R.drawable.w_179),
 /*   WeatherIcon(1069, R.drawable.w_182),
    WeatherIcon(1072, R.drawable.w_185),
    WeatherIcon(1087, R.drawable.w_200),
    WeatherIcon(1114, R.drawable.w_227),
    WeatherIcon(1117, R.drawable.w_230),
    WeatherIcon(1135, R.drawable.w_248),
    WeatherIcon(1147, R.drawable.w_260),
    WeatherIcon(1150, R.drawable.w_263),
    WeatherIcon(1153, R.drawable.w_266),
    WeatherIcon(1168, R.drawable.w_281),
    WeatherIcon(1171, R.drawable.w_284),
    WeatherIcon(1180, R.drawable.w_293),
    WeatherIcon(1183, R.drawable.w_296),
    WeatherIcon(1186, R.drawable.w_299),
    WeatherIcon(1189, R.drawable.w_302),
    WeatherIcon(1192, R.drawable.w_305),
    WeatherIcon(1195, R.drawable.w_308),
    WeatherIcon(1198, R.drawable.w_311),
    WeatherIcon(1201, R.drawable.w_314),
  */
    WeatherIcon(1204, R.drawable.w_317),
    WeatherIcon(1207, R.drawable.w_320),
    WeatherIcon(1210, R.drawable.w_323),
    WeatherIcon(1213, R.drawable.w_326),
    WeatherIcon(1216, R.drawable.w_329),
 //   WeatherIcon(1219, R.drawable.w_332),
    WeatherIcon(1222, R.drawable.w_335),
    WeatherIcon(1225, R.drawable.w_338),
    WeatherIcon(1237, R.drawable.w_350),
    WeatherIcon(1240, R.drawable.w_353),
    WeatherIcon(1243, R.drawable.w_356),
    WeatherIcon(1246, R.drawable.w_359),
    WeatherIcon(1249, R.drawable.w_362),
    WeatherIcon(1252, R.drawable.w_365),
    WeatherIcon(1255, R.drawable.w_368),
    WeatherIcon(1258, R.drawable.w_371),
    WeatherIcon(1261, R.drawable.w_374),
    WeatherIcon(1264, R.drawable.w_377),
    WeatherIcon(1273, R.drawable.w_386),
    WeatherIcon(1276, R.drawable.w_389),
    WeatherIcon(1279, R.drawable.w_392),
    WeatherIcon(1282, R.drawable.w_395)
)