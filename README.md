# Codelab Pokedex
### Programación 3

Bienvenidos al codelab de Pokedex!

A continuación encontrarán un tutorial para repasar los conceptos de Layouts, Resources, Listas, RecyclerViews y nuevos Componentes en Android.

Nuestra meta será armar un Pokedex usando componentes Android.

![Resultado](pokedex.png?raw=true "Resultado")

Todos los recursos necesarios se encuentran en este mismo repositorio.

### Manos a la obra!

## 1. Clonar el repositorio

Clonar el repositorio:

```
git clone https://github.com/andres-vasquez/progra3-codelab-pokedex.git
```

Abrir el proyecto clonado en `Android Studio`

## 2. Revisar la estructura del proyecto

La estructura del proyecto es  Layout `activity_main.xml` vacío.

- MainActivity --> Menu principal
- PokemonDetailsActivity --> Activity con detalles del pokemón seleccionado
- PokemonListActivity --> Activity con la lista de pokemón (favoritos)
- PokemonRecyclerActivity --> Acitvity con la lista de pokemón (grid layout).

La carpeta de `res/drawables` contiene las imágenes (Pokemons y Componentes) que serán usadas en el codelab:

- ash_ketchum.png
- bulbasaur.png
- butterfree.png
- charmander.png
- ekans.png
- icon_hamburger.xml
- pidgey.png
- pikachu.png
- pokeball_background.png
- pokedex.png
- rattata.png
- round_box.xml
- sandshrew.png
- snorlax.png
- sqirtle.png
- venonat.png
- zubat.png

y también contiene los fondos que usaremos para algunos componentes.

El archivo `res/values/strings.xml` contiene todos los textos que necesitamos mostrar en las pantallas.
El archivo `res/values/colors.xml` contiene todos los colores (Hexadecimales) que necesitaremos.

## 3. Creemos nuestro primer menu deslizante (Navigation Drawer)
Para nuestro menú de itpo navigation drawer crearemos un dos nuevos layouts llamados: `drawer_layout` y `drawer_header_layout` se ubicarán en `res/layout/drawer_layout.xml` y `res/layout/drawer_header_layout.xml`

### drawer_header_layout.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorBackground"
    android:elevation="2dp"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="30dp">

    <ImageView
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:scaleType="centerCrop"
        android:src="@drawable/ash_ketchum" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:gravity="center"
        android:text="ASH KETCHUM"
        android:textColor="@color/colorBlack"
        android:textSize="18sp"
        android:textStyle="bold" />

</LinearLayout>
```

### drawer_layout.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <include layout="@layout/drawer_header_layout" />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/selectableItemBackground"
        android:text="@string/drawer_button_my_pokemons"
        android:onClick="goToMyPokemons"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/selectableItemBackground"
        android:text="@string/drawer_button_my_favorites"
        android:onClick="goToMyFavoritePokemons"/>

</LinearLayout>
```

La función `<include layout="my_layout"/>` nos permite insertar layouts dentro de un layout padre con el objetivo de ordenar el código y que se pueda utilizar layouts diferentes según su responsabilidad.

En este caso `res/layout/drawer_header_layout.xml` estaraá dentro de `res/layout/drawer_layout.xml` y tendrá la funcionalidad de mostrar info del usuario.

Para adicionar el menú a nuestra activity abrimos `activity_main.xml` y borramos el textView de la parte inferior (NavigationView) que tiene y lo reemplazamos con:

```
<include layout="@layout/drawer_layout"/>
```

### activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <!-- Drawer Layout encargado de manejar el Navigation Drawer-->
    <android.support.v4.widget.DrawerLayout
        android:id="@+id/navigationDrawer"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <!--Acepta sólo dos elementos hijos-->

        <!-- El layout principal (Pantalla principal) -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@color/colorPrimary"
                android:elevation="5dp"/>

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:scaleType="centerCrop"
                    android:src="@drawable/pokeball_background" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="vertical"
                    android:padding="50dp">

                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center"
                        android:background="@drawable/round_box"
                        android:gravity="center"
                        android:padding="20dp"
                        android:text="@string/main_activity_welcome_message"
                        android:textColor="@color/colorBlack"
                        android:textSize="40sp"
                        android:textStyle="bold" />

                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:layout_marginTop="25dp"
                        android:background="@drawable/round_box"
                        android:gravity="center"
                        android:padding="20dp"
                        android:text="@string/main_activity_instructions"
                        android:textColor="@color/colorBlack"
                        android:textSize="18sp" />
                </LinearLayout>
            </FrameLayout>

        </LinearLayout>

        <!-- Y como segundo elemento, acepta un Navigation View -->
        <!-- Este navigation view es el layout que se oculta -->
        <!-- Acepta los mismos atributos que un FrameLayout -->

        <android.support.design.widget.NavigationView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:fitsSystemWindows="true">

            <include
                layout="@layout/drawer_layout"/>

        </android.support.design.widget.NavigationView>

    </android.support.v4.widget.DrawerLayout>

</LinearLayout>
```

Por ultimo adicionamos la funcionalidad de los botones en `MainAcitity.class`
```
public void goToMyPokemons(View view) {
        Intent intent = new Intent(this, PokemonRecyclerActivity.class);
        startActivity(intent);
}

public void goToMyFavoritePokemons(View view) {
        Intent intent = new Intent(this, PokemonListActivity.class);
        startActivity(intent);
}
```
# Checkpoint 1: Ejecutar la app.
En este punto nuestra app nos mostrará el Menu desplegable o Navigation Drawer :-)


## 4. RecyclerView de pokemons
Utilizaremos un RecyclerView para mostrar la lista de pokemons.

### 4.1 RecyclerView viewHolder
Para comenzar creamos un package llamado `adapters` de tal menera que la ruta sea: `bo.upb.programacion3.codelabpokedex.adapters`

En el nuevo package crearemos una clase llamada: `PokemonViewHolder` que extienda a RecyclerView.ViewHolder en la cual declararemos los Views que llenarán nuestro adapter:

ImageView imageView --> Imagen del pokemon
TextView textViewName --> Nombre del pokemon. Ej. Pikachu
TextView textViewType --> Tipo del pokemon Ej. Eléctrico

Nuestra clase de ViewHolder quedará de la siguiente manera:

### PokemonViewHolder.class
```
public class PokemonViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textViewName;
    public TextView textViewType;

    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageViewPokemon);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.textViewType = itemView.findViewById(R.id.textViewType);
    }
}
```

El layout que llenará nuestro adapter tendrá el nombre: `pokemon_list_item.xml` en la cual se mostrarán los datos del pokemon mencionados en PokemonViewHolder.

### pokemon_list_item.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="15dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/round_box"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        android:padding="15dp">

        <ImageView
            android:id="@+id/imageViewPokemon"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerInside"
            tools:src="@drawable/bulbasaur" />

        <TextView
            android:id="@+id/textViewName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:textColor="@color/colorBlack"
            android:textSize="18sp"
            tools:text="Pokemon Name Example" />

        <TextView
            android:id="@+id/textViewType"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:textSize="17sp"
            tools:text="Pokemon Type Example" />
    </LinearLayout>
</FrameLayout>
```
Es importante revisar que el fondo redondeado es definido por: `@drawable/round_box`

