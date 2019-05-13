SUMMARY = "A very basic X11 image with a HFP console"

EXTRA_IMAGE_FEATURES = "splash package-management hwcodecs x11-base debug-tweaks ssh-server-openssh"

LICENSE = "MIT"

inherit core-image distro_features_check extrausers

REQUIRED_DISTRO_FEATURES = "x11"

EXTRA_USERS_PARAMS_append = " useradd -p '' -d /home/hfp -s /bin/sh -G pulse -g audio hfp; "

# xf86-input-libinput is the default input driver which is recommended by
# Xorg upstream, it's installed by XSERVER itself, but if you want to try
# other drivers, just uncomment the following line, the order would be:
# xf86-input-synaptics < xf86-input-evdev < xf86-input-libinput
HFP_INPUT_DRIVER ?= ""
# HFP_INPUT_DRIVER ?= "xf86-input-evdev"
# HFP_INPUT_DRIVER ?= "xf86-input-synaptics"

CORE_IMAGE_BASE_INSTALL += " \
    hfp-x-session \
    xrefresh \
    libexif \
    ${HFP_INPUT_DRIVER} \
    packagegroup-hfp-common \
"

ROOTFS_POSTPROCESS_COMMAND += " zap_empty_root_password; "

zap_empty_root_password () {
	if [ -e ${IMAGE_ROOTFS}/etc/shadow ]; then
		sed -i 's%^hfp::%hfp:*:%' ${IMAGE_ROOTFS}/etc/shadow
	fi
	if [ -e ${IMAGE_ROOTFS}/etc/passwd ]; then
		sed -i 's%^hfp::%hfp:*:%' ${IMAGE_ROOTFS}/etc/passwd
	fi
}
