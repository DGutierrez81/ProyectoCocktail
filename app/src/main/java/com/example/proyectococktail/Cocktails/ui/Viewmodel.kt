package com.example.proyectococktail.Cocktails.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.proyectococktail.Cocktails.Domain.NameUseCase
import com.example.proyectococktail.Cocktails.Domain.RandomCocktail
import com.example.proyectococktail.Cocktails.Model.CocktailUser
import com.example.proyectococktail.Cocktails.Model.Response.User
import com.example.proyectococktail.Cocktails.ui.State.drinkState
import com.example.proyectococktail.basilkeyoutline.BasilKeyOutline
import com.example.proyectococktail.complogin.CompLogIn
import com.example.proyectococktail.compsignup.CompSignUp
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

@HiltViewModel
class Viewmodel @Inject constructor(private val nameUseCase: NameUseCase, private val randomCocktail: RandomCocktail, private val alcoholicsCocktail: AlcoholicsCocktail): ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore: FirebaseFirestore = Firebase.firestore
    //private val _games = MutableStateFlow<List<GameInfoState>>(emptyList())
    //val games: StateFlow<List<GameInfoState>> = _games.asStateFlow()
    private val _nombre = MutableStateFlow<List<drinkState>>(emptyList())
    val nombre: StateFlow<List<drinkState>> = _nombre.asStateFlow()

    private val _cocktailData = MutableStateFlow<List<CocktailUser>>(emptyList())
    val cocktailData: StateFlow<List<CocktailUser>> = _cocktailData

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

    var listaIngredientes by mutableStateOf<MutableList<String>>(mutableListOf())
        private set

    var cocktailName by mutableStateOf("")
        private set

    var cocktail by mutableStateOf("")
        private set

    var alochol by mutableStateOf("")
        private set
    var drink by mutableStateOf(CocktailUser())
        private set

    var showAlert by mutableStateOf(false)
        private set


    var _selectedRowId by mutableStateOf<String?>(null)
        private set


    fun getName(name: String){
        viewModelScope.launch {
            _nombre.value = nameUseCase(name).drinks
        }
    }

    fun getRandom(){
        viewModelScope.launch {
            _nombre.value = randomCocktail().drinks
        }
    }

    fun vCocktailAlcoholic(){
        viewModelScope.launch {
            _nombre.value = alcoholicsCocktail().drinks
        }
    }

    fun IngredientsUser(ingredientes: CocktailUser): String{
        _ingredient = ""
        for(ingrediente in ingredientes.strList!!){
            if(ingrediente.equals("vacio")) break else _ingredient += "$ingrediente "
        }
        return _ingredient
    }


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



    fun calculateBackgroundColor(index: Int): Color {
        return if (index % 2 == 0) Color(0xFFF9EBE0) else Color.White
    }


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
        drink = CocktailUser(email.toString(), idDrink, strDrink, strAlcoholic, strInstructions, strDrinkThumb, listaIngredientes)
    }

    fun mostrar(){
        showAlert = !showAlert
    }


    fun login(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                // DCS - Utiliza el servicio de autenticación de Firebase para validar al usuario
                // por email y contraseña
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


    fun createUser(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                // DCS - Utiliza el servicio de autenticación de Firebase para registrar al usuario
                // por email y contraseña
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // DCS - Si se realiza con éxito, almacenamos el usuario en la colección "Users"
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

    //newCocktail: CocktailUser
    fun saveNewCocktail(onSuccess: () -> Unit) {
        val email = auth.currentUser?.email

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

    fun fetchCoctail() {
        val email = auth.currentUser?.email

        // DCS - addSnapshotListener ya trae todas las funciones necesarias para la concurrencia
        // de datos y es asíncrono, por lo que no es necesario introducir el viewModelScope.
        // Ya lleva incluida todas las corrutinas necesarias...
        firestore.collection("Cocktails")
            .whereEqualTo("emailUser", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val documents = mutableListOf<CocktailUser>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        val myDocument = document.toObject(CocktailUser::class.java).copy(idDrink = document.id)
                        documents.add(myDocument)
                    }
                }
                _cocktailData.value = documents
            }
    }

    fun pantallasIncio(screen: Int){
        pantallasI = screen
    }


    @Composable
    fun LogOrsign(screen: Int){
        when(screen){
            1 -> {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(227.dp)
                ) {
                    CompSignUp(
                        Modifier.fillMaxWidth()
                    )
                }
            }
            2 -> {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(227.dp)
                ) {
                    CompLogIn(
                        Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }

    @Composable
    fun Head(number: Int)
        {
            Column(Modifier.fillMaxWidth().background(color = Color(0xFF45413C)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = alochol, fontFamily = jollyLodger, fontSize = 32.sp, color = Color(0xFF00F5D4))
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

    @Composable
    fun LogElection(valor: String): Unit {
        return when (valor) {
            "userName" -> EiUser(Modifier.size(50.dp, 50.dp))
            "email" -> FluentEmojiHighContrastEnvelope(Modifier.size(50.dp, 50.dp))
            "password" -> BasilKeyOutline(Modifier.size(50.dp, 50.dp))
            "email " -> SobreGreen(Modifier.size(50.dp, 50.dp).padding(end = 3.dp))
            "password " -> KeyGreen(Modifier.size(50.dp, 50.dp).padding(end = 3.dp))
            else -> {}
        }
    }

    @Composable
    fun InformationElection(valor: String): String{
        return when (valor) {
            "userName" -> userName
            "email" -> email
            "password" -> password
            "email " -> email
            "password " -> password
            else -> ""
        }
    }


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

    fun changeScreen(screen: Int) {
        this.number = screen
    }

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

    fun changeCocktail(cocktail: String){
        this.cocktail = cocktail
    }

    fun alcoholicOrno(alcoholic: String){
        //if(alcoholic.equals("Alcoholic")) this.alochol = "Alcoholic" else this.alochol = " No Alcoholic"
        this.alochol = alcoholic
    }

    fun lightRow(vista: Boolean){
        _show.value = !vista
    }

    fun changeSelectedRow(id: String?) {
        _selectedRowId = id
    }

    fun changeColorRow(row: String?): Color {
        return if(_selectedRowId == row) Color.Red else Color.White
    }
}