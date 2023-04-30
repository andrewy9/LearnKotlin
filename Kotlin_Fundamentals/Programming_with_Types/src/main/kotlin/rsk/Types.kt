package rsk

interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    fun setTime(time: AndrewTime) = print(time.hours)
}

interface EndOfTheWorld {
    fun setTime(time: AndrewTime){}
}

class AndrewTime {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int =0
}

class YetiTime: Time, EndOfTheWorld {
    override fun setTime(hours: Int, mins: Int, secs: Int) {
    }

    override fun setTime(time: AndrewTime) {
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }
}