# Linux

## Types

- `GNU / Linux`

- `Android / Linux`

- `* / Linux`

## Filesystem

- Hierarchy

- Starts at `/` (root)

- `/etc/` - config files for the distro installation

- `~` - home dir, same as `/home/username/`

- `/bin/` - most important commands are stored here

- `/sbin/` - administrator commands are stored here

- `/dev/` - most devices are represented here as files  

- `/usr/` - has almost all the directories that are in `/`, less important files are stored here, those that are not **required** to run the OS

- `/tmp/` - temporary place, the OS doesn't gurrantee that the files will stay

- `/var/` - config files which do not belong to any user; file logs

## File permissions

- RWX
	- **R**ead
	- **W**rite
	- E**x**ecute

- `d` - directory

- `c` - devices that is supposed to be read symbol by symbol (not necessarily)

- `b` - device that is read block by block

- `-` - file

- RWX RWX RWX - User, Group, Other

- XATTR 
	- System attributes

## Commands

- `cd` - change directory

- `ls` - list directories and files
	- `ls -a`
		- List all files, including invisible files (files that start with `.` (dot))
	- `ls -l` 
		- Lists files and their file permissions

- `mount` - mounting devices (USB Flash drives, other HDDs / SSDs)

- `sudo` - gives administrator privileges

- `chmod` - changes file permissions

- `touch` - create a file (or just update the last modified date on an already existing file)

## Useful shell script

```sh
cat /etc/passwd | \
while read LINE
do
    echo $LINE
done
```

- Used for reading lines of a file