package com.gramirez.bol2_2

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.gramirez.bol2_2.databinding.ActivityMainBinding
import com.gramirez.bol2_2.model.Ciudades

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ciudades = listOf(
            Ciudades("Almeria", "https://upload.wikimedia.org/wikipedia/commons/9/9e/Aeropuerto_de_Almer%C3%ADa.jpeg", "36.8433", "-2.3700"),
            Ciudades("Sevilla", "https://res.cloudinary.com/hello-tickets/image/upload/c_limit,f_auto,q_auto,w_1300/v1659907688/ffogv2qkwl1hqqxe0y97.jpg", "37.385806", "-5.993079"),
            Ciudades("Caceres", "https://www.civitatis.com/f/espana/caceres/visita-guiada-caceres-589x392.jpg", "39.4762", "-6.3703"),
            Ciudades("Melilla", "https://melillaturismo.com/wp-content/uploads/sb-instagram-feed-images/284512543_385476266871291_2198760074185873782_n.webpfull.jpg", "35.2923", "-2.9381"),
            Ciudades("Granada", "https://www.barcelo.com/guia-turismo/wp-content/uploads/2018/06/Granada.jpg", "37.1882", "-3.6067"),
            Ciudades("Madrid", "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/01/24/istock-1297090032.jpeg", "40.4168", "-3.7038"),
            Ciudades("Barcelona", "https://media.traveler.es/photos/63838947050e0f92cd80c982/16:9/w_2560%2Cc_limit/GettyImages-1392907424.jpg", "41.3851", "2.1734"),
            Ciudades("Lanzarote", "https://static.holidu.com/wp-content/uploads/Preview-6.jpg", "29.0469", "-13.5899"),
        )

        val bd = ActivityMainBinding.inflate(layoutInflater).apply{
            setContentView(root)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

            recyclerView.adapter = CiudadesAdapter(ciudades, this@MainActivity)
        }


    }
}