### 4.2 RecyclerView adapter
Una vez definido el layout y el ViewHolder que se aplicará al RecyclerView revisamos por unos minutos la clase: `PokemonCallback` que se encuentra dentro de `callback':

### PokemonCallback.class
```
public interface PokemonCallback {
    void onPokemonClick(Pokemon pokemon);
}
```
Cada vez que el usuario haga click en un Item del RecyclerView se llamará el callback `onPokemonClick(Pokemon pokemon)` retornando el pokemon seleccionado.


Una vez declarada la función de click ya podemos declarar nuestro Adapter creando una clase llamada: `adapters/PokemonRecyclerViewAdapter.class`

### PokemonRecyclerViewAdapter.class
```
public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private LayoutInflater inflater;
    private PokemonCallback pokemonCallback;

    public PokemonRecyclerViewAdapter(Context context, List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = this.inflater.inflate(R.layout.pokemon_list_item, null);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder pokemonViewHolder, int position) {
        final Pokemon pokemon = this.pokemonList.get(position);
        pokemonViewHolder.imageView.setImageResource(pokemon.getImage());
        pokemonViewHolder.textViewName.setText(pokemon.getName());
        pokemonViewHolder.textViewType.setText(pokemon.getType());
        pokemonViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokemonCallback != null) {
                    pokemonCallback.onPokemonClick(pokemon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.pokemonList.size();
    }

    public void setPokemonCallback(PokemonCallback pokemonCallback) {
        this.pokemonCallback = pokemonCallback;
    }
}
```
Ya estamos listos para usar nuestro adapter en el Activity :-)

### 4.3 RecyclerView Activity
Abrimos nuestro layout y adicionamos dos compoenentes: toolbar y un RecyclerView.

### activity_pokemon_recycler.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:elevation="5dp"/>

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerViewMyPokemons"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </android.support.v7.widget.RecyclerView>
</LinearLayout>
```

Luego de eso abrimos nuestra Activity y le adicionamos lo siguiente:

### PokemonRecyclerActivity.class
```
public class PokemonRecyclerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler);
        initViews();
        initToolbar();

        List<Pokemon> pokemonList = PokemonUtils.getPokemons();
        PokemonRecyclerViewAdapter adapter = new PokemonRecyclerViewAdapter(this, pokemonList);
        adapter.setPokemonCallback(new PokemonCallback() {
            @Override
            public void onPokemonClick(Pokemon pokemon) {
                Intent intent = new Intent(PokemonRecyclerActivity.this, PokemonDetailsActivity.class);
                intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewMyPokemons);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_list_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
```
Es importante mencionar que la lista de pokemons es llenada en `PokemonUtils.getPokemons()`

Antes de continuar analizamos la siguiente porción de código:
```
adapter.setPokemonCallback(new PokemonCallback() {
    @Override
    public void onPokemonClick(Pokemon pokemon) {
        Intent intent = new Intent(PokemonRecyclerActivity.this, PokemonDetailsActivity.class);
        intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
        startActivity(intent);
    }
});
```
Lo que estamos haciendo en este punto es obtener el Pokemon mediante el click de interface y lo enviaremos mediante Intent a `PokemonDetailsActivity.class` para esto utilizaremos la librería `GSON` para serializar el objeto a String y enviarlo usando la clave: `Constants.POKEMON_SELECTED`


# Checkpoint 2: Ejecutar la app.
En este punto nuestra app nos mostrará el RecyclerView con los Pokemons!!! (Fuck yeah)




## 5. ListView de pokemons
Utilizaremos un ListView para mostrar la lista de pokemons (favoritos).

### 5.1 ViewHolder y Adapter
Utilizaremos un layout muy similar al utilizado en el RecyclerView en este caso la disposición de los elementos será horizontal. Para esto crearemos el siguiente layout:
### pokemon_list_item_horizontal.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorWhite"
    android:padding="15dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal"
        android:orientation="horizontal"
        android:padding="15dp">

        <ImageView
            android:id="@+id/imageViewPokemon"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:scaleType="centerInside"
            tools:src="@drawable/bulbasaur" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:orientation="vertical">

            <TextView
                android:id="@+id/textViewName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:textColor="@color/colorBlack"
                android:textSize="20sp"
                tools:text="Pokemon Name Example" />

            <TextView
                android:id="@+id/textViewType"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:textSize="17sp"
                tools:text="Pokemon Type Example" />
        </LinearLayout>
    </LinearLayout>
