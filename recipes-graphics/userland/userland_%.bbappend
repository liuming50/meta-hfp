RPROVIDES_${PN}_remove = "libgl1"
RDEPENDS_${PN}_remove = "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "libegl1", "", d)}"
RDEPENDS_${PN}_append = " ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "libegl-mesa", "", d)}"
