# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)
project(Project)

add_library(
        apriltag
        SHARED
        src/main/apriltag/apriltag.c
        src/main/apriltag/apriltag_jni.c
        src/main/apriltag/apriltag_quad_thresh.c
        src/main/apriltag/common/g2d.c
        src/main/apriltag/common/getopt.c
        src/main/apriltag/common/homography.c
        src/main/apriltag/common/image_u8.c
        src/main/apriltag/common/image_u8x3.c
        src/main/apriltag/common/matd.c
        src/main/apriltag/common/pnm.c
        src/main/apriltag/common/string_util.c
        src/main/apriltag/common/svd22.c
        src/main/apriltag/common/time_util.c
        src/main/apriltag/common/unionfind.c
        src/main/apriltag/common/workerpool.c
        src/main/apriltag/common/zarray.c
        src/main/apriltag/common/zhash.c
        src/main/apriltag/common/zmaxheap.c
        src/main/apriltag/tag16h5.c
        src/main/apriltag/tag25h9.c
        src/main/apriltag/tag36h10.c
        src/main/apriltag/tag36h11.c
        src/main/apriltag/apriltag_pose.c
)
# 统一优化参数
set(CMAKE_C_FLAGS_DEBUG "-O2 -g")
set(CMAKE_C_FLAGS_RELEASE "-O3 -DNDEBUG")

# 可能的 NEON 兼容优化（如果不稳定可去掉）
#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -mfpu=neon-fp16")

# C++11 兼容性（如果 AprilTag 代码用到 C++）
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

include_directories(src/main/apriltag/)

find_library(log-lib log)
find_library(jnigraphics-lib jnigraphics)
find_library(m-lib m)  # 手动链接数学库
target_link_libraries(apriltag ${log-lib} ${jnigraphics-lib} ${m-lib})

#STRING(REPLACE "-O0" "-O4" CMAKE_C_FLAGS_DEBUG ${CMAKE_C_FLAGS_DEBUG})
#STRING(REPLACE "-O2" "-O4" CMAKE_C_FLAGS_RELEASE ${CMAKE_C_FLAGS_RELEASE})
#
#
#include_directories(src/main/apriltag/)
#
#find_library(log-lib log)
#find_library(jnigraphics-lib jnigraphics)
#target_link_libraries(apriltag ${log-lib} ${jnigraphics-lib})
