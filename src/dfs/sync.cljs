(ns dfs.sync
  (:require
    [datascript.core :as d]
    [dfs.database :as db]
    [dfs.firebase :as fb]
    [dfs.transit :as transit]
    [goog.object :as gobj]))

(def datoms-ref
  (fb/child fb/root "datoms"))

(defn update-val [datom]
  (when (.-added datom)
    (transit/write [(.-e datom) (.-a datom) (.-v datom)])))

(defn update-obj [tx-data]
  (let [obj (js-obj)]
    (doseq [datom tx-data]
      (gobj/set obj (hash datom) (update-val datom)))
    obj))

(defn handle-report [{:keys [tx-data tx-meta]}]
  (when-not (= tx-meta ::firebase)
    (js/console.log "update firebase")
    (.update datoms-ref (update-obj tx-data))))

(defn add! [ss]
  (let [[e a v] (transit/read (.val ss))]
    (js/console.log "add from firebase")
    (d/transact! db/cnx [[:db/add e a v]] ::firebase)))

(defn retract! [ss]
  (let [[e a v] (transit/read (.val ss))]
    (js/console.log "retract from firebase")
    (d/transact! db/cnx [[:db/retract e a v]] ::firebase)))

(defn datoms! []
  (d/listen! db/cnx handle-report)
  (doto datoms-ref
    (.on "child_added" add!)
    (.on "child_changed" add!)
    (.on "child_removed" retract!)))
