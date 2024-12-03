

----------------------------------------assistant


You can override the `toString()` method in your `RestClientException` class to include the message when the stack trace is printed. Here's an example of how you can do that:

```java
public static class RestClientException extends RuntimeException {
    private final int statusCode;
    private String body;

    public RestClientException(int statusCode, String message, String body, Exception cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        String message = getMessage();
        if (message != null) {
            return message + " [status code: " + statusCode + ", body: " + body + "]";
        } else {
            return "RestClientException: [status code: " + statusCode + ", body: " + body + "]";
        }
    }
}
```

Now, when you print the stack trace of an instance of `RestClientException`, the message along with the status code and body will be included in the output.


----------------------------------------user


Hey chat, I have this exception:

```java

    public static class RestClientException extends RuntimeException {
        private final int statusCode;
        private String body;

        public RestClientException(int statusCode, String message, String body, Exception cause) {
            super(message, cause);
            this.statusCode = statusCode;
            this.body = body;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getBody() {
            return body;
        }
    }
```
How can I have the message printed out when the stack trace is printed?

