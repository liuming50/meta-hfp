SYSTEMD_PACKAGES = "${PN}-server"
PACKAGECONFIG[systemd] = "--enable-systemd-daemon --enable-systemd-login --enable-systemd-journal --with-systemduserunitdir=${systemd_unitdir}/system,--disable-systemd-daemon --disable-systemd-login --disable-systemd-journal,systemd"
