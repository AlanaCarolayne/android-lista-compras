package alanacarolayne.com.github.listacompras.viewmodel

import alanacarolayne.com.github.listacompras.data.ItemDao
import alanacarolayne.com.github.listacompras.data.ItemDatabase
import alanacarolayne.com.github.listacompras.model.ItemModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val itemDao: ItemDao
    val itemsLiveData: LiveData<List<ItemModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()
        itemDao = database.itemDao()
        itemsLiveData = itemDao.getAll()
    }

    fun addItem(item: String, toInt: Any?, toDouble: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            val newItem = ItemModel(name = item, quantidade = toInt as Int, preco = toDouble)
            itemDao.insert(newItem)
        }
    }

    fun removeItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }
    }
}