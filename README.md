# Desktop Popup App

Text and Image Popups.

set the Environment Variable RES_DIR to a folder containing images/ messages/ and config.txt

images: this folder should contain all images you want to display
messages: this folder should contain two files messages.txt and text-only-messages.txt
config.txt: this file should contain texts for UI-Elements. "closeButton" is the only available text.

use the following format:
closeButton=close;

the left side of the assignment is the key, the right side the value (without the ;)

Images are enhanced with texts from the messages.txt file
Text popups are from the text-only-messages.txt file

The program requires three arguments, all integer values in minutes.
1. the initial delay till the first popup
2. the maximal delay till the next popup
3. the minimal delay till the next popup

You can only set ALL or none of these values (default: 15 90 30)