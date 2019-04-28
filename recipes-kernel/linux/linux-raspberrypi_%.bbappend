FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

python __anonymous () {
    d.appendVarFlag('do_unpack', 'cleandirs', ' ${WORKDIR}/configs')
}

SRC_URI_append = " \
    file://configs/hid-multitouch.cfg \
    file://configs/i2c-dev.cfg \
"

ROOTFS_DEVICE = "/dev/mmcblk0p2"

CMDLINE = "dwc_otg.lpm_enable=0 consoleblank=0 loglevel=1 quiet root=${ROOTFS_DEVICE} rootfstype=ext4 rootwait usbhid.mousepoll=0"

do_preconfigure () {
    if [ -f "${B}/.config" ]; then
        defconfig="${B}/.config"
    else
        defconfig="${WORKDIR}/defconfig"
    fi
    cat ${WORKDIR}/configs/*.cfg 2>/dev/null | while read line; do
        config=$(echo "$line" | grep -o 'CONFIG_[^= ]*')
        sed -i "/$config[ =]/d;" $defconfig
        echo "$line" >> $defconfig
    done
}
addtask preconfigure before do_configure after do_kernel_configme
