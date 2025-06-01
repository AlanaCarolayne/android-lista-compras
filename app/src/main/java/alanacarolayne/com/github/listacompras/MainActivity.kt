package alanacarolayne.com.github.listacompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import alanacarolayne.com.github.listacompras.viewmodel.ItemAdapter
import alanacarolayne.com.github.listacompras.viewmodel.ItemsViewModel
import alanacarolayne.com.github.listacompras.viewmodel.ItemsViewModelFactory


class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: ItemsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

         val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Lista de Compras"


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
      val itemsAdapter = ItemAdapter { item ->
            viewModel.removeItem(item)
        }

        recyclerView.adapter = itemsAdapter


        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val quantText = findViewById<EditText>(R.id.quantText)
        val precoText = findViewById<EditText>(R.id.precoText)

        button.setOnClickListener {

            if (editText.text.isEmpty() || quantText.text.isEmpty() || precoText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }


            viewModel.addItem(editText.text.toString(), quantText.text.toString().toInt(), precoText.text.toString().toDouble())
            editText.text.clear()
            quantText.text.clear()
            precoText.text.clear()
        }


        val viewModelFactory = ItemsViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemsViewModel::class.java)

          viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
}