SUMMARY = "HFP common packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
	util-linux-lscpu \
	libgl-mesa \
	libegl-mesa \
	libgbm \
	libglapi \
	libgles1-mesa \
	libgles2-mesa \
	htop \
	grep \
	sed \
	dstat \
	pulseaudio \
	ofono \
	nohands \
	vim-tiny \
	i2c-tools \
	ntp \
	bluez5 \
	hostapd \
	iptables \
	wpa-supplicant \
	procps \
	virtual/network-configuration \
"
