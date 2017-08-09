(ns dfs.transit
  (:require
    [cognitect.transit :as transit]))

(defonce reader
  (transit/reader :json))

(defn read [string]
  (transit/read reader string))

(defonce writer
  (transit/writer :json))

(defn write [value]
  (transit/write writer value))
