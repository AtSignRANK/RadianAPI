package io.github.rank.api.radain

public fun Double.toRadian(): Double { return this * 180 / Math.PI }

public fun Double.fromRadian(): Double { return this / 180  * Math.PI }
