# Spring Boot meets Consul

## Why?

In a micro-service world, we need to find other micro services.
So first of all we need to tell someone, that we are here.
This is done by register ourself to a Service Discovery like Consul.

In case of Spring-Boot we can use part of the `org.springframework.cloud` ecosystem.

We use the `spring-cloud-starter-consul-all`
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-all</artifactId>
    <version>2.2.2.RELEASE</version>
</dependency>
```

Once you have this, Spring tries automatically register the current service to Consul.
Also Consul wants to know the health of the server, because unhealthy services will not be used.

The health can be easy added by adding actuator

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
    <version>2.2.6.RELEASE</version>
</dependency>
```

Connect a Spring-Boot application to Consul.

## Requirement
### Consul

To be able to connect to Consul we need a Consul instance up and running.
The easiest way it to use the docker image. (https://hub.docker.com/_/consul)
``` 
docker run -d --name=consul --net=host  consul
```

__Do not use the default setting from Consul in production__, this is only the development mode.

Once the Consul container is up and running, you can access the UI via http://localhost:8500/ui/


## Service Discovery
So we can use Consul now as a Service Discovery.

To control the uniqueness, and the name, how the service will end up in the 
Service Discovery list, you can use the configuration in `bootstrap.yml`

```yaml
spring:
  cloud:
    consul:
      port: 8500
      host: localhost
      discovery:
        instanceId: ${spring.application.name}:${vcap.application.instance_id:${spring.application.instance_id:${random.value}}}
        fail-fast: false
        tags:
          - "consulTagValue"
```

## Configuration Service
Consul also provide Key-Value store, which will be automaticall used by String
To add some data in Consul, you can use the UI or the API interface.
```
curl \
    --request PUT \
    --data 'echo:
  value: value from consul' \
    http://127.0.0.1:8500/v1/kv/config/boot-consul/data
```

here we add some new Key-Value content to __"config/boot-consul/data"__
Spring will use the schema
"config"
"application-name"
to pick up the configuration from Consul

the "data" part is defined in the "bootstrap.yml" as "data-key"

```yaml
spring:
  cloud:
    consul:
      port: 8500
      host: localhost
      config:
        format: YAML
        data-key: data
        fail-fast: false
        watch:
          delay: 10000
```
if you define the consul config in `bootstrap.yml` the values from consul will be
already available on startup, so you can for exampe already define the port of the application.


