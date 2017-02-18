(ns cifs-clj.core
  (:import [jcifs.util Hexdump MD4])
  (:gen-class))

(defn hash-nt-password [pwd]
  (let [pwd-bytes (.getBytes pwd "UnicodeLittleUnmarked")
        md4 (doto (MD4.)
              (.engineUpdate pwd-bytes 0 (alength pwd-bytes)))
        hash-bytes (.engineDigest md4)]
    (Hexdump/toHexString hash-bytes 0 (* 2 (alength hash-bytes)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  )
