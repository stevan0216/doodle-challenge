Challenge project for TX Services selection process

**Overview**:

Simple project for TX Services selection process, Doodle team.

Doodle is a Swiss online calendar tool for time management and coordinating meetings.

Main goal is to create Restful API with following functionalities:

1.List all polls created by a user

2.Search polls by its title

3 List all polls created after a certain date

Project is created using combination of Spring and MySQL. Postman was used for testing functionalities.

**Solution**

There were few steps in developing this solution:
1. Analyzing polls.json file
2. Creating database structure, grouping data in specific tables. Main tables are user, participant, poll, poll_option, proposal (option), preference and location.
3. Once the database was completed, coding phase started. Following Controller-Service-Repository pattern, corresponding classes were created.
4. Main class which contains business logic is PollServiceImpl. It's methods retrieve data using repository calls. Then, retrieved data is processed and encapsulated in matching DTO objects which are suited for moving around between layers. 
5. Testing different scenarios, fixing bugs and validating functionalities.

**If I had more time**

With a bit more time at my disposal, I would change few things:
1. Regarding data structure, I was forced to use one class/table for both, text poll options and date poll options. This leads to unused fields, depending on option type. I am sure there is a way to follow object-oriented principles and to create base class/table and derived classes/tables, so I would take my time find it.
2. I used simple queries to retrieve data, which are easy to create and to debug. The consequence of that approach is having more code inside main service classes. By creating more complex queries which can retrieve more data at once, service classes would be more simple, and maybe the performances would be better.
3. Take care of storing emojis in the database. 
4. Fix docker-compose. I am familiar with the concept, but I haven't previously worked with it, so I needed a bit more time.