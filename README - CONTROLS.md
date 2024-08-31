### CONTROLS - DS PORTS:
* Standard Differential Drive with Joysticks on DS ports 2 and 3 (left and right, respectively)
* Differential Drive also possible on Xbox Controller DS port 0 with a change in Constants.java
* Subsystems are controlled on operator Xbox Controller on DS port 1
* The robot's drivetrain has a voltage limit. To temporarily remove the limit, hold down the operator controller left trigger. If released, it will return to its voltage limit.

### OPERATOR CONTROLS (see OperatorControls.png for graphical diagram):
* Intake is controlled by the right stick on the operator controller. Push up to intake, push down to outtake.
* Shooter is controlled by operator controller right trigger. Press and hold to spin up, release to allow for spin down. The amount you hold down affects the acceleration and final speed.
    * During spinup, ensure that no balls are touching the shooter wheels. If they are, use the feeder control in reverse.
    * Note that it will take multiple seconds for the shooter to fully spin up. Feeding early will result in lower exit velocity, for better or for worse.
* Once shooter is up to speed, use the operator controller left stick to control the feeder. Push up to push the ball into the shooter. Push down to push away the ball (for example, to clear the shooter to allow spinup).
* The Hood and Turret are controlled by the operator controller's DPad. Use the up and down buttons for the hood and the left and right buttons for the turret.
    * Note that there are currently no software limits, so ensure that you are not trying to pass a hard stop.

### OTHER NOTES:
* The robot's name is Atris. 
* The cost, when built, was roughly $4000-$6000.