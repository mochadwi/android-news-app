package io.mochadwi.mobilenews.model.news_source

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class NewsSourceModel(

	@field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)