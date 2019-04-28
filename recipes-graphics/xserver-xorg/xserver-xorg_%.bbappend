FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-linux-Make-platform-device-probe-less-fragile.patch \
"

do_install_append () {
	chgrp video ${D}/usr/bin/Xorg
	chmod u+s,o=- ${D}/usr/bin/Xorg
}
