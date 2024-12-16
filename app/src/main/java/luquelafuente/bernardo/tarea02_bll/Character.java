package luquelafuente.bernardo.tarea02_bll;

/**
 * Clase que representa un personaje del juego.
 *
 * Contiene atributos relacionados con el personaje, como nombre, descripción,
 * ID de la imagen y habilidades especiales.
 * Esta clase es utilizada como modelo de datos para mostrar información en la aplicación.
 */
public class Character {

    private String name;        // Nombre del personaje
    private String description; // Descripción del personaje
    private int idImage;        // ID del recurso de la imagen del personaje
    private String abilities;   // Habilidades del personaje

    /**
     * Constructor que inicializa un personaje con sus datos básicos.
     *
     * @param name        Nombre del personaje.
     * @param description Breve descripción del personaje.
     * @param abilities   Habilidades especiales del personaje.
     * @param idImage     ID del recurso de la imagen asociada al personaje.
     */
    public Character(String name, String description, String abilities, int idImage){
        this.name = name;
        this.description = description;
        this.idImage = idImage;
        this.abilities = abilities;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del personaje.
     *
     * @return La descripción del personaje.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene el ID del recurso de la imagen asociada al personaje.
     *
     * @return El ID del recurso de la imagen.
     */
    public int getIdImage() {
        return idImage;
    }

    /**
     * Obtiene las habilidades especiales del personaje.
     *
     * @return Las habilidades del personaje.
     */
    public String getAbilities() {
        return abilities;
    }
}
