# Associate Developer Python Practice Questions

Date: 19/02/3023

Result: 17/28 (61%)

Source: [Quiz](https://learn.mongodb.com/learn/course/associate-developer-python-practice-questions/prep-questions/practice-questions)


# Questions

## 1 - What numeric type is a valid MongoDB BSON type?

```diff
+ Correct Answer
```

```
A. Float
No such type, it's Double

B. Number
This not a BSON type

C. BIGINT
This not a BSON type

D. 32-bit integerYour Answer 
This is correct.
```


## 2 - Given the following documents in a collection:
```python
{ _id: 1, n: [1,2,5], p: 0.75, c: 'Green' },
{ _id: 2, n: 'Orange', p: 'Blue', c: 42, q: 14 },
{ _id: 3, n: [1,3,7], p: 0.85, c: 'Orange' }
```
Which two documents can successfully be added in the same collection?

```diff
+ Correct Answer
```


```
A. { _id: 1, n: [1,2,5], p: 0.75, c: 'Green' }
Wrong, _id 1 exists already

B. { _id: 5, n: [1,2,5], p: 0.75, c: 'Green' }Your Answer 
This is correct.

C. { _id: 2, n: [1,2,5], p: 0.75, c: 'Green' }
Wrong, _id 2 exists already

D. { _id; 6, n: [1,3,7], p: 0.85, c: 'Orange }Correct Answer
This is correct.
```


## 3 - Given the following documents in a collection:

```python
{_id: 1, txt: "just some text"},
{_id: 2, txt: "just some text"}
```
Which two documents can successfully be added in the same collection?

```diff
+ Correct Answer
```

```
A. {_id: 0, txt: "just some text"}Your Answer 
This is correct.

B. {_id: 1, txt: "just some text"}
Wrong, duplicate key error on _id

C. {_id: [4], txt: "just some text"}
Wrong, _id must not be an array

D. {_id: 3, txt: "just some text"}Your Answer 
This is correct.
```



## 4 - Given the following document:

The name is a.log, the owner of the file is applicationA, the size of the file is 1KB, and the file was deleted.

What command will properly add this document to the files collection using mongosh?

```diff
+ Correct Answer
```

```
A. db.files.insertOne({ file: "a.log", owner: "applicationA", size: 1KB, deleted: true })
Incorrect. Size should be a number or a string "1KB"

B. db.files.insertOne({ file: "a.log", owner: "applicationA", size: 1KB, deleted: True })
Incorrect. Size should be a number or a string "1KB". True is not a boolean value in mongosh.

C. db.files.insertOne({ file: "a.log", owner: "applicationA", size: 1024, deleted: true })Your Answer 
This is correct.

D. db.files.insertOne({ file: "a.log", owner: "applicationA", size: 1024, deleted: True })
Incorrect. True is not a boolean value in mongosh.
```


## 5 - Given the following sample documents in products collection:

```python
{ "name" : "XPhone", "price" : 799, "color" : [ "white", "black" ], "storage" : [ 64, 128, 256 ] },
{ "name" : "XPad", "price" : 899, "color" : [ "white", "black", "purple" ], "storage" : [ 128, 256, 512 ] },
{ "name" : "GTablet", "price" : 899, "color" : [ "blue" ], "storage" : [ 16, 64, 128 ] },
{ "name" : "GPad", "price" : 699, "color" : [ "white", "orange", "gold", "gray" ], "storage" : [ 128, 256, 1024 ] },
{ "name" : "GPhone", "price" : 599, "color" : [ "white", "orange", "gold", "gray" ], "storage" : [ 128, 256, 512 ] }
```
Given the following query:

```sh
db.products.find(
     {
          $and : [
               {"price" : {$lte : 800}},
               {$or : [{"color" : "purple"}, {"storage" : 1024}]}
          ]
     }
)
```
What is the correct output of the query?

```diff
- Incorrect Answer
```


```
A. { "name" : "XPhone", "price" : 799, "color" : [ "white", "black" ], "storage" : [ 64, 128, 256 ] },
Incorrect. Storage does not include 1024 nor color does not include purple.

B. { "name" : "XPad", "price" : 899, "color" : [ "white", "black", "purple" ], "storage" : [ 128, 256, 512 ] }Your Answer 
Incorrect.  Price must not be greater than 800.

C. { "name" : "GPhone", "price" : 599, "color" : [ "white", "orange", "gold", "gray" ], "storage" : [ 128, 256, 512 ] }
Incorrect. Storage does not include 1024 nor color does not include purple.

D. { "name" : "GPad", "price" : 699, "color" : [ "white", "orange", "gold", "gray" ], "storage" : [ 128, 256, 1024 ] }Correct Answer
This is correct.
```



## 6 - An `inventory` collection consists of 200 documents.

What method should be used to get all documents from a cursor using mongosh?

```diff
- Incorrect Answer
```

```
A. `db.inventory.findOne()`
Wrong, the findOne() method returns a single document.

B. `db.inventory.find().toArray();`Correct Answer
This is correct. This method returns an array that contains all documents returned by the cursor.

C. `db.inventory.find();`Your Answer 
Wrong, find returns a cursor

D. `db.inventory.findMany().toArray()`
Wrong, you cannot convert a collection to an array like this, no such function findMany.
```





## 7 - A collection has documents like the following:

```python
{ _id: 1, name: 'Oatmeal Fruit Cake with Gummy Bears ', price: 11}
{ _id: 2, name: 'Cheesecake Trifle with Chocolate Sprinkles ', price: 14}
{ _id: 3, name: 'Pistachio Brownie with Walnuts ', price: 5},
{ _id: 4, name: 'Strawberry Ice Cream Cake with Butterscotch Syrup ', price: 3}
```
How should the 'autocomplete' index be defined to look for matches at the beginning of a word on the name field?

```diff
- Incorrect Answer
```

```
A. {  "mappings": {    "dynamic": false,    "fields": {         "name": [   {  "type": "autocomplete",                              "tokenization": "regexCaptureGroup"} ]     } }}Your Answer 
Wrong index definition. "regexCaptureGroup" tokenization does not look only at the beginning of a word.

B. {  "mappings": {    "dynamic": false,    "fields": {         "name": [   {  "type": "autocomplete",                              "tokenization": "edgeGram"} ]    } }}Correct Answer
This is correct.

C. {  "mappings": {    "dynamic": false,    "fields": {         "name": [   {  "type": "autocomplete",                              "tokenization": "nGram"} ]    } }}
Wrong index definition. "nGram" tokenization does not look only at the beginning of a word.

D. {  "mappings": {    "dynamic": false,    "fields": {         "name": [   {  "type": "autocomplete",                              "tokenization": "matchNGram"}} ]     } }}
Wrong index definition. "matchNGram" is not a valid tokenization algorithm.
```



## 8 - Given the following sample documents:

```python
{_id:1, name: "Quesedillas Inc.", active: true },
{_id:2, name: "Pasta Inc.", active: true },
{_id:3, name: "Tacos Inc.", active: false },
{_id:4, name: "Cubanos Inc.", active: false },
{_id:5, name: "Chicken Parm Inc.", active: false }
```

A company wants to create a mobile app for users to find restaurants by name. The developer wants to show the user restaurants that match their search. An Atlas Search index has already been created to support this query.

What query satisfies these requirements?

```diff
- Incorrect Answer
```

```
A. db.restaurants.aggregate([{    "$search": {      "text": { "path": "name", "synonym": "cuban"}    } }])
Incorrect usage of boolean logic with $and in query.

B. db.restaurants.aggregate([{    "$search": {      "text": { "path": "name", "query": "cuban"}    } }])Correct Answer
This is correct.

C. db.restaurants.aggregate([{    "$search": {      "text": { "field": "name", "query": "cuban"}    } }])Your Answer 
Not correct usage of query.

D. db.restaurants.aggregate([{    "$search": {      "text": { "field": "name", "synonym": "cuban"}    } }])
Not correct usage of query.
```



## 9 - Given the data set and query:

```bash
{ "_id" : ObjectId("512bc95fe835e68f199c8686"), "player" : "p1", "score" : 89 }
{ "_id" : ObjectId("512bc962e835e68f199c8687"), "player" : "p2", "score" : 85 }
{ "_id" : ObjectId("55f5a192d4bede9ac365b257"), "player" : "p2", "score" : 65 }
{ "_id" : ObjectId("55f5a192d4bede9ac365b258"), "player" : "p3", "score" : 65 }
{ "_id" : ObjectId("55f5a1d3d4bede9ac365b259"), "player" : "p3", "score" : 75 }
{ "_id" : ObjectId("55f5a1d3d4bede9ac365b25a"), "player" : "p5", "score" : 70 }
{ "_id" : ObjectId("55f5a1d3d4bede9ac365b25b"), "player" : "p6", "score" : 100 }

db.scores.aggregate(
[{ $group: {
      _id: '$player',
      score: {
           $avg: '$score'
      }
 },
 { $match: {
     score: { 
            $gt: 70
      }
 }
])
```
What is the output?​

```diff
- Incorrect Answer
```

```
A. { "player" : "p1", "score" : 89 } { "player" : "p2", "score" : 85 } { "player" : "p3", "score" : 75 } { "player" : "p6", "score" : 100 }Your Answer 
Not correct average scores

B. { "player" : "p1", "score" : 89 } { "player" : "p2", "score" : 75 } { "player" : "p6", "score" : 100 }Correct Answer
This is correct.

C. { "player" : "p1", "score" : 89 } { "player" : "p2", "score" : 75 } { "player" : "p3", "score" : 70 } { "player" : "p5", "score" : 70 } { "player" : "p6", "score" : 100 }
Incorrect.  includes results not greater than 70

D. { "player" : "p1", "score" : 89 } { "player" : "p2", "score" : 75 } { "player" : "p3", "score" : 70 } { "player" : "p6", "score" : 100 }
Incorrect.  includes results not greater than 70
```


## 10 - A collection 'coll' in database 'mdb' has the following documents :

```bash
{_id: 1, type: "A", value: 60}
{_id: 2, type: "B", value: 80}
{_id: 3, type: "C", value: 10}
```
After executing the following aggregation pipeline:

```bash
db.getSiblingDB("mdb").coll.aggregate([
    { $out: {db:'test', collection:'results'}} ])
```
What are two expected results?

```diff
- Incorrect Answer
```

```
A. Collection 'results' is created in database 'test'.
This is incorrect.

B. There is a syntax error command. Collection 'results' is not created.Correct Answer
This is correct.

C. No documents in collection 'coll' are written to collection 'results'.Correct Answer
This is correct.

D. All documents in collection 'coll' are written to collection 'results'.Your Answer 
This is incorrect.
```



## 11 - Given the following documents:

```bash
{_id:1, a: "one", b: "four"}
{_id:2, a: "two", b: "four"}
{_id:3, a: "three", b: "four", c: "three"}
```
If the following command is executed:

```bash
db.coll.replaceOne({}, {a: "ten", b: "five"})
```
What is the result?

```diff
+ Correct Answer
```

```
A. {_id:1, a: "ten", b: "five"} {_id:2, a: "ten", b: "five"} {_id:3, a: "ten", b: "five"}
Wrong answer. All documents are changed.

B. {_id:1, a: "ten", b: "five"} {_id:2, a: "two", b: "four"} {_id:3, a: "three", b: "four", c: "three"}Your Answer 
This is correct.

C. {_id:1, a: "ten", b: "five"} {_id:2, a: "ten", b: "five"} {_id:3, a: "ten", b: "five", c: "three"}
Wrong answer. All documents are changed.

D. {_id:1, a: "one", b: "four"} {_id:2, a: "two", b: "four"} {_id:3, a: "three", b: "four", c: "three"}
Wrong answer. No document is changed.
```


## 12 - Given the collection called "coll," with only the following documents,

```bash
{
 _id:1,
 a:1,
 b:1
},
{
 _id:2,
 a:2
}
```
The update operation db.coll.updateMany({},{$set:{b:2}}) successfully completes.

What is the output of db.coll.find()?

```diff
+ Correct Answer
```

```
A. [{_id:1,  b:2}, {_id:2,  b:2}]
This answer is incorrect. Because "a" is not included in the $set operation, it will not change or be unset.

B. [{_id:1,  a:1,  b:2}, {_id:2,  a:2}]
This answer is incorrect. the $set operator will create a new field if it doesn't already exist. UpdateMany will update all documents in the collection.

C. [{_id:1,  a:1,  b:1}, {_id:2,  a:2,  b:2}]
This answer is incorrect. It does not accurately represent the $set functionality that updates a field that already exists.

D. [{_id:1,  a:1,  b:2}, {_id:2,  a:2,  b:2}]Your Answer 
This is correct.  The $set operator will update a field if it exists, and add a new field if it doesn't exist.
```



## 13 - Given the following document from the cakeFlavors collection. All documents in this collection have the same schema.

```bash
{
"_id" : 1,
"flavor" : "chocolate",
"number" : 15
}
```
What operation on the "cakeFlavors" collection will update the value of the number field to 100 for a document with a "strawberry" flavor value and insert a new document if it does not exist?

```diff
- Incorrect Answer
```

```
A. db.cakeFlavors.updateOne({ flavor: "strawberry"} , { $set: { number: 100 } }, { $upsert: true })Your Answer 
Incorrect.  This updates the value of the number field to 100. However, this shouldn't insert a new document if it does not exist. $upsert will NOT cause a syntax error, but it will be just ignored.

B. db.cakeFlavors.insertOne({ flavor: "strawberry"} , { $set: { number: 100 } }, { $upsert: true })
Incorrect.  This will always add a new document and not update the matched document.

C. db.cakeFlavors.insertOne({ flavor: "strawberry"} , { $set: { number: 100 } }, { upsert: true })
Incorrect.  This will always add a new document and not update the matched document.

D. db.cakeFlavors.updateOne({ flavor: "strawberry"} , { $set: { number: 100 } }, { upsert: true })Correct Answer
This is correct.
```


## 14 - Given the following example document from the movie collection:

```bash
{
   _id: ObjectId("62872ccd590c3c06d78af00d"),
   genres: [ "Drama", "Romance", "War" ],
   title: "A.B.",
   year: 1921,
   tomatoes: { rating: 3.9, votes: 507, id: "76" },
   countries: [ "USA" ],
   classic : false
}
```
All documents in this collection have the same schema.

What command updates the value of the classic field to true for all documents with a year value less than 2000?

```diff
- Incorrect Answer
```

```
A. db.movie.updateOne({ year: { $lt: 2000 } }, { $set: { classic: true } }, { multi: true })
Incorrect.  This parameter "multi" is not available for updateOne.

B. db.movie.updateMany({ year: { $lt: 2000 } }, { $set: { classic: true } })Your Answer 
This is correct.

C. db.movie.updateMulti({ year: { $lt: 2000 } }, { $set: { classic: true } })
Incorrect.  updateMulti is invalid.

D. db.movie.updateBulk({ year: { $lt: 2000 } }, { $set: { classic: true } })Your Answer 
Incorrect.  updateBulk is invalid.
```


## 15 - Given the following sample documents in the loans collection:

```bash
{ _id: 122, book: "ABC", name: "L.A.", date: ISODate("2022-05-20") },
{ _id: 343, book: "EFF", name: "T.B.", date: ISODate("2022-05-22") },
{ _id: 454, book: "CFH", name: "M.C.", date: ISODate("2022-05-12") }
```

What command deletes document which book is "EFF" and user is "T.B.", and returns the deleted document?

```diff
- Incorrect Answer
```

```
A. db.loans.deleteOne( { book: "EFF", name: "T.B." } )
This does not return the deleted document.

B. db.loans.findOneAndDelete( { book: "EFF", name: "T.B." } )Correct Answer
This is correct.

C. db.loans.remove( { book: "EFF", name: "T.B." } , {returnDocument: true} )
This does not return the deleted document.

D. db.loans.deleteOne( { book: "EFF", name: "T.B." }, {returnDocument: true} )Your Answer 
This does not return the deleted document.
```



## 16 - Given the following sample documents in the inventory collection:

```bash
{ _id: 6305, name : "A. S.", "assignment" : 5, "status" : "A" },   
{ _id: 6308, name : "B. M.", "assignment" : 3, "status" : "B" },   
{ _id: 6312, name : "E. M.", "assignment" : 5, "status" : "C" },   
{ _id: 6319, name : "R. S.", "assignment" : 2, "status" : "D" },   
{ _id: 6322, name : "A. S.", "assignment" : 2, "status" : "A" },   
{ _id: 6234, name : "R. S.", "assignment" : 1, "status" : "B" },
{ _id: 6235, name : "A. S.", "assignment" : 1, "status" : "C" },
{ _id: 6315, name : "E. M.", "assignment" : 3, "status" : "A" }
```

What expression will remove all documents with "status" : "C" in the inventory collection?

```diff
+ Correct Answer
```

```
A. db.inventory.delete ({"status" : "C"})
Incorrect.  No command called delete.

B. db.inventory.deleteOne ({"status" : "C"})
Incorrect.  This will delete only one matching document.

C. db.inventory.deleteMany ({"status" : "C"})Your Answer 
This is correct.

D. db.inventory.findOneAndDelete ({"status" : "C"})
Incorrect. This will delete and return only one matching document.
```


## 17 - Given the following documents in the ratings collection:

```bash
{ _id: 0, hotel: "AAA", rating: 4.5 },
{ _id: 1, hotel: "BBB", rating: 3.0 },
{ _id: 2, hotel: "CCC", rating: 4.2 }
```
What mongosh command will return a document for hotel "CCC"?

```diff
+ Correct Answer
```

```
A. db.ratings.return_one( {hotel: "CCC"} )
No such command.

B. db.ratings.find_one( {hotel: "CCC"} )
No such command.

C. db.ratings.returnOne( {hotel: "CCC"} )
No such command.

D. db.ratings.findOne( {hotel: "CCC"} )Your Answer 
This is correct.
```


## 18 - The following query generates a collection scan:

```bash
db.people.find({employer : "ABC" }).sort ({last_name:1 , job:1})
```

Which two indexes will most improve the performance of the query?

```diff
- Incorrect Answer
```

```
A. db.people.createIndex({employer:1, last_name : 1  , job : 1 } )Your Answer 
This is correct.  The sort order of the query matches the sort order of the index construct

B. db.people.createIndex({employer:1, last_name : -1  , job : -1 } )Correct Answer
This is correct. The sort order of the query is the exact opposite of the sort order on the index construct thus enabling the DB to leverage the index in reverse.

C. db.people.createIndex({employer:1,last_name : -1  , job : 1 } )
Incorrect. The sort order of the query does not match the sort of order on the index construct

D. db.people.createIndex({employer:1,last_name : 1  , job : -1 } )Your Answer 
Incorrect. The sort order of the query does not match the sort of order on the index construct
```


## 19 - Given a collection called "collection," in which all documents have the following shape:

```bash
{
 _id:1,
 objs:[
   {a:1,b:2},{a:2,b:1}
 ] 
}
```

And the query on this collection:

```bash
db.collection.find({"objs.a":1})
```
What index will support this query?

```diff
+ Correct Answer
```

```
A. {"objs.a":1}Your Answer 
This is correct.

B. {objs:1}
Incorrect. This index will only help with exact equality matches on the object "obj"

C. {objs:1,"objs.a"1}
Incorrect. {"objs.a":1} which is the correct index is not part of the index prefix.

D. {objs:1,"a"1}
Incorrect.This index doesn't cover queries on "objs.a"
```


## 20 - Given the following query:

```bash
db.coll.find({}).sort({"product": 1, "price": 1})
```
Which two indexes will improve the performance of this query?

```diff
+ Correct Answer
```

```
A. {"product": 1, "price": 1}Your Answer 
This is correct. Index is used for the sort regularly.

B. {"product": 1, "price": -1}
Incorrect. The price field is not sorted in correct order.

C. {"product": -1, "price": 1}
Incorrect. The price field is not sorted in reverse order as product is.

D. {"product": -1, "price": -1}Your Answer 
This is correct, index is used for the sort backwards.
```


## 21 - Given the following query:

```bash
db.coll.find({}).sort({"product": 1, "price": 1})
```
Which two indexes improve the performance of this query the most?

```diff
+ Correct Answer
```

```
A. { v: 2, key: { price: 1, product: 1 }, name: 'price_1_product_1' }
Incorrect. Compound index field order must match sort field order.

B. { v: 2, key: { product: 1, price: 1 }, name: 'product_1_price_1' }Your Answer 
This is the correct answer, { product: 1, price: 1 } and { product: -1, price: -1 }

C. { v: 2, key: { price: -1, product: -1 }, name: 'price_-1_product_-1' }
Incorrect. Compound index field order must match sort field order.

D. { v: 2, key: { product: -1, price: -1 }, name: 'product_-1_price_-1' }Your Answer 
This is the correct answer, { product: 1, price: 1 } and { product: -1, price: -1 }
```


## 22 - What mongosh command shows how many indexes are associated with an inventory collection?

```diff
+ Correct Answer
```

```
A. db.inventory.getIndexes()Your Answer 
This is correct. Returns an array that holds a list of documents that identify and describe the existing indexes on the AB collection

B. db.inventory.indexes()
This command does not exist.

C. db.inventory.showIndexes()
This command does not exist.

D. db.inventory.displayIndexes()
This command does not exist.
```


## 23 - A typical products collection is in an e-commerce database.

What schema is the most effective?

```diff
+ Correct Answer
```

```
A. Orders for products should be embedded as an array in each product document.
Incorrect. Since there can be a huge number of orders, they should not be embedded.

B. Reviews for products should be embedded as an array in each product document.
Incorrect. Since there can be a huge number of reviews, they should not be embedded.

C. Current and historical prices for product should be embedded in each product document.
Incorrect. Since there can be a large number of historical prices, they should not be embedded (current price absolutely should be).

D. Current inventory/availability for product should be embedded in each product document.Your Answer 
This is correct.
```


## 24 - A Cooking dataset is in Atlas. There is a "Recipes" database with a "Desserts" collection.

How can one document be found that provides a recipe for cookies without chocolate using Atlas Data Explorer?

```diff
- Incorrect Answer
```

```
A. 1. Select the collection on the left-hand side. 2. Select the "Aggregation" view. 3. Specify the first stage as $match query: {dessert_type: "Cookie"} 4. Specify the second stage as $match query: {ingredients: {$all: ["chocolate"]}}. 5. Set $limit to 1.
Incorrect. This uses the aggregation pipeline, but it returns one documents for a cookie recipe that does include chocolate in the ingredients.

B. 1. Select the collection on the left-hand side. 2. Select the "Aggregation" view. 3. Specify the first stage as $match query: {dessert_type: "Cookie", ingredients: {$nin: ["chocolate"]}}. 4. Set $limit to 1.Correct Answer
This is correct. This properly uses the aggregation pipeline. The $nin operator will exclude documents with "chocolate" in the ingredients array, and the limit is set to return only 1 document.

C. 1. Select the collection on the left-hand side. 2. Specify the "Find" view. 3. Specify the filter query: {dessert_type: "Cookie", ingredients: {$nin: ["chocolate"]} 4. Specify the project query: {dessert_type: 1}.
Incorrect.  This properly filters on the cookie recipes without chocolate. However, project does not limit the number of documents returned; it only limits the fields returned within each matching document.

D. 1. Select the collection on the left-hand side. 2. Specify the "Find" view. 3. Specify the filter query with limit: {dessert_type: "Cookie", ingredients: {$nin: ["chocolate"], $limit: 1}Your Answer 
Incorrect. The filter query is correct until the $limit addition. Functionally it looks correct, but the syntax is wrong and will cause the filter to fail when applied.
```


## 25 - What Python code is a valid aggregation that can be used with collection.aggregate(pipeline)?


```diff
+ Correct Answer
```

```
A. { "$match": { "categories": "Bakery" } }
Pipeline must be an array of stages.

B. { "$match": { "categories" = "Bakery" } }
Pipeline must be an array of stages and cannot use = syntax.

C. [    { "$match": { "categories": "Bakery" } },    { "$group": { "_id": "$stars" } } ]Your Answer 
This is correct.

D. [         { "$match": { "categories" = "Bakery" } },         { "$group": { "_id" = "$stars" } } ]
Cannot use = syntax.
```



## 26 - What are two valid method names for MongoClient class?

```diff
+ Correct Answer
```

```
A. get_database()Your Answer 
This is correct.

B. open()
This is not a valid method name.

C. close()Your Answer 
This is correct.

D. destroy()
This is not a valid method name.
```


## 27 - What are two advantages to using Connection Pooling within the Python driver?

```diff
+ Correct Answer
```

```
A. Reduce the latency for an applicationYour Answer 
This is correct.

B. Limit the number of connections to the serverYour Answer 
This is correct. While you can often worry about connections less with a connection pool, it does not mean you don't have to worry about it at all as you can still max out connections or have a too large or too small pool

C. Remove the need for the application to authenticate
Incorrect.  The application still needs to authenticate. Connection pool only maintains information about authentication.

D. Remove the need to open and close connections explicitly
Incorrect. The application still needs to open connection. The connection pool will handle using existing connection if one is available.
```


## 27 - Given the following Python code:

```python
db = client.people
collection = db.employees


filter = {
              "name": "Samantha Smith"
}


update = { 
               "$set": { "name”: "Sam Smith” }
}
```

Assume client is a valid connection to MongoDB.

What statement correctly updates a single document in MongoDB?

```diff
+ Correct Answer
```

```
A. collection.update_one(filter, update)Your Answer 
This is correct.

B. collection.update_one(update, filter)
Incorrect. The filter and update parameters are in the incorrect order.

C. collection.update_single(filter, update)
Incorrect. The update operator is not correct.

D. collection.update_single(update, filter)
Incorrect. The update operator is not correct.
```