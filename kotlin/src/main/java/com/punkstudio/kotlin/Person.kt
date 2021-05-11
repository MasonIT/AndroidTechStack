package com.punkstudio.kotlin

/**
 * Date:2020/12/29-10:48 AM
 * @author Mason
 */
class Person {
    var updateCount = 0
    var firstName by FormattedName()
    var lastName by FormattedName()


    override fun toString(): String {
        return "Person(updateCount=$updateCount, firstName=$firstName, lastName=$lastName)"
    }


}