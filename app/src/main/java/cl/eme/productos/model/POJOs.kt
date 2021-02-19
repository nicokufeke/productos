package cl.eme.productos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// POJOs

@Entity (tableName = "product")

data class Products (
    @PrimaryKey val id: Int,
    val name: String,
    val price: String,
    val image: String,
        )

@Entity (tableName = "productDetail")

data class ProductDetail (
    @PrimaryKey val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val description: String,
    val lastPrice: String,
    val credit: String,
        )