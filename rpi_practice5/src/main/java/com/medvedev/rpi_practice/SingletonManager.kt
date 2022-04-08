package com.medvedev.rpi_practice

class SingletonManager{
    private lateinit var viewModel: RandomNumberViewModel
    fun setState(model: RandomNumberViewModel){
        viewModel = model
    }

    fun getState():RandomNumberViewModel{
        return viewModel
    }

    companion object : SingletonHolder<SingletonManager>(::SingletonManager)
}

open class SingletonHolder<out T: Any>(creator: () -> T) {
    private var creator: (() -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(): T {
        val checkInstance = instance
        if (checkInstance != null) {
            return checkInstance
        }

        return synchronized(this) {
            val checkInstanceAgain = instance
            if (checkInstanceAgain != null) {
                checkInstanceAgain
            } else {
                val created = creator!!()
                instance = created
                creator = null
                created
            }
        }
    }
}

