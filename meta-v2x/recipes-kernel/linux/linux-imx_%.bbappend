FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_mx8dxl = " \
    file://0010-Add-FTRACE-support.patch \
    file://0011-Add-definition-of-v2x_kernel_event-and-V2x_LOG_EVENT.patch \
    file://0012-Add-example-use-of-V2x_LOG_EVENT-in-seco_mu.c.patch \
"