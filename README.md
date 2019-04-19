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

- MainActivity
- PokemonDetailsActivity
- PokemonListActivity
- PokemonRecyclerActivity

La carpeta de `res/drawables` contiene las imágenes (Pokemones y Componentes) que serán usadas en el codelab:

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









## 3. Agregar logo de la empresa

Agregaremos el logo de la empresa `hippo.png` a nuestro layout.
Como nuestro elemento de Layout principal es FrameLayout, lo cambiaremos por un RelativeLayout para organizar los elementos de la pantalla.
A este elemento le ponemos el gradiente azul como fondo:

`activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/gradient">
</RelativeLayout>
```

Agragamos el logo con un `ImageView` dentro de nuestro relative layout. La posición de este es centrada horizontalmente y top:
```xml
<RelativeLayout ...>
    <ImageView
        android:id="@+id/hippo"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp"
        android:src="@drawable/hippo" />
</RelativeLayout>
```

## 4. Agregamos los layouts para la entrada de texto del usuario/password

Como estos layouts tienen un fondo semitransparente, usaremos el drawable `button_background.xml`.
Como verás, los drawables no solo pueden ser imágenes en formatos .png o .jpg, sino también formas personalizadas creadas en XML.

Agregaremos el siguiente XML del LinearLayout debajo de nuestro ImageView del hipopótamo:
```xml
<RelativeLayout ...>
    <ImageView ../>
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/hippo"
        android:orientation="vertical"
        android:padding="20dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:background="@drawable/inputs_background"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="10dp"
                android:layout_marginTop="10dp"
                android:text="@string/title_username"
                android:textColor="@color/colorAccent"
                android:textSize="18sp" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="10dp"
                android:layout_marginEnd="10dp"
                android:imeOptions="actionNext"
                android:inputType="text"
                android:maxLines="1"
                android:textColor="@color/white"
                android:textSize="18sp" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:background="@drawable/inputs_background"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="10dp"
                android:layout_marginTop="10dp"
                android:text="@string/title_password"
                android:textColor="@color/colorAccent"
                android:textSize="18sp" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="10dp"
                android:layout_marginEnd="10dp"
                android:imeOptions="actionGo"
                android:inputType="textPassword"
                android:maxLines="1"
                android:textColor="@color/white"
                android:textSize="18sp" />
        </LinearLayout>
    </LinearLayout>
</RelativeLayout>
```

Este Linear layout contiene los elementos de los inputs de texto:

![Inputs](inputs.png?raw=true "Inputs")

Debido a que el fondo debe incluir al TextView de título y al EditText, puedes observar que este se aplica directamente al Linear Layout que los agrupa:

```xml
    android:background="@drawable/inputs_background"
```

También observarás que algunas de las propiedades del EditText son usadas:

```
    android:imeOptions="actionNext"     ->  Agrega un botón "NEXT" en el teclado de android (redirige al siguiente EditText)
    android:imeOptions="actionDone"     ->  Agrega un botón "DONE" en el teclado de android (oculta el teclado)
    android:inputType="text"            ->  Indica que el tipo de texto a ingresar es un texto normal
    android:inputType="textPassword"    ->  Indica que el tipo de texto a ingresar es un password y debe ocultarse
    android:maxLines="1"                ->  Indica la cantidad máxima de lineas que permitirá la entrada de texto
    android:textColor="@color/white"    ->  Cambia el color del texto
    android:textSize="18sp"             ->  Cambia el tamaño del texto
```

## 5. Agregamos el checkbox "Remember Me" y link "Forgot Password"

Dentro de este mismo LinearLayout (con id = `@+id/linearLayoutElements`) agregaremos mas elementos al final:

```xml
<RelativeLayout ...>
    ...
    <LinearLayout ...>
    ...
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp">

            <CheckBox
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:buttonTint="@color/white"
                android:imeOptions="actionNone"
                android:text="@string/remember_me"
                android:textColor="@color/white" />

            <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:gravity="end"
                android:text="@string/forgot_password"
                android:textColor="@color/white" />
        </LinearLayout>
        
    </LinearLayout>
</RelativeLayout>
```

Estos dos elementos se encuentran de manera horizontal, por lo cual los ingresamos con un LinearLayout con esta misma orientación.
Como ambos elementos ocupan el mismo espacio en la pantalla (50%, 50%), usaremos el atributo del peso para definir su ancho.

