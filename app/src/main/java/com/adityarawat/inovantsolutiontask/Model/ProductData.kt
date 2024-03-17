package com.adityarawat.inovantsolutiontask.Model

import com.google.gson.annotations.SerializedName

data class ProductData(
    val id: String,
    val sku: String,
    @SerializedName("is_return")
    val isReturn: Int,
    val name: String,
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    val price: String,
    @SerializedName("final_price")
    val finalPrice: String,
    val status: String,
    val type: String,
    @SerializedName("web_url")
    val webUrl: String,
    @SerializedName("brand_name")
    val brandName: String,
    val brand: String,
    @SerializedName("is_following_brand")
    val isFollowingBrand: Int,
    @SerializedName("brand_banner_url")
    val brandBannerUrl: String,
    @SerializedName("is_salable")
    val isSalable: Boolean,
    @SerializedName("is_new")
    val isNew: Int,
    @SerializedName("is_sale")
    val isSale: Int,
    @SerializedName("is_trending")
    val isTrending: Int,
    @SerializedName("is_best_seller")
    val isBestSeller: Int,
    val image: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val weight: String?, // Adjust type according to actual data
    val description: String,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("how_to_use")
    val howToUse: String?,
    val manufacturer: String?,
    @SerializedName("key_ingredients")
    val keyIngredients: String?,
    @SerializedName("returns_and_exchanges")
    val returnsAndExchanges: String?,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("meta_keyword")
    val metaKeyword: String?,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("size_chart")
    val sizeChart: String?,
    @SerializedName("wishlist_item_id")
    val wishlistItemId: Int,
    @SerializedName("has_options")
    val hasOptions: String,
    val options: List<Any>, // Adjust type according to actual data
    @SerializedName("bundle_options")
    val bundleOptions: List<Any>, // Adjust type according to actual data
    @SerializedName("configurable_option")
    val configurableOptions: List<ConfigurableOption>,
    @SerializedName("remaining_qty")
    val remainingQty: Int,
    val images: List<String>,
    val upsell: List<Any>, // Adjust type according to actual data
    val related: List<Any>, // Adjust type according to actual data
    val review: Review
)


