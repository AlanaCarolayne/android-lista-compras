package alanacarolayne.com.github.listacompras.viewmodel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import alanacarolayne.com.github.listacompras.R
import alanacarolayne.com.github.listacompras.model.ItemModel
import android.widget.NumberPicker
import kotlin.math.roundToInt

class ItemAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    private var items = listOf<ItemModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val numberPickerItemQuant = view.findViewById<NumberPicker>(R.id.numberPickerItemQuant)
        val numberPickerPreco = view.findViewById<NumberPicker>(R.id.numberPickerPreco)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(item: ItemModel) {
            textView.text = item.name
            numberPickerItemQuant.value = item.quantidade
            numberPickerPreco.value = item.preco.roundToInt()
            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}