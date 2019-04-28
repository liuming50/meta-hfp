RDEPENDS_${PN}_remove = "${@bb.utils.contains('PACKAGECONFIG', 'serial-getty-generator', '', 'systemd-serialgetty', d)}"

do_install_append () {
    rm -f ${D}${systemd_unitdir}/system/serial-getty*
    rm -f ${D}${sysconfdir}/systemd/system/getty.target.wants/getty*
    rm -f ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty*
}
