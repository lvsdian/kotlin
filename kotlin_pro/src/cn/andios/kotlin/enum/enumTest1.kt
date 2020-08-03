package cn.andios.kotlin.enum

/**
 * @author lvsdian
 * Created on 2020-08-03
 */
enum class Season1 {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class  Season2 (val temperature: Int) {
    SPRING(10), SUMMER(40), AUTUMN(30), WINTER(0)
}

enum class Season3 {
    SPRING {
        override fun getSeason(): Season3 = SPRING
    },

    SUMMER {
        override fun getSeason(): Season3 = SUMMER
    },

    AUTUMN {
        override fun getSeason(): Season3 = AUTUMN
    },

    WINTER {
        override fun getSeason(): Season3 = WINTER
    };

    abstract fun getSeason(): Season3
}

fun main(args: Array<String>) {
    val seasons = Season1.values()
    seasons.forEach { season: Season1 -> println(season) }
    seasons.forEach { println(it) }

    println("----------------------------")

    val season = Season1.valueOf("SPRING")
    println(season.name)
    println(season.ordinal)
    println(season.declaringClass)

}






















