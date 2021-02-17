package cl.eme.productos.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber


@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: List<Products>)

    @Query("SELECT * FROM product")
    fun getProduct(): LiveData<List<Products>>

/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productDetail: List<ProductDetail>)
*/

    @Query ("SELECT * FROM product WHERE id=:code")
    fun getProductDetail(code: Int) : LiveData<ProductDetail>

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
            Timber.d("onCreate de Application")
            productsDatabase =
                Room.databaseBuilder(this, ProductsDatabase::class.java, "Produc_DataBase").build()
        }
    }