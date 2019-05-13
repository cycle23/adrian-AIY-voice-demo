# adrian-AIY-voice-demo

Adrian's Project for [Spark Program](www.sparkprogram.org) mentorship, Spring 2019.

[Google Slides Presentation](https://bit.ly/30cd1el)

1. Follow [AIY Voice Kit](https://aiyprojects.withgoogle.com/voice/) setup instructions
2. Add and start a service using the Python in this repository on the AIY Voice Kit. (ie: copy onto the Raspberry Pi at `/home/pi/AIY-voice-kit-python/src/examples/voice/` and follow [service install instructions](https://aiyprojects.withgoogle.com/voice/#makers-guide--run-your-app-at-bootup)).
3. Use [Android Studio](https://developer.android.com/studio) or similar to install the Android Application from this repository to a phone.
4. You will need to run on a shared local network (ie: a hotspot from the phone) between the application and the voice kit and modify the [IP address](https://github.com/cycle23/adrian-AIY-voice-demo/blob/master/app/src/main/java/com/example/animatedgif/ImageIntentService.java#L27) in the Android Application accordingly.
5. You can request the IP Address from the AIY Voice Kit via "OK Google, IP Address", or logging into the Raspberry Pi kernel.
6. Once running, use a phrase containing the word "dance" and one of the 5 preset dances, ie: "Hey Google, Do the marshmallow dance", or "OK Google, dance like Iconic".
7. The phone application should update to reflect the latest dance

References Used:
- [GifImageView for Android Apps](https://github.com/NihalPandya/demoUpload/blob/master/GifImageView.java)
- [HowTo Display Animated Gif in Android Application](http://www.gkmit.co/articles/how-to-display-animated-gif-in-an-android-application)
- [Android CountdownTimer Example](https://www.journaldev.com/9896/android-countdowntimer-example)
- [Android IntentService Example](https://www.zoftino.com/android-intentservice-example)
- [Android Volley HTTP Request](https://developer.android.com/training/volley/simple.html)
- [Simple HTTP Server With Python 3](https://daanlenaerts.com/blog/2015/06/03/create-a-simple-http-server-with-python-3/)
- [Python HTTP](https://www.acmesystems.it/python_http)
- [Python Threading Example](https://gist.github.com/sebdah/832219525541e059aefa)

Notes:
- This project was for a middle school student I mentored. The code was just put together as quickly as possible to achieve our goals, not to show software best practices.
- The use of IntentService may be overkill in this implementation since Volley is already placing web requests in the background.
