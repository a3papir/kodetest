# kodetest
Implemented an application which can format numerical inputs to written text.

## Running the application with the newest version
Build a new .jar file with 
```mvn clean install```

Then create a docker image
```docker build -f Dockerfile -t kodetest```

Now just run the application
```docker run -p 9000:9000 kodetest```

The application is now running on ```localhost:9000```, and the api is exposed at ```/api/convert/```

## Running the tests
You can run the tests using
```mvn clean test```
