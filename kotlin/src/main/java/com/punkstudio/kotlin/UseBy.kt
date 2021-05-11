package com.punkstudio.kotlin

/**
 * Date:2020/12/29-10:48 AM
 * @author Mason
 */


fun main() {
    val person = Person()
    person.firstName = "mason"
    println(person.toString())
    person.lastName = "christina"
    changePerson(person)
    println(person.toString())

//    val person1 = Person()
//    person1.firstName = "mason1"
//    person1.lastName = "christina1"
//
//    val person2 = Person()
//    person2.firstName = "mason1"
//    person2.lastName = "christina1"
//
//    println("p1==p2 is ${person1 == person2}")
//    println("p1===p2 is ${person1 === person2}")

}

private fun changePerson(p: Person) {
    p.firstName = "Hahaha"
}