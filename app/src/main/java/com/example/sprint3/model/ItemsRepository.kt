package com.example.sprint3.model

class ItemsRepository {
companion object {
    var list = mutableListOf<Items>()

    fun startUp(){
        //make some default items on startup
        list.add(Items("apple", 5))
        list.add(Items("bear", 3))
        list.add(Items("crustacean", 2))
        list.add(Items("dentist", 1))
        list.add(Items("elizabeth", 4))
    }

}



}
