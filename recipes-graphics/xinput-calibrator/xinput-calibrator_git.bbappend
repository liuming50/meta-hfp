do_install_append () {
	rm -f ${D}/etc/X11/Xsession.d/30xinput_calibrate.sh
	rm -f ${D}/etc/xdg/autostart/xinput_calibrator.desktop
}
