package br.com.mnweb.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colosseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.pisa)
        val colesseum = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.eiffel)
        val london = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.london_bridge)

        val landmarkImages = ArrayList<Bitmap>()

        landmarkImages.add(pisa)
        landmarkImages.add(colesseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(london)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)

        this.listView.adapter = arrayAdapter

        this.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("name", landmarkNames[i])

            val bitmap = landmarkImages[i]

            val chosen = Globals.Chosen
            chosen.chosenImages = bitmap

            startActivity(intent)
        }
    }
}
