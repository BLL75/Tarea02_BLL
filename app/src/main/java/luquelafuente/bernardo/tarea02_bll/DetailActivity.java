package luquelafuente.bernardo.tarea02_bll;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad que muestra los detalles de un personaje seleccionado.
 * <p>
 * Esta actividad recibe información de un personaje a través de un Intent
 * y muestra su imagen, nombre, descripción y habilidades en la interfaz.
 */
public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewDetail; // Imagen del personaje
    private TextView textViewDetailName; // Nombre del personaje
    private TextView textViewDetailDescription; // Descripción del personaje
    private TextView textViewDetailAbilities; // Habilidades del personaje

    /**
     * Método llamado al crear la actividad.
     * <p>
     * En este método, se inicializan las vistas, se reciben los datos del personaje
     * a través del Intent y se muestran los detalles en la interfaz.
     *
     * @param savedInstanceState Un objeto Bundle que contiene el estado previamente guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Enlaza las vistas del layout con sus correspondientes IDs
        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewDetailName = findViewById(R.id.textViewDetailName);
        textViewDetailDescription = findViewById(R.id.textViewDetailDescription);
        textViewDetailAbilities = findViewById(R.id.textViewDetailAbilities);

        // Obtén los datos del Intent que inició esta actividad
        Intent intent = getIntent();
        if (intent != null) {
            int imageResId = intent.getIntExtra("image", 0); // Obtiene el ID de la imagen
            String name = intent.getStringExtra("name"); // Obtiene el nombre del personaje
            String description = intent.getStringExtra("description"); // Obtiene la descripción del personaje
            String abilities = intent.getStringExtra("abilities"); // Obtiene las habilidades del personaje

            // Asigna los valores a las vistas
            if (imageResId != 0) {
                imageViewDetail.setImageResource(imageResId); // Asigna la imagen al ImageView
            }
            // Asigna el nombre al TextView, o un mensaje si no hay nombre
            textViewDetailName.setText(name != null ? name : getString(R.string.no_disponible));
            // Asigna la descripción al TextView, o un mensaje si no hay descripción
            textViewDetailDescription.setText(description != null ? description : getString(R.string.no_disponible));
            // Asigna las habilidades al TextView, o un mensaje si no hay habilidades
            textViewDetailAbilities.setText(abilities != null ? abilities : getString(R.string.no_disponible));
        }
    }
}
