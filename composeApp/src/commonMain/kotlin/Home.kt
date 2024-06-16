import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import calculation.CalcularImc




@Composable
fun Home(){



    val calcularImc = CalcularImc()

    var peso by remember {
        mutableStateOf("")
    }

    var altura by remember {
        mutableStateOf("")
    }

    var textoResultado by remember {
        mutableStateOf("")
    }


    var showEmptyFieldsAlert by remember {
        mutableStateOf(false)
    }

    Column() {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Blue,
                    title = {
                        Text(
                        text = "Calculadora de IMC",
                        color = Color.White )})
            })
        //---------------------------Corpo-----------------------//

        {
            Column(


                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())

            ) {
                Text(
                    text = "Calculadora de IMC",
                    color = Color.Blue,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(50.dp) )

                OutlinedTextField(
                    value = peso,
                    onValueChange = {
                        peso = it
                    },

                    label = {
                        Text("Peso(Kg)")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = Color.Blue,
                        unfocusedLabelColor = Color.Blue,
                        focusedLabelColor = Color.Blue,
                        textColor = Color.Black
                    ),
                    textStyle = TextStyle(Color.Blue,18.sp),
                    maxLines = 1,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(20.dp,0.dp,20.dp, bottom = 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )

                )

                OutlinedTextField(
                    value = altura,
                    onValueChange = {
                        altura = it
                    },

                    label = {
                        Text("Altura")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = Color.Blue,
                        unfocusedLabelColor = Color.Blue,
                        focusedLabelColor = Color.Blue,
                        textColor = Color.Black
                    ),
                    textStyle = TextStyle(Color.Blue,18.sp),
                    maxLines = 1,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(20.dp,10.dp,20.dp, bottom = 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )

                )

                if (showEmptyFieldsAlert) { // relacinado ao botão "Calcular IMC"
                    Text(
                        text = "Preencha todos os campos",
                        fontSize = 14.sp,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
                    )
                }

                Button(

                    onClick = {
                        if (peso.isNotEmpty() && altura.isNotEmpty()){
                            calcularImc.calcularImc(peso,altura)
                            textoResultado = calcularImc.resultImc()
                            showEmptyFieldsAlert = false
                        }else{
                            showEmptyFieldsAlert = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(50.dp),

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.White )

                ){ Text(
                    text="Calcular IMC",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold )}

                Text(
                    text= textoResultado,
                    fontSize = 18.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp))





            }
        }


    }

}