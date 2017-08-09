#!/usr/bin/env bash
set -e

curl -L https://unpkg.com/firebase/firebase-app.js --create-dirs -o resources/firebase/firebase-app.js
curl -L https://unpkg.com/firebase/firebase-auth.js --create-dirs -o resources/firebase/firebase-auth.js
curl -L https://unpkg.com/firebase/firebase-database.js --create-dirs -o resources/firebase/firebase-database.js

curl -L https://unpkg.com/firebase/externs/firebase-app-externs.js --create-dirs -o resources/firebase/firebase-app-externs.js
curl -L https://unpkg.com/firebase/externs/firebase-auth-externs.js --create-dirs -o resources/firebase/firebase-auth-externs.js
curl -L https://unpkg.com/firebase/externs/firebase-database-externs.js --create-dirs -o resources/firebase/firebase-database-externs.js
