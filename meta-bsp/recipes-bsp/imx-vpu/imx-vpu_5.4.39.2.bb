# Copyright (C) 2013-2018 O.S. Systems Software LTDA.
# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

DESCRIPTION = "Freescale VPU library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6c12031a11b81db21cdfe0be88cac4b3"

PROVIDES = "virtual/imxvpu"
RPROVIDES_${PN} = "virtual/imxvpu"

PE = "1"

SRC_URI = "${FSL_MIRROR}/${BP}.bin;fsl-eula=true"
SRC_URI[md5sum] = "fb11619e07dafbc46a335c7db4c9b9a2"
SRC_URI[sha256sum] = "604885463ca7d292ddf376795ee95ae32abcc60512a3378e016b173222362900"

inherit fsl-eula-unpack use-imx-headers

PLATFORM = "IMX6Q"

do_compile() {
    INCLUDE_DIR="-I${STAGING_INCDIR_IMX}"
    oe_runmake CROSS_COMPILE="${HOST_PREFIX}" PLATFORM="${PLATFORM}" INCLUDE="${INCLUDE_DIR}" all
}

do_install() {
    oe_runmake PLATFORM="${PLATFORM}" DEST_DIR="${D}" install
    if [ "${libdir}" != "/usr/lib" ]; then
        install -d "$(dirname "${D}${libdir}")"
        mv "${D}/usr/lib" "${D}${libdir}"
    fi
    if [ "${includedir}" != "/usr/include" ]; then
        install -d "$(dirname "${D}${includedir}")"
        mv "${D}/usr/include" "${D}${includedir}"
    fi
    rmdir --ignore-fail-on-non-empty "${D}/usr"
}

# Compatible only for i.MX with Chips&Media VPU
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_imxvpucnm = "${MACHINE}"
