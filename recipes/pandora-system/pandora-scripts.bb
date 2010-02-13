DESCRIPTION = "Scripts to support system options on the OpenPandora."
LICENSE = "GPLV2"

COMPATIBLE_MACHINE = "omap3-pandora"

DEPENDS = "zenity dbus"
RDEPENDS = "zenity dbus"

PR = "r4"

SRC_URI = " \
          file://op_bright.sh \
          file://op_bright.desktop \
          file://op_cpuspeed.sh \
          file://op_cpuspeed.desktop \          
          file://op_wifi.sh \
          file://op_wifi.desktop \          
          file://op_bluetooth.sh \
          file://op_bluetooth.desktop \
          file://op_defaultgui.sh \
          file://op_defaultgui.desktop \
"

do_install() {
          install -d ${D}${prefix}/pandora/scripts/
          install -m 0755 ${WORKDIR}/op_bright.sh ${D}${prefix}/pandora/scripts/
          install -m 0755 ${WORKDIR}/op_cpuspeed.sh ${D}${prefix}/pandora/scripts/
          install -m 0755 ${WORKDIR}/op_wifi.sh ${D}${prefix}/pandora/scripts/
          install -m 0755 ${WORKDIR}/op_bluetooth.sh ${D}${prefix}/pandora/scripts/          
          install -d ${D}${datadir}/applications/
          install -m 0644 ${WORKDIR}/op_bright.desktop ${D}${datadir}/applications/
          install -m 0644 ${WORKDIR}/op_cpuspeed.desktop ${D}${datadir}/applications/
          install -m 0644 ${WORKDIR}/op_wifi.desktop ${D}${datadir}/applications/
          install -m 0644 ${WORKDIR}/op_bluetooth.desktop ${D}${datadir}/applications/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${prefix} ${datadir}"
