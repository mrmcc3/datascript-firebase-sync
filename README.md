### datascript-firebase-sync

Example ClojureScript app showing naive DataScript <-> Firebase Syncing.

### setup

You need parts of the Firebase javascript SDK (including externs).
`./scripts/firebase.sh` will download them so `deps.cljs` can pick them up

You also need to configure a firebase to sync to. Install the firebase
config in `dfs.firebase/config` as shown. Keep in mind the default 
firebase rules don't allow unauthed writes.

### builds

* `lein dev` runs figwheel at `http://localhost:3449/` 
* `lein dist` does advanced build

