# راهنمای ساخت و استقرار پروژه Frontend با Vue و Spring Boot


---

## پیش‌نیازها

- نصب Node.js و npm (نسخه 14 به بالا پیشنهاد می‌شود)
- نصب Java JDK (برای اجرای Spring Boot)
- نصب Maven یا Gradle (بسته به پروژه بک‌اند)
- دسترسی به کد پروژه Vue (هر برنچ جداگانه برای frontf و frontb)
- دسترسی به پروژه Spring Boot

---

## مرحله 1: تنظیم پروژه Vue

### 1.1. تنظیم `vue.config.js` در هر برنچ

**برنچ frontf (کاربر):**

```js
module.exports = {
  publicPath: '/user/',

  devServer: {
    hot: true,
    watchOptions: { poll: true }
  },

  configureWebpack: {
    devtool: 'source-map'
  }
};

'''js
module.exports = {
  publicPath: '/admin/',

  devServer: {
    hot: true,
    watchOptions: { poll: true }
  },

  configureWebpack: {
    devtool: 'source-map'
  }
};

'''js
npm install

'''js
npm install --save-dev fs-extra rimraf

'''js

در پوشه ریشه پروژه Vue فایل build-and-copy.js را ایجاد کنید و کد زیر را در آن قرار دهید:

js
Copy

'''js
const { exec } = require('child_process');
const rimraf = require('rimraf');
const fs = require('fs-extra');
const path = require('path');

// دریافت آرگومان ورودی (frontf یا frontb)
const target = process.argv[2];
if (!target || (target !== 'frontf' && target !== 'frontb')) {
  console.error('لطفا یکی از مقادیر frontf یا frontb را به عنوان آرگومان وارد کنید.');
  process.exit(1);
}

// تنظیمات مسیرها
const distFolder = path.resolve(__dirname, 'dist');
const backendPublicFolder = path.resolve(__dirname, '..', 'backend-project', 'src', 'main', 'resources', 'public');
const targetFolder = path.join(backendPublicFolder, target);

// پاکسازی پوشه dist قبل build
console.log('پاکسازی پوشه dist ...');
rimraf.sync(distFolder);

// پاکسازی پوشه مقصد قبل از کپی
console.log(`پاکسازی پوشه مقصد: ${targetFolder} ...`);
rimraf.sync(targetFolder);

// دستور build با متغیر محیطی
const buildCommand = process.platform === "win32"
  ? `set VUE_APP_BUILD_TARGET=${target}&& npm run build`
  : `VUE_APP_BUILD_TARGET=${target} npm run build`;

console.log(`اجرای build با دستور: ${buildCommand}`);
exec(buildCommand, (err, stdout, stderr) => {
  if (err) {
    console.error('خطا در هنگام build:', err);
    process.exit(1);
  }
  console.log(stdout);
  console.error(stderr);

  // کپی خروجی به پوشه مقصد
  console.log(`کپی خروجی build به ${targetFolder} ...`);
  fs.copy(distFolder, targetFolder)
    .then(() => {
      console.log('کپی با موفقیت انجام شد!');
    })
    .catch(copyErr => {
      console.error('خطا در هنگام کپی:', copyErr);
      process.exit(1);
    });
});


در فایل package.json، قسمت scripts را به شکل زیر تنظیم کنید:

json
Copy

'''js
"scripts": {
  "build": "vue-cli-service build",
  "build:frontf": "node build-and-copy.js frontf",
  "build:frontb": "node build-and-copy.js frontb"
}


