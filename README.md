# OMO: Smart Home


## TL;DR: Overview of the entire project 

At the start application loads configuration json file, if none was found a standard present is used. Configuration file defines the length of the simulation, inhabitants and the house itself. Structurally, the house is a collection of predesigned rooms where are located appliances that suit the theme.

In the simulation the minimal time unit is an hour. Each hour takes places some kind of action, either it's an interaction between creatures and appliances or some unexpected event, e.g. power shortage. Every interaction is outputed in the console and in the end 5 main report files are saved.

## Configuration parameters
   For a more comfortable config creation, there is a class ConfigGenerator which is mostly prepared for the use in the main, needs just to be uncommented and edited (java doc is in place).

- simulation_duration - an positive integer number which represents a number of days the simulation will play out.
- List<Creature> - a list of creatures, in format "name type". Available types are: {Adult, Child, Animal}
- List<Room> - a list of rooms in the House, in format "type". Available types are: {Living Room, Bedroom, Kitchen, Office, Shower}

### Room description:
- Living Room = {TV, Smart Speaker}
- Kitchen = {Stove, Drink Maker, Refrigerator, Food Dispenser}
- Office = {Computer, Smart Speaker}
- Bedroom = {TV, Smart Speaker, Computer}
- Shower = {Smart Speaker}

[Code Structure]: #code-structure
## Code structure

1. system: contains simulation related classes and general utility, such as RandomGenerator, ConfigReader and so on.
2. appliance: contains all appliance related objects: factory for creation, types, states, enumerations, event detectors.
3. creature: contains all creature related objects: factory for creation, types and event listeners.
4. event: contains utility classes for global event realization.
5. home: contains logic for constructing a home itself, which is done through a Builder.
5. report: contains classes responsible for the report generation.
6. sensor: contains global event detector logic, i.e. sensors.

## Report logs
- ActivityAndUsageReport - displays the activity of each creature throughout the simulation, i.e. how many times each creature had used a specific types of appliances.
- ConsumptionReport - displays a resource consumption of every appliance throughout the simulation.
- GlobalEventReport - displays how many times every possible global event had happened.
- LocalEventReport - displays how many times each of the appliances had been broken and by whom.
- HouseConfigurationReport - displays from which file was loaded a current configuration for the SmartHome and the configuration itself.

## Design patterns used

1. Observer - for event detection and notification
   >Classes: GlobalEventDetector, GlobalEventListener, Sensor, ApplianceAPI, LocalEventDetector, LocalEventListener, CreatureAPI.
   
2. Builder - for house construction
   >Classes: RoomBuilder, RoomDirector.

3. State machine - for appliance state switching
   >States: Active, Broken, Idle and Off.
   
5. Factory - for appliance and creature creation
   >Classes: ApplianceFactory, CreatureFactory.

6. Facade - for incorporating only required methods from common utility Java classes
   >Classes: ConfigReader, RandomGenerator.
   
7. Mediator - to seize unnecessary initialization and inter class communication
   >Classes: ReportHub ( We believe it's also a facade )

8. Visitor - main logic for creature-appliance interaction. Appliances react differently to different creature types.
   >Classes: ApplianceAPI, CreatureAPI.

9. Bridge - to comply with the Demeter's rule
   >Throughout the code, but especially classes: ApplianceAPI, CreatureAPI.

10. Streams - for a more efficient and pretty iteration through lists
   >Mainly inside of Simulation

11. Optional - for the sake of avoiding old and non-safe NULL
   >Both of factory classes use it: ApplianceFactory, CreatureFactory

12. Object Pool - pre-initialization of the object data and classes for further use in the simulation
   >Throughout the code
   
## A checklist for the project's functional requirements
### (the requirements are in Czech)

- [x] F1: "Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity"
   > The SmartHome simulation consists of a House with rooms and appliances & different Creatures, like animals and people. Check out appliance, home and creature packages, [Code structure](#code-structure).
- [x] F2: "Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD."
   > All appliances in the house are divided on a data and API parts. Every interaction with them is through an API. (CreatureAPI class)
- [x] F3: "Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu"
   > Every appliance can be in one of 4 states: Active, Off, Idle and Broken. Depending on the state, it'll require a different amount of resources to work. All values are predefined in the enum - APPLIANCE_CONSUMP_INFO
- [x] F4: "Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem)"
   > Appliances have a data object that stores all information about its consumption.
- [x] F5: "Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu"
   > The application simulates time in hours when every Creature, which is not occupied, each single hour randomly interacts with one of the available appliances in the room. Each appliance has its own logic and special interactions.
- [x] F6: "Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo alert)"
   > Pretty much everything that was said in F5 is also in compliance with this requirement. 
- [x] F7: "Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními)."
   > Again, this requirement is tightly connected to F5 & F6. However, in addition to them, Creatures are never dormant. The logic is written so when there is none available appliances in the current room then the creature will change it and look for a new activity in another one. In case, there are absolutely no possible options - it'll entertain itself by training, sleeping or doing other leisure without appliance involvement.
- [x] F8 Vygenerování reportů:
   > All report classes in project have complying names with these requirements, in exception with EventReport which is divided into GlobalEventReport and LocalEventReport

  - [x]	HouseConfigurationReport: "veškerá konfigurační data domu zachovávající hieararchii - dům -> patro -> místnost -> okno -> žaluzie atd. Plus jací jsou obyvatelé domu."
      >A source and the configuration itself it being reported

  - [x]	EventReport: "report eventů, kde grupujeme eventy podle typu, zdroje eventů a jejich cíle (jaká entita event odbavila)"
      > Every possible event, global or local, being reported with an occurance rate and the source object

  - [x]	ActivityAndUsageReport: "report akcí (aktivit) jednotlivých osob a zvířat, kolikrát které osoby použily které zařízení."
      > All creatures accumulate information about their activity and then report it

  - [x]	ConsumptionReport: "kolik jednotlivé spotřebiče spotřebovaly elektřiny, plynu, vody. Včetně finančního vyčíslení."
      > A class from F4 requirement is being used to form a report about all resources that were consumed during the simulation by each appliance
- [x] F9 "Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je najdete. Hint: Modelujte jako jednoduché akce ...dokumentace je přístupná jako proměnná přímo v zařízení, nicméně se dotahuje až, když je potřeba."
   > Every appliance type has its own manual that defines an amount of time needed to fix it. An observer logic is being used to notify any capable creature, in our case any Adult, to fix it.
- [x] F10 "Rodina je aktivní a volný čas tráví zhruba v poměru. Když není volné zařízení nebo sportovní náčiní, tak osoba čeká."
   > Every creature either uses appliance or doing some other leisure activities, like sport. As mentioned before, we slightly reimagined this requirement so every creature has something to do every moment of the day, but functionally it can be rephrased as "an entity waits"
