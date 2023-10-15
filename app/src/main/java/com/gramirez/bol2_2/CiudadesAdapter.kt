package com.gramirez.bol2_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.gramirez.bol2_2.model.Ciudades
import com.gramirez.bol2_2.databinding.ActivityMainBinding
import com.gramirez.bol2_2.databinding.ViewCityBinding


class CiudadesAdapter(val ciudades: List<Ciudades>, val context: Context) :
    RecyclerView.Adapter<CiudadesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bd = ViewCityBinding.bind(view)

        fun bind(ciudades: Ciudades) {
            with(bd) {
                nomCiudad.text = ciudades.nomCiudad
                Glide.with(root.context).load(ciudades.urlCiudad).into(ciudadImagen)

                // Agrega un OnClickListener a la imagen
                ciudadImagen.setOnClickListener {
                    val latitud = ciudades.latitud
                    val altitud = ciudades.altitud
                    val locationUri =
                        "geo:$latitud,$altitud?q=$latitud,$altitud (${ciudades.nomCiudad})"

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(locationUri))
                    intent.setPackage("com.google.android.apps.maps") // Abre en la aplicación Google Maps si está instalada

                    if (intent.resolveActivity(root.context.packageManager) != null) {
                        root.context.startActivity(intent)
                    } else {
                        // Si Google Maps no está instalada, abre en un navegador web
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps?q=$latitud,$altitud")
                        )
                        root.context.startActivity(webIntent)
                    }
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_city, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = ciudades.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ciudades[position])
    }

}

