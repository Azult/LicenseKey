import frida
import sys

session = frida.get_usb_device().attach('com.cyber.licensekey')
print "[*] Started"
print session
script = session.create_script("""
Java.perform(function(){
	console.log("Hooked!");
	var mainClass = Java.use("com.cyber.licensekey.CheckLicense");
	mainClass.checkLicense.overload("java.lang.String").implementation = function(license){
		console.log(license);
	    var ret = true;
	    return ret;
	};
})


""")

script.load()
sys.stdin.read()