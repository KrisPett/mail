mvn spring-boot:run

**application-secret.properties**

```
email.username=
email.password=
email.host=
email.port=
```

docker run -it --rm --privileged -p 1000:1000 --name maven -v ${PWD}:/workdir -w /workdir maven:3.9.8-eclipse-temurin-22-alpine bash

```
curl -X POST --location "http://localhost:8080/send-email" \
    -H "Content-Type: application/json" \
    -d '{
          "course": "course",
          "name": "name",
          "email": "email",
          "company": "company",
          "phone": "phone",
          "participantsDesired": "participantsDesired",
          "date": "date"
        }'
```

### Performance

```
5f2aedaa3b72   email-java   0.07%     189.3MiB / 46.99GiB   0.39%     19.3kB / 4.29kB   0B / 143kB   42
```