</FrameLayout>
```


En el caso de la lista podemos declarar el ViewHolder y el adapter en la misma clase para esto creamos la clase: `PokemonListViewAdapter` dentro de `adapters`.

### PokemonListViewAdapter.class
```
public class PokemonListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonListViewAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }


    @Override
    public int getCount() {
        return this.pokemonList.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return this.pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.pokemonList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.pokemon_list_item_horizontal, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewPokemon);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            viewHolder.textViewType = vista.findViewById(R.id.textViewType);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Pokemon pokemon = this.pokemonList.get(position);
        viewHolder.imageView.setImageResource(pokemon.getImage());
        viewHolder.textViewName.setText(pokemon.getName());
        viewHolder.textViewType.setText(pokemon.getType());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}
```

### 5.2 ListView Activity
Modificaremos el layout donde mostraremos la lista de pokemons:
### activity_pokemon_list.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:elevation="5dp"/>

    <ListView
        android:id="@+id/listViewMyPokemons"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </ListView>
</LinearLayout>
```

Modificamos el activty donde alojamos la lista.
### PokemonListActivity.class
```
public class PokemonListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        initViews();
        initToolbar();

        final List<Pokemon> pokemonList = PokemonUtils.getPokemons();
        PokemonListViewAdapter adapter = new PokemonListViewAdapter(this, pokemonList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon pokemon = pokemonList.get(position);
                Intent intent = new Intent(PokemonListActivity.this, PokemonDetailsActivity.class);
                intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        listview = findViewById(R.id.listViewMyPokemons);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.pokemon_favorites_activity_title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
```

Antes de continuar analizamos la siguiente porción de código:
```
Pokemon pokemon = pokemonList.get(position);
Intent intent = new Intent(PokemonListActivity.this, PokemonDetailsActivity.class);
intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
startActivity(intent);
```
Lo que estamos haciendo en este punto es obtener el Pokemon según su posición y lo enviaremos mediante Intent a `PokemonDetailsActivity.class` para esto utilizaremos la librería `GSON` para serializar el objeto a String y enviarlo usando la clave: `Constants.POKEMON_SELECTED`

# Checkpoint 3: Ejecutar la app.
En este punto nuestra app nos mostrará el ListView con los Pokemons!!! (yujuuu)

## 6. Pokemon Details
Para terminar con el CodeLab llenaremos el Activity: `PokemonDetailsActivity` con los datos del pokemon seleccionado:

### PokemonDetailsActivity.class
```
public class PokemonDetailsActivity extends AppCompatActivity {

    private ImageView pokemonImage;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typeTextView;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        initViews();

        Pokemon pokemon = this.gson.fromJson(getIntent().getStringExtra(Constants.POKEMON_SELECTED), Pokemon.class);

        fillPokemonData(pokemon);
    }

    // Esto ya saben!
    private void initViews() {
        this.pokemonImage = findViewById(R.id.pokemonImage);
        this.nameTextView = findViewById(R.id.nameTextView);
        this.idTextView = findViewById(R.id.idTextView);
        this.typeTextView = findViewById(R.id.typeTextView);
    }

    private void fillPokemonData(Pokemon pokemon) {
        this.pokemonImage.setImageResource(pokemon.getImage());
        this.nameTextView.setText(pokemon.getName());
        this.idTextView.setText(String.valueOf(pokemon.getId()));
        this.typeTextView.setText(pokemon.getType());
    }
}
```

# Checkpoint 4: Ejecutar la app.
En este punto nuestra app nos mostrará el acitivity de Details una vez que seleccionemos un Item desde el RecyclerView o el ListView correspondiente.
Es importante mencionar que el activity mostrará una orientacion horizontal obligando al usuario a que incline su teléfono debido a que en AndroidManifest se declara la orientación especiífica:

```
<activity
  android:name=".PokemonDetailsActivity"
  android:screenOrientation="landscape" />
```

## Consideraciones
Recuerda que:
- Los elementos de lista requieren de `Adapters`
- Serializar: Convertir un objeto o array en String.
- Deserializar: Convertir un String a un objeto o Array.
- Para usar una librería como Gson debes abrir app/build.gradle y adicionar una dependencia:
```
dependencies {
...
   implementation 'com.google.code.gson:gson:2.8.5'
}
```

## Saludos
Esperamos que hayan disfrutado el Codelab B-)
- Adrián  Rodriguez
- Andrés Vasquez

