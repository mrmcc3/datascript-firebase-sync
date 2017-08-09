{:foreign-libs [{:file     "firebase/firebase-app.js"
                 :provides ["firebase.app"]}
                {:file     "firebase/firebase-auth.js"
                 :requires ["firebase.app"]
                 :provides ["firebase.auth"]}
                {:file     "firebase/firebase-database.js"
                 :requires ["firebase.app"]
                 :provides ["firebase.database"]}]
 :externs      ["firebase/firebase-app-externs.js"
                "firebase/firebase-auth-externs.js"
                "firebase/firebase-database-externs.js"]}