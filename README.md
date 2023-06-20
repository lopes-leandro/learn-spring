Simple project to learning Spring Framework


#  Tratamento de Exceções de Tempo de Execução

* IndexOutOfBoundsException: essa exceção ocorre quando acessamos um índice de um array de string ou interável está fora do intervalo;
* IllegalArgumentException: essa exceção ocorre quando um método foi passado por um argumento ilegal;
* NullPointerException: esse exceção ocorre quando uma variável é acessada não aponta para nenhum objeto ou nulo;

# Criando Controladores no Spring Framework

* __@RestController__ : é uma forma especializada da anotação __@Controller__, ele já inclui a anotação __@Controller__ e __@ResponseBody__, não sendo necessário especificar a anotação __@ResponseBody__ em cada método.

* __@RequestMapping__ : é uma anotação usada para mapear as solicitações do HyperText Transfer Protocol (HTTP) aos métodos dos controladores Representational State Transfer (REST). É também onde definimos um caminho base para o controlador.

* __@GetMapping__ : mapeia solicitações __HTTP GET__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.GET)__

* __@PutMapping__ : mapeia solicitações __HTTP PUT__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.PUT)__

* __@PostMapping__ : mapeia solicitações __HTTP POST__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.POST)__

* __@DeleteMapping__ : mapeia solicitações __HTTP DELETE__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.DELETE)__ 

* __@PathVariable__ : essa anotação é usada para obter o valor dos parâmetros do terminal

* __@Valid__ : essa anotação é usada para verificar a validade de um objeto; é comumente usado no corpo da solicitação para verificar se uma solicitação passada é um objeto válido;

# Configurando o Ambiente do Redis Com Docker e Spring

### Criando um Contêiner Docker com Redis

```docker
docker run -d --name treina-redis-stack -p 6379:6379 -p 8001:8001 -e REDIS_ARGS="--requirepass <<your password here>>" redis/redis-stack
```

### Acessando Localmente a Instância do Redis

- http://localhost:8001/redis-stack/browser

### Documentação

- **redisStandaloneConfiguration.setHostName("host")** : isso define o **Uniform Resource Locator ( URL )** do host onde o servidor Redis está em execução;

- **redisStandaloneConfiguration.setPort("port")** : isso define a porta onde a aplicativo se conectará;

- **redisStandaloneConfiguration.setUsername("username")** : isso define o nome de usuário do servidor Redis;

- **redisStandaloneConfiguration.setPassword("password")** : isso define a senha para o servidor Redis;


#### Configuração
```java
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<UUID, Object> redisTemplate() {
        RedisTemplate<UUID, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
}

```

#### Entidade
```java

import java.util.Date;
import org.springframework.data.redis.core.RedisHash;
import jakarta.persistence.Entity;
...

@RedisHash("AntiHero")
@Data
@Entity
...
public class AntiHeroEntity {
   ...
}
```


# Repositórios Auxiliares

- [Repositório de Pacotes do MVN](https://mvnrepository.com/)

- [Documentação Redis com Docker](https://redis.io/docs/stack/get-started/install/docker/)

- [Documentação Spring Data Redis](https://docs.spring.io/spring-data/redis/docs/current/reference/html/#reference)


# Referência de Estudo

- [JavaTechie: Spring Data Redis](https://www.youtube.com/watch?v=oRGqCz8OLcM)
