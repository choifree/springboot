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

단건 조회시 데이터가 없을 경우에는 successOrNot: "N", statusCode: "NO_DATA"로 리턴
````
NoDataModel noDataModel = new NoDataModel("N", "NO_DATA");

{
    "successOrNot": "N",
    "statusCode": "NO_DATA"
}
````
패키지명이 enum일때 java class 생성이 안되는 이슈가 있어서 enum 패키지는 _enum으로 생성함