package ua.devmaksem.network.adapters

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import ua.devmaksem.network.factory.ServiceProperties.Companion.DATE_FORMAT
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class DateTypeAdapter : JsonDeserializer<Date> {

    companion object {
        private const val TAG = "DateTypeAdapter"
    }

    override fun deserialize(
        jsonElement: JsonElement?,
        type: Type?,
        context: JsonDeserializationContext?
    ): Date? {
        if (jsonElement == null)
            return null

        val dateStr = jsonElement.asString
        val sdf = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())

        try {
            return sdf.parse(dateStr)
        } catch (ex: JsonParseException) {
            Log.e(TAG, "DateTypeAdapter - ERROR :: ${ex.message}")
            return null
        }
    }
}