Como notarás, el ancho ahora puede ser `0dp` debido a que ahora el que se encarga de calcular este es el peso `layout_weight`.

Un atributo interesante en este momento es el `Tint`, el cual "tiñe" al widget de el color que nosotros queramos, en este caso, blanco.

El texto Forgot Password, en este caso, debe estar subrayado. Para lograr esto, en nuestro archivo `strings.xml`, el recurso que hace referencia al texto de Forgot Password, tiene un elemento extra, que es `<u> ... </u>`. Este indica que cualquier texto que esté dentro se marcará como subrayado.

Prueba lo que ocurre cuando usas `<b> ... </b>` o  `<i> ... </i>`

## 6. Agregamos botones

Ahora agregaremos nuestros botones a este mismo LinearLayout.

Como la orientación es vertical, agregaremos primeramente un botón para `Sign In`.
Luego agregaremos el siguiente grupo de botones que se encuentran ordenados de manera horizontal, ocupando el 50% del espacio cada uno, con una imagen a la derecha. Esto lo logramos simplemente con un LinearLayout horizontal, e indicando el peso de cada botón a 1 para que ocupen el ancho en espacios iguales.
El fondo de los botones tiene un borde blanco, mismo que podemos verlo en el drawable `button_background.xml`.

Para agregar una imagen a cada botón, el elemento Button tiene un atributo que nos permite hacer eso, este es:
```
    android:drawableEnd="@drawable/facebook_logo"
```

```xml
<RelativeLayout ...>
    ...
    <LinearLayout ...>
    ...
        <Button
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:layout_marginTop="20dp"
            android:layout_marginBottom="10dp"
            android:background="@drawable/button_background"
            android:text="@string/button_sign_in"
            android:textColor="@color/white" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:layout_width="0dp"
                android:layout_height="40dp"
                android:layout_marginEnd="5dp"
                android:layout_marginBottom="20dp"
                android:layout_weight="1"
                android:background="@drawable/button_background"
                android:drawableEnd="@drawable/facebook_logo"
                android:paddingEnd="13dp"
                android:text="@string/button_sign_in_with"
                android:textColor="@color/white" />

            <Button
                android:layout_width="0dp"
                android:layout_height="40dp"
                android:layout_marginStart="5dp"
                android:layout_marginBottom="20dp"
                android:layout_weight="1"
                android:background="@drawable/button_background"
                android:drawableEnd="@drawable/google_logo"
                android:paddingEnd="13dp"
                android:text="@string/button_sign_in_with"
                android:textColor="@color/white" />
        </LinearLayout>

    </LinearLayout>
</Relative>
```

## 7. Agregamos el botón de registro

Como último paso agregaremos el botón de `Sign Up` que se encuentra en la parte inferior. Para lograr esto, posicionaremos nuestro botón dentro del RelativeLayout principal, y lo agregaremos al final de este:

```xml
<RelativeLayout ...>
    ...
    <LinearLayout ...>
    ...
    </LinearLayout>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_margin="20dp"
        android:background="?attr/selectableItemBackground"
        android:text="@string/button_sign_up"
        android:textColor="@color/white" />

</RelativeLayout>
```

Este botón siempre se quedará colado a la parte inferior de la pantalla debido a la pripiedad `layout_alignParentBottom=true`. En este caso, el background de este elemento es un atributo por defecto de Android, el cual nos da un fondo transparente, pero con un efecto circular al tocarlo.

## Consideraciones

Recuerda que:
- Todos los textos de la pantalla se referencian directamente con los identificadores que se encuentran en el archivo `strings.xml`
- Todos los colores de los elementos de la pantalla se referencian del archivo `colors.xml`
- Podemos crear formas personalizadas en nuestra carpeta Drawables. Estos se adaptan a cualquier tamaño de los elementos
- Revisa y prueba la app en la sección 4 para entender mejor los atributos personalizados de los EditText
- Puedes hacer mas pruebas, cambiar a tu gusto o agregar nuevos elementos a estas pantallas
- Si tienes dudas, puedes revisar el branch **codigo_completo** (No olvides hacer commit de tus cambios antes de cambiar de branch!)