import Java from "frida-java-bridge";

send("agent loaded");

setTimeout(() => {
  send(`Java.available=${Java.available}`);

  if (!Java.available) {
    send("Java bridge not available in this process");
    return;
  }

  Java.perform(() => {
    try {
      send("inside Java.perform");

      const Activity = Java.use("com.example.a11x256.frida_test.my_activity");
      send("class resolved");

      const fun = Activity.fun.overload("int", "int");
      send("method resolved");

      fun.implementation = function (x: number, y: number) {
        send(`original fun(${x}, ${y})`);
        return fun.call(this, 2, 5);
      };

      send("hook installed");
    } catch (e) {
      send(`hook error: ${e}`);
    }
  });
}, 1000);
