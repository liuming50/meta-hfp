FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://pulseaudio.service \
    file://pulseaudio-system.conf \
"

PACKAGECONFIG_append = " autospawn-for-root"

SYSTEMD_PACKAGES = "${PN}-server"
PACKAGECONFIG[systemd] = "--enable-systemd-daemon --enable-systemd-login --enable-systemd-journal --with-systemduserunitdir=${systemd_unitdir}/system,--disable-systemd-daemon --disable-systemd-login --disable-systemd-journal,systemd"

do_install_append () {
    install -m 0644 ${WORKDIR}/pulseaudio.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/pulseaudio-system.conf ${D}${sysconfdir}/dbus-1/system.d/
}
