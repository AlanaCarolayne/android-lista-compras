package alanacarolayne.com.github.listacompras.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
//entity -> uma tabela, uma entidade no banco de dados.
data class ItemModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)