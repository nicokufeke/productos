package cl.eme.productos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*

Alcance del Proyecto (Actualmente la empresa cuenta con un servicio Rest Mock. Esta contiene dos endpoint:)

1. [ ] El primero entrega un listado de productos con descripción, precio e imagen
2. [ ] El otro endpoint entrega los detalles de un producto particular por ID.
Considerando que para esta primera versión se busca tener una gran cobertura de dispositivos manteniendo los costos de mantención bajos, la API mínima es 23 y el target 30.
La idea es mostrar en un RecyclerView desde la persistencia local el listado inicial. Al hacer clic sobre un elemento, mostrar un detalle de ese elemento.
Lo que se espera que haga la aplicación es que cualquier usuario que la instale sin necesidad de autenticarse, pueda ver una lista de los productos y, ver los detalles del que seleccione y enviar un correo al área de ventas con información predefinida.
3. [ ] La primera pantalla es una lista de productos
4. [ ] La segunda pantalla muestra la información en detalle de un producto
5. [ ] La segunda pantalla tiene un botón que al presionarlo envía el correo descrito

Código, arquitectura y dependencias

1 [ ] Versionamiento con Git. El código debe quedar en g  ithub.com  u otra plataforma de desarrollo cooperativo.
2.[ ] Seguir los fundamentos de escritura de código (indentación, reutilización, sin código comentado)
3.[ ] Seguir las convenciones de nombres.
4.[ ] La arquitectura tiene que ser MVVM - LiveData - ROOM
5.[ ] Los request HTTP tienen que ser realizados utilizando Retrofit.
6.[ ] Utilice Kotlin coroutines para manejar el trabajo en segundo plano.
7.[ ] Utilice las bibliotecas que estime necesario para hacer testing.
8.[ ] Al menos 1 test unitarios.
9.[ ] Al menos 1 test instrumental (con el emulador).

Diseño

0. [ ] Use la siguiente paleta para los colores de la aplicación:
1. [ ] Aunque los tamaños pueden variar, la diagramación de los layouts se debe mantener, esto incluye las filas de la lista y la segunda pantalla.
2. [ ] La primera pantalla es un fragmento que contiene la lista de productos. No existe una pantalla preliminar, debe privilegiar mostrar el título del producto y su valor y la foto.
3. [ ] La segunda pantalla es una “scrolling activity” y 2 fragmentos, uno para la cabecera colapsable y otro para el cuerpo. (Este diseño puede cambiar, la idea es mostrar el detalle del producto de forma llamativa).
4. [ ] Todos los textos que no sean obtenidos a partir de la API REST deben ser traducibles.

Endpoints

1. [ ] Ambos endpoints se deben acceder a través del verbo de request HTTP GET. El primer endpoint es para obtener una lista de los productos
https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/products/
2. [ ] El segundo endpoint corresponde al detalle y se accede indicando el ID específico.
https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/details/1

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}