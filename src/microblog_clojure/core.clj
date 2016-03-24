(ns microblog-clojure.core
  (:require [ring.adapter.jetty :as j]
            [compojure.core :as c])
  (:gen-class))

(c/defroutes app
  (c/GET "/" request
    "Hello World"))

(defonce server (atom nil))

(defn -main []
  (when @server
      (.stop @server))
  (reset! server (j/run-jetty app {:port 3000 :join? false})))
