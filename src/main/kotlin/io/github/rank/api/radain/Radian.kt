package io.github.rank.api.radain

class Radian(private val angle: Double) {
    private var radian = angle * 180 / Math.PI
        get() { return field }
        set(radian: Double) { field = radian }

    fun Double.toRadian(): Double { return this / 180 * Math.PI }
}