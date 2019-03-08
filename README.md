##Consumer Driven contract tests using Pact

####To create pacts from consumer side
```./gradlew clean test```

####To verify pact at provider side
```./gradlew pactVerify```


####To run application before verifying pact
```./gradlew bootRun```