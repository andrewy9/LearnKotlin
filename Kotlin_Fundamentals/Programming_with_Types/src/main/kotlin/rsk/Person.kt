package rsk

fun main(args: Array<String>) {
    val andrew = Student("Andrew", "Yang", 1, "some tutor")
//    print(andrew.id)
    andrew.enrole("Kotlin Fundamentals")

    Student.createPostgrad("Simon")
    Student.createUndergrad("Kevin")
}

abstract class Person(var firstName:String, var lastName:String) {

    open fun getName() : String = "$firstName $lastName"
    abstract fun getAddress():String;
}

open class Student(firstName: String, lastName: String, _id: Int = 10, var tutor:String = ""): Person(firstName, lastName) {
    val id: Int

    init {
        id = _id
    }

    fun enrole(courseName: String) {
        Courses.initialise();
        val course = Courses.allCourses
            .filter { it.Title == courseName }
            .firstOrNull()
    }

    override fun getName(): String{
        return ""
    }

    override fun getAddress(): String {
        return ""
    }

    companion object {
        lateinit var newUndergraduate: Undergraduate;

        fun createUndergrad(name: String): Undergraduate {
            newUndergraduate = Undergraduate(name)
            return newUndergraduate
        }

        fun createPostgrad(name: String): Postgraduate {
            return Postgraduate(name)
        }
    }

}

class Undergraduate(firstName: String) : Student(firstName, "", 1) {

}

class Postgraduate(firstName: String) : Student(firstName, "", 1) {

}