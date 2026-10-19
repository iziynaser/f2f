#############################################
#   Stage 1 — Install Once (Offline-friendly)
#############################################
FROM node:18-alpine AS base

WORKDIR /app
COPY package*.json ./
RUN npm install --legacy-peer-deps

#############################################
#   Stage 2 — Development DEBUG Mode
#############################################
FROM base AS dev
WORKDIR /app
COPY . .
EXPOSE 8082
CMD ["npm", "run", "serve"]

#############################################
#   Stage 3 — Production Build
#############################################
FROM base AS build
WORKDIR /app
COPY . .
RUN npm run build

#############################################
#   Stage 4 — Production Serve (Nginx)
#############################################
FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist /usr/share/nginx/html/store
EXPOSE 8082
CMD ["nginx", "-g", "daemon off;"]
