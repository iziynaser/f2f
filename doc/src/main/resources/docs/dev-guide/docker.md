## فعال کردن Remote debug در docker file
برای اجرای معمولی برنامه در فایل تنظیمات می توانید از دستور زیر استفاده کنید:
`ENTRYPOINT ["java","-jar","/app/app.war"]`

برای ریموت دیباگ باید jvm arguments را اضافه کنیم:
`ENTRYPOINT ["java",
"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
"-jar","/app/app.war"]`

## پورت 5005  را در تنظیمات داکر باز می کنیم
خطی که در تنظیمات به این موضوع اشاره دارد:
` - "5005:5005"`

## ساخت و اجرا
با دستور زیر ابتدا build می کنیم :
`docker-compose up --build`
بعد از اجرا اگر همه چیز اوکی باشد در لاگ کانتینر خطی شبیه به این نمایش داده می شود:
`Listening for transport dt_socket at address: 5005`

## تنطیم محیط توسعه intellij برای remote debug
در محیط توسعه intellij به بخش زیر می رویم:
`Run → Edit Configurations → Add New Configuration → Remote JVM Debug`
سپس پارامترهای زیر را تنظیم می کنیم:
پارامترها:
Host: localhost
Port: 5005
Mode: Attach to remote JVM

سپس روی debug کلیک می کنیم


##  ساخت بسته افلاین برای برنامه 
ابتدا ایمیج های لازم برای اجرای برنامه را دانلود کنید
```
docker pull eclipse-temurin:21-jre-jammy
docker pull maven:3.9.6-eclipse-temurin-21
docker pull postgres:13
docker pull redis:7
docker pull node:18-alpine   # اگر Vue داری
```
در مرحله بعد ایمیج های دانلود شده را بر روی دیسک یا فضای ذخیره سازی پرتابل ذخیره می کنیم:
```
docker save -o offline-images.tar eclipse-temurin:21-jre-jammy \
  maven:3.9.6-eclipse-temurin-21 \
  postgres:13 \
  redis:7 \
  node:18-alpine
```
حالا ایمیج های ذخیره شده را روی هر سیستم جدیدی یا ریموت می توان با دستور زیر لود کرد
`docker load -i offline-images.tar`

برای اینکه ایمیج ها دانلود نشوند و از cache  لوکال استفاده شود می توانیم از دستورهای زیر استفاده کنیم:
```
docker-compose up --build --pull=never
docker-compose up --no-build
```
