# CookBook
CookbookServer (spring)
* ✓ 1 разработать rest api
  * ✓ 1.1 запрос на авторизацию
  * ✓ 1.2 получение списка рецептов (в запросе могут присутствовать условия фильтрации)
  * ✓ 1.3 создание / редактирование рецепта
  * ✓ 1.4 голосование за / против рецепта
* ✓ 2 разработать хранилище объектов (пользователей, рецептов)

# For H2
## Gradle:
runtime 'com.h2database:h2'

## application.properties:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
