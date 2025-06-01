package alanacarolayne.com.github.listacompras.data

import alanacarolayne.com.github.listacompras.model.CategoriaModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CategoriaModel::class], version = 1)
abstract  class CategoriaDatabase: RoomDatabase() {
    abstract  fun CategoriaDao(): CategoriaDao
}