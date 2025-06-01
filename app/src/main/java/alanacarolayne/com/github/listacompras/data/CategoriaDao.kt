package alanacarolayne.com.github.listacompras.data

import alanacarolayne.com.github.listacompras.model.CategoriaModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoriaDao {
    @Query("SELECT * FROM CategoriaModel")
    fun getAll(): LiveData<List<CategoriaModel>>

    @Insert
    suspend fun insert(categoria: CategoriaModel)

    @Delete
    suspend fun delete(categoria: CategoriaModel)
}
