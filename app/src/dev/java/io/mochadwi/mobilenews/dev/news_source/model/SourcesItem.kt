package io.mochadwi.mobilenews.dev.news_source.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import io.mochadwi.mobilenews.util.CloneableRealmObject
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
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

	@PrimaryKey
	@field:SerializedName("id")
	var id: String? = null,

	@field:SerializedName("category")
	var category: String? = null,

	@field:SerializedName("url")
	var url: String? = null

//	@field:SerializedName("timestamps")
//	var timestamps: Int = 0

) : RealmObject(), CloneableRealmObject<SourcesItem> {
	override fun toString(): String {
		return Gson().toJson(this.cloneRealmObject())
	}

	override fun cloneRealmObject(): SourcesItem {
		val clone = SourcesItem()
		clone.id = this.id
		clone.name = this.name
		clone.country = this.country
		clone.description = this.description
		clone.language = this.language
		clone.category = this.category
		clone.url = this.url
//		clone.timestamps = this.timestamps
		return clone
	}
}