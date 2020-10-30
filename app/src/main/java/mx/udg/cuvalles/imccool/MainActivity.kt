package mx.udg.cuvalles.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var edad:Int = 25
    var peso:Int = 75
    var sexo:String = "Hombre"
    var altura:Int = 180
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekAltura.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, p1: Int, p2: Boolean) {
                if(p1 <= 100){
                    seekAltura.setProgress(100)
                    tbAltura.text = "100"
                    altura = 100
                }else{
                    tbAltura.text = "$p1"
                    altura = p1
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        btnEdadMas.setOnClickListener (this)
        btnEdadMenos.setOnClickListener (this)
        btnPesoMenos.setOnClickListener (this)
        btnPesoMas.setOnClickListener (this)
        imbtnFemale.setOnClickListener(this)
        imbtnMale.setOnClickListener(this)
        btnCalcular.setOnClickListener(this)
        tvPeso.text = "$peso"
        tvAltura.text = "$altura"
        tvEdad.text = "$edad"
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnEdadMenos->{
                edad--
                tvEdad.text = "$edad"
            }
            R.id.btnEdadMas->{
                edad++
                tvEdad.text = "$edad"
            }
            R.id.btnPesoMenos->{
                peso--
                tvEdad.text = "$peso"
            }
            R.id.btnPesoMas->{
                peso++
                tvEdad.text = "$peso"
            }

            R.id.imbtnFemale->sexo="f"
            R.id.imbtnMale->sexo="m"

            R.id.btnCalcular->{
                val imc = calcularIMC(peso, altura)
                val intencion = Intent(this,Activity2::class.java)
                intencion.putExtra("imc", imc)
                intencion.putExtra("sexo", sexo)
                intencion.putExtra("edad", edad)
                startActivity(intencion)
            }
        }
    }

    fun calcularIMC(peso:Int, altura:Int):Float {
        val pesof = peso.toFloat()
        val alturaf = altura.toFloat()/100

        var imc = pesof / (alturaf * alturaf)
        return imc.toFloat()
    }
}