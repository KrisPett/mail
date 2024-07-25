**application-secret.properties**

```
email.username=
email.password=
email.host=
email.port=
```

docker run -it --rm --privileged -p 1000:1000 --name maven -v ${PWD}:/workdir -w /workdir maven:3.9.8-eclipse-temurin-22-alpine bash
