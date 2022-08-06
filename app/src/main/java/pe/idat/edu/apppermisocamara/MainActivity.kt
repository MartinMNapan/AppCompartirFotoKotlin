package pe.idat.edu.apppermisocamara

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import pe.idat.edu.apppermisocamara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTomarFoto.setOnClickListener(this)
        binding.btnCompartirFoto.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnCompartirFoto -> tomarFoto()
                R.id.btnCompartirFoto -> compartirFoto()
        }
    }

    private fun tomarFoto() {

    }

    private fun compartirFoto() {


    }

    private fun validarPermisoAlmacenamiento() : Boolean{
        val resultado = ContextCompat.checkSelfPermission(
            applicationContext, android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        var permiso = false
        if (resultado == PackageManager.PERMISSION_GRANTED) permiso = true
        return permiso

    }
    private  fun solicitarPermiso(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1999
        )
    }



}