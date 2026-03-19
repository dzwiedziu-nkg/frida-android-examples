import frida
import sys

def on_message(message, data):
    print("[FRIDA]", message)

device = frida.get_usb_device(timeout=5)
pid = 3157
session = device.attach(pid)

with open("mem_read.js", "r", encoding="utf-8") as f:
    script = session.create_script(f.read())

script.on("message", on_message)
script.load()
