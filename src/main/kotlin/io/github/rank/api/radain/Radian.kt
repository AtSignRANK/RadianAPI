package io.github.rank.api.radain

import org.jetbrains.annotations.Contract

interface Radian {
    var radian: Double

    @Contract(pure = true)
    fun Double.toRadian(): Double { return this / 180 * Math.PI }
}
