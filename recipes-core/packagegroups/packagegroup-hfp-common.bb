SUMMARY = "HFP common packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PULSEAUDIO_PACKAGES = " \
	pulseaudio-server \
	pulseaudio-misc \
	pulseaudio-lib-bluez5-util \
	pulseaudio-module-bluetooth-policy \
	pulseaudio-module-bluez5-discover \
	ofono ofono-tests \
"

BLUEZ_AUDIO_PACKAGES = "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', '${PULSEAUDIO_PACKAGES}', 'bluez-alsa bluez-tools alsa-utils', d)}"

RDEPENDS_${PN} = " \
	wget \
	curl \
	${BLUEZ_AUDIO_PACKAGES} \
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
