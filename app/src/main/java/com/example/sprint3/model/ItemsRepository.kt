package com.example.sprint3.model

class ItemsRepository {
companion object {
    var list = mutableListOf<Items>()

    fun startUp(){
        //make some default items on startup
        list.add(Items("item1", 5))
        list.add(Items("item2", 3))
        list.add(Items("item3", 2))
        list.add(Items("item4", 1))
        list.add(Items("item5", 4))
    }

}



}
