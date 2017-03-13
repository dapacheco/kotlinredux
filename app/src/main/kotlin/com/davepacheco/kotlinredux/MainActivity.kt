package com.davepacheco.kotlinredux

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.davepacheco.kotlinredux.redux.BasicStore
import com.davepacheco.kotlinredux.redux.counter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {

    val store: BasicStore<Int, String> = BasicStore(::counter, 0)
    lateinit var unsubscribeFromStore: () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
//        binding.counter = store.state

        setUpUI()

    }

    private fun setUpUI() {
        counter_text.text = "Counter is ${store.state}"

        add_button.onClick { store.dispatch("INCREMENT") }
        remove_button.onClick { store.dispatch("DECREMENT") }
    }

    override fun onResume() {
        super.onResume()
        unsubscribeFromStore = store.subscribe({ state: Int -> counter_text.text = "Counter is ${store.state}" })
    }

    override fun onPause() {
        unsubscribeFromStore()
        super.onPause()
    }
}
