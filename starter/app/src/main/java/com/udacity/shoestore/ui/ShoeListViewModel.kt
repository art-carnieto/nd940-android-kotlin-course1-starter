package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>?>()
    val shoeList: LiveData<List<Shoe>?>
        get() = _shoeList

    init {
        Timber.d("init ShoeListViewModel")
        populateShoes()
    }

    private fun populateShoes() {
        _shoeList.value = mutableListOf(
            Shoe(
                "Moccasin",
                11.3,
                "Italian Shoes",
                "A moccasin is a shoe, made of deerskin or other soft leather, consisting" +
                        " of a sole and sides made of one piece of leather, stitched together at the top, and sometimes with a vamp.",
                R.drawable.mocassin
            ),
            Shoe(
                "Oxford",
                13.0,
                "Fancy Wedding Shoes Company",
                "An Oxford shoe is a type of shoe characterized by shoelace eyelet tabs that " +
                        "are attached under the vamp, a feature termed \"closed lacing\".",
                R.drawable.oxford
            ),
            Shoe(
                "Flip Flops",
                12.7,
                "Havaianas",
                "Havaianas is a Brazilian brand of flip-flop sandals created and patented in 1962. " +
                        "The brand was founded by Brazilian manufacturer Alpargatas S.A.. Inspired by the Japanese " +
                        "zori sandals, Havaianas became the first mass-produced flip-flops made out of rubber.",
                R.drawable.havaianas
            ),
            Shoe(
                "Crocs",
                9.4,
                "Crocs",
                "Crocs, Inc. is an American footwear company based in Broomfield, Colorado. " +
                        "It manufactures and markets the Crocs brand of foam footwear. " +
                        "Crocs, Inc. terms these \"clogs,\" but they do not contain wood like traditional clogs.",
                R.drawable.crocs
            ),
            Shoe(
                "Sandal",
                11.0,
                "Amazing Sandals Corp.",
                "Sandals are an open type of shoe, consisting of a sole held to the wearer's foot " +
                        "by straps going over the instep and around the ankle. Sandals can also have a heel.",
                R.drawable.sandal
            ),
            Shoe(
                "Aqua Shoe",
                10.6,
                "Aquatic Sports",
                "A water shoe is a type of footwear that is typically used for activities where the feet " +
                        "are likely to become wet, such as kayaking. Water shoes are usually made of mesh and have a " +
                        "hard sole used to prevent cuts and abrasions when walking in wet, rocky environments.",
                R.drawable.aqua_shoes
            ),
            Shoe(
                "High-heeled shoe",
                9.5,
                "Ultra Fancy",
                "High-heeled shoes, also known as high heels (colloquially shortened to heels), are a type " +
                        "of shoe with an upward-angled sole. The heel in such shoes is raised above the ball of the foot. " +
                        "High heels cause the legs to appear longer, make the wearer appear taller, and accentuate the calf muscle.",
                R.drawable.high_heels
            ),
            Shoe(
                "Geta",
                7.1,
                "JapanShoes Inc.",
                "Geta (下駄) (pl. geta) are traditional Japanese footwear resembling flip-flops. A kind of " +
                        "sandal, geta have a flat wooden base elevated with up to three (though commonly two) \"teeth\", " +
                        "held on the foot with a fabric thong, which keeps the foot raised above the ground.",
                R.drawable.geta
            ),
            Shoe(
                "Slipper",
                11.6,
                "Sleep Comfy",
                "Slippers are a type of shoes falling under the broader category of light footwear, that are " +
                        "easy to put on and off and are intended to be worn indoors, particularly at home. They provide comfort " +
                        "and protection for the feet when walking indoors.",
                R.drawable.slippers
            ),
            Shoe(
                "Sneaker",
                13.4,
                "Top Sports",
                "Sneakers (US) or trainers (UK), also known by a wide variety of other names, are shoes primarily " +
                        "designed for sports or other forms of physical exercise, but are also widely used for everyday casual wear.",
                R.drawable.sneakers
            )
        )
    }

    fun getShoe(index: Int) : Shoe? = shoeList.value?.get(index)

    fun editShoe(newShoe: Shoe, index: Int) {
        val newShoeList = _shoeList.value?.toMutableList()
        if(newShoeList?.get(index) == null) {
            Timber.e("Invalid shoe index $index!")
            return
        }
        newShoeList[index] = newShoe
        _shoeList.value = newShoeList
    }

    fun createNewShoe(newShoe: Shoe) {
        val newShoeList = _shoeList.value?.toMutableList()
        newShoeList?.add(newShoe)
        _shoeList.value = newShoeList
    }
}