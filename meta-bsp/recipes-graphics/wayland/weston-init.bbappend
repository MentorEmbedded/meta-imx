FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://profile"

SRC_URI_append_mx8dx = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', ' file://weston.config', '', d)}"

do_install_append() {
    install -Dm0755 ${WORKDIR}/profile ${D}${sysconfdir}/profile.d/weston.sh
}
