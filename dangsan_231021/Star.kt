package dangsan_231021

import kotlin.math.abs

class Star {
    fun solution(line: Array<IntArray>): Array<String> {
        val intersectionPoints = mutableSetOf<Pair<Double, Double>>()
        for (i in 0 until line.size - 1) {
            for (j in i + 1 until line.size) {
                intersectionPoints.add(getIntersectionPoint(line[i], line[j]))
            }
        }

        val intersectionPointsOfInt = intersectionPoints
            .filter { it.first.isInt() && it.second.isInt() }
            .map { it.first.toInt() to it.second.toInt() }

        return getMinCoordinateString(intersectionPointsOfInt)
    }

    private fun getIntersectionPoint(point1: IntArray, point2: IntArray): Pair<Double, Double> {
        val ad = point1[0] * point2[1]
        val af = point1[0] * point2[2]
        val bc = point1[1] * point2[0]
        val bf = point1[1] * point2[2]
        val ce = point1[2] * point2[0]
        val de = point1[2] * point2[1]

        if (ad - bc == 0) {
            Double.NaN to Double.NaN
        }

        val x = (bf - de).toDouble() / (ad - bc)
        val y = (ce - af).toDouble() / (ad - bc)

        return x to y
    }

    private fun Double.isInt(): Boolean {
        return this == this.toInt().toDouble()
    }

    private fun getMinCoordinateString(points: List<Pair<Int, Int>>): Array<String> {
        if (points.isEmpty()) return arrayOf()

        val minX = points.minByOrNull { it.first }!!.first
        val maxX = points.maxByOrNull { it.first }!!.first
        val minY = points.minByOrNull { it.second }!!.second
        val maxY = points.maxByOrNull { it.second }!!.second

        val width = maxX - minX + 1
        val height = maxY - minY + 1

        val coordinateOf00 = abs(minX) to abs(maxY)

        val coordinate = MutableList(height) { MutableList(width) { "." } }
        for (point in points) {
            val x = coordinateOf00.first + point.first
            val y = coordinateOf00.second - point.second

            coordinate[y][x] = "*"
        }

        return coordinate
            .map { it.joinToString("") }
            .toTypedArray()
    }
}