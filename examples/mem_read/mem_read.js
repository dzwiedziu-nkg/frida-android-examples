const p = ptr("0x73cd0db0");

console.log("UTF-8:", p.readUtf8String());
console.log(hexdump(p, { length: 32 }));
