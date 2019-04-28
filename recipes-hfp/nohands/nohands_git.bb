SUMMARY = "HFP for Linux is a Bluetooth Hands-Free Profile server."
DESCRIPTION = "It allows your Linux system to act as a speakerphone for \
your mobile phone. It aims to be a compliant Bluetooth HFP 1.5 \
Hands Free implementation, supporting all required commands and \
notifications, as well as streaming audio."
SECTION = "console/utils"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/heinervdm/nohands.git;protocol=https"

SRCREV = "${AUTOREV}"
PV = "0.1.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit distro_features_check qt4x11 autotools pkgconfig

REQUIRED_DISTRO_FEATURES = "bluetooth"

DEPENDS = "bluez5"

FILES_${PN} += "/usr/share/*"

PACKAGECONFIG = "alsa audiofile speexdsp dbus"
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[audiofile] = "--enable-audiofile,--disable-audiofile,audiofile"
PACKAGECONFIG[speexdsp] = "--enable-speexdsp,--disable-speexdsp,speexdsp"
PACKAGECONFIG[dbus] = "--enable-dbus,--disable-dbus,dbus"
