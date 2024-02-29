package com.example.proyectococktail.Cocktails.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectococktail.Cocktails.Domain.AlcoholicsCocktail
import com.example.proyectococktail.Cocktails.Domain.CocktailGlass
import com.example.proyectococktail.Cocktails.Domain.GlassCham
import com.example.proyectococktail.Cocktails.Domain.NameUseCase
import com.example.proyectococktail.Cocktails.Domain.NoAlcoholics
import com.example.proyectococktail.Cocktails.Domain.Ordinary
import com.example.proyectococktail.Cocktails.Domain.RandomCocktail
import com.example.proyectococktail.Cocktails.Model.Response.User
import com.example.proyectococktail.Cocktails.ui.State.CocktailUserState
import com.example.proyectococktail.Cocktails.ui.State.drinkState
import com.example.proyectococktail.basilkeyoutline.BasilKeyOutline
import com.example.proyectococktail.eiuser.EiUser
import com.example.proyectococktail.fluentemojihighcontrastenvelope.FluentEmojiHighContrastEnvelope
import com.example.proyectococktail.home.jollyLodger
import com.example.proyectococktail.keygreen.KeyGreen
import com.example.proyectococktail.sobregreen.SobreGreen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


/**
 * ViewModel responsable de la lógica de la aplicación.
 *
 * @property auth Instancia de FirebaseAuth utilizada para las operaciones de autenticación.
 * @property email Email del usuario, utilizado para el inicio de sesión y registro.
 * @property password Contraseña del usuario, utilizada para el inicio de sesión y registro.
 * @property userName Nombre de usuario, utilizado solo en el proceso de registro.
 * @property fierestore Instancia de FirebaseFirestore utilizada para el servico de la base de datos.
 * @property _ingredient String de ingredientes para mostrar en las filas.
 * @property _ingredient2 String de ingredientes para mostrar en las cards.
 * @property PantallasI Int que indica que id tiene la pantalla de inicio a eligir.
 * @property _show Boolean para mostrar la fila marcada.
 * @property number Indica el id del texto de cabecera.
 * @property listaIngredientes Contiene la lista de ingredientes del objeto marcado listo para almacenar.
 * @property cocktailName Nombre del cocktail.
 * @property cocktail Nombre del cocktail proveniente de la API.
 * @property alcohol Indica si contiene alcohol o no.
 * @property drink Contiene el cocktail del usuario.
 * @property showAlert Boolean que permite ver la fila marcada.
 * @property _selectedRowId Contiene el id de la fila para poder cambiar de color.
 */
