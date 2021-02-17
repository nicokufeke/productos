package cl.eme.productos.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: List<Products>)

    @Query("SELECT * FROM product")
    fun getProduct(): LiveData<List<Products>>

    @Query ("SELECT * FROM product WHERE id=:code")
    fun getProductDetail(code: String) : LiveData<ProductDetail>

}

@Database(entities = [Products::class, ProductDetail::class], version = 1)
        abstract class ProductsDatabase : RoomDatabase() {
        abstract fun productsDao() : ProductsDao
        }

    class ProductsApplication : Application() {
        companion object{
            var productsDatabase: ProductsDatabase? = null
        }

        override fun onCreate() {
            super.onCreate()
            productsDatabase = Room.databaseBuilder(this, ProductsDatabase::class.java, "Produc_DataBase").build()
        }
    }