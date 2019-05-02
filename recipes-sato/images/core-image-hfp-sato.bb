DESCRIPTION = "Image with Sato, a mobile environment and visual style for \
mobile devices. The image supports X11 with a Sato theme, Pimlico \
applications, and contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs debug-tweaks ssh-server-openssh"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL_append = " \
    packagegroup-tools-bluetooth \    
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
    ofono \
    vim-tiny \
    i2c-tools \
    ntp \
    bluez5 \
    hostapd \
    iptables \
    procps \
"

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"
