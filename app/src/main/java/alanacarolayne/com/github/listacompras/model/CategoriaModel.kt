package alanacarolayne.com.github.listacompras.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoriaModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val categoria: String
)