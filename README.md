## 내맘대로 컨벤션임 토달지 마셈

List가 null일 경우에는 emptyList 리턴
```` 
if (postList == null) Collections.<ResponsePostDto>emptyList();

{
    "successOrNot": "Y",
    "postList": [],
    "statusCode": "OK"
}
````

DTO가 null일 경우에는 successOrNot: "N", statusCode: "NO_DATA"로 리턴
````
NoDataModel noDataModel = new NoDataModel("N", "NO_DATA");

{
    "successOrNot": "N",
    "statusCode": "NO_DATA"
}
````