(ns dfs.firebase
  (:require
    [firebase.auth]
    [firebase.database]))

(def config
  #js {:apiKey            "<your config here>"
       :authDomain        "<your config here>"
       :databaseURL       "<your config here>"
       :projectId         "<your config here>"
       :storageBucket     "<your config here>"
       :messagingSenderId "<your config here>"})

(def app
  (try
    (js/firebase.initializeApp config)
    (catch js/Error _ (js/firebase.app))))

(def db (.database app))
(def root (.ref db))
(def auth (.auth app))

(defn user->map [user-obj]
  (when user-obj
    {:uid            (.-uid user-obj)
     :display-name   (.-displayName user-obj)
     :email          (.-email user-obj)
     :email-verified (.-emailVerified user-obj)
     :photo-url      (.-photoURL user-obj)}))

(defn child [ref & args]
  (reduce #(.child %1 (str %2)) ref args))

