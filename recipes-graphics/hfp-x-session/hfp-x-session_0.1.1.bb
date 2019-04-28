SUMMARY = "Very simple session manager for X"
HOMEPAGE = "http://www.yoctoproject.org"

PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://hfp-x-session;endline=5;md5=b6430bffbcf05f9760e72938826b7487"

SECTION = "x11"
RCONFLICTS_${PN} = "matchbox-common"

SRC_URI = "file://hfp-x-session \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = "sudo"

inherit update-alternatives

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/hfp-x-session"
ALTERNATIVE_PRIORITY = "90"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/hfp-x-session ${D}/${bindir}
}
