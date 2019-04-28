ILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} += "${sysconfdir}/sudoers"

do_install_append() {
    echo "%sudo    ALL=(ALL:ALL) NOPASSWD: ALL" >> ${D}${sysconfdir}/sudoers
}
