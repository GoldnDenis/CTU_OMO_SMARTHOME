# OMO: Smart Home


## TL;DR: Overview of the entire project 

At the start application loads configuration json file, if none was found a standard present is used. Configuration file defines the length of the simulation, inhabitants and the house itself. Structurally, the house is a collection of predesigned rooms where are located appliances that suit the theme.

In the simulation the minimal time unit is an hour. Each hour takes places some kind of action, either it's an interaction between creatures and appliances or some unexpected event, e.g. power shortage. Every interaction is outputed in the console and in the end 5 main report files are saved.

## Configuration parameters
- simulation_duration - an positive integer number which represents a number of days the simulation will play out.
- List<Creature> - a list of creatures, in format "name type". Available types are: {Adult, Child, Animal}
- List<Room> - a list of rooms in the House, in format "type". Available types are: {Living Room, Bedroom, Kitchen, Office, Shower}

### Room description:
- Living Room = {TV, Smart Speaker}
- Kitchen = {Stove, Drink Maker, Refrigerator, Food Dispenser}
- Office = {Computer, Smart Speaker}
- Bedroom = {TV, Smart Speaker, Computer}
- Shower = {Smart Speaker}

## Code structure

1. system: contains simulation related classes and general utility, such as RandomGenerator, ConfigReader and so on.
2. appliance: contains all appliance related objects: factory for creation, types, states, enumerations, event detectors.
3. creature: contains all creature related objects: factory for creation, types and event listeners.
4. event: contains utility classes for global event realization.
5. home: contains logic for constructing a home itself, which is done through a Builder.
5. report: contains classes responsible for the report generation.
6. sensor: contains global event detector logic, i.e. sensors.

## Report logs
- ActivityAndUsageReport - displays the activity of each creature through out the simulation, i.e. how many times each creature had used a specific types of appliances.
- CosumptionReport - displays a resouce consumption of every appliances through out the simulation.
- GlobalEventReport - displays how many times every posible global event had happened.
- LocalEventReport - displays how many times each of the appliances had been broken and by whom.
- HouseConfigurationReport - displays from which file was loaded a current configuration for the SmartHome and the configuration itself.

## Design patterns used

1. Observer - for event detection and notification
   >Classes: GlobalEventDetector, GlobalEventListener, Sensor, ApplianceAPI, LocalEventListener, CreatureAPI.
   
2. Builder - for house construction
   >Classes: RoomBuilder, RoomDirector.

3. State machine - for appliance state switching
   >States: Active, Broken, Idle and Off.
   
5. Factory - for appliance and creature creation
   >Classes: ApplainceFactory, CreatureFactory.

6. Facade - for incorporating only required methods from common utility Java classes
   >Classes: ConfigReader, RandomGenerator.
   
7. Mediator - to seize unnecessary initialization and interclass communication
   >Classes: ReportHub ( We belive it's also a facade )

8. Visitor - main logic for creature-appliance interaction
   >Classes: ApplianceAPI, CreatureAPI.

9. Bridge - to comply with the Demeter's rule
   >Throught the code, but especially classes: ApplianceAPI, CreatureAPI.

10. Streams - for a more efficient and pretty iteration through lists
   >Mainly inside of Simulation

11. Optional - for the sake of avoiding old and non-safe NULL
   >Both of factory classes use it: ApplainceFactory, CreatureFactory

12. Object Pool - pre-initialization of the object data and classes for further use in the simulation
   >Throught the code
