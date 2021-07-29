package io.github.rank.api.radain

@Contract(pure = true)
public fun Double.toRadian(): Double { return this / 180 * Math.PI }
