# Gift Exchange Service


To Start the application run below command at root folder 
**mvnw spring-boot:run**



#### Things considered 

* Minimal API's listed in doc
* Basic validation framework
* Rule: A person cannot be assigned to give gift to themselves
* Rule: A family member cannot be given gift to the same person more than once every 3 years
* Data is stored in collections and are thread safe
* Well Structure code for better readability 


##### Todo

* Gift selection algorithm can be improved using Graphs
* Write more unit test cases and edge cases for testing
* Note: You can use application.yml file to add last 3 years of gift exchange history. This can be improved to take input as restful endpoint.



## API Details

##### Get Gift Exchange Details for last computed users

```` 
GET /v1/gift/exchange

Sample Response Body:
[
    {
        "giverId": "MEMID1",
        "receiverId": "MEMID2"
    },
    {
        "giverId": "MEMID2",
        "receiverId": "MEMID1"
    }
]

````

##### Post Reshuffle Request

```` 
POST /v1/gift/exchange/shuffle


````

##### Create Member

```` 
POST /v1/member

Body:
{
    "name" : "Goutham"
}

````

##### Get Member

```` 
GET /v1/member/{memberId}

Body:
{
    "name" : "Goutham"
}

````

##### Insert/Update Member

```` 
GET /v1/member/{memberId}

Sample Body:
{
    "name" : "Venkat"
}

````
