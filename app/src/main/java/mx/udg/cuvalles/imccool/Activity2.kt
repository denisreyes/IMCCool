package mx.udg.cuvalles.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val intencion = intent

        val imc = intencion.getFloatExtra("imc", 0.0F)
        val sexo = intencion.getStringExtra("sexo")
        val edad = intencion.getIntExtra( "edad", 25)

        tvBMI.text = "$imc"
        btnRecalcular.setOnClickListener(){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
    fun interpretaIMC(imc: Float, edad: Int, sexo: String){
        var mensaje:String = ""
        var estado:String = ""
        if(sexo == "f"){
            when(edad){
                in 19..24->{
                    when(imc){
                        in  18.9 .. 22.1->{
                            estado = "Bueno"
                            mensaje = "Tu IMC es muy bueno"
                        }
                    }
                    when(imc){
                        in 22.2 .. 25.0->{
                            estado = ""
                        }
                    }
                }
                //tvmensaje.text = "mensaje"
            }
        }else if (sexo == "m"){

        }
    }
}