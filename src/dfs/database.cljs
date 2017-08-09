(ns dfs.database
  (:require
    [datascript.core :as d]))

(def schema
  {})

(def cnx
  (d/create-conn schema))
