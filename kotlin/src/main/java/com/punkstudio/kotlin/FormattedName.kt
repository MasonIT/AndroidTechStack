package com.punkstudio.kotlin

import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Date:2020/12/29-10:49 AM
 * @author Mason
 */
class FormattedName : ReadWriteProperty<Any?, String> {
    private var name = ""
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        if (thisRef is Person) {
            thisRef.updateCount ++
        }
        name = value.toLowerCase(Locale.ROOT).capitalize(Locale.getDefault())
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return name
    }
}