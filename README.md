SMB Documents Provider
=======================

## What is this?
"SMB Documents Provider" provides access to SMB/CIFS (samba) shared folders via ASF (Android Storage access Framework).
All file managers that use ASF, includes Android's built-in "Files" app, and editors that use ASF will be able to access files on SMB.

This is a forked version of "[CIFS Documents Provider](https://github.com/wa2c/cifs-documents-provider)" that fixes a critical bug.

### Download APK:
[Releases](../../releases)

## What means "critical bug"?
Copying or editing corrupt files.

Steps to reproduce:
1. Copy a file with the same name and smaller file size as the file on SMB from Android's local storage.

or

1. Edit the file on SMB to a smaller size and save it.

## How to build:
Checkout to `SMB` branch and build.

### Changes:
- Fix file corruption during copying/editing.
- Add thumbnail to file browser.
- Change app name and id.

### Known issues:
- Unable to cancel during upload of large files.

This is a quick hack and I'm lazy.

