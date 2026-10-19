برای بررسی اینکه ایا redis در docker اجرا می شود یا خیر می توانید از دستور زیر استفاده کنید :
`docker ps`
باید چیزی شبیه به این ببینید
```
CONTAINER ID   IMAGE       PORTS
xxxxxx         redis:7     0.0.0.0:6379->6379/tcp
```
اگر در لیست نیست 
`docker start redis`
اگر compose دارید
`docker-compose up -d redis`

## بررسی باز بودن پورت

## تست مستقیم اتصال redis با کلاینت
اگر داخل کانتینر redis دستور زیر جواب بدهد به معنای سالم بودن redis است :
`docker exec -it redis redis-cli ping`
اگر جواب نداد redis  خراب است 

##  اجرای redis به صورت مستقل برای تست سریع
در ترمینال می توانید دستور زیر را وارد کنید:
`docker run -d --name redis-server -p 6379:6379 redis:7`
و برای تست می توانید دستور زیر را وارد کنید :
`docker exec -it redis-server redis-cli ping`

