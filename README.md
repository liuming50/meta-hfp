# meta-hfp
OpenEmbedded/Yocto BSP layer for HFP operating system


# Dependencies

```
URI: git://git.openembedded.org/openembedded-core.git
branch: master
revision: HEAD

URI: git://git.openembedded.org/bitbake.git
branch: master
revision: HEAD

URI: git://git.openembedded.org/meta-openembedded.git
branch: master
revision: HEAD

URI: git://git.yoctoproject.org/meta-raspberrypi.git
branch: master
revision: HEAD

URI: git://git.yoctoproject.org/meta-qt4.git
branch: master
revision: HEAD

```


# Getting started

meta-hfp consist of multiple Git repositories and repo is the tool that makes it easier to work with those repositories as a whole. Create a local bin/ directory, download the repo tool to that directory, and allow the binary executable with the following commands:

```
$ make -p ~/bin
$ curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
$ chmod a+x ~/bin/repo
$ export PATH=~/bin:$PATH
```


# Download the source

Create an empty directory that will hold the meta-hfp and Yocto source files and serve as the working directory. Enter the following commands to bring down the latest version of repo tool, including its most recent fixes. The URL specifies the manifest that refers various repositories used by meta-hfp, which are placed within the working directory. For now, a .repo folder is created to store the manifest and the metadata of the source repositories.

```
$ mkdir ~/hfp-workspace
$ cd ~/hfp-workspace
$ repo init -u https://github.com/liuming50/hfp-manifests.git -b master
```

Enter the following command to pull down the meta-hfp source tree to your working directory. The repo sync operation might take time depending on your Internet download speed.

```
$ repo sync
```


# Build the source (Only verified on Ubuntu-16.04 LTS)

Set up the environment:

```
$ cd ~/hfp-workspace
$ . hfp-init-build-env
$ bitbake core-image-hfp-sato
```


# Deploy the image to a SDCard (assume the SDCard is /dev/sdb on your host machine)

```
$ sudo dd if=~/hfp-workspace/build/tmp/deploy/images/raspberrypi3/core-image-hfp-sato-raspberrypi3.rpi-sdimg of=/dev/sdb
```

# Tested Hardware

The following undergo regular basic testing with their respective MACHINE types.
- raspberrypi3


# Submitting patches

You are encouraged to fork the mirror on [meta-hfp](https://github.com/liuming50/meta-hfp.git)
to share your patches.

Layer Maintainer: [Ming Liu](<mailto:liu.ming50@gmail.com>)
