cmake_minimum_required(VERSION 3.6.0)
message(STATUS "CMAKE_VERSION ${CMAKE_VERSION}")

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(OpenMP REQUIRED)

add_library(foo STATIC src/main/cpp/Foo.cpp)
target_compile_options(foo PRIVATE ${OpenMP_CXX_FLAGS})
target_link_libraries(foo PUBLIC log ${OpenMP_CXX_FLAGS})

add_library(bar STATIC src/main/cpp/Bar.cpp)
target_compile_options(bar PRIVATE ${OpenMP_CXX_FLAGS})
target_link_libraries(bar PUBLIC log ${OpenMP_CXX_FLAGS})

add_library(fooJNI SHARED src/main/cpp/FooJNI.cpp)
target_link_libraries(fooJNI PUBLIC foo)

add_library(barJNI SHARED src/main/cpp/BarJNI.cpp)
target_link_libraries(barJNI PUBLIC bar)
