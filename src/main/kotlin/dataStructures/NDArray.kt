package dataStructures

/**
 * N-dimensional array implementation
 *
 * @param T the type of the data
 * @property dimensions the dimensions of the array
 * @property data the data of the array
 * @constructor Creates an array with the specified dimensions
 *
 * @sample dataStructures.NDArrayTest.main
 * @see buildStringRepresentation
 */
class NDArray<T : Any>(vararg shape: Int) {
    private val dimensions: IntArray = shape
    private val data: Array<Any>

    init {
        val size = shape.fold(1) { acc, i -> acc * i }
        data = Array(size) { 0 }
    }

    /**
     * Build the string representation of the NDArray
     * @param data the data to represent
     * @param dimensions the dimensions of the data
     * @param builder the string builder to append to
     * @param depth the current depth of the data
     * @sample dataStructures.NDArray.toString
     */
    private fun buildStringRepresentation(
        data: Array<Any>,
        dimensions: IntArray,
        builder: StringBuilder,
        depth: Int
    ) {
        if (depth == dimensions.size - 1) {
            builder.append(data.joinToString(", ", "[", "]"))
        } else {
            builder.append("[")
            for (i in 0 until dimensions[depth]) {
                buildStringRepresentation(
                    data.copyOfRange(
                        i * dimensions.drop(depth + 1).fold(1) { acc, dim -> acc * dim },
                        (i + 1) * dimensions.drop(depth + 1).fold(1) { acc, dim -> acc * dim }
                    ),
                    dimensions,
                    builder,
                    depth + 1
                )
                if (i != dimensions[depth] - 1) {
                    builder.append(", ")
                }
            }
            builder.append("]")
        }
    }

    private fun offset(indices: IntArray): Int {
        require(indices.size == dimensions.size) { "Invalid number of indices" }
        require(
            indices.zip(dimensions).all { (index, dim) -> index in 0 until dim }
        ) { "Index out of bounds" }

        return indices.zip(dimensions).fold(0) { acc, (index, dim) -> acc * dim + index }
    }


    operator fun get(vararg indices: Int): T {
        val offset = offset(indices)

        @Suppress("UNCHECKED_CAST") return data[offset] as T
    }

    operator fun set(vararg indices: Int, value: T) {
        val offset = offset(indices)
        data[offset] = value
    }

    override fun toString(): String {
        val builder = StringBuilder()
        buildStringRepresentation(data, dimensions, builder, 0)
        return builder.toString()
    }


}
