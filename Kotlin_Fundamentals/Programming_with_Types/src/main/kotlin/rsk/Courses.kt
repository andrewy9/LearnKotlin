package rsk

class Course(val id: Int, val Title: String, val attendees: ArrayList<Person> = ArrayList<Person>()) {
}

object Courses {
    var allCourses = arrayListOf<Course>()

    fun initialise() {
        allCourses.add(Course(1, "Kotlin Fundamentals"))
    }
}

class Tutor(firstName: String, lastName: String, _id: Int = 9, var student:String = ""): Person(firstName, lastName) {
    override fun getAddress(): String {
        TODO("Not yet implemented")
    }

    fun enrole(courseName: String) {
        val course = Courses.allCourses
            .filter { it.Title == courseName }
            .firstOrNull()
    }

}