@HiltViewModel
class Viewmodel @Inject constructor(private val nameUseCase: NameUseCase, private val randomCocktail: RandomCocktail, private val alcoholicsCocktail: AlcoholicsCocktail,
    private val noAlcoholics: NoAlcoholics, private val ordinary: Ordinary, private val glassChamp: GlassCham, private val cocktailGlass: CocktailGlass): ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore: FirebaseFirestore = Firebase.firestore

    private val _listCocktail = MutableStateFlow<List<drinkState>>(emptyList())
    val listCocktail: StateFlow<List<drinkState>> = _listCocktail.asStateFlow()

    private val _cocktailData = MutableStateFlow<List<CocktailUserState>>(emptyList())
    val cocktailData: StateFlow<List<CocktailUserState>> = _cocktailData

    var _ingredient by mutableStateOf("")
        private set

    var _ingredient2 by mutableStateOf("")
        private set

    var pantallasI by mutableStateOf(0)
        private set



    private val _show = mutableStateOf<Boolean>(false)
    val show: MutableState<Boolean> = _show

    var email by mutableStateOf("")
        private set

    var number by mutableStateOf(0)
        private set

    var password by mutableStateOf("")
        private set

    var userName by mutableStateOf("")
        private set

    private var listaIngredientes by mutableStateOf<MutableList<String>>(mutableListOf())
        private set

    var cocktailName by mutableStateOf("")
        private set

    var cocktail by mutableStateOf("")
        private set

    var alcohol by mutableStateOf("")
        private set
    var drink by mutableStateOf(CocktailUserState())
        private set

    var showAlert by mutableStateOf(false)
        private set



    var _selectedRowId by mutableStateOf<String?>(null)
        private set

    /**
     * Obtiene la información de la api.
     */

    fun getName(name: String){
        viewModelScope.launch {
            _listCocktail.value = nameUseCase(name).drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */

    fun getRandom(){
        viewModelScope.launch {
            _listCocktail.value = randomCocktail().drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */
    fun vCocktailAlcoholic(){
        viewModelScope.launch {
            _listCocktail.value = alcoholicsCocktail().drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */
    fun getNoAlcoholic(){
        viewModelScope.launch {
            _listCocktail.value = noAlcoholics().drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */

    fun getOrdinary(){
        viewModelScope.launch {
            _listCocktail.value = ordinary().drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */
    fun getGlassChamp(){
        viewModelScope.launch {
            _listCocktail.value = glassChamp().drinks?: mutableListOf()
        }
    }

    /**
     * Obtiene la información de la api.
     */
    fun getCocktailGlass(){
        viewModelScope.launch {
            _listCocktail.value = cocktailGlass().drinks?: mutableListOf()
        }
    }

    /**
     * Devuelve los ingredientes de la lista de cockteles del usuario.
     * @param ingredientes ingredientes de lo que consta la lista.
     */
    fun IngredientsUser(ingredientes: CocktailUserState): String{
        _ingredient = ""
        for(ingrediente in ingredientes.strList){
            if(ingrediente.equals("vacio")) break else _ingredient += "$ingrediente "
        }
        return _ingredient
    }

    /**
     * Devuelve los ingredientes de la lista de cockteles del usuario para mostrarlos en la card.
     * @param ingredientes ingredientes de lo que consta la lista.
     */
    fun IngredientsUserCard(ingredientes: CocktailUserState): String{
        _ingredient2 = ""
        for(ingrediente in ingredientes.strList){
            if(ingrediente.equals("vacio")) break else _ingredient2 += "$ingrediente "
        }
        return _ingredient2
    }


    /**
     * Devuelve los ingredientes de la lista de cockteles.
     * @param ingredientes ingredientes de lo que consta la lista.
     */
    
    fun Ingredients(ingredientes: drinkState): String{
        _ingredient = ""
        val lista = mutableListOf<String>(ingredientes.strIngredient1?: "vacio", ingredientes.strIngredient2?: "vacio", ingredientes.strIngredient3?: "vacio", ingredientes.strIngredient4?: "vacio",
            ingredientes.strIngredient5?: "vacio", ingredientes.strIngredient6?: "vacio", ingredientes.strIngredient7?: "vacio", ingredientes.strIngredient8?: "vacio",
            ingredientes.strIngredient9?: "vacio", ingredientes.strIngredient10?: "vacio", ingredientes.strIngredient11?: "vacio", ingredientes.strIngredient12?: "vacio",
            ingredientes.strIngredient3?: "vacio", ingredientes.strIngredient14?: "vacio", ingredientes.strIngredient15?: "vacio")
        for(ingrediente in lista){
            if(ingrediente.equals("vacio")) break else _ingredient += "$ingrediente "
        }
        return _ingredient
    }


    /**
     * Devuelve los ingredientes de la lista de cockteles para mostrarlos en la card.
     * @param ingredientes ingredientes de lo que consta la lista.
     */

    fun IngredientsCard(ingredientes: drinkState): String{
        _ingredient2 = ""
        val lista = mutableListOf<String>(ingredientes.strIngredient1?: "vacio", ingredientes.strIngredient2?: "vacio", ingredientes.strIngredient3?: "vacio", ingredientes.strIngredient4?: "vacio",
            ingredientes.strIngredient5?: "vacio", ingredientes.strIngredient6?: "vacio", ingredientes.strIngredient7?: "vacio", ingredientes.strIngredient8?: "vacio",
            ingredientes.strIngredient9?: "vacio", ingredientes.strIngredient10?: "vacio", ingredientes.strIngredient11?: "vacio", ingredientes.strIngredient12?: "vacio",
            ingredientes.strIngredient3?: "vacio", ingredientes.strIngredient14?: "vacio", ingredientes.strIngredient15?: "vacio")
        for(ingrediente in lista){
            if(ingrediente.equals("vacio")) break else _ingredient2 += "$ingrediente "
        }
        return _ingredient2
    }


    /**
     * Si la fila es par aparece de distinto color para marcar la selección.
     * @param index Recibe el indice para realizar el cálculo.
     */

    fun calculateBackgroundColor(index: Int): Color {
        return if (index % 2 == 0) Color(0xFFF9EBE0) else Color.White
    }


    /**
     * Permite almacenar los datos del cocktail marcado por si se quiere almacenar en la base de datos y para mostrarlo en la card.
     */
    fun SaveCocktail(idDrink: String,
                     strDrink: String,
                     strAlcoholic: String,
                     strInstructions: String,
                     strDrinkThumb: String,
                     strList: MutableList<String>){
        listaIngredientes = mutableListOf()
        val email = auth.currentUser?.email
        for(ingrediente in strList){
            if(ingrediente.equals("vacio")) continue else listaIngredientes.add(ingrediente)
        }
        drink = CocktailUserState(email.toString(), idDrink, strDrink, strAlcoholic, strInstructions, strDrinkThumb, listaIngredientes)
    }

    fun mostrar(){
        showAlert = !showAlert
    }


    /**
     * Función encargada de realizar el log in y autentificar el usuario.
     */
    fun login(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onSuccess()
                        } else {
                            Log.d("ERROR EN FIREBASE","Usuario y/o contrasena incorrectos")
                            showAlert = true
                        }
                    }
            } catch (e: Exception){
                Log.d("ERROR EN JETPACK", "ERROR: ${e.localizedMessage}")
            }
        }
    }


    /**
     * Función encargada de guardar en la base de datos el usuario.
     * @param username nombre de usuario.
     */
    private fun saveUser(username: String){
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            val user = User(
                id = id.toString(),
                email = email.toString(),
                name = username
            )
            // DCS - Añade el usuario a la colección "Users" en la base de datos Firestore
            firestore.collection("Users")
                .add(user)
                .addOnSuccessListener { Log.d("GUARDAR OK", "Se guardó el usuario correctamente en Firestore") }
                .addOnFailureListener { Log.d("ERROR AL GUARDAR", "ERROR al guardar en Firestore") }
        }
    }


    /**
     * Función encargada de crear un usuario nuevo.
     * @param onSucces función lambda que nos dirige a la pantalla de home de la aplicación.
     */
    fun createUser(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            saveUser(userName)
                            onSuccess()
                        } else {
                            Log.d("ERROR EN FIREBASE","Error al crear usuario")
                            showAlert = true
                        }
                    }
            } catch (e: Exception){
                Log.d("ERROR CREAR USUARIO", "ERROR: ${e.localizedMessage}")
            }
        }
    }


    /**
     * Función que guarda un nuevo cocktail
     * @param onSuccess función lambda que cuando ejecuta manda un mesaje informativo y nos vuelve a la página anterior.
     */
    fun saveNewCocktail(onSuccess: () -> Unit) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newCocktail = drink

                // Verificar si el cocktail ya existe en la base de datos
                firestore.collection("Cocktails")
                    .whereEqualTo("IdDrink", newCocktail.idDrink)
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        if (querySnapshot.isEmpty) {
                            // No existe ningún cocktail con el mismo IdDrink, entonces lo guardamos
                            firestore.collection("Cocktails")
                                .add(newCocktail)
                                .addOnSuccessListener {
                                    onSuccess()
                                    Log.d("GUARDAR OK", "Se guardó el cocktail correctamente en Firestore")
                                }
                                .addOnFailureListener {
                                    Log.d("ERROR AL GUARDAR", "ERROR al guardar en Firestore")
                                }
                        } else {
                            // Ya existe un cocktail con el mismo IdDrink, no hacemos nada
                            Log.d("COCKTAIL REPETIDO", "El cocktail ya existe en Firestore")
                        }
                    }
                    .addOnFailureListener {
                        Log.d("ERROR AL VERIFICAR", "Error al verificar si el cocktail existe en Firestore")
                    }
            } catch (e: Exception) {
                Log.d("ERROR GUARDAR COCKTAIL", "Error al guardar ${e.localizedMessage}")
            }
        }
    }

    /**
     * Busca un cocktail de la base de datos para mostrarlo
     */
    fun fetchCoctail() {
        val email = auth.currentUser?.email
        firestore.collection("Cocktails")
            .whereEqualTo("emailUser", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val documents = mutableListOf<CocktailUserState>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        val myDocument = document.toObject(CocktailUserState::class.java).copy(idDrink = document.id)
                        documents.add(myDocument)
                    }
                }
                _cocktailData.value = documents
            }
    }


    /**
     * Establece el valor de la variable de elección de pantalla de log in o sing in
     * @param screen recibe un Int que da la elección de pantalla.
     */
    fun pantallasIncio(screen: Int){
        pantallasI = screen
    }


    /**
     * Función que lleva a la pantalla de registro o de iniciar sesión
     * @param screen Depende del número elige una opción u otra.
     */
    @Composable
    fun LogOrsign(screen: Int){
        when(screen){
            1 -> {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF45413C))
                        .padding(40.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(text = "Sing Up", fontFamily = jollyLodger, fontSize = 96.sp, color = Color(0xFF00F5D4))
                }
            }
            2 -> {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF45413C))
                        .padding(40.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(text = "Log In", fontFamily = jollyLodger, fontSize = 96.sp, color = Color(0xFFFF01FB))
                }
            }
        }
    }

    /**
     * Dependiendo del tipo de cocktail, muestra una información diferente en la cabecera.
     * @param number trae la información de la pantalla a eligir de la variable number.
     */
    @Composable
    fun Head(number: Int)
        {
            Column(Modifier.fillMaxWidth().background(color = Color(0xFF45413C)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = alcohol, fontFamily = jollyLodger, fontSize = 32.sp, color = Color(0xFF00F5D4))
            //Text(text = cocktail, fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))
                when (number){
                    1 -> {Text(text = "Glass Cocktail", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))}
                    2 -> {Text(text = "Glass Champagne", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))}
                    3 -> {Text(text = "Random Drinks", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))}
                    4 -> Text(text = "Ordinary Drinks", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))
                    5 -> Text(text = "Alcoholics", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))
                    6 -> Text(text = "No Alcoholics", fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))
                    7 -> {Text(text = "Favorites", fontFamily = jollyLodger, fontSize = 32.sp, color = Color(0xFFFF01FB))}
                }
                Text(text = cocktail, fontFamily = jollyLodger, fontSize = 24.sp, color = Color(0xFFFF01FB))
        }
    }

    /**
     * Elección del logo de las pantallas de login y sign.
     * @param valor dependiendo del valor se mostrará el icono correspondiente.
     */
    @Composable
    fun LogElection(valor: String) {
        return when (valor) {
            "userName" -> EiUser(Modifier.size(50.dp, 50.dp))
            "email" -> FluentEmojiHighContrastEnvelope(Modifier.size(50.dp, 50.dp))
            "password" -> BasilKeyOutline(Modifier.size(50.dp, 50.dp))
            "email " -> SobreGreen(Modifier.size(50.dp, 50.dp).padding(end = 3.dp))
            "password " -> KeyGreen(Modifier.size(50.dp, 50.dp).padding(end = 3.dp))
            else -> {}
        }
    }

    /**
     * Se elige hacia que variable va a ir el contenido.
     * @param valor indica hacia que variable irá el contenido.
     */
    @Composable
    fun informationElection(valor: String): String{
        return when (valor) {
            "userName" -> userName
            "email" -> email
            "password" -> password
            "email " -> email
            "password " -> password
            else -> ""
        }
    }

    /**
     * Nos dirige a la función que hace posible actualizar el contenido de la variable
     * @param valor indica hacia que variable irá el contenido.
     */
    fun ChangeElection(valor: String, cambio: String){
        when (valor) {
            "userName" -> changeUserName(cambio)
            "email" -> changeEmail(cambio)
            "password" -> changePassword(cambio)
            "email " -> changeEmail(cambio)
            "password " -> changePassword(cambio)
        }
    }

    fun closeAlert(){
        showAlert = false
    }

    /**
     * Actualiza el email del usuario.
     *
     * @param email Nuevo email a establecer.
     */
    fun changeEmail(email: String) {
        this.email = email
    }

    /**
     * Actualiza la contraseña del usuario.
     *
     * @param password Nueva contraseña a establecer.
     */
    fun changePassword(password: String) {
        this.password = password
    }

    /**
     * Actualiza el número para la elección texto de cabecera
     */
    fun changeScreen(screen: Int) {
        this.number = screen
    }

    /**
     * Actualiza el nombre del cocktail.
     */
    fun changeNameCocktail(name:String){
        this.cocktailName = name
    }
    /**
     * Actualiza el nombre de usuario.
     *
     * @param userName Nuevo nombre de usuario a establecer.
     */
    fun changeUserName(userName: String) {
        this.userName = userName
    }

    /**
     * Contiene el nombre del cocktail.
     */
    fun changeCocktail(cocktail: String){
        this.cocktail = cocktail
    }

    /**
     * Muestra el taxto Alcocholics or Non Alcoholics proveniente de la API
     */
    fun alcoholicOrno(alcoholic: String){
        this.alcohol = alcoholic
    }

    /**
     * Variable Booleana que permite marca la fila seleccionada.
     */
    fun lightRow(vista: Boolean){
        _show.value = !vista
    }

    /**
     * Selecciona el número de fila
     */
    fun changeSelectedRow(id: String?) {
        _selectedRowId = id
    }

    /**
     * Ccambia el color cuando la fila es seleccionada
     */
    fun changeColorRow(row: String?): Color {
        return if(_selectedRowId == row) Color(0xFFFF01FB) else Color.White
    }

    /**
     * Función que hace un limpiado de la información.
     */
    fun Clean(){
        alcoholicOrno("")
        changeSelectedRow("")
        changeCocktail("")
        changeNameCocktail("")
    }
}