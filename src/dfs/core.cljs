(ns dfs.core
  (:require
    [datascript.core :as d]
    [dfs.database :as db]
    [dfs.sync :as sync]
    [rum.core :as rum]))

(rum/defc app < rum/reactive []
  [:.app "The true delight is in the finding out rather than in the knowing. -Isaac Asimov"])

(defn mount-app []
  (rum/mount (app) (js/document.getElementById "app")))

(defn ^:export init []
  (enable-console-print!)
  (sync/datoms!)
  (mount-app))
