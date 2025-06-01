package alanacarolayne.com.github.listacompras.viewmodel

import alanacarolayne.com.github.listacompras.model.CategoriaModel
import alanacarolayne.com.github.listacompras.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriaAdapter(
    private val onCategoriaRemoved: (CategoriaModel) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    private var categorias = listOf<CategoriaModel>()

    inner class CategoriaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewCategoria)
        val button: ImageButton = view.findViewById(R.id.imageButton)

        fun bind(categoria: CategoriaModel) {
            textView.text = categoria.categoria
            button.setOnClickListener {
                onCategoriaRemoved(categoria)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.bind(categoria)
    }

    override fun getItemCount(): Int = categorias.size

    fun updateCategorias(newCategorias: List<CategoriaModel>) {
        categorias = newCategorias
        notifyDataSetChanged()
    }
}
