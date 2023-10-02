import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val categorias = arrayOf("Comida", "Deportes", "Viajes")
    private lateinit var adapter: TarjetaAdapter // Debes crear un adaptador personalizado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategorias.adapter = spinnerAdapter

        // Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TarjetaAdapter() // Debes crear tu propio adaptador personalizado
        recyclerView.adapter = adapter

        // Escuchar cambios en el Spinner
        spinnerCategorias.setOnItemSelectedListener { _, _, position, _ ->
            // Actualizar el RecyclerView según la categoría seleccionada
            val categoriaSeleccionada = categorias[position]
            val tarjetasFiltradas = obtenerTarjetasPorCategoria(categoriaSeleccionada)
            adapter.actualizarListaTarjetas(tarjetasFiltradas)
        }
    }

    // Método para obtener tarjetas ficticias por categoría (debes implementarlo)
    private fun obtenerTarjetasPorCategoria(categoria: String): List<Tarjeta> {
        // Lógica para filtrar tarjetas por categoría
        // Retorna una lista de Tarjeta según la categoría seleccionada
        // Debes implementar este método según tus datos de ejemplo
    }
}
