package io.mochadwi.mobilenews.news_source.model

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type


/**
 * Created by mochadwi on 3/15/18.
 */
class SourcesItemSerializer : JsonSerializer<SourcesItem> {

//    @field:SerializedName("country")
//
//    @field:SerializedName("name")
//
//    @field:SerializedName("description")
//
//    @field:SerializedName("language")
//
//    @PrimaryKey
//    @field:SerializedName("id")
//
//    @field:SerializedName("category")
//
//    @field:SerializedName("url")

    override fun serialize(src: SourcesItem, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val `object` = JsonObject()

        `object`.addProperty("id", src.id)
        `object`.addProperty("country", src.country)
        `object`.addProperty("name", src.name)
        `object`.addProperty("description", src.description)
        `object`.addProperty("language", src.language)
        `object`.addProperty("category", src.category)
        `object`.addProperty("url", src.url)

        return `object`
    }
}
