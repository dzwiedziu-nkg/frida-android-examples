import os
import sys
import frida

APP = "com.example.a11x256.frida_test"

def on_message(message, data):
    print("[FRIDA]", message)

compiler = frida.Compiler()
bundle = compiler.build("agent.ts", project_root=os.getcwd())

device = frida.get_usb_device(timeout=5)
pid = device.spawn([APP])
session = device.attach(pid)

script = session.create_script(bundle)
script.on("message", on_message)
script.load()

device.resume(pid)
sys.stdin.read()
