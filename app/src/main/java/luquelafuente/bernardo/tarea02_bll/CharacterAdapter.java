package luquelafuente.bernardo.tarea02_bll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adaptador para gestionar y mostrar una lista de personajes en un RecyclerView.
 *
 * Este adaptador se encarga de enlazar la lista de objetos {@link Character}
 * con las vistas del RecyclerView, permitiendo mostrar cada personaje en una tarjeta.
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private final List<Character> characterList; // Lista de personajes
    private final OnCharacterClickListener listener; // Listener para manejar clics

    /**
     * Constructor que inicializa el adaptador con una lista de personajes y un listener.
     *
     * @param characterList Lista de personajes que se mostrarán.
     * @param listener      Listener para manejar los clics en los personajes.
     */
    public CharacterAdapter(List<Character> characterList, OnCharacterClickListener listener) {
        this.characterList = characterList;
        this.listener = listener;
    }

    /**
     * Clase interna ViewHolder que contiene las vistas de cada tarjeta.
     *
     * Esta clase se encarga de mantener referencias a las vistas de cada elemento
     * de la lista (la imagen y el nombre del personaje), lo que mejora la eficiencia
     * del RecyclerView.
     */
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;   // Imagen del personaje
        TextView textViewName; // Nombre del personaje

        /**
         * Constructor que enlaza las vistas de la tarjeta con sus IDs en el diseño XML.
         *
         * @param itemView Vista inflada de la tarjeta.
         */
        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView); // Asocia el ImageView
            textViewName = itemView.findViewById(R.id.textViewName); // Asocia el TextView
        }
    }

    /**
     * Crea un nuevo ViewHolder para cada elemento del RecyclerView.
     *
     * @param parent   El ViewGroup padre.
     * @param viewType El tipo de vista.
     * @return Un nuevo CharacterViewHolder.
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño de cada tarjeta desde character_item.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(view);
    }

    /**
     * Asocia los datos del personaje con las vistas del ViewHolder.
     *
     * @param holder   El ViewHolder actual.
     * @param position La posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);

        // Configura las vistas con los datos del personaje
        holder.imageView.setImageResource(character.getIdImage());
        holder.textViewName.setText(character.getName());

        // Agrega el evento de clic en la tarjeta
        holder.itemView.setOnClickListener(v -> listener.onCharacterClick(character));
    }

    /**
     * Obtiene la cantidad de elementos en la lista de personajes.
     *
     * @return El tamaño de la lista.
     */
    @Override
    public int getItemCount() {
        return characterList.size();
    }

    /**
     * Interfaz para manejar clics en personajes.
     *
     * Esta interfaz define el método que se debe implementar en la actividad
     * o fragmento que use este adaptador, para que esta pueda recibir notificaciones
     * cuando el usuario hace clic en un personaje.
     */
    public interface OnCharacterClickListener {
        /**
         * Método que se llama cuando se hace clic en un personaje.
         *
         * @param character El objeto Character que se ha clickado.
         */
        void onCharacterClick(Character character);
    }
}