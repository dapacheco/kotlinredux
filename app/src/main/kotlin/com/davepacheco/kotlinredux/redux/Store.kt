package com.davepacheco.kotlinredux.redux

import java.util.*


interface Store<S, A>{

    fun dispatch(action : A) {}

    fun subscribe(listener: (S) -> Unit): () -> Unit

}

class BasicStore<S, A>(val reducer: (S, A) -> S, var state : S) : Store<S, A>  {

    var listeners : MutableList<(S) -> Unit> = ArrayList<(S) -> Unit>()

    override fun dispatch(action : A) {
        state = reducer(state, action)
        listeners.forEach  {
            it(state)
        }
    }

    override fun subscribe(listener : (S) -> Unit) : () -> Unit {
        listeners.add(listener)
        return { listeners.remove(listener) }
    }
}