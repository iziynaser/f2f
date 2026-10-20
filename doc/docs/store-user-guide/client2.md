package.json

```json
{
  "scripts": {
    "build": "vue-cli-service build",
    "copy:frontf": "cpx -r dist/** /path/to/backend/public/frontf",
    "copy:frontb": "cpx -r dist/** /path/to/backend/public/frontb",
    "build:frontf": "npm run build && npm run copy:frontf",
    "build:frontb": "npm run build && npm run copy:frontb"
  },
  "devDependencies": {
    "cpx": "^1.5.0"
  }
}
```