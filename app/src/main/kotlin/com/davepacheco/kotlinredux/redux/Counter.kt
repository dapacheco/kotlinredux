package com.davepacheco.kotlinredux.redux

/**
 * Created by dpacheco on 03/04/2016.
 */
fun counter(state: Int = 0, action: String): Int = when (action) {
            "INCREMENT" -> state + 1
            "DECREMENT" -> state - 1
            else -> state
        }