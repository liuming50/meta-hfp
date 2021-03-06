SUMMARY = "Bluetooth Audio ALSA Backend"
HOMEPAGE = "https://github.com/Arkq/bluez-alsa"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=88dc1c98120259ae67b82222d7aff5c1"

SRC_URI = "git://github.com/Arkq/bluez-alsa.git;protocol=https;branch=master \
           file://0004-bluealsa-pcm-bump-the-trigger-after-pcm-prepare.patch \
"

SRCREV = "862a4b2cfd432444d62c00ee1394f6abd1433063"
# SRCREV = "${AUTOREV}"

PV = "1.3.1+git${SRCPV}"

SRC_URI += "file://bluez-alsa.service"

S  = "${WORKDIR}/git"

DEPENDS += "alsa-lib bluez5 systemd glib-2.0 sbc"

PACKAGECONFIG[aac]  = "--enable-aac, --disable-aac, "
PACKAGECONFIG[aptx] = "--enable-aptx,--disable-aptx,"
PACKAGECONFIG[ofono] = "--enable-ofono, --disable-ofono,"
PACKAGECONFIG[debug] = "--enable-debug, --disable-debug,"

inherit autotools pkgconfig systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "bluez-alsa.service"

PACKAGECONFIG += "ofono debug"

do_install_append () {
    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/bluez-alsa.service ${D}${base_libdir}/systemd/system
}

FILES_${PN} += "\
   ${datadir}/alsa/alsa.conf.d/20-bluealsa.conf\
   ${libdir}/alsa-lib/libasound_module_ctl_bluealsa.so\
   ${libdir}/alsa-lib/libasound_module_pcm_bluealsa.so\
"
