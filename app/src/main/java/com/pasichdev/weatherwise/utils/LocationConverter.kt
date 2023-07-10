package com.pasichdev.weatherwise.utils

import com.pasichdev.weatherwise.data.model.Location


fun getLocationParam(location: Location) : String{
    return location.lat + "," + location.lon
}