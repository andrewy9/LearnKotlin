import rsk.Student
import rsk.Tutor
import rsk.YetiTime

fun main(args: Array<String>) {
    var student: Student = Student("James", "Powell", 1)
    student.enrole("Kotlin Fundamentals")
    println("____________________________________________")
    Tutor("Sam","Harrington", 10, student.firstName).enrole("Kotlin Fundamentals")
}
