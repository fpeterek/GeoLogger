# GeoLogger

Android utility, which logs geolocation (latlon pairs) into a csv file. Latitude comes first, longitude second, values are separated by a semicolon. 
Values are, of course, chronologically sorted from oldest (at the very top of the file) to latest (at the very bottom). The app needs both location and 
storage permissions to function properly. Start logging by pressing the `Start` button. Stop by pressing the `Stop` button. There's literally one big useful
button, the other buttons do nothing, you can't possibly mess this up. Filenames include a timestamp to signify when a file was created. Files need to be extracted 
from the phone's storage manually.

Not a real app, it's a utility I use for scientific purposes. I just need some real life geo data to debug autonomous driving algorithms which utilize a GPS.
