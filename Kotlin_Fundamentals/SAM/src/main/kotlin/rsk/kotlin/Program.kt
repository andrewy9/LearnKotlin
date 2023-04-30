package rsk.kotlin

import rsk.java.Created
import rsk.java.User

fun main(args: Array<String>) {
    var user = User("Kevin")

    var count = 0
    var eventListener = {u:User -> println("User $u has been created: ${++count}")}
    var eventListener2 = Created { println("User $it has been created: ${++count}") }

//    user.create {println("User $it has been created: ${++count}")}
    user.create(eventListener)
    user.create(eventListener2)
}