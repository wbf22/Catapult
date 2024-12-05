# Catapult
Terminal app for parsing and making REST requests

Here's a sample request file:
```
# type
POST

# url
https://www.example.com

# headers
Content-Type=application/json

# body
```json
{
    "field" : "value"
}
\```

```
You can then run the jar file like so:
```
java -jar catapult.jar request_file.txt
```
The app will parse the request file and make the request to the specified URL, appending the response onto the end of the file. (or replacing the last response if it exists)
