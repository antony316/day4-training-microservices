Day 4 Training Microservices

Auth Module include : 
1. Rest API With JWT
- POST https://localhost:8443/api/auth/register
- POST https://localhost:8443/api/auth/login
- GET https://localhost:8443/api/users
2. Rest API Using Certificate SSL
- GET https://localhost:8443/api/secure-hello
3. Rest API With Logging Using LogBack
- GET https://localhost:8443/api/entity
- GET https://localhost:8443/api/entity/1
- POST https://localhost:8443/api/entity
- PUT https://localhost:8443/api/entity/1
- DELETE https://localhost:8443/api/entity/1
4. Rest API with Monitoring Using Actuator
- GET https://localhost:8443/actuator/health
- GET https://localhost:8443/actuator/metrics
- GET https://localhost:8443/actuator/metrics/entity_service_success
- GET https://localhost:8443/actuator/metrics/entity_service_failed
- GET https://localhost:8443/actuator/info
