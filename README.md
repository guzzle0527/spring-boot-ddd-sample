### 概要
ドメイン駆動設計をベースにした、単純なREST APIのサンプルコード

### ローカル起動方法
```
# アプリケーション起動
gradle bootRun

# ユーザ登録API実行例
curl -X POST -H "Content-Type: application/json" -d '{"firstName":"taro","lastName":"suzuki","gender":"1","birthDay":"19991224","mailAddress":"test@test.co.jp"}' "http://localhost:8080/user"

※Windowsの場合はダブルコーテーションをエスケープした形でリクエストしないとこける
curl -X POST -H "Content-Type: application/json" -d "{\"firstName\":\"taro\",\"lastName\":\"suzuki\",\"gender\":\"1\",\"birthDay\":\"19991224\",\"mailAddress\":\"test@test.co.jp\"}" "http://localhost:8080/user"

# ユーザ取得API実行例
curl -X GET -H "Content-Type: application/json" "http://localhost:8080/user/1"

# タスク登録API実行例
curl -X POST -H "Content-Type: application/json" -d '{"taskName":"spring boot","userId":1}' "http://localhost:8080/task"

# 全ユーザ取得API実行例
curl -X GET -H "Content-Type: application/json" "http://localhost:8080/users"
```

### 技術要素
* Java11
* Spring Boot 2.2.6
* mybatis-spring-boot-starter 2.1.2
* h2

### 備考
まだ学習中のため、解釈が間違っていたり、良くない設計があると思われます。随時リファクタリング予定。