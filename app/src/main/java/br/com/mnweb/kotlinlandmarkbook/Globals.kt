package br.com.mnweb.kotlinlandmarkbook

import android.graphics.Bitmap

class Globals {

    companion object Chosen {
        var chosenImages : Bitmap? = null
        fun returnImage():Bitmap {
            return chosenImages!!
        }
    }

}