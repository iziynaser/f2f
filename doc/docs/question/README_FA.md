oauth_client_entity#
#
# The official team of the spring-security-oauth2 project has announced that it will stop further development and this project will also be suspended.
# [Spring official statement](https://spring.io/blog/2019/11/14/spring-security-oauth-2-0-roadmap-update)
## It is recommended to use other open source solutions, such as https://www.keycloak.org
#
#

## SpringBoot 2.2.x oauth2 server, SSO single sign-on

## Create a database: The persistence layer uses the JPA framework. The database must be created before the project starts. The data table will be automatically created when it starts.</br>
````
the default databse is Mysql.if you need to use another database ,please
please modify the configuration file and database driver 
#create databas sql : database name , database username , and
database password must be consistent with those in application.properties

CREATE DATABASE IF NOT EXISTS oauth2_server DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
create user 'oauth2_server'@'localhost' identified by 'password_dev';
grant all privileges on oauth2_server.* to 'oauth2_server'@'localhost';

#The initialization data sql is in src/main/resources/sql/init.sql, you can modify the initialization data such as client_id by yourself
````
## Supports 4 types of authorization modes grant_type</br>
````
authorization_code,implicit,password,client_credentials;
````
#####
* authorization_code mode: **used for PC, page jump**, highest security, requires two steps to obtain token; `Make sure the redirect_uri is consistent with the corresponding redirect_uri in the database`
````
1. Get /oauth/authorize?client_id=SampleClientId&response_type=code&redirect_uri=http://client.sso.com/login/oauth2/code/sso-login
After the user agrees to the authorization, the server responds and the browser redirects to: http://client.sso.com/login?code=1E37Xk, receives the code, and then the backend calls step 2 to get the token
2. Post /oauth/token?client_id=SampleClientId&client_secret=tgb.258&grant_type=authorization_code&redirect_uri=http://client.sso.com/login/oauth2/code/sso-login&code=1E37Xk
response:
{
    "access_token": "a.b.c",
    "token_type": "bearer",
    "refresh_token": "d.e.f",
    "expires_in": 43199,
    "scope": "user_info",
    "userId": "1",验证码错误！
    "jti": "823cdd71-4732-4f9d-b949-a37ceb4488a4"
}
````
* Password mode: used for mobile phones or other scenarios without page jumps, should be called by the background server, **protect client_id and client_secret**
````
Post /oauth/token?client_id=SampleClientId&client_secret=tgb.258&grant_type=password&scope=user_info&username=zhangsan&password=tgb.258
response:
{
    "access_token": "a.b.c",
    "token_type": "bearer",
    "refresh_token": "d.e.f",
    "expires_in": 43199,
    "scope": "user_info",
    "userId": "1",
    "jti": "823cdd71-4732-4f9d-b949-a37ceb4488a4"
}
````
## RSA key generation, used to sign tokens, and local verification of tokens on the client and resource side
````
Use the keytool in the Java toolkit to create the certificate jwt.jks. Important parameters: set the alias to [jwt], the valid number of days to [36500], the password to [keypass], and replace the location src/main/resources/jwt.jks
keytool -genkey -alias jwt -keyalg RSA -keysize 1024 -keystore /your/path/to/jwt.jks -validity 36500
````
## Get the RSA public key signed by the jwt token for local token verification
````
Get /oauth/token_key
````
## jwk-set-uri: resource server can obtain jwt token signature public key and cache it for local verification
````
Get /.well-known/jwks.json
````
## issuer-uri: resource server can get jwt token signature public key and other information
````
Get /.well-known/oauth-authorization-server
````

## Verify token, used to verify whether the token is valid on the resource side</br>
````
Post /oauth/check_token?token=a.b.c
````

## Access protected resources and carry a token when requesting
````
Get /user/me?access_token=a.b.c
Or add Authorization to the http header, as follows
Authorization: Bearer a.b.c
````

## Refresh token</br>
````
Post /oauth/token?client_id=SampleClientId&client_secret=tgb.258&grant_type=refresh_token&refresh_token=d.e.f
````

## register new user interface</br>
````
1、get the verification code
 Get /captcha/graph
 response：
 {
   "graphUrl": "/captcha/graph/print?graphId=32a41c71-d74a-4aa6-b73c-af3627e82485",
   "graphId": "32a41c71-d74a-4aa6-b73c-af3627e82485",
   "ttl": 300,
   "status": 1
 }
2、show verification code
 Get /captcha/graph/print?graphId=a32a41c71-d74a-4aa6-b73c-af3627e82485
 response：
 picture stream
3、call the registeration interface
 Post /oauth/signUp?username=lisi&password=yourpass0!&graphId=a32a41c71-d74a-4aa6-b73c-af3627e82485&verificationCode=1324
 response：
 {
     "status": 1,
     "timestamp": 1561729652797
 }
 
````

## Extend grant_type, refer to SMSCodeTokenGranter


## Startup method</br>
````
java -jar oauth2-server-0.0.3-SNAPSHOT.jar
Or specify a configuration file to override the default configuration
java -jar oauth2-server-0.0.3-SNAPSHOT.jar --spring.config.additional-location=/path/to/override.properties
````

## After logging in as an administrator, you can manage users and clients</br>
## Effect Picture
![登录页](https://raw.githubusercontent.com/jobmission/oauth2-server/master/src/test/resources/static/imgs/login.png)
![用户管理](https://raw.githubusercontent.com/jobmission/oauth2-server/master/src/test/resources/static/imgs/users.png)
![client管理](https://raw.githubusercontent.com/jobmission/oauth2-server/master/src/test/resources/static/imgs/clients.png)

## OAuth 2 Developers Guide
[spring-security-oauth官方文档](https://projects.spring.io/spring-security-oauth/docs/oauth2.html) <br/>
[Spring Boot and OAuth2 Tutorial](https://spring.io/guides/tutorials/spring-boot-oauth2/)

[client front-end DEMO](https://github.com/jobmission/oauth2-client.git) <br/>
[api resource interface DEMO](https://github.com/jobmission/oauth2-resource.git)


## Notice!!!
When the server and client are on the same machine, please configure the domain proxy to avoid cookies from overwriting each other.

[Bcrypt online password generator](https://www.jisuan.mobi/index.php?tag=Bcrypt)
[Bcrypt online password generator](https://www.devglan.com/online-tools/bcrypt-hash-generator)


## changes on company
change maven path to e:\repository

##changes on labtop

##errors
w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.bind.MissingServletRequestParameterException: Required request parameter 'productId' for method parameter type String is not present]
