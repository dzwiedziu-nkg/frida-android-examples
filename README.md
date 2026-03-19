# frida-android-examples

Original: https://github.com/11x256/frida-android-examples

Current status: 
- fixed `examples/1` example to work with frida 17.8.2 and Python 3.13 and Android 15.

New examples:
- `examples/mem_read` - read memory from a process running on a device

## Getting started

Install virtual environment and frida:

```bash
python3 -m venv .venv
source venv/bin/activate
pip install frida-tools
```

In Android Studio please create and run AVD with API 35 (Android 15) based on AOSP image (not Google Play).

Next, please launch in the console:

```bash
# for rooting device
adb root

# for download frida-server v 17.8.2
wget https://github.com/frida/frida/releases/download/17.8.2/frida-server-17.8.2-android-x86_64.xz -O frida-server.xz

# for MacOS based on M processor please use arm64 version:
wget https://github.com/frida/frida/releases/download/17.8.2/frida-server-17.8.2-android-arm64.xz -O frida-server.xz

# unpack frida-server
xz -d frida-server.xz

# upload frida-server to device
adb push frida-server /data/data
```

Please run `adb shell` and in rooted Android shell:

```bash
# go to directory with frida-server
cd /data/data

# allow to run frida-server
chmod +x frida-server

# run frida-server
./frida-server &
```

Now you can run examples.
