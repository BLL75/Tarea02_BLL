package luquelafuente.bernardo.tarea02_bll;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad que muestra la pantalla de carga (splash screen) al inicio de la aplicación.
 * Después de un tiempo determinado, redirige automáticamente a la MainActivity.
 */
public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000; // Duración del splash en milisegundos (3 segundos)

    /**
     * Método llamado al crear la actividad.
     * Se encarga de inicializar la vista y configurar el temporizador para la transición.
     * @param savedInstanceState Un objeto Bundle que contiene el estado previamente guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("SplashActivity", "Antes de la intención");

        new Handler().postDelayed(() -> {
            Log.d("SplashActivity", "Después de la intención");
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cierra la SplashActivity para que no se pueda volver a ella
        }, SPLASH_DELAY);
    }
}
