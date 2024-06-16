package calculation

import java.text.DecimalFormat

class CalcularImc {

    private var resultImc = ""

    fun calcularImc(peso:String, altura:String){

        val convertedweight = peso.toDouble()
        val convertedheight = altura.toDouble()
        val result : String

        val imc = convertedweight / (convertedheight * convertedheight)
        val decimalFormat = DecimalFormat("0.00")

        if (imc<=18.5){
            result = "Peso Baixo \nIMC:${decimalFormat.format(imc)}"

        }

        else if (imc<=24.9){
            result = "Peso Normal \nIMC:${decimalFormat.format(imc)}"
        }

        else if (imc<= 29.9){
            result = "Sobrepeso \nIMC:${decimalFormat.format(imc)}"
        }

        else if (imc<= 34.9){
            result = "Obesidade(Grau 1) \nIMC:${decimalFormat.format(imc)}"
        }

        else if (imc<= 39.9){
            result = "Obesidade Severa (Grau 2) \nIMC:${decimalFormat.format(imc)}"
        }

       else{
            result = "Obesidade Mórbida (Grau 3) \nIMC:${decimalFormat.format(imc)}"
        }

        resultImc = result
    }

    fun resultImc() : String {

        return  resultImc
    }

}