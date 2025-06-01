package alanacarolayne.com.github.listacompras.viewmodel

import alanacarolayne.com.github.listacompras.data.CategoriaDao
import alanacarolayne.com.github.listacompras.data.CategoriaDatabase
import alanacarolayne.com.github.listacompras.model.CategoriaModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaViewModel(application: Application) : AndroidViewModel(application) {

    private val categoriaDao: CategoriaDao
    val categoriaLiveData: LiveData<List<CategoriaModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            CategoriaDatabase::class.java,
            "categoria_database"
        ).build()
        categoriaDao = database.categoriaDao()
        categoriaLiveData = categoriaDao.getAll()
    }

    fun addCategoria(categoria: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newCategoria = CategoriaModel(categoria = categoria)
            categoriaDao.insert(newCategoria)
        }
    }

    fun removeCategoria(categoria: CategoriaModel) {
        viewModelScope.launch(Dispatchers.IO) {
            categoriaDao.delete(categoria)
        }
    }
}
