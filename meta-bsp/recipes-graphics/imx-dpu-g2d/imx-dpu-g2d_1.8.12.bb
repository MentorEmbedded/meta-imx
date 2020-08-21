require recipes-graphics/imx-dpu-g2d/imx-dpu-g2d_1.7.0.bb

LIC_FILES_CHKSUM = "file://COPYING;md5=983e4c77621568488dd902b27e0c2143"

SRC_URI[md5sum] = "0b63e8b50a4aa2841c819a8f48619933"
SRC_URI[sha256sum] = "e73fc5e168c4b6acc54a9a816bf87bc48066bc240a5077b8c788a2b518bcea3b"

RDEPENDS_${PN} += "libopencl-imx"