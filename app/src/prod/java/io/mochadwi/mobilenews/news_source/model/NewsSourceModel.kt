package io.mochadwi.mobilenews.news_source.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class NewsSourceModel(

	@field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null


) {
	override fun toString(): String {
		return Gson().toJson(this)
	}
}