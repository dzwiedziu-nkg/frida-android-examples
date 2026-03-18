# Example 1 – how to run

## Preparation

Install app-1.apk:

```bash
adb install app-1.apk
```

Create a frida agent and install dependencies:

```bash
frida-create -t agent
npm install
npm install frida-java-bridge
```

## Run

```bash
python load.py
```
