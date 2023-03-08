# mock-data-generator
Mock data generator which development with Spring framework. \
 \
This project can use for generation and serving mock data. Also type of mock data can be adjustable. 

## Request Fields
 \
 **dataCount:** This field define size of list of mock data. Upper limit was defined as 1000. Also this value could be changed within code. \
  \
 **items:** This field keep list of single mock data item definition. 'key' and 'type' areas should be assigned for this field. \
  \
 **key:** This field should be defined as a child of 'items' field. This area represent the name of variable. \
  \
 **type:** This field also should be defined as a child of 'items' field. This area represent the type of variable. In this project, use can enter 'id', 'number', 'text' and 'date' value for this field. Type of 'id' always generate unique text value. Type of 'number' generate random numbers which upper limit was assigned 1000 as a default.  Also precision value was set 2 for numbers. User can change this default values within the code. Type of 'text' generate character array which upper limit was assigned 20 as a default. Also this value can be changed. Type of 'date' generate incremantal date value. First date always is created randomly. Then the next dates generate by increasing day value.
 
 ## Example Request and Response
 
 **POST:** localhost:8085/api/generate
 
 Request Body:
 ```json
 {
    "dataCount": 5,
    "items": [
        {
            "key": "id_area",
            "type": "id"
        },
        {
            "key": "number_area",
            "type": "number"
        },
        {
            "key": "text_area",
            "type": "text"
        },
        {
            "key": "date_area",
            "type": "date"
        }
    ]
}
```

Response Body:

```json
{
    "data": [
        {
            "text_area": "GoEDZWBpniAqqyeXBvrR",
            "number_area": 154.72,
            "id_area": "ec8a6715-2f36-4257-80f4-e31c3c0117d1",
            "date_area": "1993-07-20T23:20:18.000+00:00"
        },
        {
            "text_area": "fzWSBOUURoZbwNlRhxpJ",
            "number_area": 456.18,
            "id_area": "533892f3-038f-4865-a5f9-827b4b30ab85",
            "date_area": "1993-07-21T23:20:18.000+00:00"
        },
        {
            "text_area": "jUdShBfkDoGbXHbRAoIB",
            "number_area": 102.22,
            "id_area": "619e6430-dc56-4f31-85a1-49dab163d316",
            "date_area": "1993-07-22T23:20:18.000+00:00"
        },
        {
            "text_area": "lSSaJXWoPxEGzAzZZmBc",
            "number_area": 186.42,
            "id_area": "c5b4600c-4e33-404b-a92c-989af7bbbe52",
            "date_area": "1993-07-23T23:20:18.000+00:00"
        },
        {
            "text_area": "YfinpPRTOfvTZRiOgqYX",
            "number_area": 293.12,
            "id_area": "7113b5e3-750b-4aad-8b0f-733777ca15c2",
            "date_area": "1993-07-24T23:20:18.000+00:00"
        }
    ]
}
```

## Installation & Starting Project

To install dependencies & run project:
``` 
cd <project_folder>
mvn spring-boot:run
```
