package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("average_price")
    val averagePrice: Int? = null,
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("floor_price")
    val floorPrice: Int? = null,
    @SerializedName("market_cap")
    val marketCap: Int? = null,
    @SerializedName("num_owners")
    val numOwners: Int? = null,
    @SerializedName("num_reports")
    val numReports: Int? = null,
    @SerializedName("one_day_average_price")
    val oneDayAveragePrice: Int? = null,
    @SerializedName("one_day_change")
    val oneDayChange: Int? = null,
    @SerializedName("one_day_difference")
    val oneDayDifference: Int? = null,
    @SerializedName("one_day_sales")
    val oneDaySales: Int? = null,
    @SerializedName("one_day_sales_change")
    val oneDaySalesChange: Int? = null,
    @SerializedName("one_day_volume")
    val oneDayVolume: Int? = null,
    @SerializedName("one_hour_average_price")
    val oneHourAveragePrice: Int? = null,
    @SerializedName("one_hour_change")
    val oneHourChange: Int? = null,
    @SerializedName("one_hour_difference")
    val oneHourDifference: Int? = null,
    @SerializedName("one_hour_sales")
    val oneHourSales: Int? = null,
    @SerializedName("one_hour_sales_change")
    val oneHourSalesChange: Int? = null,
    @SerializedName("one_hour_volume")
    val oneHourVolume: Int? = null,
    @SerializedName("seven_day_average_price")
    val sevenDayAveragePrice: Int? = null,
    @SerializedName("seven_day_change")
    val sevenDayChange: Int? = null,
    @SerializedName("seven_day_difference")
    val sevenDayDifference: Int? = null,
    @SerializedName("seven_day_sales")
    val sevenDaySales: Int? = null,
    @SerializedName("seven_day_volume")
    val sevenDayVolume: Int? = null,
    @SerializedName("six_hour_average_price")
    val sixHourAveragePrice: Int? = null,
    @SerializedName("six_hour_change")
    val sixHourChange: Int? = null,
    @SerializedName("six_hour_difference")
    val sixHourDifference: Int? = null,
    @SerializedName("six_hour_sales")
    val sixHourSales: Int? = null,
    @SerializedName("six_hour_sales_change")
    val sixHourSalesChange: Int? = null,
    @SerializedName("six_hour_volume")
    val sixHourVolume: Int? = null,
    @SerializedName("thirty_day_average_price")
    val thirtyDayAveragePrice: Int? = null,
    @SerializedName("thirty_day_change")
    val thirtyDayChange: Int? = null,
    @SerializedName("thirty_day_difference")
    val thirtyDayDifference: Int? = null,
    @SerializedName("thirty_day_sales")
    val thirtyDaySales: Int? = null,
    @SerializedName("thirty_day_volume")
    val thirtyDayVolume: Int? = null,
    @SerializedName("total_sales")
    val totalSales: Int? = null,
    @SerializedName("total_supply")
    val totalSupply: Int? = null,
    @SerializedName("total_volume")
    val totalVolume: Int? = null
)