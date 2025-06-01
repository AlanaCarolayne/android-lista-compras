import alanacarolayne.com.github.listacompras.R
import alanacarolayne.com.github.listacompras.viewmodel.CategoriaAdapter
import alanacarolayne.com.github.listacompras.viewmodel.CategoriaViewModel
import alanacarolayne.com.github.listacompras.viewmodel.CategoriasViewModelFactory
import alanacarolayne.com.github.listacompras.viewmodel.ItemAdapter
import alanacarolayne.com.github.listacompras.viewmodel.ItemsViewModel
import alanacarolayne.com.github.listacompras.viewmodel.ItemsViewModelFactory
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.material3.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemsViewModel
    private lateinit var categoriaViewModel: CategoriaViewModel

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

        val editText = findViewById<EditText>(R.id.editText)
        val quantText = findViewById<EditText>(R.id.quantText)
        val precoText = findViewById<EditText>(R.id.precoText)
        val spinner = findViewById<Spinner>(R.id.spinnerCategorias)
        val button = findViewById<Button>(R.id.button)

        // ViewModels
        viewModel = ViewModelProvider(this, ItemsViewModelFactory(application))[ItemsViewModel::class.java]
        categoriaViewModel = ViewModelProvider(this, CategoriasViewModelFactory(application))[CategoriaViewModel::class.java]

        categoriaViewModel.categoriaLiveData.observe(this) { categorias ->
            val nomesCategorias = categorias.map { it.categoria }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nomesCategorias)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        // Observar e atualizar os itens
        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }

        button.setOnClickListener {
            if (editText.text.isEmpty() || quantText.text.isEmpty() || precoText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            val nome = editText.text.toString()
            val quantidade = quantText.text.toString().toInt()
            val preco = precoText.text.toString().toDouble()
            val categoriaSelecionada = spinner.selectedItem?.toString() ?: "Sem categoria"

            // Passar a categoria ao adicionar item
            viewModel.addItem(nome, quantidade, preco, categoriaSelecionada)

            editText.text.clear()
            quantText.text.clear()
            precoText.text.clear()
        }
    }
}
