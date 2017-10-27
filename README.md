# Pimp My Fridge


                                                BIG PICTURE OF THE FRIDGE



The Pimp My Fridge Project, done by us, consists of making a USB Freezer which will allow the user to cool a can at the temperature he wants. It have also the ability to set the desired temperature in three different ways :

-	Set coarsely using a Slider.
-	Set more accurately by using the Spinner by entering the desired temperature.
-	See in real time the evolution of the temperature of the fridge thanks to a graph.
-	Being warned when the selected temperature is reached.

Other alerts have been put in place like as when the temperature reaches the dew point to avoid condensation on the can.
We also decided to warn the owner of the fridge when the door has been forgotten open and the percentage of humidity is also represented on the application.

Here's how it works:

We have created the casing with a 3D printer to serve as a fridge and also to contain all the electronic components.The Arduino Uno which bridges the gap between the electronic circuit (data flows in both directions) and the interface Java. We have an electronic assembly that makes it possible to operate the Peltier effect plate and its fan as well as the transistors and mosfets. This assembly allows us thanks to the DHT and the thermistor to recover the internal and external temperatures of the fridge to allow the system to have a maximum of efficiency.
All this is connected to the Arduino UNO which makes the connection between the electronic circuit and Java IHM.

Here's what it looks like inside the fridge:

[![3D prints](https://github.com/BAnais/Freezer_Project/blob/master/IMG_4134.JPG)]



                                                        SCHEMA 



Conception

Power management / Electronic design





                                                        FRITZING






3D printed components:

To integrate and hide all the electronic components in the fridge, we printed a plastic component using a 3D printer.



                                                   PICTURE MODELE 3D REALISED



Software


                                                      PICTURE INTERFACE JAVA















