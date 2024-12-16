package luquelafuente.bernardo.tarea02_bll;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad principal que muestra una lista de personajes en un RecyclerView.
 * <p>
 * Al seleccionar un personaje, se abre una nueva actividad mostrando detalles
 * del personaje seleccionado.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;  // Lista de personajes
    private CharacterAdapter adapter;   // Adaptador del RecyclerView
    private List<Character> characterList;  // Lista de personajes cargados
    private Toolbar toolbar;  // Barra de herramientas principal

    /**
     * Método llamado al crear la actividad principal.
     * <p>
     * Configura la vista, inicializa la lista de personajes y muestra
     * el RecyclerView con su adaptador.
     *
     * @param savedInstanceState Estado guardado de la actividad anterior.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Vista configurada correctamente.");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        characterList = new ArrayList<>();
        loadCharacters();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CharacterAdapter(characterList, this::goToDetailActivity);
        recyclerView.setAdapter(adapter);

        Snackbar.make(recyclerView, getString(R.string.welcome_message), Snackbar.LENGTH_LONG).show();
    }

    /**
     * Carga una lista de personajes con sus datos.
     * <p>
     * Los datos se obtienen de los recursos definidos en strings.xml.
     */
    private void loadCharacters() {
        characterList.add(new Character(
                getString(R.string.mario_name),
                getString(R.string.mario_description),
                getString(R.string.mario_abilities),
                R.drawable.mario
        ));
        characterList.add(new Character(
                getString(R.string.luigi_name),
                getString(R.string.luigi_description),
                getString(R.string.luigi_abilities),
                R.drawable.luigi
        ));
        characterList.add(new Character(
                getString(R.string.peach_name),
                getString(R.string.peach_description),
                getString(R.string.peach_abilities),
                R.drawable.peach
        ));
        characterList.add(new Character(
                getString(R.string.toad_name),
                getString(R.string.toad_description),
                getString(R.string.toad_abilities),
                R.drawable.toad
        ));
    }

    /**
     * Navega a la actividad de detalles con los datos del personaje seleccionado.
     *
     * @param character El personaje seleccionado.
     */
    private void goToDetailActivity(Character character) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("image", character.getIdImage());
        intent.putExtra("name", character.getName());
        intent.putExtra("description", character.getDescription());
        intent.putExtra("abilities", character.getAbilities());
        startActivity(intent);
        Toast.makeText(this, getString(R.string.toast_character_selected, character.getName()), Toast.LENGTH_SHORT).show();
    }

    /**
     * Crea el menú principal en la barra de herramientas.
     *
     * @param menu Menú principal a inflar.
     * @return true si se muestra correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Maneja la selección de ítems del menú.
     *
     * @param item El ítem seleccionado.
     * @return true si se maneja correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_menu) {
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un cuadro de diálogo "Acerca de..." con información de la aplicación.
     */
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.about_title))
                .setMessage(getString(R.string.about_message))
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}
