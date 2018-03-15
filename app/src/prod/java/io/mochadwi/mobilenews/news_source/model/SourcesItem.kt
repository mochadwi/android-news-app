package io.mochadwi.mobilenews.news_source.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@RealmClass
open class SourcesItem(

	@field:SerializedName("country")
	var country: String? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("description")
	var description: String? = null,

	@field:SerializedName("language")
	var language: String? = null,

	@field:SerializedName("id")
	var id: String? = null,

	@field:SerializedName("category")
	var category: String? = null,

	@field:SerializedName("url")
	var url: String? = null


) : RealmObject() {
	override fun toString(): String {
		return Gson().toJson(this)
	}
}