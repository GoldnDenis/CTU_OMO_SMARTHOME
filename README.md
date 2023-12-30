# OMO Smart Home


## Functionality describtion

The application reads or creates json configuration, which is loaded to the program. During the simulation, every creature acts randomly (within defined limits and rules) and interacts with devices. All interactions are logged. Sensors simulate events detection by randomly generating one and sending the message to appliances.

## Possible values
- room type: Bathroom, Bedroom, Kitchen, LivingRoom, Toilet
- appliance name: Computer, Drink maker, Food dispenser, Refrigerator, Smart speaker, Stove, TV
- creatures: Adult, Child, Animal
- living name: any

Also there are some rules for the configuration:
1. Home must have at least 1 Room

## Structure

1. system: Contains main Simulation class and other helping classes, such as ConfigReader.
2. appliance: Contains all the logic for appliances factory for creation of appliances and also contains appliance states. Appliance is separated to two classes Appliance and ApplianceAPI.
3. creature: Contains all the logic for creatures factory for creation of creatures. Creature is separated to two classes Creature and CreatureAPI.
4. event: enum for global event types.
5. report: Classes responsible for report generation.
6. sensor: Contains all the logic for sensors. Their strategy and observer.
7. home: Contains structure of home and builder for rooms.

## Reports
- EventReport:
- CosumptionReport:
- ActivityAndUsageReport:

## Design patterns used

1. Observer
   >Classes: GlobalEventDetector, GlobalEventListener, Sensor, ApplianceAPI, LocalEventListener, CreatureAPI.
   
2. Builder
   >Classes: RoomBuilder, RoomDirector.

3. State machine
   >Devices can be Active, Broken, Idle and Off. Each state defines device's behavior and can only be changed according to defined rules.

4. Strategy
   >Sensors have strategies for different global events.

5. Factory
   >Classes: ApplainceFactory.

6. Facade
   >Classes: ConfigReader, RandomGenerator, Logging.
   
7. Visitor
   >Classes: ApplianceAPI, CreatureAPI.

8. Bridge:
   >Classes: ApplianceAPI, CreatureAPI.
