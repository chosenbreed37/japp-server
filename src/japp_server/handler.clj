(ns japp-server.handler
  (:use ring.middleware.json)
  (:require [compojure.handler :as handler]
	    [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.json :refer :all]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/route/:id" [id] (response {:name "65"}))
  (route/not-found (response {:message "Not found"})))

(def app
  (-> app-routes wrap-json-response wrap-json-body))

