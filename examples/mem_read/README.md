# mem_read example

## Prepare

1. Create a new Android project based on `Native C++` template.
2. Use `com.example.testndk` package or make according changes.
3. Overwrite existing files in project form `./android`.

## Run

1. Run Android app.
2. Press read `buffer addr=` from logs in logcat.
3. Copy addr to `mem_read.js` in `const p = ptr(`.
4. Run `frida-ps -Uai | grep testndk` and read PID of working `com.example.testndk` app.
5. Copy PID to `loader.py` to `pid = `.
6. Run `python loader.py`.

You should see something like:

```hexdump
UTF-8: SECRET_ABC_123
           0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F  0123456789ABCDEF
73cd0db0  53 45 43 52 45 54 5f 41 42 43 5f 31 32 33 00 00  SECRET_ABC_123..
73cd0dc0  30 00 00 00 00 00 00 00 22 00 00 00 00 00 00 00  0.......".......
```
