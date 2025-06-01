package alanacarolayne.com.github.listacompras.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CategoriasViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(CategoriaViewModel::class.java)){
            return CategoriaViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }


}