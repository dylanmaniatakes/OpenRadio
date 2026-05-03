cmake_minimum_required(VERSION 3.22.1)

project(openradio_mbe LANGUAGES C CXX)

add_library(
    openradio_mbe
    SHARED
    openradio_mbe.cpp
    mbe/mbevocoder.cpp
    mbe/ambe3600x2400.c
    mbe/ambe3600x2450.c
    mbe/ecc.c
    mbe/mbelib.c
    imbe_vocoder/aux_sub.cc
    imbe_vocoder/basicop2.cc
    imbe_vocoder/ch_decode.cc
    imbe_vocoder/ch_encode.cc
    imbe_vocoder/dc_rmv.cc
    imbe_vocoder/decode.cc
    imbe_vocoder/dsp_sub.cc
    imbe_vocoder/encode.cc
    imbe_vocoder/imbe_vocoder.cc
    imbe_vocoder/imbe_vocoder_impl.cc
    imbe_vocoder/math_sub.cc
    imbe_vocoder/pe_lpf.cc
    imbe_vocoder/pitch_est.cc
    imbe_vocoder/pitch_ref.cc
    imbe_vocoder/qnt_sub.cc
    imbe_vocoder/rand_gen.cc
    imbe_vocoder/sa_decode.cc
    imbe_vocoder/sa_encode.cc
    imbe_vocoder/sa_enh.cc
    imbe_vocoder/tbls.cc
    imbe_vocoder/uv_synt.cc
    imbe_vocoder/v_synt.cc
    imbe_vocoder/v_uv_det.cc
)

target_include_directories(
    openradio_mbe
    PRIVATE
    .
    mbe
    imbe_vocoder
)

target_compile_definitions(
    openradio_mbe
    PRIVATE
    _GNU_SOURCE
)

target_link_libraries(
    openradio_mbe
    android
    log
    m
)
