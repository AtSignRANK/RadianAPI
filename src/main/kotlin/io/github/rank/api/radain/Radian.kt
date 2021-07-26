package io.github.rank.api.radain

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.annotations.Contract

@ApiStatus.NonExtendable
interface Radian(private val angle: Double) {
    private var radian = angle * 180 / Math.PI
        get() { return field }
        set(radian: Double) { field = radian }

    @Contract(pure = true)
    fun Double.toRadian(): Double { return this / 180 * Math.PI }
}
