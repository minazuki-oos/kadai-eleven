# アプリケーションの概要

エンドポイント:/create
HTTPメソッド:POST
リクエスト本体: JSONデータ

# 起動手順

IntelliJ IDEAを使用してDemoApplicationクラスを実行します

# APIの動作確認用のcurlコマンド:

curl --location 'http://localhost:8080/create' \
--header 'Content-Type: text/plain' \
--data '{
"name": "John Doe",
"age": 25,
"city": "Example City"
}
'