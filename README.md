# SaunaLog

サウナに関する情報や感想を登録でき、閲覧できるアプリケーション。

![スクリーンショット (6)](https://github.com/user-attachments/assets/e0082191-e43c-4279-b4a1-5c3f110cd94b)

## 概要

このプロジェクトは、サウナに関する情報や個人の感想を記録・共有するためのWebアプリケーションです。

## 機能

- サウナの情報を登録・編集・削除
- ユーザー登録とログイン
- 他のユーザーのレビューを見ることができる

## 必要な環境

- Java 17
- Maven 3.6.3 以上
- PostgreSQL 12 以上

## インストール方法

1. リポジトリをクローンする
    ```bash
    git clone https://github.com/miohuh/sauna.git
    ```
2. 必要なパッケージをインストールする
    ```bash
    mvn install
    ```
3. PostgreSQLデータベースを設定する
    - データベースを作成する
    - 必要なテーブルやスキーマをセットアップするためのSQLスクリプトを実行する
    ```sql
    CREATE DATABASE sauna;
    \c sauna;
    CREATE TABLE sauna (
      id serial NOT NULL,
      name character varying(100) NOT NULL,
      type character varying(10) NOT NULL,
      url character varying(200) NOT NULL,
      point1 character varying(50),
      point2 character varying(50),
      point3 character varying(50),
      impression character varying(400) NOT NULL,
      star integer,
      address character varying(150),
      PRIMARY KEY (id)
    );
    ```

## 使い方

1. PostgreSQLサーバーを起動する
2. アプリケーションを起動する
    ```bash
    mvn jetty:run
    ```
3. ブラウザで `http://localhost:8080` にアクセスしてアプリケーションを確認する

## 貢献方法

貢献方法については `CONTRIBUTING.md` を参照してください。ここにはバグ報告の手順や、新機能提案の方法、プルリクエストの手順が記載されています。

## ライセンス

このプロジェクトはMITライセンスのもとで公開されています。詳しくは `LICENSE` ファイルを参照してください。
