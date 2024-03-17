package com.adityarawat.inovantsolutiontask.Model

import com.google.gson.annotations.SerializedName

data class ConfigurableOption(
    @SerializedName("attribute_id")
    val attributeId: Int,
    val type: String,
    @SerializedName("attribute_code")
    val attributeCode: String,
    val attributes: List<Attribute>
)