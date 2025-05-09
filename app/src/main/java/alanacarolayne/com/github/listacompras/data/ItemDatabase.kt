package alanacarolayne.com.github.listacompras.data

import androidx.room.Database
import androidx.room.RoomDatabase
import alanacarolayne.com.github.listacompras.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}