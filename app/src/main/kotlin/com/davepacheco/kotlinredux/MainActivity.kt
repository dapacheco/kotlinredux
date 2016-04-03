package com.davepacheco.kotlinredux

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.davepacheco.kotlinredux.redux.BasicStore
import com.davepacheco.kotlinredux.redux.counter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {

    val store : BasicStore<Int, String> = BasicStore(::counter, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter_text.text = "Counter is ${store.state}"

        add_button.onClick { store.dispatch("INCREMENT") }
        remove_button.onClick { store.dispatch("DECREMENT") }

        store.subscribe({ state : Int -> counter_text.text = "Counter is ${store.state}" })
    }
}
