package com.taylorz.apriltag

object ApriltagNative {
    init {
        System.loadLibrary("apriltag")
        native_init()
    }

    private external fun native_init()

    /**
     * @param tagFamily 指定使用的 AprilTag 家族，例如 "tag36h11" 或 "tag25h9"。不同的家族有不同的编码方式和纠错能力。
     * @param errorBits   小值：如果 errorBits 设置为 0 或 1，系统将非常严格，只能容忍非常少的错误。 较大值：如果设置较大的值（例如 3 或 4），系统会在解码过程中容忍更多的错误，但也会增加误解码的风险。
     * @param decimateFactor 图像降采样因子，默认值为 1.0。可以设置为大于 1 的值以加速检测但可能降低精度。
     * @param blurSigma 高斯模糊的标准差，默认值为 0.0。适当的模糊可以帮助减少噪声影响。
     * @param nthreads 使用的线程数，默认为 1。多线程可以加速处理时间。
     * @param refineEdges 是否对边缘进行细化，默认为 True。这有助于提高定位精度。
     * @param decodeSharpening 解码时的锐化程度，默认值为 0.25。适当调整可以改善解码成功率。
     */
    external fun apriltag_init(
        tagFamily: String?, errorBits: Int, decimateFactor: Float,
        blurSigma: Float, nthreads: Int, refineEdges: Int, decodeSharpening: Double
    )

    external fun apriltag_detect_yuv(
        src: ByteArray?,
        camera: String?,
        bigId: Int,
        smallId: Int,
        width: Int,
        height: Int
    ): ArrayList<ApriltagDetection>
}
