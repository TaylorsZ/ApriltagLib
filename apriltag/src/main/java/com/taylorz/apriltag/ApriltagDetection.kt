package com.taylorz.apriltag

class ApriltagDetection {
    // The decoded ID of the tag
    var id: Int = 0

    // How many error bits were corrected? Note: accepting large numbers of
    // corrected errors leads to greatly increased false positive rates.
    // NOTE: As of this implementation, the detector cannot detect tags with
    // a hamming distance greater than 2.
    var hamming: Int = 0


    // The center of the detection in image pixel coordinates.
    var center: DoubleArray = DoubleArray(2)

    // The corners of the tag in image pixel coordinates. These always
    // wrap counter-clock wise around the tag.
    // Flattened to [x0 y0 x1 y1 ...] for JNI convenience
    var polygon: DoubleArray = DoubleArray(8)

    var yaw: Double = 0.0
    var pitch: Double = 0.0
    var roll: Double = 0.0

    var attitude: DoubleArray = DoubleArray(3)

    override fun toString(): String {
        return "ApriltagDetection{" +
                "id=" + id +
                ", hamming=" + hamming +
                ", center=" + center.contentToString() +
                ", polygon=" + polygon.contentToString() +
                ", yaw=" + yaw +
                ", pitch=" + pitch +
                ", roll=" + roll +
                ", attitude=" + attitude.contentToString() +
                '}'
    }
}

